package com.example.employeedp.emplyeServiceImp;

import com.example.employeedp.employee.Employee;
import com.example.employeedp.employeeException.ResourceNotFoundException;
import com.example.employeedp.employeeResporitory.EmployeeRepository;
import com.example.employeedp.emplyeeService.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private EmployeeRepository respo;

    public EmployeeServiceImp(EmployeeRepository respo) {
        this.respo = respo;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return respo.findAll();
    }

    @Override
    public Employee postEmployee(Employee employee) {
        return respo.save(employee);
    }

    @Override
    public Employee findById(long id) {
        return respo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
    }

    @Override
    public Employee update(long id, Employee employee) {
        Employee existEmployee = respo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        existEmployee.setId(employee.getId());
        existEmployee.setUsername(employee.getUsername());
        existEmployee.setPassword(employee.getPassword());

        return respo.save(existEmployee);
    }

    @Override
    public void delete(long id) {
        respo.delete(respo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id)));

    }
}
