package letenote.designpattern.prototype.employee;

public class Employee {
	private String name;
	private EmployeeSalary salary;
	private EmployeePosition position;

	public void setName(String name) {
		this.name = name;
	}

	public void setSalary(EmployeeSalary salary) {
		this.salary = salary;
	}

	public void setPosition(EmployeePosition position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public EmployeeSalary getSalary() {
		return salary;
	}

	public EmployeePosition getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				", salary=" + salary +
				", position=" + position +
				'}';
	}
}
