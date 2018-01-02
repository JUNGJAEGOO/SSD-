package back11408;

import java.util.*;

public class Main {
	static ArrayList<Integer> adj[];
	static int flow[][] = new int[802][802];
	static int capa[][] = new int[802][802];;
	static int cost[][] = new int[802][802];;
	static final int inf = 1900000000;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int start = 0;
		int end = N+M+1;
		adj = new ArrayList[end+1];
		for ( int i = 1 ; i <= end ; i++){
			adj[i] = new ArrayList<>();
		}
		for (int i = 1 ; i<= N ; i++) {
			adj[start].add(i);
			adj[i].add(start);
			capa[start][i] = 1;
			
			int works = in.nextInt();
			for ( int j = 1 ; j <= works ; j++) {
				int target = in.nextInt();
				int costing = in.nextInt();
				
				adj[i].add(target+N);
				adj[target+N].add(i);
				capa[i][target+N] = 1;
				
				cost[i][target+N] = costing;
				cost[target+N][i] = -costing;
				
			}
		}
		
		for(int i = N+1 ; i < end ; i++) {
			adj[i].add(end);
			adj[end].add(i);
			capa[i][end]= 1;
		}
		
		
	}
	
}
