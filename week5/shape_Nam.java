import java.util.Scanner;
class Radius{
	protected double r;
	public void getR() {
		Scanner sc=new Scanner(System.in);
		System.out.print("반지름의 길이: ");
		r=sc.nextDouble();
	}
	public void show() {
		System.out.println("반지름의 길이는 "+r+"입니다. ");
	}
}
class Circle extends Radius{
	protected double area;
	protected double perimeter;
	public void gets() {
		area=r*r*Math.PI;
		perimeter=2.0*r*Math.PI;
	}
	public void show() {
		System.out.printf("원의 넓이는 %.2f, 둘레는 %.2f입니다. \n", area, perimeter);
	}
	
}
class Sphere extends Radius{
	private double area;
	private double volume;
	public void gets() {
		area=4.0*r*Math.PI;
		volume=4.0*r*r*r*Math.PI/3;
	}
	public void show() {
		System.out.printf("구의 겉넓이는 %.2f, 부피는 %.2f입니다. \n", area, volume);
	}
}
class Cylinder extends Circle{
	private double height;
	public void getHeight() {
		Scanner sc=new Scanner(System.in);
		System.out.print("높이: ");
		height=sc.nextDouble();
	}
	private double cylinderArea;
	private double cylinderVolume;
	public void getsCylinder() {
		cylinderArea=2*area+perimeter*height*Math.PI;
		cylinderVolume=area*height;
	}
	public void show() {		
		System.out.printf("원기둥의 겉넓이는 %.2f, 부피는 %.2f 입니다. \n", cylinderArea, cylinderVolume);
	}
}
public class RadiusTest {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("도형을 선택하시오. (원, 원기둥, 구) ");
		String shape=sc.nextLine();
		if(shape.equals("구")==true) {
			Sphere obj2=new Sphere();
			obj2.getR();
			obj2.gets();
			obj2.show();
		}
		else if(shape.equals("원기둥")==true) {
			Cylinder obj1=new Cylinder();
			obj1.getR();
			obj1.getHeight();
			obj1.gets();
			obj1.getsCylinder();
			obj1.show();
		}
		else if(shape.equals("원")==true) {
			Circle obj3=new Circle();
			obj3.getR();
			obj3.gets();
			obj3.show();
		}
		
	}
}
