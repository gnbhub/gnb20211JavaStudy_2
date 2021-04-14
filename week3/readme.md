 # 3주차 배열/ 클래스
 ## 배열(array)
  인덱스와 인덱스에 대응하는 데이터들로 이루어진 자료 구조, 배열을 이용하면 같은 종류의 대량의 데이터를 한 번에 선언할 수 있다. 그리고 연속적인 메모리 공간을 할당한다는 장점이 있다. 자바에서 배열은 객체(object)이다. 정수형 배열은 아래처럼 선언한다.
``` Java
int []	s;
s = new int[10];
```
 int는 배열 요소의 자료형을 나타내고, 첫째 문장은 배열 참조 변수를 선언한 것이다. 그 다음 실제 배열을 생성해주기 위해서 new연산자를 사용하였다. [10]은 자료형 10개를 저장할 수 있다는 것을 나타낸다. 배열 선언과 동시에 배열을 생성하는 것도 가능하다.
``` Java
int[]	s = new int[size];
```
 배열은 한번 생성되면 크기를 변경할 수 없다, 만약 실행 도중에 크기 변경이 필요하다면 ArrayList나 Vector클래스를 이용해야 한다.
``` Java
int[] scores = new int[] {10, 20, 30, 40, 50};
```
 처럼 직접 배열 안의 데이터를 초기화할 수도 있고, 또는 메소드(method)를 이용하여 초기화할 수 있다. 우선 메소드를 이용하기 위해서 **import java.util.Arrays;** 문장이 필요하다.
``` Java
Java Arrays.fill(배열이름, 초기값);
```
을 통해 전체 항목을 초기값으로 초기화할 수 있다.

 ### 배열에서 활용할 수 있는 메소드
 배열 복사 메소드는 시스템에 내장되있어서 import문이 필요 없다.
``` Java
System.arraycopy(원본 배열 이름, 시작인덱스, 대상 배열 이름, 복사 위치인덱스, 길이);
```
와 같이 입력한다면, 원본 배열의 시작인덱스의 값부터 길이만큼 대상 배열의 복사 위치인덱스부터 복사한다.
<br> 배열의 모든 요소 출력은 import java.util.Arrays; 문장이 필요하다.
``` Java
System.out.println(Arrays.toString(배열 이름); 
```
배열의 모든 요소를 출력한다. <br>
 배열을 오름차순으로 정렬하고자 한다면 **import java.util.Arrays;** 문장이 필요하다.
``` Java
Arrays.sort(배열 이름);
Arrays.sort(배열 이름, 시작 인덱스, 끝 인덱스); 
```
시작 인덱스부터 끝인덱스-1의 데이터까지 오름차순으로 정렬한다. <br>
 내림차순으로 정렬하고자 한다면 **import java.util.Arrays;** 문과 **import.java.util.Collections;** 문장이 필요하다.
``` Java
Arrays.sort(배열 이름, Collections.reverseOrder());
```
하게 되면 내림차순으로 정렬된다. <br>
 이진탐색은 정렬된 데이터에서 절반씩 줄여나가서 특정값을 탐색하는 방법으로, 정렬이 우선되어야 한다. **import java.util.Arrays;** 문이 필요하다.
``` Java
Arrays.binarysearch(배열 이름, 특정 값);
```
 배열에서 특정 값이 몇 번째 인덱스에 있는지 알 수 있다. 배열에 없는 특정값을 탐색하면 –부호의 인덱스가 출력된다.

### for-each 루프
 반복문의 변수제어를 배열을 통해 할 수 있다. 형태는 for( 변수 선언 : 배열이름) 꼴이다.
 ``` Java
int[] list = {1, 2, 3, 4, 5};
for( int e : list)
	{실행 문장 ...}
  ```
 예를 들면 list 배열의 각 요소가 차례대로 변수 e에 대입되면서 반복한다. 즉 배열의 데이터 수만큼 반복하는 루프이다.

 ### 2차원 배열
 배열은 다차원으로도 활용할 수 있는데, 2차원을 선언하려면 다음과같이 작성하면 된다.
``` Java
int [][]		s = new int[3][5];	// 3행 5열의 s라는 2차원 배열을 선언하게 된다.
```

 ### ArrayList
 배열보다 훨씬 사용이 편리한 배열로, 배열은 크기가 한번 결정되면 절대 변경할 수 없지만, ArrayList는 배열의 크기를 자동으로 변경하면서 사용할 수 있다.
``` Java 
ArrayList<String> list;
list = new ArrayList<>();	// List라는 문자열(String)을 저장할 수 있는 ArrayList를 생성한다.
list.add(“항목”);	//ArrayList에 요소들을 추가할 수 있다.
list.remove(“항목”);	//ArrayList에 요소를 삭제할 수 있다.
list.get(인덱스);	// 해당 인덱스에 저장된 값을 확인할 수 있다.
```

## 객체 지향 프로그래밍(Object-Oriented Programming)
 절차 지향 프로그래밍은 순서(절차)에 초점을 맞추어서 프로그래밍 한다면, 객체 지향 프로그래밍은 데이터(필드)와 절차(메소드)를 하나의 덩어리(객체)로 묶어서 객체를 표현하는데 초점을 둔 기법이다.

 ### 클래스(class)
 특정한 종류의 객체들을 만들어내는 틀과 같은 것이다. 이 클래스로부터 생성되는 객체를 인스턴스(instance)라 한다. 클래스를 이용하면 유형이 비슷한 객체들을 만들기 편리하다.
<br> 필드는 객체 안에 정의될 변수이고 메소드는 클래스 안에 정의된 함수이다.
``` Java
class Circle{	//클래스 이름 
	int radius;	자료형 필드
	String color;	자료형 필드

	double calcArea(){
		return 3.14 * radius * radius;	//반환형 메소드1(){반환 내용}
	}
}
…
메인함수{
	Circle obj1;	//obj1은 Circle클래스를 참조하겠다는 뜻이다.
	obj1 = new Circle();	//obj1은 Circle클래스가 만드는 인스턴스라는 뜻이다.
	obj1.radius = 100;	//Circle 클래스 내에 radius라는 필드가 있었는데, obj1 인스턴스의 radius 필드에 100이라는 값을 입력한다는 뜻이다.
	obj1.color = “blue”;	//마찬가지로 obj1의 color필드에 “blue“를 입력한다.
	double area = obj1.calcArea();	//Circle 클래스 내에 calcArea()라는 메소드를 이용해서 area라는 변수에 값을 선언할 수 있다.
	}
  ```
