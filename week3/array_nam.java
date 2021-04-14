import java.util.Arrays;
import java.util.Scanner;
public class week3_1 {
	public static void main(String[] args) {
		int[] arr=new int[6];
		Scanner sc=new Scanner(System.in);
		int sum=0;
		int c, randnum;
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*40-20);		
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("배열 성분의 합");
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		System.out.println(sum);
		System.out.println("성분 셔플");
		for(int i=0;i<arr.length;i++) {
			randnum=(int)(Math.random()*(arr.length-1));
			c=arr[i];
			arr[i]=arr[randnum];
			arr[randnum]=c;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("왼쪽으로 한 칸 로테이션");
		c=arr[0];
		for(int i=1;i<arr.length;i++) {
			arr[i-1]=arr[i];
			
		}
		arr[arr.length-1]=c;
		System.out.println(Arrays.toString(arr));
		System.out.println("오른쪽으로 한 칸 로테이션");
		c=arr[arr.length-1];
		for(int i=arr.length-1;i>0;i--) {
			arr[i]=arr[i-1];			
		}
		arr[0]=c;
		System.out.println(Arrays.toString(arr));
		System.out.print("왼쪽으로 몇 칸? ");
		int n=sc.nextInt();
		for(int j=0;j<n%arr.length;j++) {
			c=arr[0];
			for(int i=1;i<arr.length;i++) {
				arr[i-1]=arr[i];
				
			}
			arr[arr.length-1]=c;
		}
		System.out.println(Arrays.toString(arr));
		System.out.print("오른쪽으로 몇 칸? ");
		n=sc.nextInt();
		for(int j=0;j<n%arr.length;j++) {
			c=arr[arr.length-1];
			for(int i=arr.length-1;i>0;i--) {
				arr[i]=arr[i-1];			
			}
			arr[0]=c;
		}
		System.out.println(Arrays.toString(arr));
	}
}
