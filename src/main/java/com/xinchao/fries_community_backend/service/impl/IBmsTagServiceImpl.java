package com.xinchao.fries_community_backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xinchao.fries_community_backend.mapper.BmsTagMapper;
import com.xinchao.fries_community_backend.model.entity.BmsTag;
import com.xinchao.fries_community_backend.service.IBmsTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 新超
 * @version : 1.0
 * @Project : fries_community_backend
 * @Package : com.xinchao.fries_community_backend.service.impl
 * @ClassName : IBmsTagServiceImpl.java
 * @createTime : 2021/12/16 13:23
 * @Email : xinchao302@foxmail.com
 * @Description :
 */
@Service
public class IBmsTagServiceImpl extends ServiceImpl<BmsTagMapper, BmsTag> implements IBmsTagService {

    @Autowired
    private com.xinchao.fries_community_backend.service.IBmsTopicTagService IBmsTopicTagService;

    @Autowired
    private com.xinchao.fries_community_backend.service.IBmsPostService iBmsPostService;


    @Override
    public List<BmsTag> insertTags(List<String> tagNames) {
        List<BmsTag> tagList = new ArrayList<>();
        for (String tagName : tagNames) {
            BmsTag tag = this.baseMapper.selectOne(new LambdaQueryWrapper<BmsTag>().eq(BmsTag::getName, tagName));
            if (tag == null) {
                tag = BmsTag.builder().name(tagName).build();
                this.baseMapper.insert(tag);
            } else {
                tag.setTopicCount(tag.getTopicCount() + 1);
                this.baseMapper.updateById(tag);
            }
            tagList.add(tag);
        }
        return tagList;
    }



}