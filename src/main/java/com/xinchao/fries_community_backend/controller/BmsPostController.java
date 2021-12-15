package com.xinchao.fries_community_backend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xinchao.fries_community_backend.common.api.ApiResult;
import com.xinchao.fries_community_backend.model.vo.PostVO;
import com.xinchao.fries_community_backend.service.IBmsPostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 新超
 * @version : 1.0
 * @Project : fries_community_backend
 * @Package : com.xinchao.fries_community_backend.controller
 * @ClassName : BmsPostController.java
 * @createTime : 2021/12/15 22:29
 * @Email : xinchao302@foxmail.com
 * @Description :
 */
@RestController
@RequestMapping("/post")
public class BmsPostController extends BaseController{
    @Resource
    private IBmsPostService iBmsPostService;

    @GetMapping("/list")
    public ApiResult<Page<PostVO>> list(@RequestParam(value = "tab", defaultValue = "latest") String tab,
                                        @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                        @RequestParam(value = "size", defaultValue = "10") Integer pageSize) {
        Page<PostVO> list = iBmsPostService.getList(new Page<>(pageNo, pageSize), tab);
        return ApiResult.success(list);
    }
}
