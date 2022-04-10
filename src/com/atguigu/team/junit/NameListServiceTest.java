package com.atguigu.team.junit;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;
import org.junit.jupiter.api.Test;

/**
 * @author wyl
 * @description 测试NameListService
 * @create 2022-04-08 22:31
 */
public class NameListServiceTest {
    NameListService service = new NameListService();
    @Test
    public void testGetAllEmployees(){
        Employee[] employees = service.getAllEmployees();
        for(int i = 0;i <employees.length;i++){
            System.out.println(employees[i]);
        }
    }
    @Test
    public void testGetEmployee(){
        int id = 1;
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());;
        }

    }

}
