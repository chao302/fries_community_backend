package com.xinchao.fries_community_backend.common.api;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 新超
 * @version : 1.0
 * @Project : fries_community_backend
 * @Package : com.xinchao.fries_community_backend.common.api
 * @ClassName : ApiErrorCode.java
 * @createTime : 2021/12/12 18:00
 * @Email : xinchao302@foxmail.com
 * @Description :
 */
public enum ApiErrorCode implements IErrorCode {

     //成功
    SUCCESS(200, "操作成功"),

    //失败
    FAILED(-1, "操作失败"),

    //未登录，Token过期
    UNAUTHORIZED(401, "暂未登录或token已经过期"),

     //权限不足
    FORBIDDEN(403, "权限不足"),

    //参数校验错误
    VALIDATE_FAILED(404, "参数检验失败");

    private final Integer code;
    private final String message;

    ApiErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ApiErrorCode{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
