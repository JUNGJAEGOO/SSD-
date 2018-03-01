package back10820;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int a = 0, A = 0, num = 0, blank = 0;
		
		while ( in.hasNext() ) {
			a = 0;
			A = 0;
			num = 0;
			blank = 0;
			char[] input = in.nextLine().toCharArray();
			for (int i = 0 ; i < input.length ; i++) {
				
				if ( input[i] >= 'a' && input[i] <= 'z' ) {
					a++;
				}else if ( input[i] >= 'A' && input[i] <= 'Z') {
					A++;
				}else if ( input[i] >= '0' && input[i] <= '9') {
					num++;
				}else if ( input[i] == ' ') {
					blank++;
				}
				
			}
			
			System.out.println(a+" "+A+" "+num+" "+blank);
			
			
		}
	}
}
