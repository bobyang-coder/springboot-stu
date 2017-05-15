package com.bob.stu.handle;

import com.bob.stu.domain.Result;
import com.bob.stu.enums.ResultEnum;
import com.bob.stu.exception.ServiceException;
import com.bob.stu.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 异常处理器
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/5/14
 */
@ControllerAdvice
public class ExceptionHandle {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof ServiceException) {
            ServiceException se = (ServiceException) e;
            logger.warn("[ServiceException]-code:{},msg={}", se.getCode(), se.getMessage(), e);
            return ResultUtils.error(se.getCode(), se.getMessage());
        }
        logger.warn("[Exception]-msg={}", e.getMessage(), e);
        return ResultUtils.error(ResultEnum.UNKONW_ERROR.getCode(), ResultEnum.UNKONW_ERROR.getMsg());
    }
}
