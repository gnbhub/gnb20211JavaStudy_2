# 8주차  GUI 이벤트 처리 / 파일 입출력
 ## 이벤트-구동 프로그래밍(event-driven programming)
 어떤 이벤트가 일어나는지를 감시하고 있다가 이벤트가 발생하면 적절한 처리를 해주는 프로그래밍 방식
 - 이벤트의 발생에 의해 프로그램의 흐름이 결정되는 방식
	  - 이벤트가 발생하면 **이벤트를 처리하는 루틴(이벤트 리스너) 실행**
	  - 이벤트가 발생되는 실행될 코드가 이벤트 리스너에 작성됨

 ## 이벤트 종류
 - 사용자의 입력
	- 마우스 클릭, 마우스 드래그, 키보드 누름 등
 - 센서로부터의 입력
 - 네트워크로부터 데이터 송수신
 - 다른 응용프로그램이나 다른 스레드로부터의 메시지

 ## 이벤트 리스너
 - 이벤트를 처리하는 코드이다. 클래스로 작성된다
 - 자바에서 이벤트 리스너 작성을 위한 인터페이스가 제공
	- 프로그래머가 **리스너 인터페이스의 추상 메소드 구현**
	- 이벤트가 발생하면 리스너 인터페이스의 추상 메소드 호출

 - 이벤트 처리 과정
1. 이벤트 발생 – ex) 마우스의 움직임 혹은 키보드입력
2. 이벤트 객체 생성 – 현재 발생한 이벤트에 대한 정보를 가진 객체
3. JVM이 찾은 응용프로그램에 작성된 이벤트 리스너 찾기
4. 해당 이벤트 리스너 실행
  - 리스너에 이벤트 객체 전달
  - 리스너 코드 **(해당 이벤트가 발생되면 실행될 사용자가 작성한 코드)** 실행

### #1 이벤트를 처리할 클래스 정의
리스너 인터페이스 : 어떤 클래스가 이벤트를 처리하기 위하여 구현해야 하는 규격<br>
 ex) 버튼을 클릭하면 액션 이벤트(action event)가 발생하는데 이 이벤트를 처리하기 위한 리스너 인터페이스는 ActionListener 인터페이스이다. ActionListener에서는 actionPerformed()라는 메소드가 정의되어 있다. 액션 이벤트를 처리하려면 이 메소드를 작성하면 된다. actionPerformed()는 액션 이벤트가 발생할 때마다 호출된다.
```java
class MyListener implements ActionListener{
	public void actionPerformed(ActionEvent e){
		… // Action 이벤트를 처리하는 코드가 여기에 들어간다.
	}	//actionPerformed()는 액션 이벤트가 발생할 때마다 호출된다.
}
```

### #2 컴포넌트에 이벤트 처리 객체 등록
컴포넌트에 리스너 객체를 등록해야만 이벤트가 발생하였을 때, 이벤트가 처리된다. 각 컴포넌트는 이벤트 리스너를 등록할 수 있는 메소드를 제공한다.
<br> ex) 버튼의 경우 addActionListener() 
```java
public class MyFrame extends JFrame{
	…
	public MyFrame(){
		button = new JButton(“증가”);	//버튼 생성
		button.addActionListener(new MyListener());
//new를 이용하여 이벤트리스너 객체를 생성하고, 버튼에 이벤트 리스너 객체를 등록한다
		…
	}
}
```

## 이벤트 객체
 - 발생한 이벤트에 관한 정보를 가진 객체
 - 발생한 이벤트에 대한 모든 정보를 이벤트 리스너로 전달한다
	- 이벤트 리스너 코드가 발생한 이벤트에 대한 상황을 파악할 수 있게 함
 - 이벤트 객체가 포함하는 정보
	- 이벤트 종류 / 이벤트 소스
	- 이벤트가 발생한 화면 좌표 및 컴포넌트 내 좌표
	- 이벤트가 발생한 버튼이나 메뉴 아이템의 문자열
	- 클릭된 마우스 버튼 번호 및 마우스의 클릭 횟수
	- 키의 코드 값과 문자 값
	- 체크박스, 라디오버튼 등과 같은 컴포넌트에 이벤트가 발생하였다면 체크 상태
 - 이벤트 소스를 알아 내는 메소드
	- Object getSource()
	- **발생한 이벤트의 소스 컴포넌트 리턴**
	- **Object 타입으로 리턴하므로 캐스팅하여 사용**
	- 모든 이벤트 객체에 대해 적용
