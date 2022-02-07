package com.example.employeedp.employeeController;

import com.example.employeedp.employee.Employee;
import com.example.employeedp.emplyeeService.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.annotation.ResponseStatusExceptionResolver;

import java.util.List;

@RequestMapping("/user/login")
@RestController
public class EmployeeController {
    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    //    get rest api
    @GetMapping
    public List<Employee> getAllEmployee() {
        return service.getAllEmployee();

    }

    //    post rest api
    @PostMapping
    public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee) {
        ResponseEntity<Employee> saveEmployee = new ResponseEntity<>(service.postEmployee(employee), HttpStatus.CREATED);
        return saveEmployee;

    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> findById(@PathVariable("id") long id) {
        ResponseEntity<Employee> employeeById = new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        return employeeById;

    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> update(@PathVariable("id") long id,
                                           @RequestBody Employee employee) {

        ResponseEntity<Employee> update = new ResponseEntity<>(service.update(id, employee), HttpStatus.OK);
        return update;

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") long id) {
        service.delete(id);
    }


}
