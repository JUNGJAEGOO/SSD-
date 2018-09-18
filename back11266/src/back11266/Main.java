package back11266;

import java.util.*;

public class Main {
	
	static int V,E;
	static int num[];
	static int low[];
	static boolean isCut[];
	static ArrayList<Integer>[] adj;
	static int root = -1;
	static int cnt = 0;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		V = in.nextInt();
		E = in.nextInt();
		
		adj = new ArrayList[V+1];
		for ( int i = 0 ; i < V ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		num = new int[V+1];
		low = new int[V+1];
		isCut = new boolean[V+1];
		Arrays.fill(num, -1);
		
		for ( int i = 0 ; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < E ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			adj[from].add(to);
			adj[to].add(from);
		}
		
		for (int i = 1 ; i <= V ; i++) {
			if ( num[i] == -1) {
				root = i;
				dfs(i,true);
			}
		}
		
		int ans = 0;
		StringBuilder sb = new StringBuilder();
		for ( int i = 1 ; i<= V ; i++) {
			if ( isCut[i] ) {
				ans++;
				sb.append(i+" ");
			}
		}
		
		System.out.print(ans+"\n"+sb);
		
	}
	
	public static int dfs(int now,boolean isRoot) {
		
		num[now] = ++cnt;
		int ret = num[now];
		int childs = 0;
		
		for ( int i = 0 ; i < adj[now].size() ; i++) {
			
			int next = adj[now].get(i);
			
			if ( num[next] == -1) {

				childs++;

				int low = dfs(next,false);
				
				if ( !isRoot && low >= num[now]) {
					isCut[now] = true;
				}
				ret = Math.min(ret, low);
			}else {
				ret = Math.min(ret, num[next]);
				
			}
			
		}
		
		
		if ( root == now) {
			if ( childs >= 2) {
				isCut[now] = true;
			}
		}
		
		return ret;
	}
}
