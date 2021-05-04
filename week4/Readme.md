# 4주차 메소드 / 생성자
## 메소드(method)
 클래스 안에 정의된 함수. 즉 클래스 안에 선언된 특정한 작업을 수행하는 문장들의 모임.
``` java
int add (int x, int y)	//add 앞의 int는 이 메소드의 반환값이 int형이라는 뜻이다.
{	
  return x+y;	}	//return 이후의 값을 반환한다.
```
 add()메소드는 외부에서 2개의 정수를 받아서 두 개의 정수를 더한 값을 반환한다. <br>
반환하는 값이 없다면 `void 메소드명()` 으로 선언한다. 메소드를 호출하는 곳에서 전달하는 값을 인수(argument)라고 하고 메소드에서 값을 받을 때 사용하는 변수를 매개변수(parameter)라고 한다. 매개 변수는 콤마 단위로 구분한다.

 ## 메소드 오버로딩(method overloading)
 동일한 이름의 메소드를 여러 개 정의하는 것. 메소드의 이름은 동일해야 하고 매개변수의 타입이나 개수가 반드시 달라야 한다.
 ``` java
int add(int x, int y, int z)	//위의 add와 달리 인수3개를 전달받는다.
{	
return x+y+z;	}	//x+y+z값을 반환한다.
```
 위쪽add()는 두 개의 int형 인수를 전달받지만 이번 add()는 세 개의 int형 인수를 전달받는다. 반환형은 같을 수 있지만 매개변수의 자료형이나 개수가 반드시 달라야 한다.

## 생성자(constructor)
 객체가 생성될 때 객체를 초기화하는 특수한 메소드. 생성자의 이름은 반드시 클래스 이름과 동일해야 한다. new를 통해 객체를 생성할 때, 객체당 한번 호출되고 객체의 필드를 초기화하는 역할만 하므로 반환 타입을 지정할 수 없다. 생성자도 메소드이므로 앞선 규칙을 지킨다면 오버로딩이 가능하다. 
 <br>만약 클래스 내에 생성자를 정의하지 않으면 컴파일러가 기본 생성자(default constructor)를 자동으로 만든다. 기본 생성자에서는 자동적으로 모든 멤버 변수들을 기본값으로 초기화한다. 필드가 int와 같은 수치형 변수라면 0으로, 참조형 변수라면 null로, 부울형 변수라면 false로 초기화한다.
 ``` java
 public class Pizza
{	
	int size;
	String type;

	public Pizza() {		//매개변수가 없는 생성자 -> 생성자를 매개변수 없이 선언하면 이 메소드가 실행된다.
		size = 12;		// size에는 12가, type에는 슈퍼슈프림이 초기화된다.
		type = “슈퍼슈프림”	
	}
	public Pizza(int s, String t) {	//매개변수에 숫자, 내용을 입력하면 
		size = s;		//size에는 숫자가 type에는 내용이 초기화된다.
		type = t;
	}
…}
```

 ## this 참조 변수
 객체 자신에 대한 참조를 나타낸다. 흔히 생성자에서 매개 변수 이름과 필드 이름을 구별하기 위하여 사용한다.
 ```java
public class Circle{
	int radius;

	public Circle() { this.radius = 1; } //new Circle();로 인스턴스 선언시 radius를 1로 선언
	public Circle( int radius ) {
		this.radius = radius;	//new Circle(반지름);으로 선언시 인스턴스의 radius는 반지름으로 선언된다.
   ```
 this()는 생성자 내에서 다른 생성자를 호출할 때 사용한다. 반드시 생성자 코드의 제일 처음에 수행한다.

 ## 정적 변수(static variable or class variable)
 여러 개의 객체가 공유하는 하나의 변수. static 수식자를 변수 앞에 붙여서 만든다. 클래스당 하나만 만들어지고 동일한 클래스의 모든 객체들은 하나의 정적 변수를 공유한다. 
 <br> 정적 변수는 객체 없이도 사용이 가능하다.

## 정적 메소드
 정적 변수와 마찬가지로 메소드도 정적 메소드가 존재한다. static 수식자를 메소드 앞에 붙여서 만든다. 정적 메소드에서는 정적 변수만을 사용할 수 있다. 인스턴스 변수는 사용할 수 없다. 현재 객체를 가리키는 this도 사용할 수 없다.

## 중간고사 문제 분석
빈칸에 들어갈 적절한 코드를 작성하는 것이었다.
``` java
class Employee{
	int time;
	int pay;
	
	Employee(int time){
		this.time = time;
		}		//빈칸 시작
	void calpay(){
		pay =  time*8000;
		}
	void calpay(String s){
		if(s == "manager")
			pay = time*8000+30000;
			}
	}		//빈칸 끝
public class calPayment{
	public static void main(String[] args){
		Employee e1 = new Employee(5);
		e1.calpay();
		System.out.println("e1의 임금은"+e1.pay+"입니다.");
		Employee e2 = new Employee(4);
		e2.calpay("manager");
		System.out.print("e2의 임금은"+e2.pay+"입니다.");
		}
}
```
calpay("manager")인 경우 pay에 30000을 더해서 계산하도록 만드는 문제였다.
<br>메소드 오버로딩을 이용해서 매개변수 없이 calpay()메소드를 호출 하는 경우애는 time에 8000을 곱해서 pay에 초기화하고, calpay()메소드를 호출하는데 매개변수가 manager인 경우 pay에 8000에 time만큼 곱하고 30000을 더해주도록 설정해주었다.
