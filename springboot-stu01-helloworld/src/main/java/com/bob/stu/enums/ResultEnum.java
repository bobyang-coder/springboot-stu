package com.bob.stu.enums;

/**
 * 错误码枚举类
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/5/14
 */
public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "操作成功"),
    ILLEGAL_PARAM(100, "参数不合法"),;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
