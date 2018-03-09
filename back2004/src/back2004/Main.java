package back2004;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		long N = in.nextLong();
		long M = in.nextLong();
		long Ncut = N-M;
		long Na5 = 0 ,Na2 = 0;
		long Nb5 = 0 ,Nb2 = 0;
		long M5 = 0 ,M2 = 0;
		
		long copy = N;
		while ( copy > 0) {
			
			Na5 += copy/5;
			copy /= 5;
			
		}
		copy = N;
		while ( copy > 0) {

			Na2 += copy/2;
			copy /= 2;
			
		}
		
		copy = Ncut;
		while ( copy > 0 ) {
			Nb5 += copy/5;
			copy /= 5;
			
		}
		copy = Ncut;
		while ( copy > 0) {
			
			Nb2 += copy/2;
			copy /= 2;
			
		}
		
		copy = M;
		while ( copy > 0) {
			
			M5 += copy/5;
			copy /= 5;
			
		}
		copy = M;
		while ( copy > 0) {
			
			M2 += copy/2;
			copy /= 2;
			
		}
		
		System.out.println(Na5+" "+Na2+" "+Nb5+" "+Nb2);
		System.out.println(M5+" "+M2);
		
		
		long upmin = Math.min(Na5-Nb5-M5, Na2-Nb2-M2);
		System.out.print(upmin);
		
	}
}
