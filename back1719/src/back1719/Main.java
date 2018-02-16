package back1719;

import java.util.*;

public class Main {
	static ArrayList<node> adj[];
	static int dist[];
	static int prev[];
	static int inf = 100000000;
	static int n,m;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		adj = new ArrayList[n+1];
		for (int i = 1 ; i<= n ; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0 ; i < m ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			adj[from].add(new node(to,cost));
			adj[to].add(new node(from,cost));
		}
		
		int ans[][] = new int[n+1][n+1];
		
		for (int i = 1 ; i <= n ; i++) {
			diik(i);
			
			for (int j = 1 ; j <= n ; j++) {
				if ( j == i ) {
					continue;
				}
				ArrayList<Integer> tmp = new ArrayList<>();
				ArrayList<Integer> res = new ArrayList<>();
				
				res = back(i,j,tmp);
				ans[i][j] = res.get(res.size()-2);
			}
			
			ans[i][i] = inf;
		}
		
		for (int i = 1 ; i<= n ; i++) {
			for (int j = 1 ; j <= n ; j++) {
				if ( ans[i][j] == inf) {
					System.out.print("- ");
				}else {
					System.out.print(ans[i][j]+" ");
				}
			}System.out.println();
		}
		
	}
	
	public static ArrayList<Integer> back(int start,int end,ArrayList<Integer> list) {
		
		
		for (int i = end ; i != start ; i = prev[i]) {
			list.add(i);
		}
		list.add(start);
		//6 10
		System.out.println(list);
		return list;
	}
	
	public static void diik(int start) {
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(start,0));
		
		dist = new int[n+1];
		prev = new int[n+1];
		Arrays.fill(dist, inf);
		dist[start] = 0;
		prev[start] = start;
		
		while ( !pq.isEmpty() ) {

			int now = pq.peek().idx;
			int cost = pq.peek().cost;
			pq.poll();
			if ( dist[now] < cost) {
				continue;
			}
			
			for (int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i).idx;
				int nextcost = adj[now].get(i).cost;
				if ( dist[next] > dist[now] + nextcost) {
					dist[next] = dist[now] + nextcost;
					pq.add(new node(next,dist[now]+nextcost));
					prev[next] = now;
				}
			}
			
		}

	}
	
	public static class node implements Comparable<node>{
		int idx;
		int cost;
		node (int idx, int cost){
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(node o) {
			if ( this.cost > o.cost) {
				return 1;
			}
			return -1;
		}
	}
}
