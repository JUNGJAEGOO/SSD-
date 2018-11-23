package back16508;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int price[];
	static int word[][];
	static String T;
	static int N;
	static int min = Integer.MAX_VALUE;
	static boolean visit[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine();
		N = Integer.parseInt(br.readLine());
		price = new int[N];
		word = new int[N][26];
		for ( int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			price[i] = Integer.parseInt(st.nextToken());
			char[] tmp = st.nextToken().toCharArray();
			for ( int j = 0 ; j < tmp.length ; j++ ) {
				word[i][tmp[j]-'A']++;
			}
		}
		
		visit = new boolean[N+1];
		func(0,0);
		
		if ( min == Integer.MAX_VALUE) {
			System.out.print(-1);
			return;
		}
		System.out.print(min);
		
	}
	
	public static void func(int idx,int sum) {
		
		if ( sum > min) {
			return;
		}
		
		if ( idx == T.length() ) {
			
			min = Math.min(min, sum);
			
			return;
		}else {
			
			for ( int i = 0 ; i < N ; i++) {
				
				if ( word[i][T.charAt(idx)-'A'] > 0 ) {
					word[i][T.charAt(idx)-'A']--;
					if ( visit[i] ) {
						func(idx+1,sum);
					}else {
						visit[i] = true;
						func(idx+1,sum+price[i]);
						visit[i] = false;
					}
					word[i][T.charAt(idx)-'A']++;
				}
				
			}
			
		}
		
	}
}
