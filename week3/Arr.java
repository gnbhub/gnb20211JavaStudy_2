import java.util.Arrays;
public class Arr {
	public static void main(String[] args) {
		double r = Math.random();
		int[] s = new int[10];
		int sum =0;
		int[] copy = new int[10];
		for(int i =0; i<s.length;i++) {
			int num = (int)((Math.random()*100)%41 - 20);
			s[i]=num;
		}
		for (int m : s) {
			System.out.print(m+" ");
		}System.out.println();
		
		for(int i=0;i<s.length;i++) {
			sum+=s[i];
		}
		System.out.println("배열 성분의 합: "+sum);
		
		System.arraycopy(s, 0, copy, 0, s.length);
		Arrays.sort(copy);
		System.out.println("배열 성분의 최댓값: "+copy[9]);
		for(int i=0;i<s.length;i++) {
			if(s[i]==copy[9]) {
				System.out.println("배열성분 중 최대값의 인덱스: "+ i);
				break;
			}
		}
		for(int i=0;i<s.length;i++) {
			int n =(int)((Math.random()*10)%(s.length-1));
			int c;
			c=s[i];
			s[i]=s[n];
			s[n]=c;
		}
		System.out.println("성분 셔플");
		for (int m : s) {
			System.out.print(m+" ");
		}System.out.println();
		System.out.println("왼쪽으로 한 칸 로테이션: ");
		int ro = s[0];
		for(int i =0;i<s.length;i++) {
			if(i==9) {
				s[i]=ro;
				break;
			}
			s[i]=s[i+1];
		}
		for (int m : s) {
			System.out.print(m+" ");
		}System.out.println();
		System.out.println("오른쪽으로 한 칸 로테이션: ");
		ro=s[s.length-1];
		for(int i=s.length-2;i>=0;i--) {
			s[i+1]=s[i];
			if(i==0) {
				s[i]=ro;
				break;
			}
		}
		for (int m : s) {
			System.out.print(m+" ");
		}System.out.println();
		
		
		
	}
}
