# 6주차 추상 클래스 / 인터페이스
## 추상 클래스 
추상 클래스는 몸체가 구현되지 않은 메소드를 가지고 있는 클래스로 추상적인 개념을 표현하는데 적당하다.
## 추상 클래스 정의
예약어 abstract를 사용하여 클래스를 정의하고 클래스 내부에 추상 메소드를 정의해야 한다.
<br>그리고 추상 메소드는 추상 클래스를 상속 받은 자식 클래스에서 반드시 재정의해야 한다. 부모클래스에 있는 추상 메소드 중에 하나라도 자식 클래스에서 재정의되지 않으면 컴파일 오류가 발생한다.
```java
abstract class Shape{
	protected double area;
	public abstract void calcArea(double w, double h);    //본체 부분이 없는 추상클래스의 메소드
}
class Rect extends Shape{
	public void calcArea(double w, double h) {
		area = w*h;
	
		System.out.println("사각형의 면적은"+area);
	}
}
class Triangle extends Shape{
	public void calcArea(double w, double h) {
		area = w*h/2.0;
	
		System.out.println("삼각형의 면적은"+area);
	}
}

public class ShapeTest {
	public static void main(String[] args) {
		int w=3,h=4;
		
		Shape s= new Rect();
		s.calcArea(w,h);
		
		s= new Triangle();
		s.calcArea(w,h);
	}
}
```
⇒ 추상 클래스에는 abstract를 꼭 붙여줘야 하고 추상 메소드는 public absract를 붙이는게 원칙이다.

## 추상 클래스의 특징
- 추상 클래스는 객체 생성을 할 수 없다. 즉 인스턴스 생성이 불가능하고 참조 변수로만 선언이 가능하다.
<br> (위의 예제에서 `Shape s = new Shape()`형태로 선언하는 것이 불가능)
- 추상 클래스 멤버로는 멤버 변수, 멤버 메소드, 생성자, 추상 메소드 등이 있고 위에서 말했듯이 클래스의 멤버에 추상 메소드가 있을 경우 클래스는 반드시 추상 클래스로 선언해야 한다.
- 추상 메소드가 없어도 추상 클래스로 선언은 가능하다
- 업캐스팅 타입으로 사용 가능하다.

### 다형성(polymorphism)
“많은(poly)+모양(morph)”라는 의미로 하나의 식별자로 다양한 타입(클래스)을 처리하는 것을 의미한다. 똑같은 메시지가 전달 되더라도 객체들의 타입이 다르면 서로 다른 동작을 하는 것이다.

### 자바의 다형성 구현
상속 구조에서 상위 클래스 타입의 변수가 하위 클래스의 인스턴스를 가리킬 수 있는 기능으로 반드시 상속 관계인 클래스들 사이에서 성립된다. 이를 통해 재사용성이 높아질 수 있다.
```java
	public void draw() {
		System.out.println("Shape Draw");
	}
}
class Rect extends Shape{
	public void draw() {
		System.out.println("Rectangle Draw");
	}
}
class Tri extends Shape{
	public void draw() {
		System.out.println("Triangle Draw");
	}
}
class Circle extends Shape{
	public void draw() {
		System.out.println("Circle Draw");
	}
}

public class ShapeTest {
	public static void main(String[] args) {
		Shape[] arrayofShapes = new Shape[3];
		arrayofShapes[0] = new Rect();
		arrayofShapes[1] = new Tri();
		arrayofShapes[2] = new Circle();
		
		for(int i =0; i <arrayofShapes.length;i++) {
			arrayofShapes[i].draw();
		}
	}
}
```
⇒ 실행 결과를 보면 Rectangle Draw, Triangle Draw, Circle Draw가 순서대로 출력된다. Shape의 draw()가 호출되는 것이 아니라 참조 변수가 가리키는 실제 객체에 따라 메소드가 자동적으로 선택된다. 같은 draw()라도 객체에 따라 적절하게 호출되어 매우 편리하다. 이런 것을 동적바인딩이라고 한다.

## 다운캐스팅
상속에서 업캐스팅 된 변수를 명시적으로 하위 클래스 타입으로 타입을 바꾸는 것을 말한다.
```java
class Student{
	String name;
	public Student(String name) {
		this.name = name;
	}
	public String getInfo() {return "이름: "+name;}
}
class University extends Student{
	String major;
	public University(String name, String major) {
		super(name); this.major = major;
	}
	public String getInfo() {return "이름: "+name;}
	public String getMajor() {return "소속: "+major;}
}
public class StuTest {
	public static void main(String[] args) {
	Student s;
	s= new University("이몽룡","math");
	System.out.println(s.getInfo());
	//System.out.println(s.getMajor()); 오류발생
	
	University ob = (University)(s); //다운캐스팅
	System.out.println(ob.getMajor());
	
	}
}
```
⇒ 만약 상위클래스 참조 변수로 객체가 선언이 되면 하위클래스에 있는 상속되지 않은 메소드는 사용할 수 없기 때문에 오류가 발생한다. 그러므로 하위클래스로 타입을 바꿔서 메소드를 사용해야 한다.

## 자바 상속의 특징
클래스의 다중 상속을 지원하지 않는다. 상속횟수는 무제한이고 상속의 최상위 조상 클래스는 java.lang.Object클래스이다. 모든 클래스는 자동으로 이 최상위클래스를 상속받는다. Object 클래스의 중요 메소드들은 사용자가 재정의하여 사용할 수 있다.

