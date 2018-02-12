package back1954;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int gob = in.nextInt();
		int nam = in.nextInt();
		double sum = 0;
		ArrayList<node> list = new ArrayList<>();
		
		for (int i = 0 ; i < N-1 ; i++) {
			list.add(new node(in.nextInt(),in.nextInt()));
		}
		double M = in.nextInt();
		
		boolean pass = false;
		for (int x = 1 ; x <= 10000 ; x++) {
			sum = 0;
			
			for (int i = 0 ; i < list.size() ; i++) {
				double g = list.get(i).g;
				double n = list.get(i).n;
			
				sum += ((gob*x+nam)-n)/g;
			}
			
			sum += x;
			//System.out.println(sum+"  "+x);
			
			if ( sum == M) {
				pass = true;
				System.out.println(gob*x+nam);
				return;
			}
		}
		if ( pass == false) {
			System.out.println(0);
		}
	}
	
	public static class node{
		int g;
		int n;
		node (int g,int n){
			this.g = g;
			this.n= n;
		}
	}
}
