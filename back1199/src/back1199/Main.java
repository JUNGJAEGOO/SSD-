package back1199;

import java.util.*;

public class Main {
	static int map[][];

	static int visit[];
	static int N;
	static int res;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		map = new int[N+1][N+1];

		for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j <= N ; j++) {
				int cnt = in.nextInt();
				map[i][j] = cnt;
			}
		}
		
		// 홀수인 차수 있는지 체크
		
		res = 0;
		int even = 0;
		for (int i = 1 ; i <= N ; i++) {
			int sum = 0;
			for ( int j = 1 ; j <= N ; j++) {
				sum += map[i][j];
			}
			res += sum;
			if ( sum % 2 == 1) {
				System.out.println(-1);
				return;
			}else {
				even++;
			}
		}
		
		if (even != N) {
			System.out.println(-1);
			return;
		}
		
		DFS(1);
		
	}
	
	public static void DFS(int now) {
		
		
		
			for ( int j = 1 ; j <= N ; j++) {
				if ( map[now][j] > 0) {
					map[now][j]--;
					map[j][now]--;
					DFS(j);
				}
			}
		
		System.out.print(now+" ");
	}
	
}
