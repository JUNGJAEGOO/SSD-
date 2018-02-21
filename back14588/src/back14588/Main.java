package back14588;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int mat[][] = new int[N][N];
		ArrayList<node> list = new ArrayList<>();
		for (int i = 0 ; i < N ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			list.add(new node(from,to));
		}
		int inf = 1000000000;
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = inf;
			}
		}
		
		
		for (int i = 0 ; i < list.size() ; i++) {
			int nowFrom = list.get(i).from;
			int nowTo  = list.get(i).to;
			for (int j = 0 ; j < list.size() ; j++) {
				int goFrom = list.get(j).from;
				int goTo = list.get(j).to;
				
				if ( nowTo == goFrom) {
					mat[i][j] = 1;
				}else if ( nowFrom == goTo) {
					mat[i][j] = 1;
				}else if ( nowTo >= goFrom && nowTo <= goTo) {
					mat[i][j] = 1;
				}else if ( nowFrom >= goFrom && nowFrom <= goTo) {
					mat[i][j] = 1;
				}else if ( nowFrom >= goFrom && nowTo <= goTo) {
					mat[i][j] = 1;
				}else if ( goFrom >= nowFrom && goTo <= nowTo) {
					mat[i][j] = 1;
				}
			}
		}
		
		for (int k = 0 ; k < N ; k++) {
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < N ; j++) {
					if ( mat[i][j] > mat[i][k] + mat[k][j]) {
						mat[i][j] = mat[i][k] + mat[k][j];
					}
				}
			}
		}
		
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				if ( mat[i][j] == inf) {
					System.out.print("X ");
				}else {
					System.out.print(mat[i][j]+" ");
				}
			}System.out.println();
		}
		
		int Q = in.nextInt();
		for (int i = 0 ; i < Q ; i++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			if ( mat[x][y] == inf) {
				System.out.println(-1);
			}else {
				System.out.println(mat[x][y]);
			}
		}
	}
	
	
	
	public static class node{
		int from;
		int to;
		node (int from,int to){
			this.from = from;
			this.to= to;
		}
	}
}
