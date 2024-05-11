package kg.alatoo.hr.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import kg.alatoo.hr.entity.Department;
import kg.alatoo.hr.entity.Position;
import kg.alatoo.hr.entity.Salary;
import lombok.Data;

import java.util.Date;

@Data
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date dateOfBirth;
    private Department department;
    private Position position;
    private Date hireDate;
    private Salary salary;


}
