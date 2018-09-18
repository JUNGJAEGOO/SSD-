package back11812;

import java.util.*;
import java.io.*;

public class Main {
	static int N,K,Q,MAX = 51;
	static int par[][];
	static int depth[];
	static ArrayList<Integer>[] adj;
 	
	public static void main(String args[]) throws Exception  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		for ( int i = 0 ; i < N+1 ; i++) {
			adj[i] = new ArrayList<>();
		}
		depth = new int[N+1];
		par = new int[N+1][MAX+1];
		Arrays.fill(depth, -1);
		for ( int i = 0 ; i < N - 1 ; i++) {
			
			int from = Integer.parseInt(st.nextToken()) ;
			int to = Integer.parseInt(st.nextToken()) ;
			adj[from].add(to);
			adj[to].add(from);
		}
		dfs(1,0);
		StringBuilder sb = new StringBuilder();
		
		
		for ( int i = 0 ; i < Q ; i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if ( depth[u] != depth[v] ) {
				if ( depth[u] > depth[v]) {
					int tmp = u;
					u = v;
					v = tmp;
				}
			}
		
			for ( int j = MAX ; j >= 0 ; j--) {
				if ( depth[par[v][j]] >= depth[u]) {
					v = par[v][j];
				}
			}
			
			if ( u != v) {
				for ( int j = MAX ; j>= 0 ; j--) {
					if ( par[u][j] != par[v][j]) {
						u = par[u][j];
						v = par[v][j];
					}
				}
			}
			
			//System.out.println(u+" "+v);
			
			if ( u != v) {
				u = par[u][0];
			}
			sb.append(u+"\n");
		}
		System.out.print(sb);
	}
	
	public static void dfs(int now,int father) {
		
		par[now][0] = father;
		depth[now] = depth[father] + 1;
		
		for ( int i = 1 ; i < MAX ; i++) {
			par[now][i] = par[par[now][i-1]][i-1];
		}
		
		for (int i = 0 ; i < adj[now].size() ; i++ ) {
			int next = adj[now].get(i);
			if ( depth[next] == -1) {
				dfs(next,now);
			}
		}
	}
}
