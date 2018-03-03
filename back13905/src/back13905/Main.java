package back13905;

import java.util.*;

public class Main {
	static int N,M,S,E;
	static ArrayList<node> adj[];
	static boolean visit[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		S = in.nextInt();
		E = in.nextInt();
		adj = new ArrayList[N+1];
		for (int i = 1 ; i<= N ; i++ ) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			adj[from].add(new node(to,cost));
			adj[to].add(new node(from,cost));
		}
		
		int left = 1;
		int right = 1000000;
		int ans = 0;
		while ( left <= right ) {
			
			visit = new boolean[N+1];
			
			int mid = (left+right)/2;
			
			boolean pass = BFS(mid);
			
			if ( pass == true) {
				left = mid + 1;
				ans = mid;
			}else {
				right = mid - 1;
			}
			
			
		}
		System.out.println(ans);
		
	}
	
	public static boolean BFS(int limit) {
		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		visit[S] = true;
		
		
		while (!q.isEmpty()) {
			int now = q.poll();
			if ( now == E) {
				return true;
			}
			
			for (int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i).idx;
				int nextcost = adj[now].get(i).cost;
				if ( nextcost >= limit && visit[next] == false) {
					q.add(next);
					visit[next] = true;
				}
			}
		}
		return false;
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
