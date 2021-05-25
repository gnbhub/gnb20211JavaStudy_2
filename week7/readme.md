# 7주차 예외처리 / GUI
## 에외(Exception) 처리
예외 : 오동작이나 결과에 영향을 주는 실행 중 발생한 오류
- 정수를 0으로 나누는 경우
- 배열보다 큰 인덱스로 배열의 원소를 접근하는 경우
- 존재하지 않는 파일을 읽으려고 시도하는 경우 
- 정수 입력을 기다리는 코드가 실행되고 있을 때, 문자가 입력된 경우
- 예외 발생 시 프로그램이 비정상 종료 되는 것을 막고 예외와 상관없는 기능은 정상 동작되도록 처리하는 작업 하는 것이 예외처리의 목적

<예외 발생 예>
``` java
import java.util.Scanner;

public class DivideByZero {
	public static void main(String[] args) {
		int x,y;
		Scanner sc = new Scanner (System.in);
		
		System.out.print("피젯수 :");  x = sc.nextInt();
		System.out.print("젯수: ");   y = sc.nextInt();
		
		int result = x/y;	// 예외가 발생할 수 있는 문장
		System.out.println("나눗셈 결과 : " + result);
	}
}
```
실행결과
```java
=> 피젯수 :10
젯수: 0
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at 예외처리.DivideByZero.main(DivideByZero.java:14
```
-> 정수 10을 0으로 나누었기 때문에 **ArithmethicException** 이라는 이름의 예외가 발생하였다. 현재 예외를 처리하고 있지 않기 때문에 예외가 발생하는 즉시 프로그램이 종료된다.
## 자바 예외 처리
- 프로그램 실행 시 발생하는 예외를 **Exception** 클래스로 제공
- java.lang 패키지에 정의 
- 예외가 발생하면 객체로 인식하여 예외 처리 함

### 자바 Exception 클래스 계층 구조 
![Exception](/week7/Exception.jpg)
### Exception 클래스 생성자
`Exception()`:                                예외 메시지 없이 예외 클래스 예외를 생성<br>
`Exception(String message )`:                 예외 생성 시 예외 메시지를 예외에 전달<br>
`Exception(String message, Throwable cause)`: 예외 생성 시 예외 메시지와 원인을 예외에 전달

### Exception 클래스 메소드
`public String getMessage( )`:     예외 발생 시 전달된 메시지를 반환<br>
`public Throwable getCause( )`:   예외 발생 시 전달된 예외 원인을 반환<br>
`public void printStackTrace( )`:  예외 발생 시 예외 발생 이력(backtrace)을 출력

### try~catch 구문
```java
try {
	//예외 발생 가능성이 있는 코드
}catch(예외 처리 클래스 변수) {
	//예외 처리 코드 : 적절한 메시지를 출력하는 코드
}
//실행코드
```

<try catch 구문 예시>
```
import java.util.Scanner;
public class DivideByZero {
	public static void main(String[] args) {
		int x,y;
		Scanner sc = new Scanner (System.in);
		
		System.out.print("피젯수 :");  x = sc.nextInt();
		System.out.print("젯수: ");   y = sc.nextInt();
		
		try {
			int result = x/y;
			System.out.println(x+"/"+y+"="+result);
		}catch(Exception e)
		{  System.out.println("0으로 나눌 수 없음");}
		
		System.out.println(x+"*3=" +(x*3));
	}
}
```
```java
=>피젯수 :75
젯수: 0
0으로 나눌 수 없음
75*3=225
```

### 다중 catch문
- 명령문이 많아지면 다양한 Exception가 발생할 가능성이 높음<br>
-> 여러 catch문을 작성하여 순차적으로 해당 예외를 체크 후 예외 처리<br>
-> Exception 계층 구조에서 상위 클래스 타입 매개변수를 가지는 catch문은 뒤에 위치시켜야 함.
```java
try {
	//명령문1
	//명령문2
	//명령문3
}
catch(FileNotFoundException e1)
{ //에외처리1  }
catch(IOException e2)
{ //예외처리2  }
catch(Exception e3)
{ //예외처리3 }
```

