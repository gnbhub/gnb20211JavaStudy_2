import java.util.Scanner;
class Radius{
	public final static double PI = 3.14;
	protected double r;
	public void getR() {
		Scanner sc = new Scanner(System.in);
		System.out.print("반지름의 길이: ");
		r = sc.nextDouble();
	}
}
class Circle extends Radius{
	public Circle() {
		super.getR();
		double area = PI*r*r;
		double periphery = 2*PI*r;
		System.out.println("원의 넓이는 "+area+", 둘레는 "+periphery+"입니다.");
	}
}
class Cylinder extends Radius{
	public Cylinder() {
		super.getR();
		System.out.print("높이: ");
		Scanner sc = new Scanner (System.in);
		double height = sc.nextDouble();
		double surface = 2*PI*r*height+2*PI*r*r;
		double volume = PI*r*r*height;
		System.out.println("원기둥의 겉넓이는 "+surface+", 부피는 "+volume+"입니다.");
	}
}
class Sphere extends Radius{
	public Sphere() {
		super.getR();
		double surface = 4*PI*r*r;
		double volume = (4/3)*PI*r*r*r;
		System.out.println("구의 겉넓이는 "+surface+", 부피는 "+volume+"입니다.");
	}
}
public class SurfaceandVolume {

	public static void main(String[] args) {
		System.out.print("도형을 선택하시오. (원, 원기둥, 구)  ");
		Scanner sc = new Scanner(System.in);
		String what = sc.nextLine();
		switch(what) {
		case ("원"):
			Circle c = new Circle();
			break;
		
		case ("원기둥"):
			Cylinder y = new Cylinder();
			break;
		
		case ("구"):
			Sphere s = new Sphere();
			break;
		}

	}

}
