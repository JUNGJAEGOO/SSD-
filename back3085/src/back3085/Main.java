package back3085;

import java.util.Scanner;

public class Main {
	static char mat[][];
	static int N;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = Integer.parseInt(in.nextLine());
		mat = new char[N][N];
		for (int i = 0 ; i < N ; i++) {
			char[] tmp = in.nextLine().toCharArray();
			for (int j = 0 ; j < N ; j++) {
				mat[i][j] = tmp[j];
			}
		}

		int ans = 0;
		//System.out.println(ans);
		// 행 바꾸기
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N-1 ; j++) {
				char temp = mat[i][j];
				mat[i][j] = mat[i][j+1];
				mat[i][j+1] = temp;
				
				int tmprow = scanRow();
				int tmpcol = scanCol();
				/*for (int s = 0 ; s < N ; s++) {
					for (int k = 0 ; k< N ; k++) {
						System.out.print(mat[s][k]+" ");
					}System.out.println();
				}System.out.println("---------"+tmprow+","+tmpcol);*/
				ans = Math.max(ans, Math.max(tmprow, tmpcol));
				temp = mat[i][j];
				mat[i][j] = mat[i][j+1];
				mat[i][j+1] = temp;	
			}
		}
		// 열 바꾸기
		for (int j= 0 ; j < N ; j++) {
			for (int i = 0 ; i < N-1 ; i++) {
				char temp = mat[i][j];
				mat[i][j] = mat[i+1][j];
				mat[i+1][j] = temp;

				int tmprow = scanRow();
				int tmpcol = scanCol();
				
				/*for (int s = 0 ; s < N ; s++) {
					for (int k = 0 ; k< N ; k++) {
						System.out.print(mat[s][k]+" ");
					}System.out.println();
				}System.out.println("---------"+tmprow+","+tmpcol);*/
				ans = Math.max(ans, Math.max(tmprow, tmpcol));
				temp = mat[i][j];
				mat[i][j] = mat[i+1][j];
				mat[i+1][j] = temp;
			}
		}
		
		System.out.println(ans);
	}
	
	public static int scanRow() {
		
		int sum = 0;
		int ans = 1;
		char before;
		for (int i = 0 ; i < N ; i++) {
			sum = 1;
			before = mat[i][0];
			for (int j = 1 ; j < N ; j++) {
				if ( mat[i][j] == before) {
					sum++;
					ans = Math.max(ans, sum);
				}else {
					before = mat[i][j];
					sum =1;
				}
			}
			
		}
		return ans;
	}
	
	public static int scanCol() {
		int sum = 0;
		int ans = 1;
		char before;
		for (int j = 0 ; j < N ; j++) {
			sum = 1;
			before = mat[0][j];
			for (int i = 1 ; i < N ; i++) {
				if ( mat[i][j] == before) {
					sum++;
					ans = Math.max(ans, sum);
				}else {
					before = mat[i][j];
					sum =1;
				}
			}
			
		}
		return ans;
	}
}
