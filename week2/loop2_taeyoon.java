import java.util.Scanner;
public class Hello {
	public static void main(String[] args) {
		Scanner nn = new Scanner(System.in);
		System.out.print("a : ");
		int a = nn.nextInt();
		System.out.print("b : ");
		int b = nn.nextInt();
		 
		
		if(a>b) { 
			int c=a; a=b;b=c;}		
		
		for(int i=a;i<=b;i++) {
			System.out.print(i + "의 약수 : ");
			for(int n=1;n<=i;n++) {
				if((i%n)==0)
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
}
