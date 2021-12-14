package com.xinchao.fries_community_backend.common.exception;

import com.xinchao.fries_community_backend.common.api.IErrorCode;
/**
 * Created with IntelliJ IDEA.
 *
 * @author : 新超
 * @version : 1.0
 * @Project : fries_community_backend
 * @Package : com.xinchao.fries_community_backend.common.exception
 * @ClassName : ApiException.java
 * @createTime : 2021/12/14 15:22
 * @Email : xinchao302@foxmail.com
 * @Description :
 */
public class ApiException extends RuntimeException {
    private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}