## 인터페이스 
interface 예약어로 선언된 추상 클래스. 추상 클래스가 발전한 개념이고 추상 클래스와 마찬가지로 인스턴스 생성이 불가능하고 참조 변수로만 선언이 가능하며 업캐스팅 타입으로 사용할 수 있다. 
<br>멤버로는 JAVA 7까지는 상수와 추상 메소드로만 구성되었지만 현재는 default 메소드와 private메소드, static 메소드를 포함시킬 수 있다. 인터페이스는 추상클래스와 다르게 필드(멤버변수) 선언은 불가하다.
<br>하위 클래스는 상위 클래스가 가지는 추상 메소드를 재정의하기 위하여 하위 클래스와 상위 클래스는 implements 관계가 된다. 하위 클래스는 여러 인터페이스를 동시에 implements 할 수 있고 이런 기능이 단일 상속을 보완할 수 있다.
```java
interface Shape{
	public static final double PI = 3.14;
	public abstract void calcArea(double w, double h);
	public abstract void calcGirth(double...v);
	//인터페이스 안의 모든 메소드는 public과 abstract를 붙이지 않아도 public과 abstract로 취급된다.
}
class Tri implements Shape{
	double len = 0;
	public void calcArea(double w, double h) {
		System.out.println("삼각형의 면적" + (w*h)/2);
	}
	public void calcGirth(double...v) {
		for(double val:v) {len+=val;}
		System.out.println("삼각형의 둘레"+len);
	}
}
class Rect implements Shape{
	double len =0;
	public void calcArea(double w, double h) {
		System.out.println("사각형의 면적" + (w*h));
	}
	public void calcGirth(double...v) {
		for(double val:v) {len+=val;}
		System.out.println("사각형의둘레"+len);
	}
}
class Circle implements Shape{
	public void calcArea(double w, double h) {
		System.out.printf("원의 면적 %.2f\n" , PI*w*w);
	}
	public void calcGirth(double...v) {
		double len=0;
		for(double val:v) {len+=val;}
		System.out.println("원의둘레"+2*PI*len);
	}
	
}
public class inter {
	public static void main(String[] args) {
		Shape s = new Tri();
		
		System.out.println("s.PI="+Shape.PI);
		System.out.println("----------------");
		s.calcArea(3,4); ((Tri)s).calcGirth(3,4,5);
		System.out.println("----------------");
		s= new Rect();
		s.calcArea(5, 6); s.calcGirth(5,6);
		System.out.println("----------------");
		s=new Circle();
		s.calcArea(3, 0); s.calcGirth(3);
		
	}

}
```
## 인터페이스의 구성 요소들
- 상수 : public만 허용
- 추상 메소드 : 본체 코드 구현이 생략된 메소드
- default 메소드 : 인터페이스에 코드가 작성된 메소드, 인터페이스를 구현하는 클래스에 자동 상속, public 접근 지정만 허용
- private 메소드 : 인터페이스 내에 메소드 코드가 작성되어야 함, 인터페이스 내에 있는 다른 메소드에 의해서만 호출 가능.
- static 메소드 : public, private 모두 지정 가능

## 다중 인터페이스 사용
하위 클래스에서는 여러 인터페이스를 동시에 implements 할 수 있다.
```java
interface Printable{
	void print();
}
interface Drawable{
	void draw();
}
class Circle implements Printable, Drawable{
	public void print() {}
	public void draw() {}
}
```
상속과 동시에 인터페이스를 구현하는 것도 가능하다.
```java
class Shape{
	protected int x,y;
}
interface Drawable{
	void draw();
}
class Circle extends Shape implements Drawable{
	public void draw() {}
}
```
```java
interface Itest{
	void fun();
}
interface Itest1{
	void fun1();
}
interface Itest2 extends Itest{		//Itest2는 Itest상속받음
	void fun2();
}
class Child implements Itest1,Itest2{	//Child는 Itest1과 Itest2를 내포함, 즉 Itest까지 내포함
	public void fun() {}
	public void fun1() {}
	public void fun2() {}
}
public class MultiTest{
	public static void main(String[] args) {
		Child c = new Child();
		Itest i = new Child();
		Itest1 i1 = new Child();
		c.fun(); c.fun1(); c.fun2();
		i.fun();
		//i.fun1(); i.fun2(); 오류발생
		i1.fun1();
		//i1.fun1(); i1.fun2();	마찬가지로 오류 발생
	}
}
```
⇒ 업캐스팅된 참조변수는 하위클래스에 있는 멤버는 사용불가능하므로 오류가 발생한다.
<br>다운캐스팅을 이용하면 되겠다.

## 추상클래스와 인터페이스 비교
- 유사점 : 객체를 생성할 수 없고, 상속을 위한 슈퍼 클래스로만 사용, 클래스의 다형성을 제공하기 위한 목적
- 다른점 : 추상 클래스는 서브 클래스에서 필요로 하는 기능을 대부분 구현해 두고 서브 클래스가 상속 받아 활용할 수 있도록 하되, 서브 클래스에서 반드시 구현 해야 하는 기능을 추상 메소드로 선언하여 다형성을 제공한다. 
<br>추상 메소드와 일반메소드 모두 포함하고 상수, 변수 필드 모두 포함 가능하다. 그러나 인터페이스는 객체의 기능을 모두 공개한 표준 문서와 같은 것으로 개발자에게 인터페이스의 모든 추상 메소드를 만들도록 하여 다형성을 제공한다. 변수필드는 포함 불가하고 protected 접근 권한을 지정할 수 없으며 다중 상속이 지원 된다.

 - wrote by kyh
