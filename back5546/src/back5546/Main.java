package back5546;

import java.util.*;

public class Main {
	static int N,K;
	static long dp[][][];
	static int arr[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		N = in.nextInt();
		K = in.nextInt();
		
		arr = new int[101];
		
		for ( int i = 0 ; i < K ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			arr[x] = y;
		}
		
		
		dp =new long[101][4][3];
		
		for ( int i = 0 ; i < 101 ; i++) {
			for ( int j = 0 ; j < 4 ; j++) {
				for (int k = 0 ; k < 3 ; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
	
		long ans = func(0,0,0);
		
		System.out.print(ans);
		
		
	}
	
	public static long func(int pos,int spa,int cons) {
		
		//System.out.println(pos+" "+spa+" "+cons);
		
		if ( pos == N) {
			return 1;
		}
		
		long ret = dp[pos][spa][cons];
		if( ret != -1 ) {
			return ret;
		}
		ret = 0;
		
		if ( arr[pos+1] != 0) {
			if ( spa != arr[pos+1] ) {
				ret += func(pos+1,arr[pos+1],0) % 10000;
			}else {
				if ( cons < 1) {
					ret += func(pos+1,arr[pos+1],cons+1) % 10000;
				}
			}
		}
		else {
			
			if ( spa == 0) {

				ret += func(pos+1,1,0) % 10000;
				ret += func(pos+1,2,0) % 10000;
				ret += func(pos+1,3,0) % 10000;
			}
			else if ( spa == 1) {
				
				if ( cons != 1) {
					ret += func(pos+1,1,cons+1) % 10000;
				}
				ret += func(pos+1,2,0) % 10000;
				ret += func(pos+1,3,0) % 10000;
				
			}else if (spa == 2) {
				
				if ( cons != 1) {
					ret += func(pos+1,2,cons+1) % 10000;
				}
				ret += func(pos+1,1,0) % 10000;
				ret += func(pos+1,3,0) % 10000;
				
			}else {
			
				if ( cons != 1) {
					ret += func(pos+1,3,cons+1) % 10000;
				}
				ret += func(pos+1,2,0) % 10000;
				ret += func(pos+1,1,0) % 10000;
				
			}
		}
	
		return dp[pos][spa][cons] = ret % 10000;
	}
}
