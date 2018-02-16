package back13418;

import java.util.*;

public class Main {
	static ArrayList<node> adj[];
	static boolean visit[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		adj = new ArrayList[N+1];
		for (int i = 0 ; i<= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < M+1 ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int cnt = in.nextInt();
			adj[from].add(new node(to,cnt));
			adj[to].add(new node(from,cnt));
		}
		visit = new boolean[1001];
		BFS();
		visit = new boolean[1001];
		BFS2();
		
	}
	
}
