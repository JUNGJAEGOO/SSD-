package back7790;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		int cnt = 0;
		String joker = "joke";
		while ( in.hasNext() ) {
			String str = in.nextLine();
			if ( str == null || str.equals("final")) {
				break;
			}
			
			
			int j = 0;
			for ( int i = 0 ; i < str.length() ; i++ ) {
				
				if ( str.charAt(i) == joker.charAt(j) ) {
					if ( j == joker.length()- 1) {
						cnt++;
						j = 0;
					}else {
						j++;
					}
				}else {
					
					j = 0;
				}
			}
		}
		
		System.out.print(cnt);
	}
}
