package com.atguigu.mp.test;


import com.atguigu.mp.beans.Employee;
import com.atguigu.mp.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gxl
 * @date 2021年08月22日 12:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestMP {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 条件构造器 删除操作
     */
    @Test
    public void testQueryWrapperDelete(){
        employeeMapper.delete(new QueryWrapper<Employee>()
                    .eq("last_name","Tom")
                    .eq("age",22));
    }

    /**
     * 条件构造器 修改操作
     */
    @Test
    public void testQueryWrapperUpdate(){
        Employee employee = new Employee("cls","cls@qq.com",0,null);
        int result = employeeMapper.update(employee, new QueryWrapper<Employee>()
                .eq("last_name", "Tom")
                .eq("age", 44));
    }
    
    /**
     * 条件构造器 查询操作
     */
    @Test
    public void testQueryWrapperSelect(){
        //我们需要分页查询tbl_employee表中，年龄在18~50之间性别为男且姓名为Tom的所有用户
//        Page<Employee> emps = employeeMapper.selectPage(new Page<>(1, 2),
//                new QueryWrapper<Employee>()
//                        .between("age", 18, 50)
//                        .eq("gender", 1)
//                        .eq("last_name", "Tom"));
//        System.out.println(emps.getRecords());

        //查询tbl_employee表中，性别为女并且名字中带有"老师"或者邮箱中带有"a"
//        List<Employee> emps = employeeMapper.selectList(new QueryWrapper<Employee>()
//                .eq("gender", 0)
//                .like("last_name", "老师")
//                .or()
//                .like("email", "a"));
//        System.out.println(emps);

        //查询性别为女的，根据age进行排序(asc/desc)，简单分页
//        Page<Employee> emps = employeeMapper.selectPage(new Page<>(1, 2), new QueryWrapper<Employee>()
//                .eq("gender", 0)
//                //.orderByAsc("age")
//                .last("order by age")
//        );
//        emps.getRecords().forEach(System.out::println);
    }

    /**
     * 通用删除操作
     */
    @Test
    public void testCommonDelete(){
        //1.根据id进行删除
        int result = employeeMapper.deleteById(11);
        System.out.println("result："+result);

        //2.根据条件进行删除
//        Map<String,Object> columnMap = new HashMap<>();
//        columnMap.put("last_name","MP");
//        columnMap.put("email","mp@qq.com");
//        int result = employeeMapper.deleteByMap(columnMap);
//        System.out.println("result："+result);

        //3.批量删除
//        int result = employeeMapper.deleteBatchIds(Arrays.asList(3, 4, 5));
//        System.out.println("result："+result);
    }

    /**
     * 通用查询操作
     */
    @Test
    public void testCommonSelect(){
        //1.通过id查询
//        Employee employee = employeeMapper.selectById(7);
//        System.out.println(employee);

        //2.通过多个列进行查询，通过id + lastName
//        Employee employee = new Employee();
//        employee.setId(2);
//        employee.setLastName("Jerry");
//        //employee.setGender(1);
//        QueryWrapper<Employee> wrapper = new QueryWrapper<>(employee);
//
//        Employee result = employeeMapper.selectOne(wrapper);
//        System.out.println("result："+result);

        //3.通过多个id进行查询
//        employeeMapper.selectBatchIds(Arrays.asList(4,5,6)).forEach(System.out::println);

        //4.通过Map封装条件查询
//        Map<String,Object> columnMap = new HashMap<>();
//        columnMap.put("last_name","Tom");
//        columnMap.put("gender",1);
//        employeeMapper.selectByMap(columnMap).forEach(System.out::println);

        //5.分页查询
        Page<Employee> emps = employeeMapper.selectPage(new Page<>(2, 2), null);
        List<Employee> result = emps.getRecords();
        for (Employee employee : result) {
            System.out.println(employee);
        }
    }

    /**
     * 通用更新操作
     */
    @Test
    public void testCommonUpdate(){
        //初始化修改对象
        Employee employee = new Employee(6,"玛利亚老师","mly@qq.com",0,null);

        int result = employeeMapper.updateById(employee);
        System.out.println("result："+result);
    }

    /**
     * 通用 插入操作
     * @author gxl
     * @date 2021/8/22 13:44
     */
    @Test
    public void testCommonInsert(){

        //初始化Employee对象
        Employee employee = new Employee("MP","mp@qq.com",null,21);
        employee.setSalary(2000.0);
        //插入到数据库
        int result = employeeMapper.insert(employee);
        System.out.println("result："+result);

        //获取当前数据在数据库中的主键值
        Integer key = employee.getId();
        System.out.println("key："+key);
    }

    @Test
    public void testDataSource() throws Exception{
        System.out.println(dataSource.getConnection());
    }
}
