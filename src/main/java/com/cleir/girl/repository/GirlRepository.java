package com.cleir.girl.repository;

import com.cleir.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Create By Cleir Leong 
 * 2018/6/28 14:58
 **/
public interface GirlRepository extends JpaRepository<Girl, Integer> {

    //通过年龄查询
    public List<Girl> findByAge(Integer age);
}
