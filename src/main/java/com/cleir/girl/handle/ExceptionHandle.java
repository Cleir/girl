package com.cleir.girl.handle;

import com.cleir.girl.domain.Girl;
import com.cleir.girl.domain.Result;
import com.cleir.girl.enums.ResultEnums;
import com.cleir.girl.exception.GirlException;
import com.cleir.girl.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create By Cleir Leong
 * 2018/6/30 16:07
 **/
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.fail(girlException.getCode(), e.getMessage());
        }
        return ResultUtil.fail(-1, e.getMessage());
    }

}
