package com.atguigu.mp.beans;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * javaBean
 *
 * 定义JavaBean中成员变量时所使用的类型
 *  因为每个基本类型都有一个默认值：
 *      int -> 0
 *      boolean -> false
 *
 * @author gxl
 * @date 2021年08月22日 11:01
 */

/**
 * MyBatisPlus会默认使用实体类的类名到数据库中找对应的表
 */
//@TableName("tbl_employee")
public class Employee {

    /*
     * @TableId:
     *      value：指定表中的主键列的列名，如果实体属性名与列名一致，可以省略不指定
     *      type：指定主键策略
     */
    //@TableId(value = "id",type = IdType.AUTO)
    private Integer id; //int

    @TableField(value = "last_name")
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    @TableField(exist = false)
    private Double salary;

    public Employee() {
    }

    public Employee(String lastName, String email, Integer gender, Integer age) {
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public Employee(Integer id, String lastName, String email, Integer gender, Integer age) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
