package back16399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<node> dist[];
	static int Oil[];
	static int C,E,D,N;
	static final int inf = Integer.MAX_VALUE;
	static int dp[][][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		C = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		dist = new ArrayList[1003];
		for ( int i = 0 ; i < 1003 ; i++) {
			dist[i] = new ArrayList();
		}
		
		int sum = 0;
		for ( int i = 1 ; i <= N ; i++) {
			dist[i].add(new node(i+1,Integer.parseInt(st.nextToken())));
			sum += dist[i].get(0).cost;
		}
		dist[N+1].add(new node(N+2,D-sum));
		
		st = new StringTokenizer(br.readLine()," ");
		Oil = new int[N+1];
		for ( int i = 1 ; i <= N ; i++) {
			Oil[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[2][1003][501];
		for ( int i = 0 ; i < 1003 ; i++) {
			for ( int j = 0 ; j < 501 ; j++) {
				dp[0][i][j] = -1;
				dp[1][i][j] = -1;
			}
		}
		
		System.out.println(func(0,1,C));
	}
	
	public static int func(int state,int idx,int oil) {
		
		if ( idx == N+2) {
			return 0;
		}
		
		int ret = dp[state][idx][oil];
		if ( ret != -1) {
			return ret;
		}
		ret = inf;
		
		
		System.out.println(idx+" "+oil);
			
		if ( idx >= 2 && idx <= N) {
			if ( C >= E*dist[idx].get(0).cost) {
				ret = Math.min(ret, (C-oil)*Oil[idx] + func(1,idx+1,C));
				if ( oil - dist[idx].get(0).cost*E >= 0) {
					ret = Math.min(ret, func(0,idx+1,oil-dist[idx].get(0).cost*E));
				}else {
					
					ret = Math.min(ret, Oil[idx]*(dist[idx].get(0).cost*E-oil) + func(1,idx+1,0) );
					
				}
			}
			
		}else if ( idx == 1) {
			
			if ( C >= E*dist[idx].get(0).cost) {
				ret = Math.min(ret, func(0,idx+1,C-E*dist[idx].get(0).cost) );
			}
		}else if ( idx == N+1) {
			if ( C >= E*dist[idx].get(0).cost) {
				ret = Math.min(ret, func(0,idx+1,C-E*dist[idx].get(0).cost) );
			}
		}
			
		
		
		
		return dp[state][idx][oil] = ret;
		
	}
	
	public static class node{
		int idx;
		int cost;
		node ( int idx,int cost){
			this.idx = idx;
			this.cost = cost;
		}
	}
}
