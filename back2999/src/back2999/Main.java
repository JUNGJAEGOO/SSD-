package back2999;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		int len = str.length();
		
		ArrayList<node> combi = new ArrayList<>();
		for ( int i = 1 ; i<= 100 ; i++) {
			for ( int j = 1 ; j<= 100 ; j++) {
				if ( i*j == len) {
					if ( i <= j ) {
					combi.add(new node(i,j));
					}
				}
			}
		}
		
		//System.out.println(combi.get(combi.size()-1).r+" "+combi.get(combi.size()-1).c);
		int R = combi.get(combi.size()-1).r;
		int C = combi.get(combi.size()-1).c;
		
		char mat[][]= new char[R][C];
		int cnt = 0;
		
		for ( int i = 0 ; i <C ; i++) {
			for ( int j = 0 ; j < R; j++) {
				mat[j][i] = str.charAt(cnt);
				cnt++;
			}
		}
		
		String res = "";
		for ( int i = 0 ; i < R ; i++) {
			for ( int j = 0 ; j < C; j++) {
				System.out.print(mat[i][j]+" ");
			}System.out.println();
		}
		
		for ( int i = 0 ; i < R ; i++) {
			for ( int j = 0 ; j < C; j++) {
				res += mat[i][j];
			}
		}
		
		System.out.print(res);
	}
	
	public static class node{
		int r;
		int c;
		node (int r,int c){
			this.r = r;
			this.c = c;
		}
	}
}
