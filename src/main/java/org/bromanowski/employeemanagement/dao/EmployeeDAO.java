package org.bromanowski.employeemanagement.dao;

import org.bromanowski.employeemanagement.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}
