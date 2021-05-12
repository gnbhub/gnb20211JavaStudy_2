# 5주차 상속 / 생성자 오버라이딩
## 상속
부모클래스에 있는 필드와 메소드를 자식클래스가 물려받는 것을 뜻한다. <br>
기존 클래스의 필드와 메소드를 재사용하여 생산성이 향상되며 코드의 중복을 줄일 수 있다. 
또한, 기존 클래스를 변경할 수도 있으며, 
신뢰성 있는 소프트웨어를 손쉽개 개발하고 유지 보수 할 수 있다. <br>
상속하는 클래스는 부모 클래스, 슈퍼(super) 클래스, 기본(base) 클래스로 부르며, 
상속받는 클래스는 자식 클래스, 서브(sub) 클래스, 파생(drived) 클래스로 부른다. <br>

### 자바 상속의 형식
상속하여 새로운 클래스를 만들려면 클래스 이름 뒤에 extends를 써주고 부모 클래스 이름을 적으면 된다. 
예시로 Car클래스의 상속을 받는 자식 클래스 SportsCar 클래스를 생성하려면
```java
class SportsCar extends Car{
	//Car 클래스에서 확장시킬 내용
}
```
으로 생상 할 수 있다. <br>
자식 클래스의 객체를 생성하면 생성된 객체는 자신의 자체 필드와 메소드 뿐만 아니라 부모 클래스의 필드와 메소드를 사용 할 수 있다. 
### 상속과 접근 권한
보통 클래스의 필드의 접근 권한을 public으로 설정하는 것은 class 디자인 원칙에 위반하므로 private으로 주로 설정한다. 
하지만 부모 클래스에서 접근 권한을 설정할 때 privite 으로 설정하면 자식 클래스에서 해당 필드를 사용할 수 없게 되므로 접근 권한을 protected로 설정하여 
자식 클래스에서도 해당 필드값을 사용 할 수 있도록 한다. 
<br>접근 권한이 protected인 경우 다른 패키지의 클래스여도 상속받은 경우 해당 필드를 사용할 수 있다. 
### 상속과 생성자
서브 클래스의 객체가 생성될 때, 생성자의 호출은 부모 클래스의 생성자가 먼저 호출되며, 다음으로 자식 클래스의 생성자가 호출된다. <br>
예시를 살펴보면
```java
class Base{
	public Base(){
		System.out.println("Base() 생성자");
	}
}
class Derived extends Base{
	public Derived(){
		System.out.println("Derived() 생성자");
	}
}
public class Test{
	public static void main (String[] args){
		Derived r=new Derived();
	}
}
```
의 코드를 작성하면 실행 결과는 'Base() 생성자'가 출력되고 다음 줄에 'Derived() 생성자'가 출력이 된다. 
#### 명시적인 생성자 호출
super를 사용하면 명시적으로 수퍼 클래스의 생성자를 호출할 수 있다. super 문은 자식 클래스의 첫 번째 줄에서 사용되어야 한다. 
<br>예시를 살펴보자. 
```java
class Shape {
	public Shape(){
		System.out.println("Shape 생성자()");
	}
	public Shape(String msg){
		System.out.println("Shape 생성자() "+msg);
	}
}
class Rectangle extends Shape{
	public Rectangle(){
		super("from Recteangle");	//명시적인 호출
		System.out.println("Rectangle 생성자()");
	}
}
public class ShapeTest{
	public static void main(String[] args){
		Rectangle r=new Rectangle();
	}
}
```
위 코드의 실행 결과로는 "Shape 생성자() from Rectangle"이 나온 후 다음 줄에 "Rectangle 생성자()"가 출력된다. 
<br>생성자를 호출하는 코드가 없는 경우에는 매개변수가 없는 맨 위의 생성자를 실행한다. 

### 참조변수의 참조 가능성
하위 클래스의 참조변수로는 상위 클래스의 멤버를 참조할 수 있지만 역은 성립하지 않는다. 
<br>예시
```java
class People{
	public void PeopleInfo(){
		//실행 내용
	}
}
class Student extends People{
	public void StudentInfo() {
		//실행 내용
	}
}
public class StudentTest{
	public static vodi main(String[] args){
		Student s1=new Student();
		s1.PeopleInfo();
		s1.StudentInfo();
		People s2=new Student();	//가능
		s2.PeopleInfo();
		s2.StudentInfo();	//오류 발생 (역이 성립하지 않으므로)
	}
}
```
### instanceof 연산자
참조변수의 타입을 확인하는 연산자로 `if(ref instanceof ClassName)`인 경우 ref가 ClassName 클래스의 인스턴스이면 true를 반환하고 
ref가 ClassName 클래스의 인스턴스가 아니면 false를 반환한다. 
<br>예시
```java
class People{
	//실행 내용
}
class Student extends People{
	//실행 내용
}
public class StudentTest{
	public static void main(String[] args){
		People p=new Student();
		if(p instanceof Student)
			System.out.println("Student 타입");
		else 
			System.out.println("People 타입");
	}
}
```
위 프로그램을 실행하면 "Student 타입"이라고 출력되므로 p의 타입은 Student타입이 된다. 
이것은 java가 메모리 할당을 할 때 동적 할당을 한다는 증거이다. 즉, java에서는 객체가 생성이 될 때 타입이 결정된다. 
## 메소드 재정의(method overriding)
메소드 재정의는 자식 클래스가 필요에 따라 상속된 메소드를 다시 정의하는 것이다. 메소드의 헤드는 변경이 불가능하고 
메소드의 본체만 변경 할 수 있다. 
### 메소드 오버라이딩의 규칙
부모 클래스에 있는 메소드 중 변경하고자 하는 메소드를 자식 클래스에서 똑같이 선언 후 내용을 변경하면 된다. 
이때, 새로 정의한 메소드의 이름, 반환형, 매개 변수의 개수와 데이터 타입은 기존의 것과 일치해야 한다. 
### 오버라이딩된 부모 클래스 멤버 접근
클래스 내부에서 super를 사용하여 `super.methodName();`으로 기존의 super 클래스의 methodName이라는 메소드를 사용 할 수 있다. 
이렇게 오버라이딩된 부모 클래스의 메소드는 클래스 내부에서만 호출 가능하며 클래스 외부에서 호출하는 방법은 없다. 
<br>예시
```java
class Animal{
	public void eat(){
		Sysem.out.println("동물이 먹고 있습니다. ");
	}
}
class Dog extends Animal{
	public void eat(){
		super.eat();	//Animal 클래스의 메소드 eat를 호출
		System.out.println("강아지가 먹고 있습니다. ");
	}
}
public class DogTest{
	public static void main(String[] args){
		Dog d=new Dog();
		d.eat();
	}
}
```

