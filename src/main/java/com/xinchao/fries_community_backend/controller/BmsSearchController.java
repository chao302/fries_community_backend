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
 * @ClassName : BmsSearchController.java
 * @createTime : 2021/12/16 15:56
 * @Email : xinchao302@foxmail.com
 * @Description :
 */
@RestController
@RequestMapping("/search")
public class BmsSearchController extends BaseController {

    @Resource
    private IBmsPostService postService;

    @GetMapping
    public ApiResult<Page<PostVO>> searchList(@RequestParam("keyword") String keyword,
                                              @RequestParam("pageNum") Integer pageNum,
                                              @RequestParam("pageSize") Integer pageSize) {
        Page<PostVO> results = postService.searchByKey(keyword, new Page<>(pageNum, pageSize));
        return ApiResult.success(results);
    }

}