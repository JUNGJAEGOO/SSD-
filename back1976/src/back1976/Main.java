package back1976;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int p[];
	public static void main(String args[]) {
		Scanner in= new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		p = new int[N+1];
		Arrays.fill(p, -1);
		for (int i = 1 ; i <= N ; i++) {
			for  (int j = 1 ; j <= N ; j++) {
				int x = in.nextInt();
				if ( x == 1) {
					union(i,j);
				}
			}
		}
		
		int start = in.nextInt();
		int b = find(start);
		for ( int i = 0 ; i < M-1 ; i++) {
			int next = in.nextInt();
			//System.out.println(find(start)+" "+find(next));
			if ( b != find(next)) {
				System.out.println("NO");
				return;
			}
		}
		
		/*for (int i = 1 ; i<= N ; i++) {
			System.out.println(p[i]);
		}*/
		
		System.out.println("YES");
	}
	
	public static void union(int x,int y) {
		if ( find(x) == find(y) ) {
			return;
		}else {
			p[find(x)] = find(y);
		}
	}
	
	public static int find(int x) {
		if ( p[x] < 0) {
			return x;
		}else {
			return p[x] = find(p[x]);
		}
	}
}
