package rps;
import java.util.Scanner;
import java.util.Random;

public class Hangman {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] words = { "java", "count", "school", "book", "student", "programmer"};
		int index = (new Random()).nextInt(words.length);
		String solution = words[index];
		StringBuffer answer = new StringBuffer(solution.length());
		for(int i =0; i<solution.length();i++) {
			answer.insert(i,"_");
		}
		int count = 0;
		do {
			System.out.println("현재의 상태:"+answer);
			System.out.print("글자를 추측하시오:");
			char c = (sc.next()).charAt(0);
			for(int i = 0;i<solution.length();i++) {
				if(solution.charAt(i)==c) {
					answer.insert(i, c);
					answer.deleteCharAt(i+1);
					count++;}
			}
			}while(count!=answer.length());
			System.out.println("현재의 상태:"+answer);

	}

}
