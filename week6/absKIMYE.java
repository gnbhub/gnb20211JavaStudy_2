import java.util.Scanner;

abstract class Calc{
	protected int sol;
	protected int a, b;
	public void setValue(int a, int b) {
		this.a =a; this.b=b;
	}
	public abstract int calculate();
}
class Add extends Calc{
	public int calculate() {
		sol = a +b;
		return sol;
	}
}
class Sub extends Calc{
	public int calculate() {
		sol = a-b;
		return sol;
	}
}
class Mul extends Calc{
	public int calculate() {
		sol = a*b;
		return sol;
	}
}
class Div extends Calc{
	public int calculate() {
		sol = a/b;
		return sol;
	}
}
public class abs {
	public static void main(String[] args) {
		String line;
		System.out.print("두 정수와 연산자를 입력하세요>>");
		Scanner input = new Scanner(System.in);
		line = input.nextLine();
		String[] data = line.split(" ");
		int n1 = Integer.parseInt(data[0]);
		int n2 = Integer.parseInt(data[1]);
		switch(data[2]) {
		case "+" : Add q = new Add();
		q.setValue(n1, n2);
		System.out.println(q.calculate());
		break;
		case "-" : Sub r = new Sub();
		r.setValue(n1, n2);
		System.out.println(r.calculate());
		break;
		case "*" : Mul s = new Mul();
		s.setValue(n1, n2);
		System.out.println(s.calculate());
		break;
		case "/" :  Div t = new Div();
		t.setValue(n1, n2);
		System.out.println(t.calculate());
		break;
		}
	}

}
