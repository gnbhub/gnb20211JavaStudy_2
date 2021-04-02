//배열 활용
import java.util.Scanner;
public class Hello
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 :");
		int num = sc.nextInt();
	        int i;
		int[] s = new int[9];
		
		for(i = 0; i<s.length; i++) {
			s[i] = num %2;
	     	        num = num/2;
		}
		
		for(i=s.length-1;i>=0;i--) 
			System.out.print(s[i]);
		
	}
}

//배열 활용X
import java.util.Scanner;
public class Hello
{
	public static void main(String[] args) {
		Scanner yo = new Scanner(System.in);
		System.out.print("정수 :");
		int num = yo.nextInt();
	
		int nine = num%2;
		num = num/2;
		int eight = num%2;
		num = num/2;
		int seven = num%2;
		num = num/2;
		int six = num%2;
		num = num/2;
		int five = num%2;
		num = num/2;
		int four = num%2;
		num = num/2;
		int three = num%2;
		num = num/2;
		int two = num%2;
		num = num/2;
		int one = num%2;
		num = num/2;
		
		System.out.print(one);
		System.out.print(two);
		System.out.print(three);
		System.out.print(four);
		System.out.print(five);
		System.out.print(six);
		System.out.print(seven);
		System.out.print(eight);
		System.out.print(nine);		
		}
	
	}
