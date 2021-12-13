package com.xinchao.fries_community_backend.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xinchao.fries_community_backend.common.api.ApiResult;
import com.xinchao.fries_community_backend.model.entity.BmsBillboard;
import com.xinchao.fries_community_backend.service.IBmsBillboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 新超
 * @version : 1.0
 * @Project : fries_community_backend
 * @Package : com.xinchao.fries_community_backend.controller
 * @ClassName : BmsBillboardController.java
 * @createTime : 2021/12/12 18:13
 * @Email : xinchao302@foxmail.com
 * @Description :
 */
@RestController
@RequestMapping("/billboard")
public class BmsBillboardController extends BaseController{

    @Resource
    private IBmsBillboardService bmsBillboardService;

    @GetMapping("/show")
    public ApiResult<BmsBillboard> getNotices(){
        List<BmsBillboard> list = bmsBillboardService.list(new
                LambdaQueryWrapper<BmsBillboard>().eq(BmsBillboard::isShow,true));
        return ApiResult.success(list.get(list.size()- 1));
    }
}
