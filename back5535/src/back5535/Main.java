package back5535;

import java.util.*;

public class Main {
	static ArrayList<node> list = new ArrayList<>();
	static int arr[];
	static int dp[][];
	static int D,N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		D = in.nextInt();
		N = in.nextInt();
		
		arr = new int[D];
		
		for (int i = 0 ; i < D ; i++) {
			arr[i] = in.nextInt();
		}
		
		for ( int i = 0 ; i < N ; i++) {
			int A = in.nextInt();
			int B = in.nextInt();
			int C = in.nextInt();
			list.add(new node(A,B,C));
		}
		
		dp = new int[201][101];
		for ( int i = 0 ; i < 201 ; i++) {
			for ( int j = 0 ; j < 101 ; j++) {
				dp[i][j] = -1;
			}
		}
		
		int ans = 0;
		for  (int i = 0 ; i < N ; i++) {
			if ( arr[0] >= list.get(i).min && arr[0] <= list.get(i).max) {
				ans = Math.max(ans,func(1,list.get(i).cost));
			}
		}
		
		System.out.println(ans);
	}
	
	public static int func(int idx,int before) {
		
		if ( idx == D) {
			return 0;
		}
		
		int ret = dp[idx][before];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		for ( int i = 0 ; i < N ; i++) {
			if ( arr[idx] <= list.get(i).max && arr[idx] >= list.get(i).min) {
				ret = Math.max(ret, Math.abs(before-list.get(i).cost) + func(idx+1,list.get(i).cost));
			}
		}
		
		
		return dp[idx][before] = ret;
	}
	
	public static class node{
		int min;
		int max;
		int cost;
		node ( int min,int max,int cost){
			this.min = min;
			this.max = max;
			this.cost = cost;
		}
	}
}
