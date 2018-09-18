package back14628;

import java.io.*;
import java.util.*;

public class Main {
	static int N,M,K;
	static int mana[];
	static int damage[];
	static int dp[][];
	static ArrayList<node> list;
	static final int inf = 1900000000;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		mana = new int[N];
		damage = new int[N];
		list = new ArrayList<>();
		
		for ( int i = 0 ; i < N ; i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			mana[i] = Integer.parseInt(st.nextToken());
			damage[i] = Integer.parseInt(st.nextToken());
			list.add(new node(mana[i],damage[i]));
		}
		Collections.sort(list);
		
		dp = new int[102][101];
		for( int i = 0 ; i < 102; i++) {
			for( int j = 0 ; j < 101; j++) {
				
				
				dp[i][j] = -1;
					
				
			}
			
			
		}
		
		//System.out.println(list.get(2).damage);
		
		System.out.print(func(M,0));
	}
	
	public static int func(int hp,int idx) {
		
		//System.out.println(hp+" "+idx);
		
		if ( hp == 0 ) {
			return 0;
		}
		
		int ret= dp[hp][idx];
		if (ret != -1) {
			return ret;
		}
		ret= inf;
		
		for (int i = 0 ; i <= 100 ; i++) {
			if ( idx < N && hp - i*list.get(idx).damage >= 0 ) {
				ret = Math.min(ret, K*((i*(i-1))/2) + i*list.get(idx).mana + func(hp - i*list.get(idx).damage , idx+1));	
			}

		}
		
		
		return dp[hp][idx] = ret;
	}
	
	static class node implements Comparable<node>{
		int mana,damage;
		node (int mana,int damage){
			this.mana = mana;
			this.damage = damage;
		}
		@Override
		public int compareTo(node o) {
			if ( this.damage > o.damage) {
				return -1;
			}
			return 1;
		}
	}
}
