package back15970;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Integer> point[] = new ArrayList[5001];
		for ( int i = 0 ; i < 5001 ; i++) {
			point[i] = new ArrayList<>();
		}
		
		int N = Integer.parseInt(br.readLine());
		for ( int i = 0 ; i < N ; i++) {
			StringTokenizer st  =new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			point[y].add(x);
		}
		
		for ( int i = 0 ; i < 5001 ; i++) {
			Collections.sort(point[i]);
		}
		
		int cnt = 0;
		
		for ( int j = 0 ; j < 5001 ; j++) {
			if ( point[j].size() > 2 ) {
				for ( int i = 1 ; i < point[j].size()-1 ; i++) {
					
					int min = Math.min(Math.abs(point[j].get(i)-point[j].get(i-1)),Math.abs(point[j].get(i+1) - point[j].get(i)) );
					cnt += min;
					
				}
			}
			
			if ( point[j].size() >= 2) {
				cnt += point[j].get(1) - point[j].get(0);
				cnt += point[j].get(point[j].size()-1) - point[j].get(point[j].size()-2);
			}
		}
		
		System.out.print(cnt);
	}
}
