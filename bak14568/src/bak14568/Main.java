package bak14568;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int ans = 0;
		if ( N <= 3) {
			System.out.println(0);
			return;
		}else {
			
				
				for ( int i = 2 ; i<100 ; i=i+2) {
					int tmp = N;
					tmp -= i;
					if ( tmp >= 2) {
					
					for ( int j = 1 ; j <= tmp ; j ++) {
						int tmptmp = tmp;
						
						int a = tmptmp-j;
						int b = j;
						if ( a>=b+2 && a>0 && b>0) {
							//System.out.println(i+":"+a+","+b);
							ans++;
						}
						
					}
					}
				}
				
				
			System.out.println(ans);
			
			
		}
	}
}
