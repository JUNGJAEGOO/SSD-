package back13907;
import java.util.*;
public class Main {
	static ArrayList<node> adj[];
	static int N,M,K;
	static int dist[][];
	static int inf = 100000000;
	static int start,end;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		K = in.nextInt();
		start = in.nextInt();
		end = in.nextInt();
		
		adj = new ArrayList[N+1];
		for (int i =1 ; i<= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0 ; i < M ; i++  ){
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			adj[from].add(new node(to,cost,0));
			adj[to].add(new node(from,cost,0));
		}
		
		dist = new int[N+1][N+1];
		for (int i = 0 ; i <= N ; i++) {
			for (int j = 0 ; j <= N ; j++) {
				dist[i][j] = inf;
			}
		}
		
		diikstra();
		
		for ( int i = 0 ; i < 4 ; i++) {
			for (int j = 0 ; j <= 2 ; j++) {
				System.out.print(dist[i][j]+" ");
			}System.out.println();
		}
		
	}
	
	static void diikstra() {
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(start,0,0));
		dist[start][0] = 0;
		while( !pq.isEmpty() ) {
			
			node tmp = pq.poll();
			int now = tmp.idx;
			int nowcost = tmp.cost;
			int nowcnt = tmp.cnt;
			
			for (int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i).idx;
				int nextcost = adj[now].get(i).cost;
				
				if ( nowcnt+1 <= N && dist[next][nowcnt+1] > dist[now][nowcnt] + nextcost) {
					dist[next][nowcnt+1] = dist[now][nowcnt]+nextcost;
					pq.add(new node(next,dist[next][nowcnt+1],nowcnt+1));
				}
			}
			
			
		}
	}
	
	static class node implements Comparable<node>{
		int idx;
		int cost;
		int cnt;
		node(int idx,int cost,int cnt){
			this.idx = idx;
			this.cost =cost;
			this.cnt = cnt;
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
