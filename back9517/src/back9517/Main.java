package back9517;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int boom = 210;
		int ans = -1;
		for ( int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int time = Integer.parseInt(st.nextToken());
			char word = st.nextToken().charAt(0);
			if ( word == 'T') {
				while ( time > 0) {
					time--;
					boom--;
					if ( boom == 0) {
						ans = K;
					}
				}
				K = ( K + 1 );
				if ( K == 9) {
					K = 1;
				}
			}else {
				while ( time > 0) {
					time--;
					boom--;
				if ( boom == 0) {
					ans = K;
				}
				}
				
			}
		}
		
		System.out.println(ans);
	}
}
