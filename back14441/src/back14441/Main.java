package back14441;

import java.util.*;
import java.io.*;

public class Main {
	static int N,K,M;
	static ArrayList<Integer>[] adj;
	//static boolean visit[];
	static int ans;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		adj = new ArrayList[N+1];
		for ( int i = 0 ; i < N+1 ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < N; i++) {
			char[] tmp = br.readLine().toCharArray();
			
			for ( int j = 0 ; j < N ; j++) {
				if ( tmp[j] == 'Y') {
					adj[i].add(j);
					adj[j].add(i);
				}
			}
			
		}
		
		//visit = new boolean[N+1];
		//cnt = new int[N+1];
		
		for ( int i = 0 ; i < N ; i++) {
	
			dfs(i,i,0);
			
		}
		
		System.out.println(ans);
	}
	
	public static void dfs(int now,int start,int len) {
		
		//visit[now] = true;
		System.out.println(now+" "+start);
	
		for (int i = 0 ; i < adj[now].size() ; i++) {
			int next = adj[now].get(i);
			
			if ( len+1 <= K) {
				
				if ( next == start) {
					dfs(next,start,len+1);
					ans += ( len+1 % M );
				}else {
					dfs(next,start,len+1);
				}

			}
			
			
		}
		
	}
}
