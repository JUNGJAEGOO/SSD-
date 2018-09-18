package back9372;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for ( int testcase = T ; testcase > 0 ; testcase--) {
			
			int N = in.nextInt();
			int M = in.nextInt();
			
			int[][] mat =  new int[N][N];
			boolean visit[][] = new boolean[N][N];
			boolean v[] = new boolean[N];
			
			for ( int j = 0 ; j < M ; j++) {
				
				
				int a = in.nextInt();
				int b = in.nextInt();
				
				mat[a-1][b-1] = 1;
				
				
			}
			
			
			Queue<Integer> q = new LinkedList<>();
			
			
			int cnt = 0;
			
			while ( !q.isEmpty() ) {
				
				
				
				int now = q.poll();
				if ( v[now-1] == false) {
					cnt++;
				}
				
				
				
			}
			
			
			System.out.println(cnt);
		}
	}
}
