package back4803;

import java.util.*;

public class Main {

	static int p[];
	static int flag[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while ( true ) {
			int n = in.nextInt();
			int m = in.nextInt();
			if ( n == 0 && m == 0) {
				break;
			}

			p = new int[n+1];
			flag = new int[n+1];
			
			for (int i = 1 ; i<= n ; i++) {
				p[i] = 0;
			}
			for (int i = 0 ; i < m ; i++) {
				
				int from = in.nextInt();
				int to = in.nextInt();
				
				int x = find(from);
				int y = find(to);
				System.out.println(x+" "+y);
				union(x,y);
				
			}
			
			
			for (int i = 1 ; i<= n ; i++) {
				System.out.print(p[i]+" ");
			}System.out.println();
			
			for (int i = 1 ; i<= n ; i++) {
				System.out.print(flag[i]+" ");
			}System.out.println();
			
		}
	}
	
	public static void union(int a,int b) {
		
		if ( a == b) {
			flag[a] = 1;
			return;
		}else {
			if ( flag[b] == 0 ) {
				flag[b] = flag[a];
			}
			p[a] = b;
		}
		
	}
	
	public static int find(int input) {
		if ( p[input] == 0) {
			return input;
		}else {
			return find(p[input]);
		}
	}
	
}
