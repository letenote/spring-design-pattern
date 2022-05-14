package letenote.designpattern.prototype.employee;

public enum EmployeeSalary {
//	public static final Long STAFF = 7_500_000L;
//	public static final Long MANAGER = 18_000_000L;
//	public static final Long VP = 28_000_000L;
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
