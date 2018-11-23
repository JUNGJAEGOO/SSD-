package back16437;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer> adj[];
	static long sum[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		for ( int i = 0 ; i <N+1 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		sum = new long[N+1];
		boolean isEdge[] = new boolean[N+1];
		Arrays.fill(isEdge, true);
		isEdge[1] = false;
		
		for ( int i = 2 ; i <= N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char SorW = st.nextToken().charAt(0);
			int num = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			isEdge[to] = false;
			if ( SorW == 'S') {
				sum[i] = num;
			}else {
				sum[i] = -num;
			}
			adj[i].add(to);
		}
		
		for ( int i = 2 ; i <= N ; i++) {
			if( isEdge[i] ) {
				DFS(i);
			}
		}
		
		System.out.print(sum[1]);
	}
	
	public static void DFS(int idx) {
		System.out.println(idx);
		
		if ( idx == 1) {
			return;
		}
		
		long nextSum = 0;
		if ( sum[idx] < 0 ) {
			
		}else {
			nextSum = sum[idx] + sum[adj[idx].get(0)];
		}
		
		sum[idx] = 0;
		if ( nextSum > 0) {
			sum[adj[idx].get(0)] = nextSum;
		}
		
		DFS(adj[idx].get(0));
		
	}
	
	
}
