package hello;
import java.util.Scanner;
public class Binary {

	public static void main(String[] args) {
		int num, left1, left2, left3, left4, left5, left6, left7, left8, left9;
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
		left1 = num % 2;
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
