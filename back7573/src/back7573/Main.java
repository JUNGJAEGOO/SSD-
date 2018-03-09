package back7573;

import java.util.*;

public class Main {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int I = in.nextInt()/2;
		int M = in.nextInt();
		
	
		ArrayList<node> fish = new ArrayList<>();
		
		for (int i = 0 ; i < M ; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			fish.add(new node(x,y));
		}
		
		
		int max = 0;
		
				
		for (int i = 0 ; i < fish.size() ; i++) {
			int startX = fish.get(i).x;
			int startY = fish.get(i).y; 
			
			for ( int k = 1; k < I ; k++) {	
				int xlim = k;
				int ylim = I-k;
				
				
				for ( int x = startX - xlim ; x <= startX ; x++ ) {
					for (int y = startY - ylim ; y <= startY ; y++) {
						
						int sum = 0;
						System.out.println(x+" "+y+" "+xlim+" "+ylim+"---------------");
						for (int s = 0; s < fish.size() ; s++) {
							int nx = fish.get(s).x;
							int ny = fish.get(s).y;
							if ( x <= nx && nx <= x+xlim && y <= ny && ny <= y+ylim) {
								System.out.println(nx+" "+ny);
								sum++;
							}
						}
						max = Math.max(max, sum);
					}
				}
			}
				
		}
				
		
		System.out.println(max);
	}
	
	public static class node{
		int x,y;
		node ( int x, int y ){
			this.x = x;
			this.y = y;
		}
	}
}
