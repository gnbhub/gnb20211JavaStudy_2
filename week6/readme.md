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
	public void calcArea(double w, double h) {	//calcArea오버라이딩
		area = w*h;
	
		System.out.println("사각형의 면적은"+area);
	}
}
class Triangle extends Shape{
	public void calcArea(double w, double h) {	//calcArea오버라이딩
		area = w*h/2.0;
	
		System.out.println("삼각형의 면적은"+area);
	}
}

public class ShapeTest {
	public static void main(String[] args) {
		int w=3,h=4;
		
		Shape s = new Rect();		//s는 Shape를 참조하는 Rect인스턴스
		s.calcArea(w,h);		//오버라이딩된 메소드 호출됨
		
		s = new Triangle();		//s는 Shape를 참조하는 Triangle 인스턴스
		s.calcArea(w,h);		//오버라이딩된 메소드 호출됨
	}
}
```
⇒ 추상 클래스에는 abstract를 꼭 붙여줘야 하고 추상 메소드는 public absract를 붙이는게 원칙이다.

## 추상 클래스의 특징
- 추상 클래스는 객체 생성을 할 수 없다. 즉 인스턴스 생성이 불가능하고 참조 변수로만 선언이 가능하다.
<br> (위의 예제에서 `Shape s = new Shape();`형태로 선언하는 것이 불가능)
- 추상 클래스 멤버로는 멤버 변수, 멤버 메소드, 생성자, 추상 메소드 등이 있고 위에서 말했듯이 클래스의 멤버에 추상 메소드가 있을 경우 클래스는 반드시 추상 클래스로 선언해야 한다.
- 추상 메소드가 없어도 추상 클래스로 선언은 가능하다
- 업캐스팅 타입으로 사용 가능하다.

### 다형성(polymorphism)
“많은(poly)+모양(morph)”라는 의미로 하나의 식별자로 다양한 타입(클래스)을 처리하는 것을 의미한다. 똑같은 메시지가 전달 되더라도 객체들의 타입이 다르면 서로 다른 동작을 하는 것이다.

### 자바의 다형성 구현
상속 구조에서 상위 클래스 타입의 변수가 하위 클래스의 인스턴스를 가리킬 수 있는 기능으로 반드시 상속 관계인 클래스들 사이에서 성립된다. 이를 통해 재사용성이 높아질 수 있다.
```java
		…
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
	Student s;		//s는 Student 참조
	s= new University("이몽룡","math");	//s는 University 인스턴스
	System.out.println(s.getInfo());
	//System.out.println(s.getMajor()); 오류발생: Student를 참조하기 때문이다.
	
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
class Tri implements Shape{		//Tri는 Shape를 implements함
	double len = 0;
	public void calcArea(double w, double h) {
		System.out.println("삼각형의 면적" + (w*h)/2);
	}		//calcArea()재정의
	public void calcGirth(double...v) {
		for(double val:v) {len+=val;}
		System.out.println("삼각형의 둘레"+len);
	}		//calcGirth()재정의
}
class Rect implements Shape{		//Rect는 Shape를 implements함
	double len =0;
	public void calcArea(double w, double h) {
		System.out.println("사각형의 면적" + (w*h));
	}		//calcArea()재정의
	public void calcGirth(double...v) {
		for(double val:v) {len+=val;}
		System.out.println("사각형의둘레"+len);
	}		//calcGirth()재정의
}
class Circle implements Shape{		//Circle은 Shape를 implements함
	public void calcArea(double w, double h) {
		System.out.printf("원의 면적 %.2f\n" , PI*w*w);
	}		//calcArea()재정의
	public void calcGirth(double...v) {
		double len=0;
		for(double val:v) {len+=val;}
		System.out.println("원의둘레"+2*PI*len);
	}		//calcGirth()재정의
	
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
	public void func() {}
	public void func1() {}
	public void func2() {}
}
public class MultiTest{
	public static void main(String[] args) {
		Child c = new Child();
		Itest i = new Child();
		Itest1 i1 = new Child();
		c.func(); c.func1(); c.func2();
		i.func();
		//i.func1(); i.func2(); 오류발생
		i1.func1();
		//i1.func(); i1.func2();	마찬가지로 오류 발생
	}
}
```
⇒ 업캐스팅된 참조변수는 하위클래스에 있는 멤버는 사용불가능하므로 오류가 발생한다.
<br>다운캐스팅을 이용하면 되겠다.

## 추상클래스와 인터페이스 비교
- 유사점 : 객체를 생성할 수 없고, 상속을 위한 슈퍼 클래스로만 사용, 클래스의 다형성을 제공하기 위한 목적
- 다른점 : 추상 클래스는 서브 클래스에서 필요로 하는 기능을 대부분 구현해 두고 서브 클래스가 상속 받아 활용할 수 있도록 하되, 서브 클래스에서 반드시 구현 해야 하는 기능을 추상 메소드로 선언하여 다형성을 제공한다. 
<br>추상 메소드와 일반메소드 모두 포함하고 상수, 변수 필드 모두 포함 가능하다. 그러나 인터페이스는 객체의 기능을 모두 공개한 표준 문서와 같은 것으로 개발자에게 인터페이스의 모든 추상 메소드를 만들도록 하여 다형성을 제공한다. 변수필드는 포함 불가하고 protected 접근 권한을 지정할 수 없으며 다중 상속이 지원 된다.

 #written by kyh

## 패키지(package)
서로 관련된 클래스와 인터페이스의 컴파일 된 클래스 파일들을 하나의 폴더에 묶어놓은 것.
### 패키지를 사용하는 이유
 - "이름 공간(name space)" 때문이다. 클래스 이름이 겹치더라도 패키지가 다르면 중복 문제가 발생하지 않는다.
 - 서로 관련된 클래스들을 묶어서 조직화 할 수 있다.
 - 패키지별로 접근에 제약을 가할 수 있다.
### 패키지 선언
예약어 `package`를 사용하여 소스파일의 첫 줄에 선언해야 한다.
```java
package garphics;
public class Circle {
	···
}
```
패키지 문을 사용하지 않은 경우에는 디폴트 패키지(default package)에 속하게 된다.
 - 디폴트 패키지 : 이름이 없는 패키지로서 임시적인 프로그램을 작성하는 경우에 사용하는 패키지
### 패키지 사용
#### (1)클래스 이름에 패키지를 붙여서 참조
``` java
graphics.Circle obj = new graphics.Circle();
```
#### (2)패키지를 포함한다 - import
``` java
import graphics.*;
```
별표`*`는 패키지 안에 모든 클래스를 포함한다는 의미이다.
``` java
Circle myCircle = new Circle();
```
import로 패키지를 포함시켜놓으면 그 패키지 안에 들어있는 클래스들은 패키지 이름을 생략하고 클래스 이름으로만 사용할 수 있다.

## 연습문제
아래와 같이 4개의 멤버(필드와 메소드)를 가진, 4개의 클래스 Add,Sub,Mul,Div 를 작성하세요.
- int타입의 a, b 필드 : 2개의 피연산자 저장할 변수
- void setValue(int a, int b) : 피연산자 값을 객체 내에 저장
- int calculate() : 클래스의 목적에 맞는 연산을 실행하고 결과를 리턴한다.

그런데, 각각의 클래스마다 공통된 필드와 메소드가 존재하는 구조이므로, Calc라는 이름의 추상클래스를 작성하여 Calc를 상속받아 각 4개의 클래스를 작성해보세요.
<br>그리고, main()메소드에서 실행예시와 같이 2개의 정수와 연산자를 입력받은 후,
<br>4개의 클래스 중 적합한 연산을 처리할 수 있는 객체를 생성하고 메소드를 호출하여 그 결과 값을 화면에 출력하게 작성해보세요. 
<br>[출처] [Java] 상속/추상클래스/인터페이스 연습문제|작성자 HeraPro
``` java
import java.util.Scanner;
abstract class Calc{
	protected int a,b;
	void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	} 	//두 정수를 입력받아 각각 a, b에 대입하는 setValue()
	public abstract int calculate();
}		//내용이 없는 추상메소드 calculate()

