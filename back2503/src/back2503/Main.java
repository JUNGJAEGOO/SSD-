package back2503;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int arrX[] = new int[N];
		int arrS[] = new int[N];
		int arrB[] = new int[N];
		
		for (int i = 0 ; i < N ; i++) {
			int X = in.nextInt();
			int S = in.nextInt();
			int B = in.nextInt();
			arrX[i] = X;
			arrS[i] = S;
			arrB[i] = B;
		}
		
		int ans = 0;
		for ( int i = 123 ; i <= 987 ; i++) {
			
			int a[] = new int[3];
			a[0] = i/100;
			a[1] = (i/10)%10;
			a[2] = i%10;
			
			if ( a[0] == 0 || a[1] == 0 || a[2] == 0) {
				continue;
			}
			
			if ( a[0] == a[1] || a[1] == a[2] || a[0] == a[2] ) {
				continue;
			}
			
			int sum = 0;
			
			for ( int j = 0 ; j < N ; j++) {
				
				int b[] = new int[3];
				b[0] = arrX[j]/100;
				b[1] = (arrX[j]/10)%10;
				b[2] = arrX[j]%10;
				
				int strike = 0;
				int ball = 0;
				
				if ( a[0] == b[0]  ) {
					strike++;
				}
				
				if ( a[1] == b[1]  ) {
					strike++;
				}
				
				if ( a[2] == b[2]  ) {
					strike++;
				}
				
				if ( a[0] == b[1] || a[0] == b[2]) {
					ball++;
				}
				
				if ( a[1] == b[0] || a[1] == b[2]) {
					ball++;
				}
				
				if ( a[2] == b[1] || a[2] == b[0]) {
					ball++;
				}
				
				if ( strike == arrS[j] && ball == arrB[j]) {
					sum++;
				}
			}
			
			if ( sum == N) {
				ans++;
			}
			
		}
		
		System.out.print(ans);
	}
}
