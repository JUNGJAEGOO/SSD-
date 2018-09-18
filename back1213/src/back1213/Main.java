package back1213;

import java.io.*;
import java.util.*;

public class Main {
	static int abc[];
	static int OddIdx = -1;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		char c[] = str.toCharArray();
		
		abc = new int[26];
		for ( int i = 0 ; i < c.length ; i++) {
			abc[c[i]-'A']++;
		}
		
		if ( check() == false ) {
			System.out.print("I'm Sorry Hansoo");
		}else {
			
			String ans = "";
			
			for ( int i = 0 ; i < abc.length ; i++ ) {
				if ( abc[i] != 0 && abc[i] % 2 == 0 ) {
					//System.out.println(i+" "+(char)(i+'A'));
					for ( int j = 0 ; j < abc[i]/2 ; j++) {
						ans += (char)( i + 'A' );
					}
					
				}
			}

			char tmp[] = ans.toCharArray();
			
			if ( OddIdx != -1) {
				ans += (char)(OddIdx + 'A');
			}
			
			for ( int i = tmp.length-1 ; i >= 0 ; i--) {
				ans += tmp[i];
			}
			
			System.out.print(ans);
		}
	}
	
	public static boolean check() {
		
		int even = 0;
		int odd = 0;
		int oddidx = -1;
		
		for ( int i = 0 ; i < abc.length ; i++) {
			if ( abc[i] != 0 && abc[i]%2 == 0) {
				even++;
			}else if( abc[i] != 0 && abc[i]%2 == 1) {
				odd++;
				abc[i]--;
				oddidx = i;
			}
		}
		
		if ( odd > 1) {
			return false;
		}
		
		//System.out.print(even+" "+odd);
		OddIdx = oddidx;
		return true;
	}
}
