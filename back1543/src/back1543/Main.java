package back1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char input[] = br.readLine().toCharArray();
		char pattern[] = br.readLine().toCharArray();
		
		int ans = 0;
		int j = 0 ; 
		for ( int i = 0 ; i < input.length ; i++) {
			if ( input[i] == pattern[j]) {
				if ( j == pattern.length - 1) {
					System.out.println(i-j+" "+i);
					ans ++;
					i = i - j + pattern.length -1;
					System.out.println("½ÃÀÛ"+i);
					j=0;
				}else {
					j++;
				}
			}else {
				j = 0;
			}
		}
		
		System.out.println(ans);
	}
}
