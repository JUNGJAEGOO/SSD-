package back14501;

import java.util.Scanner;

public class Main {
	static int t[];
	static int p[];
	static int N;
	static int max = 0;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		t = new int[N+1];
		p = new int[N+1];

		
		for (int i = 1 ; i <= N ; i++) {
			t[i] = in.nextInt();
			p[i] = in.nextInt();
		}
		
		for ( int i = 1 ; i <= N ; i++) {
			if ( i+t[i]<=N+1) {
				back(i+t[i]-1,p[i]);
				
			}
		}
		
		System.out.println(max);
	}
	
	public static void back(int len,int sum) {
		//System.out.println(sum+" "+len);
		if ( max < sum) {
			max = sum;
		}

		{
			for ( int i = len+1 ; i <= N ; i++ ) {
				if ( i+t[i] <= N+1) {
					back(i+t[i]-1,sum+p[i]);
				}
			}
		}
	}
}
