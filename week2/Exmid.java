package hello;

import java.util.Scanner;

public class Exmid {

	public static void main(String[] args) {
		int ln = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("라인 수:");
			int x = sc.nextInt();
			if (x<3) {
				System.out.println("라인은 3이상의 정수만 가능합니다.");
				continue;}
			if(x%2==1) {
				int column = x/2+1;
				for(int j = 0; j<column ; j++) {
					for(int k = 0; k<column-j-1; k++) {
						System.out.print(" ");}
					for(int k = 0; k<=j; k++) {
						System.out.print(x);}
					System.out.println("");}
				for(int j = 0; j<x-column ; j++) {
					for(int k = 0; k<column-j-1; k++) {
						System.out.print(x);}
					for(int k = 0; k<=j; k++) {
						System.out.print(" ");}
					System.out.println("");}}
			else {
				ln = 1+3*x;
				for(int j = 0; j<x;j++) {
					for(int k = 0; k<ln;k++) {
						if((k>=ln/2+1-2*j)&(k<=ln/2+1+2*j)) {
							System.out.print("*");}
						else{System.out.print(" ");}
						}
					System.out.println("");
					}
				}
		}while(true);
	}
}
