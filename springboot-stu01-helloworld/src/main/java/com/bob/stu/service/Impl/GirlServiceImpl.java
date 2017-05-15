package com.bob.stu.service.Impl;

import com.bob.stu.dao.GirlDao;
import com.bob.stu.domain.Girl;
import com.bob.stu.enums.ResultEnum;
import com.bob.stu.exception.ServiceException;
import com.bob.stu.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Girl业务层实现
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/5/14
 */
@Service
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlDao girlDao;

    /**
     * 检查指定女孩的年龄
     *
     * @param id 主键
     */
    public void checkAge(Integer id) {
        Girl girl = girlDao.findOne(id);
        if (null == girl) {
            throw new ServiceException(ResultEnum.ILLEGAL_PARAM);
        }
        Integer age = girl.getAge();
        if (age < 10) {
            throw new ServiceException(201, "小学生!");
        } else if (age < 16) {
            throw new ServiceException(202, "初中生!");
        }
    }
}
