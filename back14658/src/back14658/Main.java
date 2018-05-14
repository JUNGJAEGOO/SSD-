package back14658;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int L = in.nextInt();
		int K = in.nextInt();
		ArrayList<node> star = new ArrayList<>();
		
		for (int i = 0 ; i < K ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			star.add(new node(x,y));
		}
		
		int min = 10000000;
		
		for ( int i = 0 ; i < K ; i++) {
			for ( int j = 0 ; j < K ; j++) {
				int sum = 0;
				for ( int s = 0 ; s < K ; s++) {
				
					int leftX = star.get(i).x;
					
					int rightY = star.get(j).y;
					
					if ( star.get(s).x >= leftX && star.get(s).x <= leftX + L && 
							star.get(s).y <= rightY + L && star.get(s).y >= rightY) {
						sum++;
					}
						
					
				}
				
				min = Math.min(min, K-sum);
			}
		}
		
		System.out.print(min);
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x =x;
			this.y =y;
		}
	}
}
