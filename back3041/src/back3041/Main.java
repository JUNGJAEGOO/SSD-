package back3041;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		char[][] mat = new char[4][4];
		for ( int i = 0 ; i  < 4 ; i++) {
			char[] tmp = in.nextLine().toCharArray();
			
			for ( int j = 0 ; j < 4 ; j++) {
				mat[i][j] = tmp[j];
			}
		}
		
		HashMap<Character,node> hm = new HashMap<>();
		hm.put('A',new node(0,0)); hm.put('B',new node(0,1));
		hm.put('C',new node(0,2)); hm.put('D',new node(0,3));
		hm.put('E',new node(1,0)); hm.put('F',new node(1,1));
		hm.put('G',new node(1,2)); hm.put('H',new node(1,3));
		hm.put('I',new node(2,0)); hm.put('J',new node(2,1));
		hm.put('K',new node(2,2)); hm.put('L',new node(2,3));
		hm.put('M',new node(3,0)); hm.put('N',new node(3,1));
		hm.put('O',new node(3,2)); hm.put('.',new node(3,3));
		
		int sum = 0;
		for (int i = 0 ; i < 4 ; i++) {
			for ( int j = 0 ; j < 4 ; j++) {
				
				node now = hm.get(mat[i][j]);
				int X = now.x;
				int Y = now.y;
				
				int dist = Math.abs(X - i) + Math.abs(Y - j);
				
				//System.out.println(dist+" "+i+","+j);
				
				if ( mat[i][j] == '.') {
					continue;
				}
				sum += dist;
			}
		}
		
		System.out.print(sum);
	}
	
	public static class node{
		int x,y;
		node ( int x,int y){
			this.x =x;
			this.y= y;
		}
	}
}