### finally 블록에서의 실행 흐름
- finally 블록은 예외 발생 여부와 상관없이 실행되는 부분
- 외부 장치 연동 시 초기화 작업이나 마무리 작업 시 주로 사용
- finally 블록은 생략 가능

<final 블록 사용 예시>
```java
 import java.util.Scanner;
public class ExceptionTest3 {
	public static void main(String[] args) {
		int x, y,result;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("피젯수 :");  x = sc.nextInt();
		System.out.print("젯수: ");   y = sc.nextInt();
		
		try {	result = x/y;
		    	System.out.println(x+"/"+y+"="+result);
		}catch(ArithmeticException e)
		{  System.out.println("0으로 나눌 수 없음");
		}finally {
			System.out.println("오류 발생 유무와 무관하게 수행");
		}
		System.out.println("에외 World");
	}
}
```
```java
=>피젯수 :75
젯수: 3
75/3=25
오류 발생 유무와 무관하게 수행
에외 World
```
```java
피젯수 :75
젯수: 0
0으로 나눌 수 없음
오류 발생 유무와 무관하게 수행
에외 World
```

### throws를 이용한 예외처리
- 예외 발생 시 발생한 예외를 메소드를 호출한 곳으로 전달하여 예외 처리
```java
import java.util.Scanner;
class Calculator{
	public void DivideFun() throws ArithmeticException{
			System.out.println("메소드 시작");
			int x,y; Scanner sc = new Scanner(System.in);
			System.out.print("피젯수 : ");  x=sc.nextInt();
			System.out.print("젯수 : ");   y= sc.nextInt();
			int result = x /y; //예외발생
			System.out.println(x+"/"+y+"="+result);
			System.out.println("메소드 종료");
	}
}
public class ThrowTest {
	public static void main(String [] args) {
		Calculator c = new Calculator();
		try {  c.DivideFun();  //함수 호출
		}catch(ArithmeticException e) {
			System.out.println("main 메소드에서 산술 에외 처리");
			System.out.println("0으로 나눌 수 없다.");
		}
		System.out.println("예외처리 세계");
	}
}
```
```java
=>메소드 시작
피젯수 : 75
젯수 : 0
main 메소드에서 산술 에외 처리
0으로 나눌 수 없다.
예외처리 세계
```

## GUI(Graphical User Interface
이미지 (또는 그래픽)을 이용하여 사용자가 편리하도록 만들어진 인터페이스
- 메뉴 등을 포함하는 화면 구성
- 키보드, 마우스 등의 편리한 입출력 도구 이용 가능

### 컴포넌트
- 순수컴포넌트: 컨테이너에 포함되어야 화면에 표시되는 GUI객체, 컴포넌트를 포함할 수 없는 컴포넌트(JButtion, JLabel..)
- 컨테이너 : 다른 컴포넌트를 포함할 수 있는 컴포넌트(JRame, JDialog..)

#### 주요 메소드
`add(componet)`: 프레임(컨테이너)에 컴포넌트를 추가하는 메소드<br>
`setLocation(x,y)`: 프레임의 위치 설정하는 메소드<br>
`setSize(width, height)`: 프레임의 크기 설정하는 메소드<br>
`setIconImage(IconImage)`: 타이틀 바에 표시할 아이콘을 설정하는 메소드<br>
`setTitle(“제목”)`: 타이틀 바의 제목을 설정하는 메소드<br>
`seBackground(Color,yellow)`: 컨텐트팬의 배경색을 지정하는 메소드<br>
`setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);` : 프레임 종료버튼이 클릴될 떄 프레임을 듣고 응용프로그램도 종료시킬 경우

<컨테이너 생성하고 컴포넌트 추가하기>
```java
import javax.swing.*;

public class MyFrame extends JFrame{
	public MyFrame() {
		setSize(300,200);
		setTitle("프레임생성, 컴포넌트 추가");
		
		JButton b = new JButton("버튼");
		add(b);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
	}
}
```

