package com.xinchao.fries_community_backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xinchao.fries_community_backend.model.entity.BmsTag;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 新超
 * @version : 1.0
 * @Project : fries_community_backend
 * @Package : com.xinchao.fries_community_backend.service
 * @ClassName : IBmsTagService.java
 * @createTime : 2021/12/16 13:17
 * @Email : xinchao302@foxmail.com
 * @Description :
 */
public interface IBmsTagService extends IService<BmsTag> {
    /**
     * 插入标签
     *
     * @param tags
     * @return
     */
    List<BmsTag> insertTags(List<String> tags);

}