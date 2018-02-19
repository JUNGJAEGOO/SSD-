package back14564;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in) ;
			int N = in.nextInt();
			int M = in.nextInt();
			int A = in.nextInt();
			int standard = (M/2) + 1;
			int standardnumber = A;
			// 처음에 A는 m/2 +1 번으로 시작
			while ( true) {
				
				int call = in.nextInt();
				if ( call != standard) {
					int diff = call - standard;
					int res = (standardnumber + diff);
					if ( res > N) { res= res - N; }
					else if ( res < 1) { res = N + res; }
					System.out.println(res);
					standardnumber = res;
				}else{
					System.out.println(0);
					break;
				}
				
				
			}
		
	}
}
