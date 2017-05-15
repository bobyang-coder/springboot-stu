package com.bob.stu.dao;

import com.bob.stu.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by bob on 2017/5/14.
 *
 * @author bob
 * @since 2017/5/14
 */
public interface GirlDao extends JpaRepository<Girl, Integer> {

    List<Girl> findByAge(Integer age);
}
