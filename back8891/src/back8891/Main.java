package back8891;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int arr[][] = new int[301][301];
		int cnt  = 1;
		int x = 1,y = 1;
		int idx = 2;
		ArrayList<node> list  = new ArrayList<>();
		list.add(new node(0,0));
		while ( true ) {
			if ( x > 300 ) {
				break;
			}
			arr[x][y] = cnt;
			list.add(new node(x,y));
			cnt++;
			y++;
			x--;
			if ( x <= 0 || y > 300 ) {
				x = idx;
				idx++;
				y = 1;
			}
		}
		
		/*for ( int i = 1 ; i <= 10 ; i++) {
			for ( int j = 1 ; j <= 10 ; j++) {
				System.out.print(arr[i][j]+" ");
			}System.out.println();
		}*/
		
		int T = in.nextInt();
		while ( T > 0) {
			
			int X = in.nextInt();
			int Y = in.nextInt();
			int oneX = list.get(X).x;
			int oneY = list.get(X).y;
			int twoX = list.get(Y).x;
			int twoY = list.get(Y).y;
			System.out.println(arr[oneX+twoX][oneY+twoY]);
			
			T--;
		}
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x =x ;
			this.y =y;
		}
	}
}
