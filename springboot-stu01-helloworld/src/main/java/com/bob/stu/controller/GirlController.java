package com.bob.stu.controller;

import com.bob.stu.dao.GirlDao;
import com.bob.stu.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bob  <bobyang_coder@163.com>
 * @since 2017/5/14
 */
@RestController
@RequestMapping("girl")
public class GirlController {

    @Autowired
    private GirlDao girlDao;

    @GetMapping("list")
    public List<Girl> list() {
        return girlDao.findAll();
    }

    /**
     * 添加
     *
     * @param name
     * @param age
     * @return
     */
    @PostMapping("add")
    public Girl add(@RequestParam(value = "name", defaultValue = "bob") String name,
                    @RequestParam(value = "age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setName(name);
        return girlDao.save(girl);
    }

    /**
     * 查询某个
     *
     * @param id
     * @return
     */
    @GetMapping(value = "{id}")
    public Girl get(@PathVariable("id") Integer id) {
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
}
