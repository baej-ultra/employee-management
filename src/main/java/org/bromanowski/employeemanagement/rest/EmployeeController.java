package org.bromanowski.employeemanagement.rest;

import org.bromanowski.employeemanagement.entity.Employee;
import org.bromanowski.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getSingleEmployee(@PathVariable int id) {
        return employeeService
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No employee with id " + id));
    }

    @PostMapping
    Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(null);
        return employeeService.save(employee);
    }

    @PutMapping()
    Employee editEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        if (employeeService.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No employee with id " + id);
        }
        employeeService.deleteById(id);
        return "Employee deleted - " + id;
    }

}
