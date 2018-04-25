package back2591;

import java.util.*;

public class Main {
	static char[] arr;
	static int dp[][][];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		arr = in.nextLine().toCharArray();
		dp = new int[41][41][2];
		
		for ( int i = 0 ; i <41 ; i++) {
			for ( int j = 0 ; j < 41 ; j++) {
				for ( int k = 0 ; k < 2 ; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		
		//System.out.println(arr.length);
		System.out.print(func(0,0,1));
		
	}
	
	public static int func (int len,int last,int flag) {
		
		//System.out.println(len+"  "+flag);
		
		if ( len == arr.length ) {
			return 1;
		}
		
		int ret = dp[len][last][flag];
		if ( ret  != -1) {
			return ret;
		}
		
		ret = 0;
		
		if ( flag == 0) {
			
			
			ret += func(len+1,len,1);
			
		}
		else {
			
			if ( arr[len] != '0') {
				ret += func(len+1,len,1);
			}
			
			if ( len < arr.length-1) {
				int num = Integer.parseInt(String.valueOf(arr[len]) + String.valueOf(arr[len+1]));
				//System.out.println(num);
				if ( arr[len] != '0') {
					if ( num <= 34) {
					ret += func(len+1,last,0);
					}
				}
			}
			
		}
	
		return dp[len][last][flag] = ret;
	}
}
