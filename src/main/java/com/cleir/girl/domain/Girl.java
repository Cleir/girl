package com.cleir.girl.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Create By Cleir Leong
 * 2018/6/28 14:25
 **/
@Entity
public class Girl implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String cupSize;
    @Min(value = 12, message = "未成年")
    private Integer age;
    @NotNull(message = "金额必填")
    private Double money;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }

}
