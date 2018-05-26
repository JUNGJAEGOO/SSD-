package back15770;

import java.util.*;

public class Main {
	static char[] t;
	static int dp[][];
	static int len = 0;
	static String target;
	static char[] tmp;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());
		
		t = in.nextLine().toCharArray();
		
		len = 0;
		
		for ( int i = 0 ; i < t.length ; i++) {
			if ( t[i] != '-') {
				len++;
			}
		}
		
		target = "";
		
		for ( int test = 0 ; test < t.length ; test++) {
			
			if ( t[test] == '-') {
				target = target.substring(0,target.length()-1);
				tmp = target.toCharArray();
				
				dp = new int[len+1][len+1];
				for ( int i = 0 ; i <= len ; i++) {
					for ( int j = 0 ; j <= len ; j ++) {
						dp[i][j] = -1;
					}
				}
				
				System.out.println(func(0,tmp.length-1));
				
			}else {
				target += t[test];
				tmp = target.toCharArray();
				
				dp = new int[len+1][len+1];
				for ( int i = 0 ; i <= len ; i++) {
					for ( int j = 0 ; j <= len ; j ++) {
						dp[i][j] = -1;
					}
				}
				
				//System.out.println(target);
				System.out.println(func(0,tmp.length-1));
				
			}
			
			
		}
	}
	
	public static int func(int l,int r) {
		//System.out.println(l+" "+r+" "+target);

		if ( l > r) {
			return 0;
		}
		
		if ( l == r) {
			//System.out.println("hi");
			return 1;
		}
		
		int ret = dp[l][r];
		if ( ret != -1) {
			return ret;
		}
		ret = 0;
		
		ret = func(l+1,r) + func(l,r-1) - func(l+1,r-1);
		
		if ( tmp[l] == tmp[r]) {
			ret += func(l+1,r-1) + 1;
		}
	
		return dp[l][r] = ret;
	}
}
