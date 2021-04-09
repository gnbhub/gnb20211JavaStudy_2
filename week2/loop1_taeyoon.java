import java.util.Scanner;
public class Hello {
	public static void main(String[] args) {
		Scanner nn = new Scanner(System.in);
		System.out.print("라인수 : ");
		int num = nn.nextInt(); 
		if(num <= 2)                                                // 2이하의 자연수 
			System.out.print("라인은 3이상의 정수만 가능합니다.");
		
		else if((num>=3)&&(num%2!=0)) {                             // 3이상의 홀수
			for(int i=1;i<=num/2;i++) {            //위쪽 부분
			for(int j=1;j<=(num-(2*i-1))/2; j++) 
				System.out.print(" ");
			for(int j=1;j<=i;j++)
				System.out.print(num);
			System.out.println("");}
			
			for(int j=1;j<=(num+1)/2;j++)          //가운데 부분
				System.out.print(num);
			System.out.println("");
			
			for(int i=1;i<=num/2;i++) {            //아래쪽 부분
				for(int j=(num+1)/2-i; j>=1 ; j--) 
				System.out.print(num);
			System.out.println("");} 
			}
		
		else if((num>=3)&&(num%2 == 0)) {                          // 3이상의 짝수
			for(int i=1;i<=num;i++) {
				for(int j=1;j<=2*(num-i);j++) 
					System.out.print(" ");
				for(int j=1;j<=4*i-3;j++)
				System.out.print("*");
			System.out.println("");	}
			}
	}
}	
