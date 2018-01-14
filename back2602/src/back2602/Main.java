package back2602;

import java.util.Scanner;

public class Main {
		static int dp[][][];
		static int N;
		static String T;
		static char[] up,down;
		static char[] target;
		
		public static void main(String args[]) {
			Scanner in = new Scanner(System.in);
			target = in.nextLine().toCharArray();
			T = String.valueOf(target);
			up = in.nextLine().toCharArray();
			down =in.nextLine().toCharArray();
			N = up.length;
			dp = new int[2][36][103];
			
			for ( int i = 0 ; i < 2 ; i++) {
				for ( int j = 0 ; j < 36 ; j++) {
					for ( int k = 0 ; k < 103 ; k++) {
						dp[i][j][k] = -1;
					}
				}
			}
			
			int ans = 0;
			for ( int i = 0 ; i < up.length ; i++) {
				ans += func(0,i,1);
				ans += func(1,i,1);
			}
			
			System.out.println(ans);
			
		}
		
		public static int func(int updown,int location,int len) {
			
			//System.out.println(len);
			if ( updown == 1) {
				if ( target[len-1] != up[location]) {
					return 0;
				}
			}else {
				if ( target[len-1] != down[location]) {
					return 0;
				}
			}
			
			if ( len == T.length() ) {
					return 1;
			}
			
			
			int	ret = dp[updown][len][location];
				if ( ret!=-1) {
					return ret;
				}

			ret = 0;
			
			  // 1은 업 , 0  은 다운
				for ( int i = location+1 ; i < N ; i++ ) {
					if ( updown == 1) {
						ret += func(0,i,len+1);
					}else {
						ret += func(1,i,len+1);
					}
					
				}
			
			
			
			return dp[updown][len][location] = ret;
		}
}
