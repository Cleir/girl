package com.cleir.girl.service;


import com.cleir.girl.domain.Girl;
import com.cleir.girl.enums.ResultEnums;
import com.cleir.girl.exception.GirlException;
import com.cleir.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create By Cleir Leong
 * 2018/6/28 15:36
 **/
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findById(id).orElse(null);
        Integer age = girl.getAge();
        if(age < 10){
            throw new GirlException(ResultEnums.PRIMARY_SCHOOL);
        }else if(age > 10 && age < 16){
            throw new GirlException(ResultEnums.MIDDLE_SCHOOL);
        }
    }
}
