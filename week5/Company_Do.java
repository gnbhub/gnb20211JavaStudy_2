class Employee{
	protected String employee, name, adress, part;
}
class formalEmployee extends Employee{
	protected int number, salary, bonusrate;
	protected String position;
}
class InformalEmployee extends Employee{
	protected String expireday;
	protected int basicwage;
}
class TempEmployee extends InformalEmployee{
	protected int paypertime, worktime;
}
class InternEmployee extends InformalEmployee{
	protected int payrate;
}
public class Company {

	public static void main(String[] args) {
		

	}

}
