package back13911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<node>[] adj;
	static boolean isMC[];
	static boolean isSTAR[];
	static int dist[][];
	static boolean isHOME[];
	static int inf = 1900000000;
	static int V;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		adj = new ArrayList[V+3];
		isMC = new boolean[V+1];
		isSTAR = new boolean[V+1];
		dist = new int[2][V+3];
		isHOME = new boolean[V+1];
		for ( int i = 1 ; i <= V+2 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < E ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to  =Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// if ( adj[from].get(to) == null ) {
				adj[from].add(new node(to,cost));
				adj[to].add(new node(from,cost));
			/*}else {
				if ( cost < costing[from].get(to) ) {
					costing[from].set(to, cost);
				}
			}*/
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		for ( int i = 0 ; i < M ; i++) {
			int next = Integer.parseInt(st.nextToken());
			adj[V+1].add(new node(next,0));
			isMC[next] = true;
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int S = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		for ( int i = 0 ; i < S ; i++) {
			int next = Integer.parseInt(st.nextToken());
			adj[V+2].add(new node(next,0));
			isSTAR[next] = true;
		}
		
		for ( int i = 1 ; i <= V ; i++ ) {
			if ( isMC[i] == false ) {
				if (isSTAR[i] == false) {
					isHOME[i] = true;
				}
			}
		}
		
		BFS(V+1,0); // 맥도날드
		BFS(V+2,1); // 별다방
		
		long ans = inf;
		long a = inf;
		long b = inf;
		
		for ( int i = 1 ; i <= V ; i++) {
			if ( isSTAR[i] || isMC[i] ) {
				continue;
			}
			if ( dist[0][i] <= x && dist[1][i] <= y) {
				ans = Math.min(dist[0][i]+dist[1][i], ans);
			}
		}
		
		if ( ans >= inf) {
			System.out.println(-1);
		}else {
		System.out.println(ans);
		}
		
	}
	
	public static void BFS(int start,int store) {
		PriorityQueue<node> q= new PriorityQueue<>();
		q.add(new node(start,0));
		Arrays.fill(dist[store],inf);
		dist[store][start] = 0;
		while ( !q.isEmpty() ) {
			node tmp = q.poll();
			int now = tmp.idx;
			int Cost = tmp.cost;
			
			if ( dist[store][now] < Cost ) {
				continue;
			}
			//System.out.println("NOW is "+now);
			for ( int i = 0 ; i < adj[now].size() ; i++) {
				int next = adj[now].get(i).idx;
				int cost = adj[now].get(i).cost;
				//System.out.println(next+","+cost);
				if ( dist[store][next] > dist[store][now] + cost) {
					dist[store][next] = dist[store][now] + cost;
					q.add(new node(next,dist[store][next]));
				}
			}
		}
		
		/*for ( int i = 1 ; i <= V ; i++) {
			System.out.print(dist[store][i]+" ");
		}System.out.println();
*/
	}

	public static class node implements Comparable<node>{
		int idx;
		int cost;
		node(int idx,int cost){
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(node o) {
			if ( this.cost < o.cost ) {
				return -1;
			}
			return 1;
		}
	}
}
