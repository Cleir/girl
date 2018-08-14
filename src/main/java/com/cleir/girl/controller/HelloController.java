package com.cleir.girl.controller;


import com.cleir.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/* *
 * Create By Cleir Leong
 * 2018/6/28 10:41
 **/
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

    @GetMapping(value = {"/B", "/girl/{id}"})
    public String say(@PathVariable(value = "id", required = false) Integer myId){
        return girlProperties.getCupSize() + myId;
    }

}
