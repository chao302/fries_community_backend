package com.xinchao.fries_community_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xinchao.fries_community_backend.model.entity.BmsTag;

import java.util.List;


public interface IBmsTagService extends IService<BmsTag> {
    /**
     * 插入标签
     *
     * @param tags
     * @return
     */
    List<BmsTag> insertTags(List<String> tags);

}