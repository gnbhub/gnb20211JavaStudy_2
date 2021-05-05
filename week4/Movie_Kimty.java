package hello;
import java.util.Scanner;
public class Movie {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int[] num = new int[10];
	
	for(int i=0;i<10;i++) 
	System.out.print(i + " ");
	System.out.println();                 //0부터 9까지 출력(좌석번호)
	
	for(int i=0;i<10;i++) 	num[i] = 0;
	for(int i=0;i<10;i++) {
		System.out.print(num[i] + " ");
	}System.out.println();                //num 1차원 배열 0으로 초기화
	
	System.out.print("몇 번째 좌석을 선택하시겠습니까?");
	int seat = sc.nextInt();
	System.out.println("예약되었습니다.");

	for(int i=0;i<10;i++) 
	System.out.print(i + " ");
	System.out.println();               //0부터 9까지 출력(좌석번호)
	
	num[seat]=1;
	for(int i=0;i<10;i++) {
		System.out.print(num[i] + " ");} // 예약한 좌석 숫자 1로 변경, 배열 출력
}}
