package back11408;

import java.util.*;

public class Main {
	static int N,M;
	static ArrayList<Integer> adj[];
	static int capa[][];
	static int flow[][];
	static int cost[][];
	static int inf = 1000000000;
	static int prev[];
	static int dist[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		adj = new ArrayList[803];  // N+1 은 시작점, N+2 는 도착점
		for (int i = 1 ; i<= 802 ; i++) {
			adj[i] = new ArrayList<>();
		}
		dist = new int[803];
		prev = new int[803];
		capa = new int[803][803];
		flow = new int[803][803];
		cost = new int[803][803];
		
		for (int i = 1 ; i <= N ; i++) {
			
			adj[801].add(i);
			adj[i].add(801);
			capa[801][i] = 1;
			//System.out.println(i);
			int num = in.nextInt();
			
			for (int j = 0 ; j < num ; j++) {
				int from = i;
				int to = in.nextInt();
				int Cost = in.nextInt();
				//System.out.println(from+" "+to+" "+Cost);
				adj[from].add(400+to);
				adj[400+to].add(i);  // 양방향이 핵심!
				
				capa[from][400+to] = 1;
				
				cost[from][400+to] = Cost;
				cost[400+to][from] = -Cost;
				
			}
		}
		
		for (int i = 1 ; i <= 400 ; i++) {
			adj[400+i].add(802);
			adj[802].add(400+i);
			capa[400+i][802] = 1;
		}
		
		int r[] = BFS(801,802);
		System.out.println(r[0]);
		System.out.println(r[1]);
	}
	
	public static int[] BFS(int start,int end) {
		
		Queue<Integer> q = new LinkedList<>();
		int resflow = 0;
		int rescost = 0;
		
		while ( true) {
			q.add(start);
			
			boolean visit[] = new boolean[803];
			Arrays.fill(dist,inf);
			Arrays.fill(prev, -1);
			prev[start] = start;
			dist[start] = 0;
			
			while ( !q.isEmpty() ) {
				
				int idx = q.poll();
				visit[idx] = false;
				//System.out.println(idx+" "+adj[idx].size());
				
				for (int i = 0 ; i < adj[idx].size() ; i++) {
					int next = adj[idx].get(i);
				
					
					if ( capa[idx][next] > flow[idx][next] && (dist[next] > dist[idx] + cost[idx][next]) ) {
						//System.out.println(idx+" "+next);
						dist[next] = dist[idx] + cost[idx][next];
						prev[next] = idx;
						if( visit[next] == false) {
							visit[next] = true;
							q.add(next);
						}
						
					}
					
				}
				
			}
			
			//System.out.println("-------------");
				
			if ( prev[end] == -1) {
				break;
			}
				
			int min = inf;
			for (int i = end ; i != start ; i = prev[i]) {
				min = Math.min(min, capa[prev[i]][i]-flow[prev[i]][i]);
			}
				
			//System.out.println(dist[end]);
			for (int i = end ; i != start ; i = prev[i]) {
				flow[i][prev[i]] -= min;
				flow[prev[i]][i] += min;
				//System.out.println(prev[i]+" "+i+" "+cost[prev[i]][i]);
				rescost += cost[prev[i]][i];
			}
			
			resflow += min;
		}
		
		int r[] = new int[2];
		r[0] = resflow;
		r[1] = rescost;
		
		return r;
		
	}
	
	
}
