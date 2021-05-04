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
 처럼 직접 배열 안의 데이터를 초기화할 수도 있고, 또는 메소드(method)를 이용하여 초기화할 수 있다. 우선 메소드를 이용하기 위해서 `import java.util.Arrays;` 문장이 필요하다.
``` Java
Java Arrays.fill(배열이름, 초기값);
```
을 통해 전체 항목을 초기값으로 초기화할 수 있다.

 ### 배열에서 활용할 수 있는 메소드
 • 배열 복사 메소드는 시스템에 내장되있어서 import문이 필요 없다.
``` Java
System.arraycopy(원본 배열 이름, 시작인덱스, 대상 배열 이름, 복사 위치인덱스, 길이);
```
와 같이 입력한다면, 원본 배열의 시작인덱스의 값부터 길이만큼 대상 배열의 복사 위치인덱스부터 복사한다.
<br> • 배열의 모든 요소 출력은 `import java.util.Arrays;` 문장이 필요하다.
``` Java
System.out.println(Arrays.toString(배열 이름); 
```
• 배열의 모든 요소를 출력한다. <br>
• 배열을 오름차순으로 정렬하고자 한다면 `import java.util.Arrays;` 문장이 필요하다.
``` Java
Arrays.sort(배열 이름);
Arrays.sort(배열 이름, 시작 인덱스, 끝 인덱스); 
```
시작 인덱스부터 끝인덱스-1의 데이터까지 오름차순으로 정렬한다. <br>
• 내림차순으로 정렬하고자 한다면 `import java.util.Arrays;` 문과 `import.java.util.Collections;` 문장이 필요하다.
``` Java
Arrays.sort(배열 이름, Collections.reverseOrder());
```
하게 되면 내림차순으로 정렬된다. <br>
• 이진탐색은 정렬된 데이터에서 절반씩 줄여나가서 특정값을 탐색하는 방법으로, 정렬이 우선되어야 한다. `import java.util.Arrays;` 문이 필요하다.
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

## 연습문제
 • 배열의 성분을 –20에서 20까지의 난수(random number)로 초기화하기 <br>
 • 배열의 모든 성분을 출력하기 <br>
 • 배열의 모든 성분의 합을 반환하기 <br>
 • 배열의 최댓값을 반환하기 <br>
 • 배열의 최댓값의 인덱스를 반환하기<br>
 • 배열 성분 셔플링<br>
 • 배열 성분 한 칸 로테이션 : 왼쪽, 오른쪽<br>
 • 배열 성분 n 칸 로테이션 : 왼쪽, 오른쪽<br>
 
 ``` Java
 import java.util.Arrays;
import java.util.Scanner;
public class week3_1 {
	public static void main(String[] args) {
		int[] arr=new int[6];	// 배열 선언
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int c, randnum;
		
		for(int i=0;i<arr.length;i++) {			// 배열 길이만큼 반복
			arr[i]=(int)(Math.random()*40-20);	//0-40 사이 난수를 지정 후 –20을 하여 –20에서 20 사이의 난수를 지정한다.
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("배열 성분의 합");
		for(int i=0;i<arr.length;i++) {			//각각의 배열 요소를 sum에 더한다
			sum+=arr[i];
		}
		System.out.println(sum);
		System.out.println("성분 셔플");	
		for(int i=0;i<arr.length;i++) {		
			randnum=(int)(Math.random()*(arr.length-1));
			c=arr[i];
			arr[i]=arr[randnum];
			arr[randnum]=c;		//각각의 배열 요소를 arr[난수]의 값과 바꾼다
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("왼쪽으로 한 칸 로테이션");
		c=arr[0];				//c에 배열 맨 앞의 요소를 저장한다.
		for(int i=1;i<arr.length;i++) {		//인덱스 1번부터 마지막 인덱스까지 증가
			arr[i-1]=arr[i];
		} 	//각각의 배열요소에 다음 요소의 값을 대입함으로써 요소들을 왼쪽으로 한 칸씩 당긴다.
		arr[arr.length-1]=c;		//배열 마지막 요소에 c값을 대입한다.
		System.out.println(Arrays.toString(arr));
		System.out.println("오른쪽으로 한 칸 로테이션");
		c=arr[arr.length-1];		//배열 마지막 요소를 c에 저장한다.
		for(int i=arr.length-1;i>0;i--) {	//마지막 인덱스부터 1까지 감소
			arr[i]=arr[i-1];			
		} 	//각각의 배열 요소에 이전의 요소의 값을 대입함으로써 요소들을 오른쪽으로 한 칸씩 당긴다.
		arr[0]=c;				//배열 처음 요소에 c값을 대입한다.
		System.out.println(Arrays.toString(arr));
		System.out.print("왼쪽으로 몇 칸? ");
		int n=sc.nextInt();			//몇 칸 이동할지 입력받는다.
// 배열의 크기만큼 이동하게 되면 결국 제자리이므로 1칸씩 이동하는 메소드를 입력받은 수를 배열의 크기로 나눈 나머지만큼 반복하면 된다. 
		for(int j=0;j<n%arr.length;j++) {	//1칸씩 이동하는 메소드를 원하는 만큼 반복하면 된다.
			c=arr[0];
			for(int i=1;i<arr.length;i++) {
				arr[i-1]=arr[i];
			}
			arr[arr.length-1]=c;
		}
		System.out.println(Arrays.toString(arr));
		System.out.print("오른쪽으로 몇 칸? ");
		n=sc.nextInt();			//몇 칸 이동할지 입력받는다
		for(int j=0;j<n%arr.length;j++) {	//1칸씩 이동하는 메소드를 원하는 만큼 반복하면 된다.
			c=arr[arr.length-1];
			for(int i=arr.length-1;i>0;i--) {
				arr[i]=arr[i-1];			
			}
			arr[0]=c;
		}
		System.out.println(Arrays.toString(arr));
	}
}
```
 Math.random() 메소드는 시스템 안에 내장되있으므로 import문은 필요 없다. 형변환(int)을 하지 않으면 0에서 1사이의 double형태의 숫자가 정해진다. 40배 해서 0과 40 사이 정수로 만든 후 20을 빼서 –20에서 20사이의 숫자로 배열의 요소를 입력하게 된다. <br>
 배열 성분의 합은 반복문내에서 증가하는 변수를 이용해서 각각의 요소를 하나의 변수에 계속 더해주면 된다.<br>
 배열 성분 셔플은 반복문을 이용해서 처음 요소부터 마지막 요소까지 배열 내의 임의의 요소와 바꾸는 과정을 거쳐서 만들 수 있다.<br>
 배열 성분의 로테이션은 우선 경계가 되어서 일반화한 식을 적용할 수 없는, 즉 처음 요소나 마지막 요소는 직접 바꾸고, 반복 루프를 이용해서 arr[i-] = arr[i]; 과 같은 문장을 통하여 요소들을 오른쪽 또는 왼쪽으로 회전시킬 수 있다.<br>
 배열 성분의 1칸의 로테이션을 하나의 묶음으로 생각하면 입력받은 숫자만큼 묶음을 실행하면 원하는 결과를 얻을 수 있다. 다만 입력받은 숫자를 배열의 크기로 나눈 나머지만큼만 반복한다면 반복 횟수를 최소로 해서 원하는 결과를 얻을 수 있다.<br>
 // 가독성은 잘 모르겠다.
