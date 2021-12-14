package com.xinchao.fries_community_backend.common.exception;

import com.xinchao.fries_community_backend.common.api.IErrorCode;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 新超
 * @version : 1.0
 * @Project : fries_community_backend
 * @Package : com.xinchao.fries_community_backend.common.exception
 * @ClassName : ApiAsserts.java
 * @createTime : 2021/12/14 15:18
 * @Email : xinchao302@foxmail.com
 * @Description :
 */
public class ApiAsserts {
    /**
     * 抛失败异常
     *
     * @param message 说明
     */
    public static void fail(String message) {
        throw new ApiException(message);
    }

    /**
     * 抛失败异常
     *
     * @param errorCode 状态码
     */
    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}