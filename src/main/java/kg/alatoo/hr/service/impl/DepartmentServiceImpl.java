package kg.alatoo.hr.service.impl;

import kg.alatoo.hr.entity.Department;
import kg.alatoo.hr.repository.DepartmentRepository;
import kg.alatoo.hr.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department getByName(String name) {
        return departmentRepository.getByName(name);
    }

    @Override
    public Department getById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);

        return department.orElse(null);
    }
}
