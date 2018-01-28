package back2618;

import java.util.*;

public class Main {
	static int dp[][];
	static ArrayList<node> list;
	static int N,W;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		W = in.nextInt();
		dp = new int[W+1][W+1];
		//for (int i = 0 ; i < N+1 ; i++) {
			//for (int j = 0 ; j < N+1 ; j++) {
				for ( int k = 0 ; k <= W ; k++) {
					for ( int s = 0 ; s <= W ; s++) {
						dp[k][s] = -1;
				}
				}
				
			//}
		//}
		
		list = new ArrayList<>();
		for (int i = 0 ; i < W ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			list.add(new node(x,y));
		}
		
		
		System.out.println(func(0,0,0,1,1,N,N,0));
		for ( int i = 0 ; i <= 3 ; i++) {
			for (int j = 0 ; j <= 3 ; j++) {
				System.out.print(dp[i][j]+" ");
			}System.out.println();
		}
	}
	
	
	public static int func(int len,int one,int two,int car1X,int car1Y,int car2X,int car2Y,int sum) {
		
		System.out.println(sum+": "+one+" "+two);
		
		if ( one == W || two == W) {
			
			return sum;
		}
		
		int ret = dp[one][two];
		if ( ret != -1) {
			return ret;
		}
		ret = 100000000;
		
		int next = Math.max(one, two) + 1;
		int nextX = list.get(len).x;
		int nextY = list.get(len).y;
				//System.out.println(Math.abs((car1X-x))+Math.abs((car1Y-y)));
		ret = Math.min(ret, func(len+1,next,two,nextX,nextY,car2X,car2Y,sum+Math.abs((car1X-nextX))+Math.abs((car1Y-nextY))));
		ret = Math.min(ret, func(len+1,one,next,car1X,car1Y,nextX,nextY,sum+Math.abs((car2X-nextX))+Math.abs((car2Y-nextY))));

		//System.out.println(ret);
		
		return dp[one][two] = ret;
		
	}
	
	
	public static class node{
		int x,y;
		node(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
