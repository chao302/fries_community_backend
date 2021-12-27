package com.xinchao.fries_community_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xinchao.fries_community_backend.model.entity.BmsPost;
import com.xinchao.fries_community_backend.model.vo.PostVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BmsTopicMapper extends BaseMapper<BmsPost> {
    /**
     * 分页查询首页话题列表
     * <p>
     *
     * @param page
     * @param tab
     * @return
     */
    Page<PostVO> selectListAndPage(@Param("page") Page<PostVO> page, @Param("tab") String tab);
    /**
     * 全文检索
     *
     * @param page
     * @param keyword
     * @return
     */
    Page<PostVO> searchByKey(@Param("page") Page<PostVO> page, @Param("keyword") String keyword);
}
