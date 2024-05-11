//package kg.alatoo.hr.config;
//
//import kg.alatoo.hr.entity.Department;
//import kg.alatoo.hr.entity.Employee;
//import kg.alatoo.hr.repository.DepartmentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DataBootstrap implements CommandLineRunner {
//    @Autowired
//    private DepartmentRepository departmentRepository;
//    public static List<Department> createDepartments() {
//        List<Department> departments = new ArrayList<>();
//
//        // Add sample departments
//        departments.add(new Department("IT Faculty"));
//        departments.add(new Department("Finance"));
//        departments.add(new Department("IT"));
//
//        return departments;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        List<Department> departments = createDepartments();
//        departmentRepository.saveAll(departments);
//    }
//
////    public static List<Employee> createEmployees() {
////        List<Employee> employees = new ArrayList<>();
////
////        // Add sample employees
////        employees.add(new Employee("John Doe", "HR", "Manager"));
////        employees.add(new Employee("Jane Smith", "Finance", "Accountant"));
////        employees.add(new Employee("Michael Johnson", "IT", "Developer"));
////
////        return employees;
////    }
////
////    public static List<Leave> createLeaves() {
////        List<Leave> leaves = new ArrayList<>();
////
////        // Add sample leave records
////        leaves.add(new Leave("John Doe", "2024-05-01", "2024-05-05"));
////        leaves.add(new Leave("Jane Smith", "2024-06-10", "2024-06-15"));
////        leaves.add(new Leave("Michael Johnson", "2024-07-20", "2024-07-25"));
////
////        return leaves;
////    }
//
////    public static List<Position> createPositions() {
////        List<Position> positions = new ArrayList<>();
////
////        // Add sample positions
////        positions.add(new Position("Manager"));
////        positions.add(new Position("Accountant"));
////        positions.add(new Position("Developer"));
////
////        return positions;
////    }
//}
