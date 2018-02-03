package back4659;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while ( true) {
			String input = in.nextLine();
			if ( input.equals("end")) {
				break;
			}
			
			boolean pass = false;
			if ( mouem(input) ) {
				if ( consec(input)) {
					if ( doublecheck(input)) {
						pass = true;
					}
				}
			}
			if ( pass) {
				System.out.println("<"+input+">"+" is acceptable.");
			}else {
				System.out.println("<"+input+">"+" is not acceptable.");
			}
		}
	}
	
	public static boolean mouem(String in) {
		
		for (int i = 0 ; i < in.length() ;i++) {
			if ( in.charAt(i) == 'a' || in.charAt(i) == 'e' || in.charAt(i) == 'i' 
					|| in.charAt(i) == 'o' || in.charAt(i) == 'u' ) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean consec(String in) {
		int mo = 0;
		int za = 0;
		
		for (int i = 0 ; i < in.length() ; i++) {
			if ( in.charAt(i) == 'a' || in.charAt(i) == 'e' || in.charAt(i) == 'i' 
					|| in.charAt(i) == 'o' || in.charAt(i) == 'u' ) {
				mo++;
				za= 0;
			}else {
				mo= 0;
				za++;
			}
			if ( mo == 3 || za == 3) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean doublecheck(String in) {
		char before = in.charAt(0);
		for (int i = 1 ; i < in.length() ; i++) {
			if ( in.charAt(i) == before) {
				if ( before == 'e' || before == 'o') {
					continue;
				}
				return false;
			}else {
				before = in.charAt(i);
			}
		}
		return true;
	}
}
