package org.bromanowski.employeemanagement.service;

import org.bromanowski.employeemanagement.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
}
