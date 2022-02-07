package com.example.employeedp.employeeResporitory;

import com.example.employeedp.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
