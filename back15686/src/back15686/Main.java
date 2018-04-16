package back15686;

import java.util.*;

public class Main {
	static int N,M;
	static int mat[][];
	static ArrayList<node> list = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> combi = new ArrayList<>();
	static boolean vv[];
	static ArrayList<node> one = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		mat = new int[N][N];
		for ( int i = 0 ; i < N ; i++) {
			for ( int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
				if ( mat[i][j] == 2) {
					list.add(new node(i,j));
				}
				if ( mat[i][j] == 1) {
					one.add(new node(i,j));
				}
			}
		}
		
		vv = new boolean[14];
		for ( int i = 1 ; i<= M ; i++) {
			make(i,0,new ArrayList<Integer>(),-1);
		}
	
		//System.out.println(combi.size());
		/*for ( int i = 0 ; i < combi.size() ; i++) {
			System.out.println(combi.get(i));
		}*/
		
		int ans = Integer.MAX_VALUE;
		for ( int i = 0 ; i < combi.size() ; i++) {
			
			int sum = 0;
			for ( int j = 0 ; j < one.size() ; j++) {
				
				int len = 1000000000;
				for ( int k = 0 ; k < combi.get(i).size() ; k++) {
					
					int X = Math.abs(one.get(j).x - list.get(combi.get(i).get(k)).x);
					int Y = Math.abs(one.get(j).y - list.get(combi.get(i).get(k)).y);
					
					len = Math.min(len, X+Y);
				}
				
				sum += len;
				
				
			}
			//System.out.println("sum "+sum);
			ans = Math.min(ans, sum);
			
		}
		
		System.out.println(ans);
		
	}
	
	public static void make(int max,int len,ArrayList<Integer> visit,int last) {
		
		//System.out.println(visit);
		if ( len == max ) {
			ArrayList<Integer> tmp = new ArrayList<>();
			for ( int i = 0 ; i < visit.size() ; i++) {
				tmp.add(visit.get(i));
			}
			combi.add(tmp);
			return;
		}

		
		for ( int i = last+1 ; i < list.size() ; i++) {
			if ( vv[i] == false ) {
				vv[i] = true;
				visit.add(i);
				make(max,len+1,visit,i);
				vv[i] = false;
				visit.remove(visit.size()-1);
			}
		}
		
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
