
import java.util.*;

public class Main {
	static int [][] mat;
	static int [][] tmp;
	static int ans = 1000000000;
	static int N;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		mat = new int[N][N];
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		
		ArrayList<Integer> start = new ArrayList<>();
		back(-1,start);
		
	
		if ( ans == 1000000000) {
			System.out.println(-1);
			return;
		}
		System.out.println(ans);
	}
	
	public static void back(int len,ArrayList<Integer> list) {
		
		if ( len == N-1) {
			int cnt = 0;
			tmp = new int[N][N];
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < N ; j++) {
					tmp[i][j] = mat[i][j];
				}
			}
			
			for (int i = 0 ; i < list.size() ; i++ ) {
				
				int now = list.get(i);
				swap(0,now);
				swap(0,now+1);
				swap(0,now-1);
				swap(1,now);
				cnt++;
			}
			
			for (int i = 1 ; i < N ; i++) {
				for (int j = 0 ; j < N ; j++) {
					
					if ( tmp[i-1][j] == 1) {
						swap(i,j);
						swap(i-1,j);
						swap(i,j-1);
						swap(i,j+1);
						swap(i+1,j);
						cnt++;
					}
					
				}
			}
			
			int sum = 0;
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < N  ;j++) {
					if ( tmp[i][j] == 1) {
						sum++;
					}
				}
			}
			
			if ( sum == 0 ) {
				ans = Math.min(ans, cnt);
			}
					
			return;
		}
		
		list.add(len+1);
		back(len+1,list);
		list.remove(list.size()-1);
		back(len+1,list);
		
	}
	
	public static void check() {
		
	}
	
	public static void swap(int row,int col) {
		
		if ( row < 0 || row >= N || col  < 0 || col >= N ) {
			return;
		}
		
		tmp[row][col] ^= 1;
		
	}
	
}