<GUI 프로그램 작성 예>
```
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,150); setLocation(200,300);
		setTitle("MyFrame"); setLayout(new FlowLayout());
		getContentPane().setBackground(Color.yellow);
		JButton button1 = new JButton("확인"); //버튼생성
		JButton button2 = new JButton("취소");
		this.add(button1); this.add(button2);
		setVisible(true);
	}
	public static void main(String[] args) {
		MyFrame f = new MyFrame(); //프레임객체생성
	}
}
```
=>x 클릭하면 프레임이 닫히고 프로그램도 종료됨.
### 배치관리자 개념
 - 컨테이너마다 하나의 배치관리자 존재
 - 컨테이너에 부착되는 컴포넌트의 위치와 크기를 자동으로 결정
 - java.awt 패키지에 구현되어 있음

### 배치관리자 유형 4가지
#### FlowLayout 
- 컴포넌트 삽입되는 순서대로 왼쪽에서 오른쪽으로 배치
- 배치할 공간이 없으면 아래로 내려와서 반복
- Panel. JPanel. Applet, JApplet의 기본배치관리자
#### BorderLayour 
- 컨테이너 공간을 동,서,남,북,중앙 5개 영역으로 나눔
- 영역을 지정하지 않으면 가운데 배치됨
- Window, JWindeow, Frame, JFrame, Dialog, JDialog의 기본배치관리자<br>
#### GridLayout
- 컨테이너를 프로그램에서 설정한 동일한 크기의 2차원 격자로 나눔
- 컴포넌트는 삽입 순서대로 좌에서 우로, 다시 위에서 아래로 배치<br>
#### CardLayout
- 컨테이너 공간에 카드를 쌓아 놓은 듯이 컴포넌트들 포개어 배치
 

<FlowLayout 배치관리자 사용 예시>
```java
import javax.swing.*;
import java.awt.*;

public class FlowLayoutEx extends JFrame{
	public FlowLayoutEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("FlowLayouTest");
		setSize(300,150);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(new JButton("버튼1"));
		add(new JButton("버튼2"));
		add(new JButton("버튼3"));
	    setVisible(true);
	}
	public static void main(String[] args) {
		FlowLayoutEx f = new FlowLayoutEx(); 
		}
}
```
<배치관리자의 생성자 활용>
```java
BoredrLayout()
BorderLayout(int hGap, intvGap) 
-hGap : 좌우 컴포넌트 수평 간격, -vGap : 상하 컴포넌트 수직 간격
FlowLayout()
FlowLayout.방향
GirdLayout()
GirdLayout(int rows, int cols)  
GirdLayout(int rows, int cols, int hGap, int vGap)
```

<GridLayout 배치관리자 사용 예시>
```java
import javax.swing.*;
import java.awt.*;

public class GridLayoutEx extends JFrame{
	public GridLayoutEx() {
		super("GridLayout 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		
		contentPane.setLayout(new GridLayout(1,10));
		
		for(int i=0; i<10; i++) {
			String text = Integer.toString(i);
			JButton button = new JButton(text);
			contentPane.add(button);
		}
		setSize(500,200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new GridLayoutEx(); 
		}
}
```
### 패널(panel)
 - 컴포넌트들을 포함하고 있도록 설계된 컨테이너
 - 창을 여러개로 나누어서 표시하고 싶을 떄 사용

### 기초 컴포넌트
 - 레이블(JLabel) : 텍스트를 표시할 수 있는 공간, 편집이 불가능
 - 텍스트필드(JTextField) - 사용자가 한 줄의 텍스트를 입력할 수 있는 공간
 - 버튼(JButton) - 클릭되면 어떤 동작을 실행하는 버튼

<온도 변환기 프로그램>
```java
public class TempConverter extends JFrame{
	public TempConverter() {
		JPanel panel = new JPanel();
		add(panel);
		
		JLabel lab1 = new JLabel("화씨 온도");
		JLabel lab2 = new JLabel("섭씨 온도");
		JTextField f1 = new JTextField(15);
		JTextField f2 = new JTextField(15);
		JButton b = new JButton("변환");
		
		panel.add(lab1);   panel.add(f1);
		panel.add(lab2);   panel.add(f2);
		panel.add(b);
		
		setSize(300,150);
		setTitle("온도변환기");
		setVisible(true);
	}
	public static void main(String[] args) {
		new TempConverter(); 
		}
}
```
#written by ktw
