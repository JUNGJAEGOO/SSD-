package back2610;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new  Scanner(System.in);
		int N = in.nextInt();
		int mat[][] = new int[N][N];
		int M = in.nextInt();
		int inf = 1000000000;
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = inf;
			}
		}
		
		for (int i = 0 ; i < M ; i++) {
			int from = in.nextInt()-1;
			int to = in.nextInt()-1;
			mat[from][to] = 1;
			mat[to][from ] = 1;
		}
		
		for (int  k = 0 ; k < N ; k++) {
			for (int i = 0 ; i  < N ; i++) {
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
		
		int position[] = new int[N];
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				if ( i == j || mat[i][j] == inf) {
					continue;
				}
				position[i] = Math.max(position[i], mat[i][j]);
			}
		}
		ArrayList<ArrayList<Integer>> group = new ArrayList<>();
		boolean visit[] = new boolean[N];
		for (int i = 0 ; i < N ; i++) {
			if ( visit[i] == true) {
				continue;
			}
			visit[i] = true;
			ArrayList<Integer> tmp = new ArrayList<>();
			tmp.add(i);
			for (int j = 0 ; j < N ; j++) {
				if ( i == j ) { continue; }
				if ( mat[i][j] != inf) {
					visit[j] = true;
					tmp.add(j);
				}
			}
			group.add(tmp);
		}
		
	
		ArrayList<Integer> ans = new ArrayList<>();
		System.out.println(group.size());
		for (int i = 0 ; i < group.size() ; i++) {
			ArrayList<Integer> tmp = group.get(i);
			int min = inf;
			int minidx = 0;
			for (int j = 0 ; j < tmp.size() ; j++) {
				if ( position[tmp.get(j)] < min) {
					min = position[tmp.get(j)];
					minidx = tmp.get(j);
				}
			}
			ans.add(minidx);
			
		}
		
		Collections.sort(ans);
		for (int i = 0 ; i < ans.size() ; i++) {
			System.out.println(ans.get(i)+1);
		}
		
	}
}
