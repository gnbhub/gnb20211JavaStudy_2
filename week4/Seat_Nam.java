import java.util.Scanner;
class Seat{
	int[] s=new int[10];
	void showSeat() {
		System.out.println("---------------------------");
		for(int i=0;i<10;i++) 
			System.out.print(i+" ");
		System.out.println();
		System.out.println("---------------------------");
		for(int i=0;i<10;i++)
			System.out.print(s[i]+" ");
		System.out.println();
		System.out.println("---------------------------");
		
	}
	void resSeat(int a) {
		if(s[a]==0) {
			s[a]=1;
			System.out.println("예약되었습니다. ");
		}
		else System.out.println("이미 예약된 자리입니다. ");
	}
}

public class SeatTest {
	public static void main(String[] args) {
		Seat a=new Seat();
		while(true) {
			a.showSeat();
			Scanner sc=new Scanner(System.in);
			System.out.print("몇 번째 좌석을 예약하시겠습니까? (그만두려면 10 이상의 숫자 입력) ");
			int seatnum=sc.nextInt();
			if(seatnum>=10)
				break;
			a.resSeat(seatnum);
		}
		
		
	}

}
