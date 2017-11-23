package back5567;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		ArrayList<Integer> adj[] = new ArrayList[N+1];
		HashSet<Integer> s = new HashSet<>();
		for ( int i = 1 ; i <= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < M ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			adj[x].add(y);
			adj[y].add(x);
		}
		
		
		for ( int i = 0 ; i < adj[1].size() ; i++) {
			int friend = adj[1].get(i);
			
			if ( friend != 1) {
				s.add(friend);
			}
			//System.out.println(friend);
			for ( int j = 0; j < adj[friend].size() ; j++) {
				//System.out.println(adj[friend].get(j));
				if ( adj[friend].get(j)!= 1) {
				s.add(adj[friend].get(j));
				}
			}
			//System.out.println("-----");
		}
		
		System.out.println(s.size());
	}
}
