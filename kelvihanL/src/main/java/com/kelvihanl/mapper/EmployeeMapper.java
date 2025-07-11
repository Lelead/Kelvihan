package com.kelvihanl.mapper;

import com.kelvihanl.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    List<Employee> selectAll();

}
