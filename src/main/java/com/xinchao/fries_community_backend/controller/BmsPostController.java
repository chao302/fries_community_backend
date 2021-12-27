package com.xinchao.fries_community_backend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vdurmont.emoji.EmojiParser;
import com.xinchao.fries_community_backend.common.api.ApiResult;
import com.xinchao.fries_community_backend.model.dto.CreateTopicDTO;
import com.xinchao.fries_community_backend.model.entity.BmsPost;
import com.xinchao.fries_community_backend.model.entity.UmsUser;
import com.xinchao.fries_community_backend.model.vo.PostVO;
import com.xinchao.fries_community_backend.service.IBmsPostService;
import com.xinchao.fries_community_backend.service.IUmsUserService;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;

import java.util.Date;
import java.util.Map;

import static com.xinchao.fries_community_backend.jwt.JwtUtil.USER_NAME;

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

    //帖子更新与删除
    @PostMapping("/update")
    public ApiResult<BmsPost> update(@RequestHeader(value = USER_NAME) String userName, @Valid @RequestBody BmsPost post) {
        UmsUser umsUser = umsUserService.getUserByUsername(userName);
        Assert.isTrue(umsUser.getId().equals(post.getUserId()), "非本人无权修改");
        post.setModifyTime(new Date());
        post.setContent(EmojiParser.parseToAliases(post.getContent()));
        iBmsPostService.updateById(post);
        return ApiResult.success(post);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResult<String> delete(@RequestHeader(value = USER_NAME) String userName, @PathVariable("id") String id) {
        UmsUser umsUser = umsUserService.getUserByUsername(userName);
        BmsPost byId = iBmsPostService.getById(id);
        Assert.notNull(byId, "话题已不存在");
        Assert.isTrue(byId.getUserId().equals(umsUser.getId()), "你无权删除别人的话题");
        iBmsPostService.removeById(id);
        return ApiResult.success(null,"删除成功");
    }
}
