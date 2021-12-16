package com.xinchao.fries_community_backend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xinchao.fries_community_backend.model.dto.CreateTopicDTO;
import com.xinchao.fries_community_backend.model.entity.BmsPost;
import com.xinchao.fries_community_backend.model.entity.UmsUser;
import com.xinchao.fries_community_backend.model.vo.PostVO;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 新超
 * @version : 1.0
 * @Project : fries_community_backend
 * @Package : com.xinchao.fries_community_backend.service
 * @ClassName : IBmsPostService.java
 * @createTime : 2021/12/15 22:39
 * @Email : xinchao302@foxmail.com
 * @Description :
 */
public interface IBmsPostService extends IService<BmsPost> {
    /**
     * 获取首页话题列表
     *
     * @param page
     * @param tab
     * @return
     */
    Page<PostVO> getList(Page<PostVO> page, String tab);
    /**
     * 发布
     *
     * @param dto
     * @param principal
     * @return
     */
    BmsPost create(CreateTopicDTO dto, UmsUser principal);

    /**
     * 查看话题详情
     *
     * @param id
     * @return
     */
    Map<String, Object> viewTopic(String id);
    /**
     * 关键字检索
     *
     * @param keyword
     * @param page
     * @return
     */
    Page<PostVO> searchByKey(String keyword, Page<PostVO> page);
}
