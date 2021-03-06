package back1717;

import java.util.Scanner;

public class Main {
	static int parent[];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		parent = new int[n+1];
		for ( int i = 1 ; i <= n ;i++) {
			parent[i] = i;
		}
		for ( int i= 0; i<m ; i++) {
			int command = in.nextInt();
			
			if ( command == 0) {
				int x = in.nextInt();
				int y = in.nextInt();
				union(x,y);
			}else if ( command == 1) {
				int x = in.nextInt();
				int y= in.nextInt();
				if ( find(x) == find(y)) {
					System.out.println("YES");
					
				}else {
					System.out.println("NO");
				}
			}
		}
	}
	
	public static void union(int x,int y) {
		int xparent = find(x);
		int yparent = find(y);
		parent[yparent] = xparent;
	}
	
	public static int find(int x) {
		if ( x == parent[x]) {
			return x;
		}
		int root = find(parent[x]);
		parent[x] = root;
		return root;
	}
}
