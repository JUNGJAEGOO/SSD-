package back13424;

import java.util.*;

public class Main {
	static int dist[][];
	static ArrayList<node> adj[];
	static int N,M;
	static int inf = 100000000;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		
		for ( int test  = 0 ; test < T ; test++) {
			
			N = in.nextInt();
			M = in.nextInt();
			
			adj = new ArrayList[N+1];
			for ( int i = 0 ; i <= N ; i++) {
				adj[i] = new ArrayList<>();
			}
			
			dist = new int[N+1][N+1];
			
			for ( int i = 0 ; i <= N ; i++) {
				for ( int j = 0 ; j <= N ; j++) {
					dist[i][j] = inf;
				}
			}
			
			for ( int i = 0 ; i < M ; i++) {
				int from = in.nextInt();
				int to = in.nextInt();
				int cost = in.nextInt();
				adj[from].add(new node(to,cost));
				adj[to].add(new node(from,cost));
				
			}
			
			ArrayList<Integer> list = new ArrayList<>();
			int go = in.nextInt();
			for ( int i = 0 ; i < go ; i++) {
				int start = in.nextInt();
				list.add(start);
				diik(start);
			}
			//System.out.println(list);
			long ans[] = new long[N+1];
			for ( int i = 0 ; i < list.size() ; i++) {
				int now = list.get(i);
				
				for ( int j = 0 ; j <= N ; j++) {
					//System.out.println(dist[now][j]);
					ans[j] += dist[now][j];
				}
			}
			
			/*for ( int i = 1 ; i <= N ; i++) {
				System.out.print(ans[i]+" ");
			}System.out.println();
*/
			int minidx = 1;
			for ( int i = 1 ; i <= N ; i++) {
				if ( ans[i] < ans[minidx] ) {
					minidx = i;
				}else if ( ans[i] == ans[minidx]) {
					if ( i < minidx) {
						minidx = list.get(i);
					}
				}
			}
			System.out.println(minidx);
		}
		
	}
	
	static public void diik(int start) {
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(start,0));
		dist[start][start] = 0;
	
		while ( !pq.isEmpty() ) {
			
			node tmp = pq.poll();
			int now = tmp.idx;
			int nowcost = tmp.cost;
			//System.out.println(now+" "+dist[start][now]);
			//System.out.println(now);
			
			if ( dist[start][now] < nowcost ) {
				continue;
			}
			
			for ( int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i).idx;
				int nextcost = adj[now].get(i).cost;
				if ( dist[start][next] > nowcost + nextcost) {
					dist[start][next] = nowcost + nextcost;
					pq.add(new node(next,nowcost+nextcost));
				}
			}

		}
	}
	
	public static class node implements Comparable<node>{

		int idx;
		int cost;
		
		node ( int idx,int cost){
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
