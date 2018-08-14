package com.cleir.girl.util;

import com.cleir.girl.domain.Result;

/**
 * Create By Cleir Leong 
 * 2018/6/30 14:57
 **/
public class ResultUtil {

    public static Result success(Object obj) {
        Result re = new Result();
        re.setCode(0);
        re.setMsg("成功");
        re.setData(obj);
        return re;
    }

    public static Result fail(Integer code, String msg){
        Result re = new Result();
        re.setCode(code);
        re.setMsg(msg);
        return re;
    }
}
