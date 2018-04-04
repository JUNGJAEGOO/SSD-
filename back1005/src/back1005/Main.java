package back1005;

import java.util.*;

public class Main {
	static int inner[];
	static ArrayList<node> adj[];
	static int cost[];
	static int N,K;
	static int Target;
	static int result[];
	static int inf = 1900000000;
	static boolean visit[];
	static int fortheWin;
	static int dist[];
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		while ( T > 0 ) {
			
			N = in.nextInt();
			K = in.nextInt();
			cost = new int[N+1];
			for ( int i = 1 ;i <= N ; i++) {
				cost[i] = in.nextInt();
			}
			
			adj = new ArrayList[N+1];
			inner = new int[N+1];
			for ( int i = 0 ; i <= N ; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for ( int i = 0 ; i < K ; i++) {
				int from = in.nextInt();
				int to = in.nextInt();
				adj[from].add(new node(to,cost[to-1]));
				inner[to]++;
			}
			fortheWin = in.nextInt();
			
			visit = new boolean[N+1];
			dist = new int[N+1];
			BFS();
			
			System.out.println(dist[fortheWin]);
			T--;
		}
	
	}
	
	public static void BFS() {
		Queue<node> q = new LinkedList<>();
		
		for ( int i = 1 ; i <= N ; i++ ) {
			if ( inner[i] == 0 ) {
				q.add(new node(i,cost[i]));
				dist[i] = cost[i];
				visit[i] = true;
			}
		}
		
		while ( !q.isEmpty() ) {
			node now = q.poll();
			int idx = now.idx;
			int c = now.cost;
			
			for ( int i = 0 ; i < adj[idx].size() ; i++) {
				int next = adj[idx].get(i).idx;
				inner[next]--;
				if ( dist[next] < dist[idx] + cost[next]) {  // 역 다익스트라
					dist[next] = dist[idx] + cost[next];
				}
			}
			
			for ( int i = 1 ; i <= N ; i++) {
				if ( inner[i] == 0 && visit[i] == false) {
					q.add(new node(i,cost[i]+c));
					visit[i] = true;
				}
			}
			
			
		}
	}
	
	public static class node{
		int idx;
		int cost;
		node (int idx,int cost){
			this.idx = idx;
			this.cost = cost;
		}
	}
}
