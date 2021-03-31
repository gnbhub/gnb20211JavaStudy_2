import java.util.Scanner;
public class Hello {
	public static void main(String[] args) {
		int i, j=0;
		Scanner a=new Scanner(System.in);
		System.out.println("정수: ");
		i=a.nextInt();
		for(j=7;j>=0;j--) {
			if(i>=Math.pow(2,j)) {
				System.out.print("1");
				i-=Math.pow(2,j);
			}
			else System.out.print("0");
		}
		
		
		a.close();
		
	}

	
}
