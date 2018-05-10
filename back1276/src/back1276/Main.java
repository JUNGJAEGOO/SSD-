package back1276;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		ArrayList<node> list = new ArrayList<>();
		
		boolean graph[][] = new boolean[10001][10001];
		
		for ( int i = 0 ; i < N ; i++) {
			
			int y = in.nextInt();
			int x1 = in.nextInt() + 1;
			int x2 = in.nextInt();
			
			list.add(new node(x1,x2,y));
			
			for ( int j = x1 ; j <= x2 ; j++) {
				graph[y][j] = true;
			}
			
		}
		
		for ( int i = 0 ; i < 10001 ; i++) {
			graph[0][i] = true;
		}
		
		long ans  = 0;
		
		for ( int i = 0 ; i < list.size() ; i++ ) {
			
			int start = list.get(i).x1;
			int end = list.get(i).x2;
			int y = list.get(i).y;
			
			//System.out.println(start+" ~ "+end);
			
			int left = 0;
			int right = 0;
			
			for ( int j = y-1 ; j >= 0 ; j--) {
				
				if ( graph[j][start] == true ) {
					left += y - j;
					break;
					
				}
			}
			
			for ( int j = y-1 ; j >= 0 ; j--) {
				
				if ( graph[j][end] == true ) {
					
					right += y - j;
					break;
					
				}
			}
			
			//System.out.println(left+" "+right);
			
			ans += left+  right;
		}
		
		System.out.print(ans);
	}
	
	public static class node{
		int x1;
		int x2;
		int y;
		node (int x1,int x2,int y){
			this.x1 = x1;
			this.x2 = x2;
			this.y = y;
		}
	}
}
