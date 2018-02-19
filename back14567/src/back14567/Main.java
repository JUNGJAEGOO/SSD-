package back14567;

import java.util.*;

public class Main {
	static ArrayList<Integer> adj[];
	static ArrayList<Integer> rev[];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		adj = new ArrayList[N+1];
		rev = new ArrayList[N+1];
		for (int i = 1 ; i<= N ; i++) {
			adj[i]= new ArrayList<>();
			rev[i]= new ArrayList<>();
		}
		for (int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			adj[from].add(to);
			rev[to].add(from);
		}
		
		int stage[] = new int[N+1];
		boolean visit[] = new boolean[N+1];
		int v = 0;
		int s = 1;
		
		while ( v < N ) {
			
			ArrayList<Integer> tmp = new ArrayList<>();
			for ( int i = 1 ; i <= N ; i++) {
				if ( rev[i].size() == 0 && visit[i] == false) {
					visit[i] = true;
					tmp.add(i);
					stage[i] = s;
					v++;
				}
			}
		
			
			for (int i = 0 ; i < tmp.size() ; i++) {
				
				
				for (int j = 1 ; j <= N ; j++) {
					
					if ( rev[j].contains(tmp.get(i))) {
						rev[j].remove((Integer)(tmp.get(i)));
					};
					
				}
				
			}
			
			
			s++;
			
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1 ; i<= N ; i++) {
			sb.append(stage[i]+" ");
		}
		System.out.print(sb);
	}
}
