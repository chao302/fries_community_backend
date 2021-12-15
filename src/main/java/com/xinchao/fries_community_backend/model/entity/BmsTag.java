package com.xinchao.fries_community_backend.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 新超
 * @version : 1.0
 * @Project : fries_community_backend
 * @Package : com.xinchao.fries_community_backend.model.entity
 * @ClassName : BmsTag.java
 * @createTime : 2021/12/15 22:37
 * @Email : xinchao302@foxmail.com
 * @Description :
 */
@Data
@Builder
@TableName("bms_tag")
@Accessors(chain = true)
public class BmsTag implements Serializable {
    private static final long serialVersionUID = 3257790983905872243L;

    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    @TableField("name")
    private String name;
    /**
     * 当前标签下的话题个数
     */
    @TableField("topic_count")
    @Builder.Default
    private Integer topicCount = 1;
}