package back10988;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] input = in.nextLine().toCharArray();
		int left = 0;
		int right = input.length-1;
		int pass = 0;
		while ( true ) {
			
			if ( left == right) {
				pass = 1;
				break;
			}
			
			if ( left-1 == right) {
				pass = 1;
				break;
			}
			
			if ( input[left] == input[right]) {
				left++;
				right--;
			}else {
				break;
			}
		}
		System.out.println(pass);
		
	}
}
