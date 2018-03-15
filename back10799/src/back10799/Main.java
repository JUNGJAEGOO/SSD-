package back10799;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		char[] input = in.nextLine().toCharArray();
		
		
		int board = 0;
		int sum = 0;
		
		for ( int i = 0 ; i < input.length ; i++) {
			
			if ( input[i] == '(') {
				board++;
			}
			else {
				board--;
				if ( input[i-1] == '(') {
					sum += board;
				}else {
					sum++;
				}
				
			}
			
			
		}
		
		System.out.println(sum);
	}
}
