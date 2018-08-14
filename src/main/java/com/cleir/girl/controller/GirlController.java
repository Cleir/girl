package com.cleir.girl.controller;

import com.cleir.girl.aspect.HttpAspect;
import com.cleir.girl.domain.Girl;
import com.cleir.girl.domain.Result;
import com.cleir.girl.repository.GirlRepository;
import com.cleir.girl.service.GirlService;
import com.cleir.girl.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Create By Cleir Leong
 * 2018/6/28 14:56
 **/
@RestController
@RequestMapping("/girls")
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询列表
     * @return
     */
    @GetMapping()
    public List<Girl> girlList(){
        logger.info("girlList");
        return girlRepository.findAll();
    }

    /**
     * 添加一个
     * @param Girl
     * @return
     */
    @PostMapping()
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.fail(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 通过id查找
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Girl getGirl(@PathVariable("id") Integer id){
        return girlRepository.findById(id).get();
    }

    /**
     * 更新
     * @param id
     * @param cupSize
     * @param age
     * @return
     */
    @PutMapping("/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRepository.save(girl);
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping("/{id}")
    public void deleteGirl(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    /**
     * 通过年龄查询
     * @param age
     * @return
     */
    @GetMapping("/age/{age}")
    public List<Girl> getGirlsByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }

    @GetMapping("/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}
