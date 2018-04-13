package back8983;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int M = in.nextInt();
		int N = in.nextInt();
		int L = in.nextInt();
		int fire[] = new int[M];
		for (int i = 0 ; i < M ; i++) {
			fire[i] = in.nextInt();
		}
		Arrays.sort(fire);
		
		int sum = 0;
		
		ArrayList<node> list = new ArrayList<>();
		for  (int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			list.add(new node(x,y));
		}
		
		Collections.sort(list);
		
		for ( int i = 0 ; i < N ; i++) {
			
			int x = list.get(i).x;
			int y = list.get(i).y;
			
			int left = 0;
			int right = M-1;
			int up = 0;
			
			while ( left <= right ) {
				
				int mid = (left+right)/2;
				
				if ( fire[mid] <= x) {
					up = mid;
					left = mid +1;
				}else {
					right=  mid -1;
				}	
			}

			left = 0;
			right = M - 1;
			int down = 0;
			
			while ( left <= right ) {
				
				int mid = (left+right)/2;
				
				if ( fire[mid] < x) {
					
					left = mid +1;
				}else {
					down = mid;
					right=  mid -1;
				}	
			}
			
			//System.out.println(x+" "+y+" " +up+" "+down);
			
			double length = Math.abs((x-fire[up])) + y;
			double length2 = Math.abs((x-fire[down])) + y;

			if ( length  <= L || length2 <= L ) {
				sum++;
			}
			
		}
		
		System.out.print(sum);
	}
	
	public static class node implements Comparable<node>{
		int x,y;
		node (int x,int y){
			this.x =x;
			this.y =y;
		}
		@Override
		public int compareTo(node o) {
			if ( this.x > o.x) {
				return 1;
			}
			return -1;
		}
	}
}
