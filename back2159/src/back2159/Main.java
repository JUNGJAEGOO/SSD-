package back2159;
import java.util.*;

public class Main {
	static int N;
	
	static ArrayList<node> list = new ArrayList<>();
	static long dp[][];
	static long inf = Long.MAX_VALUE;
	
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		
		for ( int i = 0 ; i < N+1 ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			list.add(new node(x,y));
		}
		
		dp  = new long[5][100002];
		
		for ( int i = 0 ; i < 5 ; i++ ) {
			for ( int j = 0 ; j < 100002 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.println(func(0,0));
				
	}
	
	public static long func(int state,int idx) {
		
		if ( idx == N) {
			return 0;
		}
		
		long ret = dp[state][idx];
		if ( ret != -1) {
			return ret;
		}
		ret = inf;
		
		int nowx = list.get(idx).x;
		int nowy = list.get(idx).y;
		
		if ( state == 1) {
			nowy++;
		}else if ( state == 2) {
			nowy--;
		}else if ( state == 3) {
			nowx++;
		}else if ( state == 4) {
			nowx--;
		}
		
		int nx = list.get(idx+1).x;
		int ny = list.get(idx+1).y;
		
		int center = Math.abs(nx-nowx) + 
				Math.abs(ny-nowy);
		ret = Math.min(ret, center + func(0,idx+1));
		
			
		if ( list.get(idx+1).y > 0) {
			int left = Math.abs(nowx-nx) + 
					Math.abs(nowy-ny-1);
			ret = Math.min(ret, left + func(1,idx+1));
			
		}
		
		if ( list.get(idx+1).y < 100000) {
			int right = Math.abs(nowx - nx) + 
				Math.abs(nowy - ny + 1);
			ret = Math.min(ret, right + func(2,idx+1));
		}
		
		if ( list.get(idx+1).x > 0) {
			int upper = Math.abs(nowx - nx - 1) + 
					Math.abs(nowy - ny );
			ret = Math.min(ret, upper + func(3,idx+1));
		}
		
		
		if ( list.get(idx+1).x < 100000) {
			int downer = Math.abs(nowx - nx + 1) + 
					Math.abs(nowy - ny);
			ret = Math.min(ret, downer + func(4,idx+1));
		}
		
		
		return dp[state][idx] = ret;
		
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
