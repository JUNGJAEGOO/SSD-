package back1727;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int dp[][];
	static int n,m;
	static int inf = 1000000000;
	static int men[];
	static int women[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		dp = new int[1001][1001];
		for (int i = 0 ; i < 1001 ; i++) {
			for (int j = 0 ; j < 1001 ; j++) {
				dp[i][j] = -1;
			}
		}
		men = new int[1001];
		women = new int[1001];
		for (int i = 0 ; i < n ; i++) {
			men[i] = in.nextInt();
		}
		for (int j = 0 ; j < m ; j++) {
			women[j] = in.nextInt();
		}
		Arrays.sort(men,0,n);
		Arrays.sort(women,0,m);
		
		if ( m > n) {
			swap();
			swap(men,women);
		}
		
	
		System.out.println(func(0,0));
		
	}
	
	public static void swap(int arr1[],int arr2[]) {
		int temp[] = new int[1001];
		for (int i = 0 ; i < temp.length ; i++) {
			temp[i] = arr1[i];
		}
		for (int i = 0 ; i < temp.length ; i++) {
			arr1[i] = arr2[i];
		}
		for (int i = 0 ; i < temp.length ; i++) {
			arr2[i] = temp[i];
		}
	}
	
	public static void swap() {
		int temp = n;
		n = m;
		m = temp;
	}
	
	public static int func(int man,int woman) {
		
		//System.out.println(man+" "+woman);
		
		if ( woman == m) {
			return 0;
		}
		if ( man == n) {
			return inf;
		}
		
		int ret = dp[man][woman];
		if ( ret != -1) {
			return ret;
		}
		ret = Math.min(func(man+1,woman), Math.abs(men[man]-women[woman])+func(man+1,woman+1) );
	
		//System.out.println(ret);
		
		return dp[man][woman] = ret;
	}
	

}
