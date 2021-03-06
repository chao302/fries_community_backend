package com.xinchao.fries_community_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vdurmont.emoji.EmojiParser;
import com.xinchao.fries_community_backend.mapper.BmsTagMapper;
import com.xinchao.fries_community_backend.mapper.BmsTopicMapper;
import com.xinchao.fries_community_backend.mapper.UmsUserMapper;
import com.xinchao.fries_community_backend.model.dto.CreateTopicDTO;
import com.xinchao.fries_community_backend.model.entity.BmsPost;
import com.xinchao.fries_community_backend.model.entity.BmsTag;
import com.xinchao.fries_community_backend.model.entity.BmsTopicTag;
import com.xinchao.fries_community_backend.model.entity.UmsUser;
import com.xinchao.fries_community_backend.model.vo.PostVO;
import com.xinchao.fries_community_backend.model.vo.ProfileVO;
import com.xinchao.fries_community_backend.service.IBmsPostService;
import com.xinchao.fries_community_backend.service.IBmsTagService;
import com.xinchao.fries_community_backend.service.IUmsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class IBmsPostServiceImpl extends ServiceImpl<BmsTopicMapper, BmsPost> implements IBmsPostService {
    @Resource
    private BmsTagMapper bmsTagMapper;

    @Resource
    private UmsUserMapper umsUserMapper;

    @Autowired
    @Lazy
    private IBmsTagService iBmsTagService;

    @Autowired
    private IUmsUserService iUmsUserService;

    @Autowired
    private com.xinchao.fries_community_backend.service.IBmsTopicTagService IBmsTopicTagService;
    @Override
    public Page<PostVO> getList(Page<PostVO> page, String tab) {
        // ????????????
        Page<PostVO> iPage = this.baseMapper.selectListAndPage(page, tab);
        // ?????????????????????
        setTopicTags(iPage);
        return iPage;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BmsPost create(CreateTopicDTO dto, UmsUser user) {
        BmsPost topic1 = this.baseMapper.selectOne(new LambdaQueryWrapper<BmsPost>().eq(BmsPost::getTitle, dto.getTitle()));
        Assert.isNull(topic1, "???????????????????????????");

        // ??????
        BmsPost topic = BmsPost.builder()
                .userId(user.getId())
                .title(dto.getTitle())
                .content(EmojiParser.parseToAliases(dto.getContent()))
                .createTime(new Date())
                .build();
        this.baseMapper.insert(topic);

        // ??????????????????
        int newScore = user.getScore() + 1;
        umsUserMapper.updateById(user.setScore(newScore));

        // ??????
        if (!ObjectUtils.isEmpty(dto.getTags())) {
            // ????????????
            List<BmsTag> tags = iBmsTagService.insertTags(dto.getTags());
            // ??????????????????????????????
            IBmsTopicTagService.createTopicTag(topic.getId(), tags);
        }

        return topic;
    }
    @Override
    public Map<String, Object> viewTopic(String id) {
        Map<String, Object> map = new HashMap<>(16);
        BmsPost topic = this.baseMapper.selectById(id);
        Assert.notNull(topic, "?????????????????????,?????????????????????");
        // ??????????????????
        topic.setView(topic.getView() + 1);
        this.baseMapper.updateById(topic);
        // emoji??????
        topic.setContent(EmojiParser.parseToUnicode(topic.getContent()));
        map.put("topic", topic);
        // ??????
        QueryWrapper<BmsTopicTag> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(BmsTopicTag::getTopicId, topic.getId());
        Set<String> set = new HashSet<>();
        for (BmsTopicTag articleTag : IBmsTopicTagService.list(wrapper)) {
            set.add(articleTag.getTagId());
        }
        List<BmsTag> tags = iBmsTagService.listByIds(set);
        map.put("tags", tags);

        // ??????

        ProfileVO user = iUmsUserService.getUserProfile(topic.getUserId());
        map.put("user", user);

        return map;
    }
    @Override
    public Page<PostVO> searchByKey(String keyword, Page<PostVO> page) {
        // ????????????
        Page<PostVO> iPage = this.baseMapper.searchByKey(page, keyword);
        // ?????????????????????
        setTopicTags(iPage);
        return iPage;
    }


    private void setTopicTags(Page<PostVO> iPage) {
        iPage.getRecords().forEach(topic -> {
            List<BmsTopicTag> topicTags = IBmsTopicTagService.selectByTopicId(topic.getId());
            if (!topicTags.isEmpty()) {
                List<String> tagIds = topicTags.stream().map(BmsTopicTag::getTagId).collect(Collectors.toList());
                List<BmsTag> tags = bmsTagMapper.selectBatchIds(tagIds);
                topic.setTags(tags);
            }
        });
    }
}