package hello;
import java.util.Scanner;
public class Ex2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	int a, b;
	System.out.print("a: ");
	a = sc.nextInt();
	System.out.print("b: ");
	b = sc.nextInt();
	for(int i=a ;i<b+1;i++) {
		System.out.print(i+"ÀÇ ¾à¼ö: ");
		for(int j =1; j<=i;j++) {
		if(i%j==0)
			System.out.print(j+" ");
		}
		System.out.println();
		
	}
	
	sc.close();

	}

}
