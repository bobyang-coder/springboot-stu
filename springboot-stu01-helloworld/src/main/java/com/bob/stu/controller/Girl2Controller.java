package com.bob.stu.controller;

import com.bob.stu.dao.GirlDao;
import com.bob.stu.domain.Girl;
import com.bob.stu.domain.Result;
import com.bob.stu.service.GirlService;
import com.bob.stu.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 在GirlController的基础上进行增强
 * <p>
 * 1.加入表单校验
 *
 * @author bob  <bobyang_coder@163.com>
 * @since 2017/5/14
 */
@RestController
@RequestMapping("girl2")
public class Girl2Controller {
    private static final Logger logger = LoggerFactory.getLogger(Girl2Controller.class);

    @Autowired
    private GirlDao girlDao;
    @Autowired
    private GirlService girlService;

    @GetMapping("list")
    public List<Girl> list() {
        logger.info("==========method:list========");
        return girlDao.findAll();
    }

    /**
     * 添加
     *
     * @return
     */
    @PostMapping("add")
    public Result add(@Valid Girl girl, BindingResult bindingResult) {
        logger.info("==========method:add========");
        if (bindingResult.hasErrors()) {
            return null;
//            return ResultUtils.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtils.success(girlDao.save(girl));
    }

    /**
     * 查询某个
     *
     * @param id
     * @return
     */
    @GetMapping(value = "{id}")
    public Girl get(@PathVariable("id") Integer id) {
        logger.info("==========method:get========");
        return girlDao.findOne(id);
    }


    /**
     * 更新某个
     *
     * @param id
     * @param name
     * @param age
     * @return
     */
    @PutMapping(value = "{id}")
    public Girl update(@PathVariable(value = "id") Integer id,
                       @RequestParam(value = "name") String name,
                       @RequestParam(value = "age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setName(name);
        return girlDao.save(girl);
    }

    /**
     * 删除某个
     *
     * @param id
     */
    @DeleteMapping("{id}")
    public void del(@PathVariable(value = "id") Integer id) {
        girlDao.delete(id);
    }

    @GetMapping("find/age/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age) {
        return girlDao.findByAge(age);
    }

    @GetMapping("check/age/{id}")
    public void checkAge(@PathVariable("id") Integer id) {
        girlService.checkAge(id);
    }
}