class Add extends Calc{
	public int calculate() {
		return a+b;
	}		//calculate() 재정의
}

class Sub extends Calc{
	public int calculate() {
		return a-b;
	}		//calculate() 재정의
}

class Mul extends Calc{
	public int calculate() {
		return a*b;
	}		//calculate() 재정의
}

class Div extends Calc{
	public int calculate() {
		return a/b;
	}		//calculate() 재정의
}

public class CalcEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("두 정수와 연산자를 입력하세요 >>");
		String ans = sc.nextLine();
		String[] tokens = ans.split(" ");
// tokens라는 String 배열 요소에 split()메소드를 이용하여 공백을 단위로 초기화
		String a = tokens[0];
		String b = tokens[1];
		String op = tokens[2];
		int c = Integer.parseInt(a);
		int d = Integer.parseInt(b);
// Integer.parseInt()를 이용하여 c,d에 String자료형으로 입력받은 a,b를 초기화
		Calc calc = new Add();
//calc가 Calc를 참조하는 것으로 끝내려 했으나 임의의 인스턴스 생성
		switch(op) {		//op를 기준으로 다른 인스턴스를 생성
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
		}			//이 시점에서 op에 맞는 인스턴스가 생성
		calc.setValue(c, d);	//두 정수를 setValue를 통해 초기화한다
		System.out.print(calc.calculate());
	}		//각 인스턴스에 맞는 calculate()가 호출되어 출력된다
	
}
```
 우선 문제대로 추상 클래스 Calc를 정의하고 필드, 메소드, 추상메소드를 선언했다. 
 <br>그리고 각각의 Add, Sub, Div, Mul 클래스는 Calc클래스를 상속 받고, 추상메소드 calculate()를 오버라이딩 하여 해당하는 연산자의 연산을 반환하도록 작성하였다. 
 <br>메인함수에서 문자열을 입력받아 Calc클래스에서 사용할 수 있는 형태로 바꾸어주었다. 
 <br> calc가 Calc를 참조하도록 선언하려했는데, 인스턴스가 생성되지 않을 수 있다는 오류가 나서 임의로 Add()로 생성하였다.
<br>switch문 내에서 op에 해당하는 인스턴스로 생성되도록 설정해 주고 setValue를 통해 연산에 사용할 숫자를 전달해 준 다음 calculate()를 통해 인스턴스에 해당하는 클래스의 메소드를 호출하도록 해 주었다.
