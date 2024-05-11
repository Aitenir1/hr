package kg.alatoo.hr.controller;

import kg.alatoo.hr.entity.Employee;
import kg.alatoo.hr.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getEmployeeList() {
        return ResponseEntity.ok(employeeService.getEmployeeList());
    }
}
