package back2864;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		int B = in.nextInt();
		String smallA[] = String.valueOf(A).split("");
		String smallB[] = String.valueOf(B).split("");
		String bigA[] = String.valueOf(A).split("");
		String bigB[] = String.valueOf(B).split("");
		
		for ( int i = 0 ; i < smallA.length ; i++) {
			if ( smallA[i].equals("6") ) {
				smallA[i] = "5";
			}
		}
		
		for ( int i = 0 ; i < smallB.length ; i++) {
			if ( smallB[i].equals("6") ) {
				smallB[i] = "5";
			}
		}
		
		for ( int i = 0 ; i < bigA.length ; i++) {
			if ( bigA[i].equals("5") ) {
				bigA[i] = "6";
			}
		}
		
		for ( int i = 0 ; i < bigB.length ; i++) {
			if ( bigB[i].equals("5") ) {
				bigB[i] = "6";
			}
		}
		
		String sA = "";
		String sB = "";
		String bA = "";
		String bB = "";
		for ( int i = 0 ; i < smallA.length ; i++) {
			sA += smallA[i];
		}
		for ( int i = 0 ; i < smallB.length ; i++) {
			sB += smallB[i];
		}
		for ( int i = 0 ; i < bigA.length ; i++) {
			bA += bigA[i];
		}
		for ( int i = 0 ; i < bigB.length ; i++) {
			bB += bigB[i];
		}
		
		int small = Integer.parseInt(String.valueOf(sA)) +  Integer.parseInt(String.valueOf(sB));
		int big = Integer.parseInt(String.valueOf(bA)) +  Integer.parseInt(String.valueOf(bB));
		System.out.print(small+" "+big);
	}
}
