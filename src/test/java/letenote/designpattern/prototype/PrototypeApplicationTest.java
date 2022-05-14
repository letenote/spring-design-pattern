package letenote.designpattern.prototype;

import letenote.designpattern.prototype.employee.Employee;
import letenote.designpattern.prototype.employee.EmployeePosition;
import letenote.designpattern.prototype.employee.EmployeeSalary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = PrototypeApplication.class)
class PrototypeApplicationTest {
	@Autowired
	private final ApplicationContext applicationContext;

	PrototypeApplicationTest(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Test
	void staffPrototypeTest(){
		var expectedName_1 = "erwin";
		var expectedName_2 = "jono";
		var expectedSalary = EmployeeSalary.STAFF.getValue();
		var expectedPosition = EmployeePosition.STAFF;
		var expectedObjToString = "Employee{name='jono', salary=STAFF, position=STAFF}";
		Employee newStaff = applicationContext.getBean("staffEmployee", Employee.class);

		newStaff.setName(expectedName_1);
		Assertions.assertEquals(newStaff.getName(), expectedName_1);
		Assertions.assertEquals(newStaff.getSalary().getValue(), expectedSalary);
		Assertions.assertEquals(newStaff.getPosition(), expectedPosition);
		System.out.println(newStaff.getSalary().getValue());
		newStaff.setName(expectedName_2);
		Assertions.assertNotEquals(newStaff.getName(),expectedName_1);
		Assertions.assertEquals(newStaff.getName(), expectedName_2);
		Assertions.assertEquals(newStaff.getSalary().getValue(), expectedSalary);
		Assertions.assertEquals(newStaff.getPosition(), expectedPosition);

		Assertions.assertEquals(newStaff.toString(), expectedObjToString);
	}

	@Test
	void managerPrototypeTest(){
		var expectedName_1 = "erwin";
		var expectedName_2 = "jono";
		var expectedSalary = EmployeeSalary.MANAGER.getValue();
		var expectedPosition = EmployeePosition.MANAGER;
		var expectedObjToString = "Employee{name='jono', salary=MANAGER, position=MANAGER}";
		Employee newManager = applicationContext.getBean("managerEmployee", Employee.class);

		newManager.setName(expectedName_1);
		Assertions.assertEquals(newManager.getName(), expectedName_1);
		Assertions.assertEquals(newManager.getSalary().getValue(), expectedSalary);
		Assertions.assertEquals(newManager.getPosition(), expectedPosition);

		newManager.setName(expectedName_2);
		Assertions.assertNotEquals(newManager.getName(),expectedName_1);
		Assertions.assertEquals(newManager.getName(), expectedName_2);
		Assertions.assertEquals(newManager.getSalary().getValue(), expectedSalary);
		Assertions.assertEquals(newManager.getPosition(), expectedPosition);

		Assertions.assertEquals(newManager.toString(), expectedObjToString);
	}

	@Test
	void vpPrototypeTest(){
		var expectedName_1 = "erwin";
		var expectedName_2 = "jono";
		var expectedSalary = EmployeeSalary.VP.getValue();
		var expectedPosition = EmployeePosition.VP;
		var expectedObjToString = "Employee{name='jono', salary=VP, position=VP}";
		Employee newVp = applicationContext.getBean("vpEmployee", Employee.class);

		newVp.setName(expectedName_1);
		Assertions.assertEquals(newVp.getName(), expectedName_1);
		Assertions.assertEquals(newVp.getSalary().getValue(), expectedSalary);
		Assertions.assertEquals(newVp.getPosition(), expectedPosition);

		newVp.setName(expectedName_2);
		Assertions.assertNotEquals(newVp.getName(),expectedName_1);
		Assertions.assertEquals(newVp.getName(), expectedName_2);
		Assertions.assertEquals(newVp.getSalary().getValue(), expectedSalary);
		Assertions.assertEquals(newVp.getPosition(), expectedPosition);

		Assertions.assertEquals(newVp.toString(), expectedObjToString);
	}
}