package com.bob.stu.exception;

import com.bob.stu.enums.ResultEnum;

/**
 * Service层异常
 * <p>
 * 注意：Spring事务管理只对RuntimeException进行回滚
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/5/14
 */
public class ServiceException extends RuntimeException {

    private Integer code;

    public ServiceException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public ServiceException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