![](https://github.com/gnbhub/gnb20211JavaStudy_2/blob/master/week8/pic/method.JPG?raw=true)
![](https://github.com/gnbhub/gnb20211JavaStudy_2/blob/master/week8/pic/source.JPG?raw=true)

 ## 여러 가지 이벤트 처리 방법
 ### 1. 프레임 클래스가 이벤트를 처리
 프레임 클래스가 JFrame을 상속받으면서 동시에 ActionListener 인터페이스도 구현하는 방법
<br><1번 방법을 이용한 예제>
```java
import javax.swing.*;
import java.awt.event.*;

public class EventProcFrame1 extends JFrame implements ActionListener{
// MyFrame 클래스는 JFrame 클래스를 상속받고 동시에 ActionListener를 구현한다. 따라서 프레임이 버튼에서 발생하는 이벤트도 처리할 수 있다.
	private JButton button;
	private JLabel label;
	int counter = 0;

	public void actionPerformed(ActionEvent e){
//EventProcFrame1 클래스 안에 actionPerformed()가 정의되어 있어야 한다.
		counter++;
		label.setText(“현재의 카운터값: ”+counter);
	}
	public EventProcFrame1(){
		this.setSize(400, 150);
		this.setTitle(“이벤트 예제”);

		JPanel panel = new JPanel();
		button = new JButton(“증가”);
		label = new JLabel(“현재의 카운터값: ”+counter);
		button.addActionListener(this);
//현재 객체를 이벤트 리스너로 버튼에 등록한다. 즉 자기자신이 이벤트를 처리한다고 등록한다
		panel.add(label);
		panel.add(button);
		add(panel);
		setVisible(true);
	}
	public static void main(String[] args){
		EventProcFrame1 t = new EventProcFrame1();}
}
```

### 2. 무명 클래스를 사용하는 방법
이름이 없는 클래스를 작성하여, 한번만 사용하는 것. 클래스가 정의되면서 바로 사용된다.
```java
new 인터페이스명(){
	// 클래스 body
	……
}
new ActionListener(){
	public void actionPerformed(ActionEvent e){
		// 메소드body
	}
}
```
<2번 방법을 이용한 예제>
```java
import javax.swing.*;
import javax.awt.event.*;

public class EventProcFrame2 extends JFrame{
	private JButton button;
	private JLabel label;
	int counter = 0;
	
	public EventProcFrame2(){
		this.setSize(400, 150);
		this.setTitle(“이벤트 예제”);

		JPanel panel = new Panel();
		button = new Jbutton(“증가”);
		label = new JLabel(“현재의 카운터값: ”+counter);
		button.addActionListener(new ActionListener(){
//무명 클래스는 ActionListener 인터페이스를 구현한다. 무명클래스의 객체도 동시에 생성된다.
			public void actionPerformed(ActionEvent e){
				counter++;
				label.setText(“현재의 카운터값: ”+counter);
			}
		}); 	// 무명 클래스 안에서 actionPerformed()메소드를 정의한다.
		panel.add(label);
		panel.add(button);
		add(panel);
		setVisible(true);
	}
	public static void main(String[] args){
		EventProcFrame2 f = new EventProcFrame2();
	}
}
```

### 3. 람다식을 사용하여 이벤트 처리
 람다식(lambda expression)은 이름이 없는 메소드(함수)라고 할 수 있다. 람다식을 이용하면 메소드가 필요한 곳에 간단히 메소드를 보낼 수 있다. 특히 메소드가 딱 한번만 사용되고 메소드의 길이가 짧은 경우에 유용하다.
```java
(arg1, arg2...) ->{ body}
예) (int a, int b) -> { return a+b; }
```

<3번 방법을 이용한 예제>
```java
import javax.swing.*;
import java.awt.event.*;

public class MyFrame extends JFrame{
	private JButton button;
	private JLabel label;
	int counter = 0;

	public MyFrame(){
		this.setSize(400, 150);
		this.setTitle(“이벤트 예제”);

		JPanel panel = new Panel();
		button = new Jbutton(“증가”);
		label = new JLabel(“현재의 카운터값: ”+counter);
		button.addActionListener(e -> {
			counter++;
			label.setText(“현재의 카운터값: ”+counter);
		});
// 람다식을 사용하여 이벤트를 처리하고 있다. 변수 e는 이벤트를 나타낸다. 람다식은 함수를 객체로 만들어서 메소드에 전달할 수 있다.
		panel.add(label);
		panel.add(button);
		add(panel);
		setVisible(true);
	}
	public static void main(String[] agrs){
		MyFrame t = new MyFrame();
	}
}
```
![](https://github.com/gnbhub/gnb20211JavaStudy_2/blob/master/week8/pic/eli.JPG?raw=true)

 ## 키 이벤트(key event)
 키 이벤트는 사용자가 키보드를 이용하여 입력을 하는 경우에 발생한다. 어떤 클래스가 키보드 이벤트를 처리하려면 KeyListener 인터페이스를 구현해야 한다.
```java
public class MyListener implements KeyListener{
	public void keyPressed(KeyEvent e)	{	}
// 사용자가 키를 눌렀을 경우 호출
	public void keyReleased(KeyEvent e)	{	}
// 사용자가 키에서 손을 떼었을 경우 호출
	public void keyTyped(KeyEvent e)	{	}
// 사용자가 글자를 입력했을 경우에 호출
}
```
매개 변수 e는 사용자가 입력한 키보드의 가상 키 번호이다.

## 키보드 포커스
 키 이벤트를 받을 수 있는 조건
<br>키 이벤트(Key Event)가 발생하려면 컴포넌트가 반드시 키보드 포커스를 가지고 있어야 한다.
<br>키보드 포커스를 얻으려면 requestFocus(), setFocusable(true)를 호출하여야 한다.
```java
panel.requestFocus();
panel.setFocusable(true);
```

## 마우스 이벤트(Mouse Event)
사용자가 마우스 버튼을 누르거나 마우스를 움직일 때 발생한다. 사용자가 버튼을 누르거나 메뉴를 선택할 때는 마우스 이벤트를 처리할 필요가 없다(액션 이벤트로 처리하면 되기 때문).
<br>하지만 사용자가 화면에 마우스로 그림을 그리게 하려면 마우스 이벤트를 처리하여야 한다.
<br><MouseListener 인터페이스의 추상 메소드>
```java
public class MyListener implements MouseListener{
	public void mousePressed(MouseEvent e){	}
// 마우스가 컴포넌트 위에서 눌려지면 호출된다.
	public void mouseReleased(MouseEvent e){	}
// 마우스가 컴포넌트 위에서 떼어지면 호출된다.
	public void mouseEntered(MouseEvent e){	}
// 마우스 커서가 컴포넌트로 들어가면 호출된다.
	public void mouseExited(MouseEvent e){		}
// 마우스 커서가 컴포넌트에서 나가면 호출된다.
	public void mouseClicked(MouseEvent e){	}
// 사용자가 컴포넌트를 클릭한 경우에 호출된다.
}
```
 -> 사용자가 마우스 버튼을 누르면 mousePressed()가 호출되고 마우스 버튼에서 손을 떼면 mouseReleased()가 호출된다. 이어서 mouseClicked()가 호출된다.
 <br>
<MouseMotionListener 인터페이스의 추상 메소드>
```java
public class MyListener implements MouseMotionListener{
	public void mouseDragged(MouseEvent e){	}
// 마우스 드래그하면 호출된다.
	public void mouseMoved(MouseEvent e){		}
// 마우스가 클릭되지 않고 이동하는 경우에 호출된다.
}
```
 -> 마우스 버튼이 눌린 채로 이동하면 mouseDragged()가 호출되고, 그냥 이동하면 mouseMoved()가 호출된다. 드래그시에는 mouseMoved()는 호출되지 않는다. 또 드래그시에는 mouseClicked()는 호출되지 않는다.

### 리스너 특징
앞서 공부했던 추상 메소드에 관한 내용이다. 추상클래스를 상속받거나 인터페이스를 implements 하게 되면 부모 클래스의 추상 메소드를 자식 클래스에서 무조건 재정의해줘야 한다고 배웠다. 리스너도 인터페이스라서 리스너를 implements하는 경우, 하나의 메소드만을 사용하고자 하더라도 나머지의 추상 메소드를 구현해주어야 한다.
<br>
<리스너를 사용하는 방법>
```java
class MyListener implements KeyListener{
	public void keyTyped(KeyEvent e){	//작성하기 원하는 메소드 입력
	…
	}
	public void keyPressed(KeyEvent e){	//불필요한 메소드}
	public void keyReleased(KeyEvent e){	//불필요한 메소드}
}
```

### 어댑터 클래스(Adaptor Class)
 앞서 말한 리스너의 불편을 해소하기 위한 것. 추상 메소드들 중 **필요한 것만 구현**하면 된다. 추상메소드가 하나 뿐인 리스너는 어댑터 클래스가 존재하지 않는다.
<br>
<어댑터를 사용하는 방법>
```java
class MyListener extends KeyAdapter{  //인터페이스를 구현해 놓은 어댑터 클래스	public void keyTyped(KeyEvent e){	//필요한 메소드만 재정의한다.
		if(e.getKeyChar() == ‘x’ ){
			…	}
	}
}
```
 ## 스트림(stream)
 “바이트들의 연속적인 흐름”
<br>우리는 스트림 객체에서 바이트를 읽을 수 있고 스트림 객체에 바이트를 쓸 수도 있다. 스트림은 입출력의 단위에 따라서 분류할 수 있다.
![](https://github.com/gnbhub/gnb20211JavaStudy_2/blob/master/week8/pic/stream.JPG?raw=true)

 ### 바이트 스트림
 - 바이트 스트림(byte stream)은 1byte 단위로 입출력하는 클래스
	- 한글을 다루기 곤란하다(한글은 2byte)
	- 영문자로 구성된 파일, 동영상, 이미지, 음악파일 입출력에 적합
 - 바이트 스트림 클래스들은 추상 클래스인 InputStream과 OutputStream에서 파생됨
 - 바이트 스트림 클래스 이름에는 InputStream(입력)과 OutputStream(출력)이 붙음

### 바이트 스트림의 기본적인 메소드
 - InputStream 클래스
	- read() : 1 byte를 읽어서 반환한다(0에서 255 사이의 정수)
	- read(byte[] b) 
	- read(byte[] b, int off, int len) 
 - OutputStream 클래스
	- write(int b) : 1 byte를 특정한 장치에 쓴다
	- write(byte[] b)
	- write(byte[] b, int off, int len)
	- flush()
 - close() : 스트림에서 읽거나 쓰는 동작을 종료하였다면 close()를 통해 스트림을 닫아야 한다. 스트림은 운영체제의 자원을 많이 소모하므로 사용이 끝나면 스트림을 닫아서 자원을 반환하는 것이 바람직하다.

### 문자 스트림(character stream)
 - 2byte Unicode(문자) 단위로 입출력을 수행하는 클래스
	- 한글로 구성된 파일 입출력에 적합
 - 모두 기본 추상 클래스인 Reader와 Writer 클래스에서 파생
 - 문자 스트림 클래스 이름에는 Reader와 Writer가 붙는다

### 문자 스트림의 기본적인 메소드
 #### Reader 클래스
	- abstract int read() : 한 문자를 읽어서 유니코드를 반환한다
	- read(char[] buf) : 문자를 하나씩 읽어서 char[]에 저장, 읽은 수 만큼 반환
	- read(char[] buf, int start, int length)
	- int skip(long n)
	- void close() : 문자 입력 스트림 닫기
 #### Writer 클래스
	- abstract void write(int c) : c값을 char로 변환하여 한 문자를 장치에 쓴다
	- void write(char[] b) : 문자 배열 b의 것을 쓰기
	- void write(char[] b, int start, int length)
	- void write(String str)
	- abstract void flush(); 버퍼 내용을 출력
	- abstract void close() : 문자 출력 스트림 닫기

 ### 파일 입출력 문자 스트림
 파일에서 문자를 읽거나 쓰려면 FileReader와 FileWriter를 사용한다.
<br><FileWriter스트림 사용 예>
```java
import java.io.*;
import java.util.Scanner;

public class FirleWriterEx {
	public static void main(String[] args) throws IOException{
		String st; int c;
		Scanner s = new Scanner(System.in);
		FileWriter fo = new FileWriter( “d:\\test.txt” );	// 파일 생성
		for(	;	;	){
			st = s.next();
			if(st.length() == 0) break;
			fo.write(st, 0, st.length());
			fo.flush();	// flush()해야 기록됨
			fo.write(“\r\n”, 0, 2);	// 줄바꿈
		}
		fo.close();
	}
}
```

<FileReader 스트림 사용 예>
```java
import java.io.*;
import java.util.Scanner;

public class FileWriterEx{
	public static void main(String[] args) throws IOException{
		String st; int c;
		FileReader fi = new FileReader(“d:\\test.txt”);	//파일 읽기
		System.out.println();
		while((c = fi.read() != -1)	//읽다가 –1이 나오는 경우는 파일의 끝
			System.out.print((char)c);
		fi.close();
	}
}
```
 ### 파일 입출력 바이트 스트림
 파일에서 바이트를 읽거나 쓰려면 FileInputStream와 FileOutputStream을 사용한다.
 #### FileInputStream
- FileInputStream 생성자
	- public FileInputStream(String filename);
	- public FileInputStream(File file);
- FileInputStream을 생성하고자 할 때 파일이 존재하지 않으면 java.io.FileNotFoundException가 발생
 #### FileOutputStream
- FileOutputStream 생성자
	- public FileOutputStream(String filename)
	- public FileOutputStream(File file)
	- public FileOutputStream(String filename, boolean append)
	- public FileOutputStream(File file, boolean append)
	– 파일이 존재하지 않으면 새로운 파일을 생성
	– 파일이 존재하면 파일의 내용을 모두 지움
	– 현재 내용을 유지하면서, 파일에 새로운 내용을 추가하려 append 인수를 **true**로 설정
<br>
<이진 파일 쓰기 – FileOutputStream>

```java
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileStream2{
	public static void main(String[] args){
		byte list[] = {10, 20, 30, 40, 50, 60 };
		try (FileOutputStream out = new FileOutStream(“d:\\test.dat”)){
// 파일 입출력시에는 예외가 발생할 수 있으므로 예외처리를 하는 것이 바람직
			for(byte b : list)
				out.write(b);
		} catch (IOException e) { e.printStackTrace(); }
// 예외가 발생했을 때 예외 내용 출력
	}
}
```

<이진 파일 읽기 – FileInputStream>

```java
import java.io.FileInputStream;
import java.io.IOException;

public class TestFileStream3{
	public static void main(String[] args){
		byte list[] = new byte[6];
		try (FileInputStream out = new FIleInputStream(“D:\\test.dat”)){
// 마찬가지로 예외 처리 설정
			out.read(list);
		} catch (IOException e){
			e.printStackTrace(); }	// 예외가 발생했을 때 예외 내용 출력
		for (byte b : list)
			System.out.print(b+“ ”);
		System.out.println();
	}
}	
```

 ## Path 객체
 Path 클래스는 경로를 나타내는 클래스로서 “\home\work”와 같은 경로를 받아서 객체를 반환한다.
```java
Path workDirectory = Paths.get(“C:\home\work”);
```
경로는 절대경로와 상대경로로 표시할 수 있다. 경로 설정이 잘못되면 InvalidPathException이 발생한다.

 ### File 객체
 File 클래스는 파일을 조작하고 검사하는 코드를 쉽게 작성하게 해주는 클래스이다. File 객체는 파일이 아닌 파일 이름을 나타낸다.
 ```java
File file = new File(“data.txt”);
```
<파일 정보 얻기>
```java
import java.io.*;
import java.util.*;

puiblic class FileTest {
	public static void main(String[] args) throws IOException {
		String name = “c:/eclipse”;
		File dir = new File(name);
// 여기서 만약 File 객체를 생성할 때 파일의 이름만 주면 현재 디렉토리에서 파일을 찾는다. 따라서 현재 디렉토리에 있지 않은 파일은 절대 경로로 이름을 주어야 한다.
		String[] fileNames = dir.list();	//현재 디렉토리의 전체 파일 리스트
		for(String s : fileNames){
			File f = new File(name + “/” +s);
			System.out.println(“==============================”)
			System.out.println(“이름: ”+f.getName());
			System.out.println(“경로: ”+f.getPath());
			System.out.println(“부모: ”+f.getParent());
			System.out.println(“절대경로: ”+f.getAbsolutePath());
			System.out.println(“정규경로: ”+f.getCanonicalPath());
			System.out.println(“디렉토리 여부: ”+f.isDirectory());
			System.out.println(“파일 여부: ”+f.isFile());
			System.out.println(“==============================”)
		}
	}
}
```

## 연습문제
지난 7주차에 있었던 온도 변환기를 실제로 동작하도록 만들어보았다<br>
![](https://github.com/gnbhub/gnb20211JavaStudy_2/raw/master/week7/pic/Flow.JPG?raw=true)
