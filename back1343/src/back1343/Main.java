package back1343;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		char[] input = in.nextLine().toCharArray();
		
		for ( int i = 0 ; i < input.length ; i++) {
			
			if ( input[i] == 'X') {
				
				int len = 1;
				int next = i+1;
				while ( true ) {
					
					if ( next >= input.length ) {
						break;
					}
					if ( input[next] != 'X') {
						break;
					}
					len++;
					next++;
					
				}
				
				if ( len == 2) {
					
					for ( int j = i ; j < i + len ; j++) {
						input[j] = 'B';
					}
					
				}else if ( len % 4 == 0) {
					
					for ( int j = i ; j < i + len ; j++) {
						input[j] = 'A';
					}
					
				}else if ( len % 4 == 2) {
					
					for ( int j = i ; j < i + len - 2 ; j++) {
						input[j] = 'A';
					}
					
					for ( int j = i + len - 2 ; j < i + len ; j++) {
						input[j] = 'B';
					}
				}
				
				
			}else {
				
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < input.length ; i++) {
			if ( input[i] == 'X') {
				System.out.print(-1);
				return;
			}
			sb.append(input[i]);
		}
		
		System.out.print(sb);
	}
}
