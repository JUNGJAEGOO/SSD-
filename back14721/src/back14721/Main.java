package back14721;

import java.util.*;

public class Main {
	static ArrayList<node> adj;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		adj = new ArrayList<>();
		for (int i = 0 ; i < N ; i++) {
			adj.add(new node(in.nextInt(),in.nextInt()));
		}
		
		long min = Long.MAX_VALUE;
		int X=-1,Y=-1;
		
		
			for (int a = 1 ; a <= 100 ; a++) {
				for (int b = 1 ; b <= 100 ; b++) {
					
					long RSS = 0;
					
					for (int i = 0 ; i < adj.size() ; i++) {
						
						int x = adj.get(i).x;
						int y = adj.get(i).y;
						
						RSS += (long)Math.pow((y-(a*x+b)), 2);
					
					}
					
					if ( RSS < min) {
						min = RSS;
						X = a;
						Y = b;
					}
				}
			}
		
		
		
		System.out.println(X+" "+Y);
	}
	
	static class node{
		int x,y;
		node (int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}



