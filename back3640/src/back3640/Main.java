package back3640;

import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> adj[];
	static int prev[];
	static int inf = 100000000;
	static int V,E;
	static int capa[][];
	static int flow[][];
	static int COST[][];
	static int dist[];
	static int Start,End;
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while ( true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			adj = new ArrayList[2*V+2];
			for (int i = 0 ; i<= 2*V+1 ; i++) {
				adj[i] = new ArrayList<>();
			}
			flow = new int[2*V+2][2*V+2];
			capa = new int[2*V+2][2*V+2];	
			COST = new int[2*V+2][2*V+2];
			for (int i = 0 ; i < E ; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				adj[from].add(to+V);
				adj[to+V].add(from);
				COST[from][to+V] = cost;
				COST[to+V][from] = -cost;
				capa[from][to+V] = 1;
			}
			
			Start = 0;
			End = V+1;
			
			for (int i = 1 ; i <= V ; i++) {
				adj[Start].add(i);
				adj[i].add(Start);
				//capa[Start][i] = 2;
			}
			
			for (int i = 1 ; i <= V ; i++) {
				adj[V+i].add(End);
				adj[End].add(V+i);
				//capa[V+i][End] = 2;
			}
			
			capa[Start][1] = 2;
			capa[V][End] = 2;
			
			BFS();
		}
		
	}

	
	public static void BFS() {
		Queue<Integer> q= new LinkedList<>();
		prev = new int[2*V+3];
		dist = new int[2*V+3];
		int res = 0;
		while ( true) {
			Arrays.fill(dist,inf);
			Arrays.fill(prev, -1);
			q.add(Start);
			dist[Start] = 0;
			boolean inQueue[] = new boolean[2*V+2];
			
			while ( !q.isEmpty()) {
				
				int tmp = q.poll();
				inQueue[tmp] = false;
				
				for (int i = 0 ; i < adj[tmp].size(); i++) {
					
					int next = adj[tmp].get(i);
					int cost = COST[tmp][next];
					
					if ( capa[tmp][next] > flow[tmp][next] && (dist[next] > dist[tmp] + cost) ){
						dist[next] = dist[tmp] + cost;
						prev[next] = tmp;
						
						if ( inQueue[next] == false ) {
							inQueue[next] = true;
							q.add(next);
							
						}
						
					}
					
				}
				
			}
			
			if ( prev[End] == -1) {
				break;
			}
			
			int min = inf;
			for (int i = End ; i != Start ; i = prev[i]) {
				min = Math.min(min, capa[prev[i]][i]-flow[prev[i]][i]);
			}
			
			for (int i = End ; i != Start ; i = prev[i]) {
				flow[i][prev[i]] -= min;
				flow[prev[i]][i] += min;
				res += COST[prev[i]][i];
			}
			System.out.println(res);
		}
		System.out.println(res);
		
	}
	

}
