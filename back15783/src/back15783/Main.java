package back15783;

import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> adj[],rev[],res[];
	static boolean visit[];
    static int p[];
    static Stack<Integer> stack = new Stack<>();
	
	public static void main(String args[]) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N+1];
		rev = new ArrayList[N+1];
		res = new ArrayList[N+1];
		p = new int[N];
		Arrays.fill(p,-1);
		for ( int i = 0 ; i <= N ; i++) {
			adj[i] = new ArrayList<>();
			rev[i] = new ArrayList<>();
			res[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < M ; i++) {
			st  = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken()) ;
			int to = Integer.parseInt(st.nextToken()) ;
			adj[from].add(to);
			rev[to].add(from);
			p[to] = from;
		}
		
		visit = new boolean[N+1];
		for ( int i = 0 ; i < N ; i++) {
			DFS(i);
		}
		
		Arrays.fill(visit, false);
		while ( !stack.isEmpty() ) {
			
			int next = stack.pop();
			revDFS(next,next);
			
		}
		int ans = 0;
		Arrays.fill(visit, false);
		for ( int i = 0 ; i < N ; i++) {
			
			if ( res[i].size() > 1) {
				System.out.println(res[i]);
				for ( int j = 0 ; j < res[i].size() ; j++) {
					visit[res[i].get(j)] = true;
				}
				ans++;
			}else {
				if ( p[i] == -1) {
					BFS(i);
					ans++;
				}
			}
			
		}
		
		System.out.print(ans);
	}
	
	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start] = true;;
		while ( !q.isEmpty() ) {
			
			int idx = q.poll();
			for ( int i = 0 ; i < adj[idx].size() ; i++) {
				int nx = adj[idx].get(i);
				if ( visit[nx] == false ) {
					visit[nx] = true;
					q.add(nx);
				}
			}
			
		}
	}
	
	public static void DFS(int start) {
		
		if ( visit[start] ) {
			return;
		}
		visit[start] = true;
		
		for ( int i = 0 ; i < adj[start].size() ; i++ ) {
			int next = adj[start].get(i);
			if ( visit[next] == false ) {
				DFS(next);
			}
		}
		
		stack.add(start);
	}
	
	public static void revDFS(int start,int root) {
		if ( visit[start] ) {
			return;
		}
		visit[start] = true;
		
		for ( int i = 0 ; i < rev[start].size() ; i++ ) {
			int next = rev[start].get(i);
			if ( visit[next] == false ) {
				revDFS(next,root);
			}
		}
		
		res[root].add(start);
	}
	
	
	
}
