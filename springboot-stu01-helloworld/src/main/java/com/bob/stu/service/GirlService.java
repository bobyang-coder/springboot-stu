package com.bob.stu.service;

import com.bob.stu.exception.ServiceException;

/**
 * Girl业务层
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/5/14
 */
public interface GirlService {

    /**
     * 检查指定女孩的年龄
     *
     * @param id 主键
     */
    void checkAge(Integer id) throws ServiceException;
}
