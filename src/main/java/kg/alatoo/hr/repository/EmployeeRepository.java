package kg.alatoo.hr.repository;

import jakarta.persistence.Id;
import kg.alatoo.hr.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> getEmployeeByLastName(String lastName);
}
