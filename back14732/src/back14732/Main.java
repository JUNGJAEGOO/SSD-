package back14732;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int mat[][] = new int[100002][100002];
		
		for ( int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine()," ");
			int x1 = Integer.parseInt(st.nextToken()) + 50000;
			int y1 = Integer.parseInt(st.nextToken()) + 50000;
			int x2 = Integer.parseInt(st.nextToken()) + 50000;
			int y2 = Integer.parseInt(st.nextToken()) + 50000;
			
			for (int s = y1 ; s < y2 ; s++) {
				for ( int j = x1 ; j < x2 ; j++) {
					mat[s][j]=1;
				}
			}
		}
		
		int sum = 0;
		for ( int i = 0 ; i <= 100000 ; i++) {
			for ( int j = 0 ; j <= 100000 ; j++) {
				if ( mat[i][j] >= 1) {
					sum++;
				}
				//System.out.print(mat[i][j]);
			}//System.out.println();
		}
		System.out.println(sum);
	}
}
