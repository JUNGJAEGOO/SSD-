package back11947;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T  =in.nextInt();
		while ( T > 0) {
			
			int n = in.nextInt();
			int cnt = 0;
			while ( true ) {
				if ( n >= Math.pow(10, cnt) && n < Math.pow(10, cnt+1)) {
					break;
				}
				cnt++;
			}
			cnt++;
			//System.out.println("cnt: "+cnt);
			long res = 0;
			if ( n > Math.pow(10, cnt)/ 2) {
				long x = (long)Math.pow(10, cnt)/2;
				long y = make((int)x);
				res = x * y;
				System.out.println(res);
			}else if (  n <= Math.pow(10, cnt) / 2){
				long x = n;
				long y = make((int)n);
				res = x * y;
				System.out.println(res);
			}
			
			
			T--;
		}
	}
	
	public static long make(int x) {
		
		String tmp[] = String.valueOf(x).split("");
		String reverse[] = new String[tmp.length];
		for (int i = 0 ; i < tmp.length ; i++ ) {
			reverse[i] = String.valueOf(9-Integer.parseInt(tmp[i]));
		}
		String res = "";
		for (int i = 0 ; i < reverse.length ; i++) {
			res+= reverse[i];
		}
		//System.out.println(res);
		long ans = Long.parseLong(res);
		return ans;
	}
}
