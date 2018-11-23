package back16432;

import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer> adj[];
	static int dp[][];
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		adj  =new ArrayList[N+1];
		for ( int i = 0 ; i <= N ; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for ( int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			for ( int j = 0 ; j < n ; j++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		dp = new int[1001][10];
		for ( int i = 0 ; i < 1001 ; i++ ) {
			for ( int j = 0 ; j < 10 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		
		func(0,0);
		boolean pass = false;
		for ( int i = 1 ; i <= 9 ; i++) {
			if ( dp[N][i] != -1) {
				pass = true;
				break;
			}
		}
		
		if ( pass == false) {
			System.out.print(-1);
			return;
		}
		/*if ( x == 0 || x == -1 ) {
			System.out.print(-1);
			return;
		}*/
		
		/*for ( int i = 0 ; i <= N ; i++) {
			for ( int j = 0 ; j < 10 ; j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}*/
		
		for ( int i = 1 ; i < 10 ; i++) {
			if ( dp[N][i] != -1) {
				back(N,i,String.valueOf(i));
			}
		}
	}
	
	public static void back(int idx,int before,String res) {
		
		//System.out.println(idx+" "+before);
		
		if ( idx == 0) {
			res = res.substring(0,res.length()-1);
			String cut[] = res.split("");
			for ( int i = 0 ; i < res.length() ; i++) {
				System.out.println(cut[i]);
			}
			System.exit(0);
		}else {
			for ( int i = 0 ; i < 10 ; i++) {
				if ( dp[idx-1][i] != -1 && i != before) {
					back(idx-1,i,res+String.valueOf(i));
				}
			}
		}
		
	}
	
	public static int func(int idx,int before) {
		
		if ( idx == N+1) {
			return 1;
		}
		
		int ret = dp[idx][before];
		if ( ret  != -1) {
			return ret;
		}
		ret = 0;
		
		for ( int i = 0 ; i < adj[idx].size() ; i++) {
			int nx = adj[idx].get(i);
			if ( before != nx) {
				ret += func(idx+1,nx);
			}
		}
		
		
		return dp[idx][before] = ret;
	}
}
