package back3009;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int x[] = new int[1001];
		int y[] = new int[1001];
		
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		
		int x2 = in.nextInt();
		int y2 = in.nextInt();
		
		int x3 = in.nextInt();
		int y3 = in.nextInt();
		
		
		x[x1]++;
		x[x2]++;
		x[x3]++;
		y[y1]++;
		y[y2]++;
		y[y3]++;
		
		int resX= 0, resY = 0;
		for ( int i = 0 ; i <= 1000  ; i++) {
			if ( x[i] == 1) {
				resX = i;
			}
		}
		
		for ( int i = 0 ; i <= 1000  ; i++) {
			if ( y[i] == 1) {
				resY= i;
			}
		}
		
		System.out.println(resX+" "+resY);
	}
}
