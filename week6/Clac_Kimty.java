package fff;
import java.util.Scanner;
abstract class Calc{
	int a; int b;
	protected int calculate;
	public void setValue(int a, int b) { 
		this.a= a; this.b =b;}
	public abstract void calcul(int a, int b);
	public abstract int getValue() ;
}

class Add extends Calc{
	public void calcul(int a, int b) {
		calculate=a+b;}
	public int getValue() {return calculate;}
}

class Sub extends Calc{
	public void calcul(int a, int b) {
		calculate=a-b;}
	public int getValue() {return calculate;}
}

class Mul extends Calc{
	public void calcul(int a, int b) {
		calculate=a*b;}
	public int getValue() {return calculate;}
}
class Div extends Calc{
	public void calcul(int a, int b) {
		calculate=a/b;}
	public int getValue() {return calculate;}
}

public class noo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("두 정수와 연산자를 입력하세요");
		int a = sc.nextInt(); int b = sc.nextInt(); String c = sc.next();
		if(c.equals("+")) {
			Calc obj = new Add();	obj.setValue(a,b);	obj.calcul(a,b);
			System.out.println(obj.getValue());
			}
		if(c.equals("-")) {
			Calc obj = new Sub();	obj.setValue(a,b);	obj.calcul(a,b);
			System.out.println(obj.getValue());
		}
		if(c.equals("*")) {
			Calc obj = new Mul();	obj.setValue(a,b);	obj.calcul(a,b);
			System.out.println(obj.getValue());
		}
		if(c.equals("/")) {
			Calc obj = new Div();	obj.setValue(a,b);	obj.calcul(a,b);
			System.out.println(obj.getValue());
		}	}	}
