package com.xinchao.fries_community_backend.common.api;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 新超
 * @version : 1.0
 * @Project : fries_community_backend
 * @Package : com.xinchao.fries_community_backend.common.api
 * @ClassName : IErrorCode.java
 * @createTime : 2021/12/12 18:01
 * @Email : xinchao302@foxmail.com
 * @Description :
 */
public interface IErrorCode {

     //错误编码: -1失败;200成功
     //@return 错误编码
    Integer getCode();

     //错误描述
     //@return 错误描述
    String getMessage();
}
