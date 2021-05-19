import java.util.Scanner;
abstract class Calc{
	protected int a,b;
	void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public abstract int calculate();
}

class Add extends Calc{
	public int calculate() {
		return a+b;
	}
}

class Sub extends Calc{
	public int calculate() {
		return a-b;
	}
}

class Mul extends Calc{
	public int calculate() {
		return a*b;
	}
}

class Div extends Calc{
	public int calculate() {
		return a/b;
	}
}

public class CalcEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("두 정수와 연산자를 입력하세요 >>");
		String ans = sc.nextLine();
		String[] tokens = ans.split(" ");
		String a = tokens[0];
		String b = tokens[1];
		String op = tokens[2];
		int c = Integer.parseInt(a);
		int d = Integer.parseInt(b);
		
		Calc calc = new Add();
		
		switch(op) {
		case "+":
			calc = new Add();
			break;
		case "-":
			calc = new Sub();
			break;
		case "/":
			calc = new Div();
			break;
		case "*":
			calc = new Mul();
		}
		calc.setValue(c, d);
		System.out.print(calc.calculate());
	}
	
}
