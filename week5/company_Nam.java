class Employee{
	protected String classified;		//직원구분
	protected String name;				//직원 이름
	protected String address;			//주소
	protected String department;		//소속부서
}

class formalEmployee extends Employee{
	private int num;					//직원번호
	private String rank;				//직급
	private double salary;				//연봉
	private double bonus;				//보너스 지급율	
}

class InformalEmployee extends Employee{
	protected String ex;				//계약만료일
	protected double wage;				//기본 임금
}

class TempEmployee extends InformalEmployee{
	private double wagePerHour;			//시간당 임금
	private double workHour;			//근무 시간
	
}

class InternEmployee extends InformalEmployee{
	private double wagePer;				//임금지급률	
}

public class company{
	public static void main(String[] args) {
		
		
		
	}
}



