import java.util.Scanner;
public class ex1 {
	public static void main(String[] args) {
		int line, i, j, ox=1, count=0;
		Scanner sc=new Scanner(System.in);
		while(ox!=0) {
			System.out.print("라인 수: ");
			line=sc.nextInt();			
			if(line>=3) {
				if(line%2==0) {
					for(i=1;i<=line;i++) {
						for(j=1;j<=2*line-2*i;j++) 		// 공백 개수: 2(line-행)
							System.out.print(" ");													
						for(j=1;j<=4*i-3;j++)			//별의 개수: (2*행-1)+(2*행-1)-1 = 4i-3
							System.out.print("*");						
						System.out.println();
					
				
					}
				}
				else {
					for(i=1;i<=line;i++) {
						if(i<=line/2) {					//위쪽 부분
							for(j=1;j<=line/2+1;j++) {
								if(j<=line/2+1-i) 
									System.out.print(" ");																	
								else System.out.print(line);
							}
						}
						else {							//아래쪽 부분(가운데 포함)
							for(j=1;j<=line+1-i;j++) 	//반복횟수+행=line+1->반복횟수=line+1-i
								System.out.print(line);							
						}
					System.out.println();	
					}
				}
			System.out.print("그만 두려면 0, 계속하려면 0 외의 수를 입력해주세요: ");	
			ox=sc.nextInt();
			System.out.println();
			count++;
			}
			else System.out.println("[입력오류] 라인은 3이상의 정수만 가능합니다. ");			
		}
		System.out.printf("프로그램을 종료합니다. 이제까지 총 %d번의 패턴을 출력했습니다. ", count);
		sc.close();
	}

}
