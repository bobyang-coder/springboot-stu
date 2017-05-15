package com.bob.stu.utils;

import com.bob.stu.domain.Result;

/**
 * http请求返回的最外层对象工具类
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/5/14
 */
public class ResultUtils {


    public static Result success(Object obj) {
        return create(0, "操作成功", obj);
    }


    public static Result error(Integer code, String msg) {
        return create(code, msg, null);
    }

    public static Result create(Integer code, String msg, Object obj) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(obj);
        return result;
    }
}
