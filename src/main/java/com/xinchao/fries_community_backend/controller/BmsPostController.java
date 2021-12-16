package com.xinchao.fries_community_backend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xinchao.fries_community_backend.common.api.ApiResult;
import com.xinchao.fries_community_backend.model.dto.CreateTopicDTO;
import com.xinchao.fries_community_backend.model.entity.BmsPost;
import com.xinchao.fries_community_backend.model.entity.UmsUser;
import com.xinchao.fries_community_backend.model.vo.PostVO;
import com.xinchao.fries_community_backend.service.IBmsPostService;
import com.xinchao.fries_community_backend.service.IUmsUserService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

import java.util.Map;

import static com.xinchao.fries_community_backend.jwt.JwtUtil.USER_NAME;
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

    @Resource
    private IUmsUserService umsUserService;

    @GetMapping("/list")
    public ApiResult<Page<PostVO>> list(@RequestParam(value = "tab", defaultValue = "latest") String tab,
                                        @RequestParam(value = "pageNo", defaultValue = "1")  Integer pageNo,
                                        @RequestParam(value = "size", defaultValue = "10") Integer pageSize) {
        Page<PostVO> list = iBmsPostService.getList(new Page<>(pageNo, pageSize), tab);
        return ApiResult.success(list);
    }
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ApiResult<BmsPost> create(@RequestHeader(value = USER_NAME) String userName
            , @RequestBody CreateTopicDTO dto) {
        UmsUser user = umsUserService.getUserByUsername(userName);
        BmsPost topic = iBmsPostService.create(dto, user);
        return ApiResult.success(topic);
    }
    @GetMapping()
    public ApiResult<Map<String, Object>> view(@RequestParam("id") String id) {
        Map<String, Object> map = iBmsPostService.viewTopic(id);
        return ApiResult.success(map);
    }
}
