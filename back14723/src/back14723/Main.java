package back14723;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in  =new Scanner(System.in);
		int N = in.nextInt();
		int start = 1;
		int d = 1;
		int st[] = new int[46];
		while ( true) {
			start = start+d;
			d++;
			if ( start > 1000) {
				st[d-1] = start;
				break;
			}
			st[d-1] = start;
		}
		st[0] = 1;
/*		for ( int i = 0 ; i<46 ; i++) {
			System.out.println(st[i]+" "+i);
		}*/
		int cnt  = 2;
		int idx = 1;
		int dp[] = new int[1001];
		int boonmo[] = new int[1001];
		int boonza[] = new int[1001];
		
		for ( int i = 1 ; i<= 1000 ; i++) {
			dp[i] = cnt;
			boonmo[i] = idx;
			boonza[i] = cnt-idx;
			idx++;
			if ( idx >= cnt) {
				cnt++;
				idx=1;
			}
			
		}
		
/*		for ( int i = 1 ; i<= 1000 ;i++) {
			System.out.print(dp[i]+" ");
		}
		System.out.println();
		for ( int i = 1 ; i<= 1000 ;i++) {
			System.out.print(boonmo[i]+" ");
		}
		System.out.println();
		for ( int i = 1 ; i<= 1000 ;i++) {
			System.out.print(boonza[i]+" ");
		}*/
		
		System.out.println(boonza[N]+" "+boonmo[N]);
		
		
	}
}
