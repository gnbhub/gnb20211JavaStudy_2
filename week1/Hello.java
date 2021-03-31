import java.util.Scanner;
public class Hello {
	public static void main (String[] args) {
		int num = 127;
		System.out.println("128이하의 양의 정수: ");
		Scanner in = new Scanner(System.in); 
		int n = in.nextInt();
		int c;
		c = n & 128;
	    System.out.print((c==128)? 1 : 0 );

		c = n & 64;
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