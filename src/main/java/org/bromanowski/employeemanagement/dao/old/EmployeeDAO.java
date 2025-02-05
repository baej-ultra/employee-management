package org.bromanowski.employeemanagement.dao.old;

import org.bromanowski.employeemanagement.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
