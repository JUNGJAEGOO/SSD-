package back1766;

import java.util.*;

public class Main {
	static ArrayList<Integer> adj[];

	static int revsize[];
	static boolean visit[];
	static int N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		int M = in.nextInt();
		adj = new ArrayList[N+1];
		revsize = new int[N+1];
		for (int i =1 ; i<= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			adj[from].add(to);
			revsize[to]++;
		}
		
		visit = new boolean[N+1];
		BFS();
	}
	
	public static void BFS() {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 1 ; i<= N ; i++) {
			if ( revsize[i] == 0) {
				pq.add(i);
			}
		}
		
		while ( !pq.isEmpty() ) {
			
			int now = pq.poll();
			if ( visit[now] == true) {
				continue;
			}
			visit[now] = true;
			System.out.print(now+" ");
			
			for (int i = 0 ; i < adj[now].size() ; i++ ) {
				int next = adj[now].get(i);
				revsize[next]--;
				if ( revsize[next] == 0) {
					pq.add(next);
				}
			}
			
			
			
		}
	}
}
