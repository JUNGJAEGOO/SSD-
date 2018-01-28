package back2342;

import java.util.*;

public class Main {
	static int dp[][][];
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while ( true ) {
			int x = in.nextInt();
			if ( x == 0 ) {
				break;
			}
			list.add(x);
		}
		
		dp = new int[list.size()+1][5][5];
		for ( int i = 0 ; i <= list.size() ; i ++) {
			for ( int j = 0 ; j < 5 ; j++) {
				for (int k = 0 ; k < 5 ; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		System.out.println(func(0,0,0));
			
	}
	
	
	
	
	public static int func(int len,int left,int right) {
		
		if ( len == list.size() ) {
			return 0;
		}
		
		int ret = dp[len][left][right];
		if ( ret != -1) {
			return ret;
		}
		ret = 100000000;
		
		int next = list.get(len);
		
		if ( left == 0) {
			ret = Math.min(ret, 2+func(len+1,next,right));
		}else if ( left == 1) {
			if ( next == 3) {
				ret = Math.min(ret, 4+func(len+1,next,right));
			}else if ( next == 2 || next == 4) {
				ret = Math.min(ret, 3+func(len+1,next,right));
			}else if ( next == 1) {
				ret = Math.min(ret, 1+func(len+1,next,right));
			}
		}else if ( left == 2) {
			if ( next == 4) {
				ret = Math.min(ret, 4+func(len+1,next,right));
			}else if ( next == 1 || next == 3) {
				ret = Math.min(ret, 3+func(len+1,next,right));
			}else if ( next == 2) {
				ret = Math.min(ret, 1+func(len+1,next,right));
			}
		}else if ( left == 3) {
			if ( next == 1) {
				ret = Math.min(ret, 4+func(len+1,next,right));
			}else if ( next == 2 || next == 4) {
				ret = Math.min(ret, 3+func(len+1,next,right));
			}else if ( next == 3) {
				ret = Math.min(ret, 1+func(len+1,next,right));
			}
		}else if ( left == 4) {
			if ( next == 2) {
				ret = Math.min(ret, 4+func(len+1,next,right));
			}else if ( next == 3 || next == 1) {
				ret = Math.min(ret, 3+func(len+1,next,right));
			}else if ( next == 4) {
				ret = Math.min(ret, 1+func(len+1,next,right));
			}
		}
		
		if ( right == 0) {
			ret = Math.min(ret, 2+func(len+1,left,next));
		}else if ( right == 1) {
			if ( next == 3) {
				ret = Math.min(ret, 4+func(len+1,left,next));
			}else if ( next == 2 || next == 4) {
				ret = Math.min(ret, 3+func(len+1,left,next));
			}else if ( next == 1) {
				ret = Math.min(ret, 1+func(len+1,left,next));
			}
		}else if ( right == 2) {
			if ( next == 4) {
				ret = Math.min(ret, 4+func(len+1,left,next));
			}else if ( next == 1 || next == 3) {
				ret = Math.min(ret, 3+func(len+1,left,next));
			}else if ( next == 2) {
				ret = Math.min(ret, 1+func(len+1,left,next));
			}
		}else if ( right == 3) {
			if ( next == 1) {
				ret = Math.min(ret, 4+func(len+1,left,next));
			}else if ( next == 2 || next == 4) {
				ret = Math.min(ret, 3+func(len+1,left,next));
			}else if ( next == 3) {
				ret = Math.min(ret, 1+func(len+1,left,next));
			}
		}else if ( right == 4) {
			if ( next == 2) {
				ret = Math.min(ret, 4+func(len+1,left,next));
			}else if ( next == 1 || next == 3) {
				ret = Math.min(ret, 3+func(len+1,left,next));
			}else if ( next == 4) {
				ret = Math.min(ret, 1+func(len+1,left,next));
			}
		}
		
		return dp[len][left][right] = ret;
		
	}
		
		
}

