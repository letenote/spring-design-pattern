package letenote.designpattern.prototype.employee;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class EmployeePrototype {
	@Bean
	@Scope("prototype")
	public Employee staffEmployee(){
		Employee newStaff = new Employee();
		newStaff.setSalary(EmployeeSalary.STAFF);
		newStaff.setPosition(EmployeePosition.STAFF);
		return newStaff;
	}
	@Bean
	@Scope("prototype")
	public Employee managerEmployee(){
		Employee newManager = new Employee();
		newManager.setSalary(EmployeeSalary.MANAGER);
		newManager.setPosition(EmployeePosition.MANAGER);
		return newManager;
	};
	@Bean
	@Scope("prototype")
	public Employee vpEmployee(){
		Employee newVp = new Employee();
		newVp.setSalary(EmployeeSalary.VP);
		newVp.setPosition(EmployeePosition.VP);
		return newVp;
	}
}
