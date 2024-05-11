package kg.alatoo.hr.service.impl;

import kg.alatoo.hr.entity.Employee;
import kg.alatoo.hr.repository.EmployeeRepository;
import kg.alatoo.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }
}
