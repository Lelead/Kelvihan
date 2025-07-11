package com.kelvihanl.controller;

import com.kelvihanl.common.Result;
import com.kelvihanl.entity.Employee;
import com.kelvihanl.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    /**
     * 查询所有数据
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<Employee> list = employeeService.selectAll();
        return Result.success(list);
    }

}
