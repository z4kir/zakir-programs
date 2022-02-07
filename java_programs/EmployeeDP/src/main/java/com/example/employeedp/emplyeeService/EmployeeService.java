package com.example.employeedp.emplyeeService;

import com.example.employeedp.employee.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee postEmployee(Employee employee);

    Employee findById(long id);

    Employee update(long id, Employee employee);

    void delete(long id);
}
