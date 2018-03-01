package back2422;

import java.util.*;

public class Main {
	static int no[][];
	static int N,M;
	static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		no = new int[N+1][N+1];
		
		for (int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			no[from][to] = 1;
			no[to][from] = 1;
		}
		
		
		for (int i = 1 ; i <= N ; i++) {
			for (int j = i+1 ; j <= N ; j++) {
				for (int k = j+1 ; k <= N ; k++) {
					
					if ( no[i][j] == 1 || no[j][i] == 1 || no[j][k] == 1 || no[k][j] == 1 || no[i][k] == 1|| no[k][i] == 1) {
						continue;
					}
					
					ArrayList<Integer> tmp = new ArrayList<>();
					tmp.add(i);
					tmp.add(j);
					tmp.add(k);
					//Collections.sort(tmp);
					System.out.println(tmp);
					//if ( !ans.contains(tmp) ) {
						ans.add(tmp);
					//}
					
				}
			}
		}
		
		System.out.println(ans.size());
		
	}
	

}
