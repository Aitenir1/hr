package kg.alatoo.hr.controller;

import kg.alatoo.hr.entity.Department;
import kg.alatoo.hr.service.impl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/department")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;

    @GetMapping("")
    public ResponseEntity<Department> getByName(@RequestParam Long id) {
        return ResponseEntity.ok(departmentService.getById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<Department> getByName(@RequestParam String name) {
        return ResponseEntity.ok(departmentService.getByName(name));
    }
}