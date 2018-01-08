package back9324;

import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//System.out.println('A'+0); A´Â 65 Z´Â 91
		for ( int i = 0 ; i < N ; i++) {
			int num[] = new int[26];
			char now[] = br.readLine().toCharArray();
			boolean passing = true;
			for ( int j = 0 ; j < now.length ; j++) {
				num[now[j]-'A']++;
				if ( num[now[j]-'A'] % 3 == 0 ) {
					j++;
					if ( j == now.length ) {
						passing = false;
						break;
					}else if ( now[j-1] != now[j]) {
						passing = false;
						break;
					}else {
						num[now[j]-'A'] = 0;
					}
				}
			}
			
			
			if ( passing ) { 
				System.out.println("OK");
			}else {
				System.out.println("FAKE");
			}
			
		}
	}
}
