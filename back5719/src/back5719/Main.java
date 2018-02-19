package back5719;

import java.util.*;

public class Main {
	static int N,M;
	static int S,E;
	static ArrayList<node> adj[];
	static int dist[];
	static int inf = 1000000000;
	static ArrayList<ArrayList<Integer>> second;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while ( true) {
		N = in.nextInt();
		M = in.nextInt();
		if ( N == 0 && M == 0) {
			return;
		}
		dist = new int[N];
		Arrays.fill(dist, inf);
		adj = new ArrayList[N];
		S = in.nextInt();
		E = in.nextInt();
		for (int i = 0 ; i < N ; i++) {
			adj[i] = new ArrayList<node>();
		}
		for (int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			int cost = in.nextInt();
			adj[from].add(new node(to,cost));
		}
		
		diikstra();
		
		/*for(int i = 0 ; i < N ; i++) {
			System.out.println(dist[i]);
		}
		*/
		ArrayList<Integer> visit = new ArrayList<>();
		second = new ArrayList<>();
		//System.out.println("처음 최단거리 "+dist[E]);
		int best = dist[E];
		
		DFS(S,0,best,visit);
		
	/*	for (int i = 0 ; i < second.size() ; i++) {
			System.out.println(second.get(i));
		}
		*/
		delete();
		
		Arrays.fill(dist, inf);
		
		diikstra();
		
		if ( dist[E] == inf ) {
			System.out.println(-1);
		}else {
			System.out.println(dist[E]);
		}
		
		}
	}
	
	public static void delete() {
		
		for ( int i = 0 ; i < second.size() ; i++) {
			
			ArrayList<Integer> now = second.get(i);
			//System.out.println(now);
			int s = S;
			
			for (int k = 0 ; k < now.size() ; k++) {
				int n = now.get(k);
				//System.out.println(s+" "+n);
				for (int j = 0 ; j < adj[s].size() ; j++) {

					if ( adj[s].get(j).to == n) {
						adj[s].get(j).cost = inf;
						//System.out.println(s+" 에서 "+adj[s].get(j).to+" 무한대로");
						s = adj[s].get(j).to;
						
						break;
					}
				}
			}
			
		}
	}
	
	public static void DFS(int start,int dist,int best,ArrayList<Integer> visit) {
		
		//System.out.println(start+" "+dist+" "+visit);
		if ( dist>best) {
			return;
		}
		if ( start == E && dist == best) {
			
			//System.out.println(visit);
			second.add((ArrayList<Integer>) visit.clone());
			return;
		}
		
		for ( int i = 0 ; i < adj[start].size() ; i++) {
			int next = adj[start].get(i).to;
			int cost = adj[start].get(i).cost;
			//System.out.println(next+" "+cost+"!!!!");
			
			if( !visit.contains((Integer)next)) {
				visit.add(next);
				DFS(next,dist+cost,best,visit);
				visit.remove(visit.size()-1);
			}
			
		}

	}
	
	public static void diikstra() {
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(S,0));
		dist[S] = 0;
		while ( !pq.isEmpty() ) {
			node now = pq.poll();
			int idx = now.to;
			int cost = now.cost;
			if ( dist[idx] < cost) {
				continue;
			}
			
			for ( int i = 0 ; i < adj[idx].size(); i++) {
				int nextidx = adj[idx].get(i).to;
				int nextcost = adj[idx].get(i).cost;
				if ( dist[nextidx] > dist[idx] + nextcost) {
					dist[nextidx] = dist[idx]+nextcost;
					pq.add(new node(nextidx,nextcost));
				}
				
			}
		}
	}
	
	public static class node implements Comparable<node>{
		int to;
		int cost;
		node(int to,int cost){
			this.to = to;
			this.cost = cost;
		}
	
		public int compareTo(node o) {
			if ( this.cost < o.cost) {
				return -1;
			}else {
				return 1;
			}
		}

	}
}
