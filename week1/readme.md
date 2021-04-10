 # 1주차
 ## 자바 소개, 특징
 자바는 썬마이크로시스템즈의 제임스 고슬링이 개발하였다. 처음에는 소형 가전제품에 사용할 수 있는 간결한 컴퓨터 언어를 목적으로 설계되었다. 가전제품은 작은 양의 메모리를 가지는 연산장치이므로 간단하고 다양한 제품에 적용될 수 있도록 플랫폼에 독립적일 수 있게 개발되었다.<br>
 자바는 소스코드(.java)를 자바 컴파일러를 통해 바이트코드(.javac)로 변환한다. 이것을 자바 가상기계(JVM : Java Virtual Machine)가 바이트 코드를 한 줄씩 읽어서 해석한 후에 실행한다. 이 자바 가상기계라는 개념을 통해 자바는 어느 환경에서도 구동될 수 있다.
## 자바 프로그램의 일반적인 구조
 `public class Week1{ } ` : 클래스를 선언하는 문장이다. public은 누구나 사용 가능하다는 의미이고 class 뒤에 클래스 이름을 써준다. 소스 파일 이름은 항상 public이 붙은 클래스의 이름과 동일해야 한다. <br>
 `public static void main(String[] args){ } ` : 메소드 main()이 시작되는 문장이다. 클래스 안에 선언된 함수가 메소드이다. 자바는 메인함수에서부터 구동된다. static은 정적함수임을 나타내는 것이고 void는 main함수가 반환하는 값이 없다는 것을 의미한다. String[] args는 연속적인 문자열 데이터가 들어가는 저장하는 공간 정도로 해석된다.
 ## 변수, 자료형
 변수는 특정 값을 저장하는 메모리 공간을 뜻한다. 변수 이름을 숫자로 시작하거나, 공백이 들어가거나, 자바 언어의 키워드는 허용되지 않는다. 변수를 선언할 때 var를 이용하여 초기화하면 변수 타입 선언을 생략하고 이를 컴파일러가 추론한다. <br>
 문자열은 기본 타입의 자료형이 아니다. 내장된 문자열 자료형이 없어 String 클래스를 이용한다.
 ``` Java
 String str1 = new String(“Hello”);
 String str2 = “Hello”; 
 ```
 두가지 방법으로 문자열을 선언할 수 있는데, 변수명 앞의 String은 이것이 String 클래스임을 나타내고, 우변 new String(“Hello”)에서 String 생성자를 통해 “Hello”로 객체를 초기화한다. (초기값을 지정한다). String(“Hello”)에서 String은 내장된 String 생성자를 이용하여 “Hello”로 객체를 초기화한다.
 ## 콘솔에서 입력받기
 우선 `import java.util.Scanner;` 문장을 통해 자바 프로그램의 유틸리티 중에서 Scanner 클래스를 불러와야 한다. <br>
 `Scanner sc = new Scanner(System.in);` 에서 Scanner sc는 sc라는 변수가 Scanner 타입인 것을 나타내고, Scanner 생성자를 이용하여 객체를 초기화하는데, 값은 System.in을 통해 입력받은 값이다. 이렇게 되면 sc는 메소드로써 이용하게 된다.
 ## 연습문제 풀이
 숫자를 입력 받고 이를 이진수로 출력하도록 코드를 작성했다.
 ``` Java
import java.util.Scanner;
public class Binary {
	public static void main(String[] args) {
		int num, left1, left2, left3, left4, left5, left6, left7, left8, left9;   // 숫자를 입력할 각각의 변수 지정, 추후의 나오는 배열을 활용하면 간단하게 작성할 수있다.
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		left9 = num % 2;
		num = num / 2;
		left8 = num %2;
		num = num/2;
		left7 = num % 2;
		num = num/2;
		left6 = num % 2;
		num = num/2;
		left5 = num % 2;
		num = num/2;
		left4 = num % 2;
		num = num/2;
		left3 = num % 2;
		num = num/2;
		left2 = num % 2;
		num = num/2;
		left1 = num % 2;  // 입력받은수를 순서대로 출력한다면 저장하지 않아도 되지만, 역순으로 출력해야하므로 저장한다.
		System.out.print(left1);
		System.out.print(left2);
		System.out.print(left3);
		System.out.print(left4);
		System.out.print(left5);
		System.out.print(left6);
		System.out.print(left7);
		System.out.print(left8);
		System.out.print(left9);
		sc.close();
	}
}
```
이 경우는 입력받은 수를 9자리 이하의 이진수로 표현한다고 생각하고 구성한 경우이다. 최초로 2로 나누었을 때 나머지가 마지막으로 출력이 되야하므로 즉시 나누어 출력하지 않고 변수를 각각 지정해서 마지막에 2로 나눈 나머지가 제일 먼저 출력되도록 작성하였다.
### 조건문 응용
``` Java
import java.util.Scanner;
public class Hello {
	public static void main (String[] args) {
		System.out.println("255이하의 수를 입력하시오: “);
		Scanner in = new Scanner(System.in); 
		int n = in.nextInt();
		int c;
		c = n & 128;
		System.out.print((c==128)? 1 : 0 );  // 3항연산자를 이용해서 조건문안의 식이 참이면 : 왼쪽의 문장을, 거짓이면 오른쪽문장을 출력한다.
		c = n & 64;                          // 입력받은 수를 각각 2의 배수와 논리연산을 통해 해당자릿수의 숫자가 1이라면 1을, 0이라면 0 을 출력하는 과정이다.
		 System.out.print((c==64)? 1 : 0 );
		c = n & 32;
		 System.out.print((c==32)? 1 : 0 );
		c = n & 16;
		 System.out.print((c==16)? 1 : 0 );
		c = n & 8;
		 System.out.print((c==8)? 1 : 0 );
		c = n & 4;
		 System.out.print((c==4)? 1 : 0 );
		c = n & 2;
		 System.out.print((c==2)? 1 : 0 );
		c = n & 1;
		 System.out.print((c==1)? 1 : 0 );	
	}
}
```
이 경우는 255이하의 수를 입력 받아 이진수로 표현하는 경우이다. 입력받은 수를 큰 수부터 2의 제곱수와 &연산자를 통해 2진수의 해당하는 자릿수의 숫자가 1이라면 1을 출력하도록 구성하였다. (이것은 해당하는 숫자만 출력하도록 하는 일종의 마스킹이다.)
### 반복문 응용
#### 반복문을 응용하여 간단하게 코드를 작성할 수 있다.
``` Java
import java.util.Scanner;
public class Hello {
	public static void main(String[] args) {
		int i, j=0;
		Scanner a=new Scanner(System.in);
		System.out.println("정수: ");
		i=a.nextInt();
		for(j=7;j>=0;j--) {
			if(i>=Math.pow(2,j)) {             // Math.pow ; 지수 활용
				System.out.print("1");     // 2의 배수와 비교하여 크다면 1을 출력하고 그 숫자만큼 빼는 과정을 반복한다.
				i-=Math.pow(2,j);
			}
			else System.out.print("0");
		}
		a.close();	
	}
}
```
이 경우도 255이하의 수를 입력 받아 이진수로 표현하는 경우이다. 입력받은 수를 2의 7제곱부터 0제곱(1) 까지 비교하여 크다면 1을 출력하고 그 숫자만큼 빼는 과정을 반복한다.
논리연산자를 이용하지 않고 논리연산을 하는것과 같은 방식이라 할 수 있다.
### 배열, 반복문까지 활용할 경우
``` Java
import java.util.Scanner;
public class Hello
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 :");
		int num = sc.nextInt();
		int[] s = new int[9];			// 사이즈 9의 배열을 선언한다.
		
		for(i = 0; i<s.length; i++) {		// 배열 길이만큼 반복
			s[i] = num %2;			// s[0] 부터 num을 2로 나눈 나머지를 차례로 저장
	     	        num = num/2;			// 나머지 저장후 나누기 2
		}
		
		for(i=s.length-1;i>=0;i--) 		// s[배열길이]에서 s[0]까지 역순으로 출력
			System.out.print(s[i]);	
	}
}
```
최초의 풀이와 비슷한데 배열을 활용하여 변수를 하나하나 선언하지 않고 배열 하나로 정리하였다. s[0]부터 입력받은 수를 2로 나눈 나머지를 차례로 저장한다. 
<br>
그다음 s[8]부터 s[0]까지 역순으로 출력한다.
