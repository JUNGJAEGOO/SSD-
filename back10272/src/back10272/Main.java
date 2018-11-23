package back10272;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static double dp[][];
	static int n;
	static ArrayList<node> arr;
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T  = Integer.parseInt(br.readLine());
		
		dp = new double[530][530];
		
		for ( int test = 0 ; test < T ; test++) {
			
			arr = new ArrayList<>();
			n = Integer.parseInt(br.readLine());
			for ( int i = 0 ; i < 530 ; i++) {
				for ( int j = 0 ;  j < 530 ; j++) {
					dp[i][j] = -1;
				}
			}
			
			for ( int i = 0 ; i < n ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				arr.add(new node(x,y));
				
				
			}
			
				
			System.out.println(func(0,0));
		}
		
		
	}
	
	public static double getDist(node p1, node p2) {
		return Math.sqrt( (p1.x-p2.x) * (p1.x-p2.x) + (p1.y-p2.y) * (p1.y-p2.y) ); 
	}
	
	public static double func(int x,int y) {
		
		if ( x == n - 1 || y == n - 1) {
			if ( y != n - 1) {
				return getDist(arr.get(y),arr.get(n-1) );
			}
			if ( x != n - 1) {
				return getDist(arr.get(x),arr.get(n-1));
			}
			return 0.0;
		}
		
		double ret = dp[x][y];
		if ( ret != -1) {
			return ret;
		}
		
		ret = (int)1e11;
		
		int next = Math.max(x, y) + 1;
		
		ret = Math.min(ret, func(x,next) + getDist(arr.get(y),arr.get(next)) );
		ret = Math.min(ret, func(next,y) + getDist(arr.get(next),arr.get(x)) );
		
		
		return dp[x][y] = ret;
		
	}
	
	public static class node{
		double x,y;
		node ( double x,double y){
			this.x = x ;
			this.y = y;
		}
	}
	
	
}
