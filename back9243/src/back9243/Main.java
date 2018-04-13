package back9243;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int N = Integer.parseInt(in.nextLine());
		
		char[] first = in.nextLine().toCharArray();
		char[] second = in.nextLine().toCharArray();
		
		for ( int i = 0 ; i < N ; i++) {
			
			for ( int j = 0 ; j < first.length ; j++) {
				
				first[j] = String.valueOf(1 - Integer.parseInt(String.valueOf(first[j])) ).charAt(0);
			}
			
		}
		
		String F = String.valueOf(first);
		String S = String.valueOf(second);
		System.out.println(F+"\n"+S);
		
		if ( F.equals(S) ) {
			System.out.println("Deletion succeeded");
		}else {
			System.out.println("Deletion failed");
		}
				
	}
}
