package back3176;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static final int MAX = 20;
	static int parent[][];
	static int depth[];
	static int min[][];
	static int max[][];
	static ArrayList<node>[] adj;
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		adj  =new ArrayList[N+1];
		for ( int i = 0 ; i < N+1 ; i++) {
			adj[i] = new ArrayList<>();
		}
		for ( int i = 0 ; i < N-1 ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from =Integer.parseInt(st.nextToken());
			int to =Integer.parseInt(st.nextToken());
			int cost =Integer.parseInt(st.nextToken());
			adj[from].add(new node(to,cost));
			adj[to].add(new node(from,cost));
		}
		
		depth = new int[N+1];
		Arrays.fill(depth, -1);
		parent = new int[N+1][MAX+1];
		min = new int[N+1][MAX+1];
		max = new int[N+1][MAX+1];
		
		MakeTree(1,0,0);
		
		int Q = Integer.parseInt(br.readLine());
		for ( int i = 0 ; i < Q ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int cmin = Integer.MAX_VALUE;
			int cmax = Integer.MIN_VALUE;
			
			if ( depth[a] != depth[b]) {
				if ( depth[a] > depth[b]) {
					int tmp = a;
					a = b;
					b = tmp;
				}
			}
			
			for ( int j = MAX ; j >= 0 ;j--) {
				if ( depth[parent[b][j]] >= depth[a]) {
					cmin = Math.min(cmin, min[b][j]);
					cmax = Math.max(cmax, max[b][j]);
					b = parent[b][j];
				}
			}
			
			if ( a != b ) {
				
				for ( int j = MAX ; j >= 0 ; j --) {
					if ( parent[b][j] != parent[a][j] ) {
						cmin = Math.min(cmin,Math.min(min[a][j], min[b][j]) );
						cmax = Math.max(cmax,Math.max(max[a][j], max[b][j]) ); // cmax도 반드시 비교!!
						b = parent[b][j];
						a = parent[a][j];
						
					}
				}
	
			}
			
			if ( a != b) {
				
				cmax = Math.max(cmax, Math.max(max[a][0], max[b][0]));
				cmin = Math.min(cmin, Math.min(min[a][0], min[b][0]));
			}
			
			System.out.println(cmin+" "+cmax);
		}
		
	}
	
	public static void MakeTree(int now,int father,int c) {
		
		depth[now]  = depth[father] + 1;
		parent[now][0] = father;
		max[now][0] = c;
		min[now][0] = c;
		
		for ( int i = 1 ; i<= MAX ; i++) {
			parent[now][i] = parent[parent[now][i-1]][i-1];
			max[now][i] = Math.max(max[now][i-1], max[parent[now][i-1]][i-1]);
			min[now][i] = Math.min(min[now][i-1], min[parent[now][i-1]][i-1]);
		}
		
		for ( int i = 0 ; i < adj[now].size() ; i++ ) {
			int next = adj[now].get(i).idx;
			int nextcost = adj[now].get(i).cost;
			
			if ( depth[next] == -1) {
				MakeTree(next,now,nextcost);
			}
		}
		
	}
	
	public static class node{
		int idx;
		int cost;
		node( int idx,int cost){
			this.idx = idx;
			this.cost = cost;
		}
	}
}
