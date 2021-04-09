import java.util.Scanner;
public class Hello {
	public static void main(String[] args) {
		int num, a, b;
		Scanner sc=new Scanner(System.in);
		System.out.print("a: ");
		a= sc.nextInt();
		System.out.print("b: ");
		b= sc.nextInt();
		if(a>b) {
			num=a;
			a=b;
			b=num;
		}
		for(int i=a;i<=b;i++) {
			System.out.printf("%d의 약수: ", i);
			for(int j=1;j<=i;j++) {
				if(i%j==0)
					System.out.printf("%d ", j);									
			}
			System.out.println();
		}
		sc.close();
	}
		
}
