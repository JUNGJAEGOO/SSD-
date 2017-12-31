package back14615;

import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Integer> adj[];
	static ArrayList<Integer> reverse[];
	static boolean visit[];
	static boolean check[];
	static boolean pass;
	static int N;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N+1];
		reverse = new ArrayList[N+1];
		visit = new boolean[N+1];
		check = new boolean[N+1];
		
		for ( int i = 1 ; i <= N ; i++) {
			adj[i] = new ArrayList<Integer>();
			reverse[i] = new ArrayList<Integer>();
		}
		for ( int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adj[start].add(end);
			reverse[end].add(start);
		}
		
		int T = Integer.parseInt(br.readLine());
		for ( int j = 1 ; j <= N ; j++){
			visit[j] = false;
			check[j] = false;
		}
		first(1);
		second(N);
		
		for ( int i = 0 ; i < T ; i++) {
			int C = Integer.parseInt(br.readLine());

			pass = false;
			if ( visit[C] == true && check[C] == true) {
				pass = true;
			}
			
			if ( pass ) {
				System.out.println("Defend the CTP");
			}else {
				System.out.println("Destroyed the CTP");
			}
		}
	}
	
	public static void first(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visit[start] = true;
		while ( !q.isEmpty() ) {
			int now  = q.poll();
			for ( int i = 0 ; i < adj[now].size() ; i++) {
				if ( visit[adj[now].get(i)] == false) {
					q.add(adj[now].get(i));
					visit[adj[now].get(i)] = true;
				}
			}
		}
	}
	
	public static void second(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		check[start] = true;
		while ( !q.isEmpty() ) {
			int now = q.poll();
			for ( int i = 0 ; i < reverse[now].size() ; i++) {
				if ( check[reverse[now].get(i)] == false) {
					q.add(reverse[now].get(i));
					check[reverse[now].get(i)] = true;
				}
			}
		}
	}

	
}
