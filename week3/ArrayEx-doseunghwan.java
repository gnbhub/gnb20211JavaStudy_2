package hello;
import java.util.Arrays;
class Utils{
	
}
public class ArrayEx {

	public static void main(String[] args) {
		int[] s = new int[10];
		int sum= 0, max = 0;
		for(int i = 0; i<10 ; i++) {
			int e = (int)(Math.random()*-2);
			int n = (int)Math.pow(-1, e);
			s[i] = (int)(Math.random()*20*n);
		}
		for(int j = 0; j<s.length; j++) {
			sum +=s[j];
		}
		System.out.println(Arrays.toString(s));
		System.out.println(sum);
		
		for(int k = 0; k<s.length;k++) {
			if(s[k]>=max)
				max = s[k];
		}
		System.out.println(max);
		
		for(int k = 0; k<s.length;k++) {
			if(s[k]==max)
				System.out.println(k);
		}
		for(int l = 0; l<s.length;l++) {
			int tmp = 0;
			int r = (int)(Math.random()*s.length);
			tmp = s[l];
			s[l] = s[r];
			s[r] = tmp;
		}
		System.out.println(Arrays.toString(s));
		
		for(int l = 0; l<s.length-1;l++) {
			int tmp = 0;
			if(l == 0) {
				tmp = s[0];
				s[0] = s[s.length-1];
				s[s.length-1] = tmp;}
			else {tmp = s[l];
			s[l]=s[l-1];
			s[l-1] = tmp;}
		}
		System.out.println(Arrays.toString(s));
		
		for(int l = s.length-1; l==0;l--) {
			int tmp = 0;
			if(l == 0) {
				tmp = s[0];
				s[0] = s[s.length-1];
				s[s.length-1] = tmp;}
			else {tmp = s[l];
			s[l]=s[l-1];
			s[l-1] = tmp;}
		}
		System.out.println(Arrays.toString(s));
		

	}

}
