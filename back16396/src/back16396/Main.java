package back16396;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static HashMap<Integer,Integer> adj;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		adj = new HashMap<>();
		
		for ( int i = 0 ; i < N ; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for( int j = a ; j < b ; j++) {
				if ( adj.get(j) == null ) {
					adj.put(j, j+1);
				}
			}
			
		}
		
		
		int sum = 0;
		
		for ( int i = 1 ; i < 10000 ; i++) {
			
			if ( adj.get(i) != null ) {
				if ( adj.get(i) == i+1 ) {
					sum++;
				}
				
			}
			
		}
			
			
			
		
		System.out.println(sum);
	}
}
