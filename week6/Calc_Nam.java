package week6;
import java.util.Scanner;
abstract class Calc{
	protected int a, b;
	public abstract void setValue(int a, int b);
	public abstract int calculate();
}
class Add extends Calc{
	public void setValue(int a, int b) {
		this.a=a; this.b=b;
	}
	public int calculate() {
		return a+b;
	}
}
class Sub extends Calc{
	public void setValue(int a, int b) {
		this.a=a; this.b=b;
	}
	public int calculate() {
		return a-b;
	}
}class Mul extends Calc{
	public void setValue(int a, int b) {
		this.a=a; this.b=b;
	}
	public int calculate() {
		return a*b;
	}
}class Div extends Calc{
	public void setValue(int a, int b) {
		this.a=a; this.b=b;
	}
	public int calculate() {
		return a/b;
	}
}
public class Calctest {
	public static void main(String[] args) {
		int a=0;
		int b=0;
		Scanner sc=new Scanner(System.in);
		System.out.print("두 정수와 연산자를 입력하세요 >>");
		String line=sc.nextLine();
		
		String[] tokens=line.split(" ");
		loop:
		for(int i=0;i<tokens.length;i++) {
			if(tokens[i].equals("+")) {
				Add obj1=new Add();
				sw1:
				switch(i) {
				case 0:
					a=Integer.parseInt(tokens[1]);
					b=Integer.parseInt(tokens[2]);
					break sw1;
				case 1:
					a=Integer.parseInt(tokens[0]);
					b=Integer.parseInt(tokens[2]);
					break sw1;
				case 2:
					a=Integer.parseInt(tokens[0]);
					b=Integer.parseInt(tokens[1]);
					break sw1;
				}
				obj1.setValue(a, b);
				System.out.println(obj1.calculate());
				break loop;
			}
			else if(tokens[i].equals("-")) {
				Sub obj2=new Sub();
				sw2:
				switch(i) {
				case 0:
					a=Integer.parseInt(tokens[1]);
					b=Integer.parseInt(tokens[2]);
					break sw2;
				case 1:
					a=Integer.parseInt(tokens[0]);
					b=Integer.parseInt(tokens[2]);
					break sw2;
				case 2:
					a=Integer.parseInt(tokens[0]);
					b=Integer.parseInt(tokens[1]);
					break sw2;
				}
				obj2.setValue(a, b);
				System.out.println(obj2.calculate());
				break loop;
			}
			else if(tokens[i].equals("*")) {
				Mul obj3=new Mul();
				sw3:
				switch(i) {
				case 0:
					a=Integer.parseInt(tokens[1]);
					b=Integer.parseInt(tokens[2]);
					break sw3;
				case 1:
					a=Integer.parseInt(tokens[0]);
					b=Integer.parseInt(tokens[2]);
					break sw3;
				case 2:
					a=Integer.parseInt(tokens[0]);
					b=Integer.parseInt(tokens[1]);
					break sw3;
				}
				obj3.setValue(a, b);
				System.out.println(obj3.calculate());
				break loop;
			}
			else if(tokens[i].equals("/")) {
				Div obj4=new Div();
				sw4:
				switch(i) {
				case 0:
					a=Integer.parseInt(tokens[1]);
					b=Integer.parseInt(tokens[2]);
					break sw4;
				case 1:
					a=Integer.parseInt(tokens[0]);
					b=Integer.parseInt(tokens[2]);
					break sw4;
				case 2:
					a=Integer.parseInt(tokens[0]);
					b=Integer.parseInt(tokens[1]);
					break sw4;
				}
				obj4.setValue(a, b);
				System.out.println(obj4.calculate());
				break loop;
				
			}
			else ;
		}
		
	}

}
