package back13235;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] input = in.nextLine().toCharArray();
		
		
		int left = 0;
		int right = input.length-1;
		
		while ( left <= right) {
			
			if ( input[left] == input[right]) {
				left++;
				right--;
			}else {
				System.out.println(false);
				return;
			}
		}
		System.out.println(true);
	}
}
