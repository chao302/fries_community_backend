package com.xinchao.fries_community_backend.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 新超
 * @version : 1.0
 * @Project : fries_community_backend
 * @Package : com.xinchao.fries_community_backend.model.entity
 * @ClassName : BmsPost.java
 * @createTime : 2021/12/14 15:48
 * @Email : xinchao302@foxmail.com
 * @Description :
 */
public class BmsPost implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 标题
     */
    @NotBlank(message = "标题不可以为空")
    @TableField(value = "title")
    private String title;
    /**
     * markdown
     */
    @NotBlank(message = "内容不可以为空")
    @TableField("`content`")
    private String content;

    /**
     * 作者ID
     */
    @TableField("user_id")
    private String userId;

    /**
     * 评论数
     */
    @TableField("comments")
    @Builder.Default
    private Integer comments = 0;

    /**
     * 收藏数
     */
    @TableField("collects")
    @Builder.Default
    private Integer collects = 0;

    /**
     * 浏览数
     */
    @TableField("view")
    @Builder.Default
    private Integer view = 0;

    /**
     * 专栏ID，默认不分栏
     */
    @TableField("section_id")
    @Builder.Default
    private Integer sectionId = 0;

    /**
     * 置顶
     */
    @TableField("top")
    @Builder.Default
    private Boolean top = false;

    /**
     * 加精
     */
    @TableField("essence")
    @Builder.Default
    private Boolean essence = false;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "modify_time", fill = FieldFill.UPDATE)
    private Date modifyTime;
}
