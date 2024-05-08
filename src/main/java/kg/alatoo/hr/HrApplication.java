package kg.alatoo.hr;

import kg.alatoo.hr.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HrApplication {

	Employee employee = new Employee();


	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}


}
