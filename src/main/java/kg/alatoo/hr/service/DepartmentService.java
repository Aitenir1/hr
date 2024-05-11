package kg.alatoo.hr.service;

import kg.alatoo.hr.entity.Department;

public interface DepartmentService {


    Department getByName(String name);

    Department getById(Long id);
}
