package letenote.designpattern.prototype.employee;

public enum EmployeeSalary {
	STAFF(7_500_000L),
	MANAGER(18_000_000L),
	VP(28_000_000L);

	private final Long numVal;

	EmployeeSalary(Long numVal) {
		this.numVal = numVal;
	}

	public Long getValue() {
		return numVal;
	}
}
