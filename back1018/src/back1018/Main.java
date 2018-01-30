package back1018;

import java.util.*;
import java.io.*;

public class Main {

	static char originW[][];
	static char originB[][];
	static char mat[][];
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		originW = new char[8][8];
		originB = new char[8][8];
		mat = new char[N][M];
		
		for (int i = 0 ; i < N ; i++) {
			char tmp[] = br.readLine().toCharArray();
			for (int j = 0 ; j < M ; j++) {
				mat[i][j] = tmp[j];
			}
		}
		
	
		init();
		
		int diffW=1000000000,diffB=1000000000;
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < M ; j++) {
				if ( 8-i >=0 && i+8 <= N) {
					if ( 8-j >=0 && j+8 <= M) {
						int map[][] = new int[8][8];
						//System.out.println(i+" "+j);
						for (int k = i ; k < i+8 ; k++) {
							for (int s = j ; s < j+8 ; s++) {
								map[k-i][s-j] = mat[k][s];
							}
						}
						
						int ans[] = biggyo(map);
						//System.out.println(ans[0]+" "+ans[1]);
						diffW = Math.min(ans[0], diffW);
						diffB = Math.min(ans[1], diffB);
					}
				}
			}
		}

		System.out.print(Math.min(diffW, diffB));
		
		
	}
	
	public static int[] biggyo(int map[][]) {
		int diffW = 0,diffB = 0;
	/*	for (int i = 0 ; i < 8 ; i++) {
			for (int j = 0 ; j < 8 ; j++) {
				System.out.print(originW[i][j]);
			}System.out.println();
		}
		System.out.println("-------");
		for (int i = 0 ; i < 8 ; i++) {
			for (int j = 0 ; j < 8 ; j++) {
				System.out.print(originB[i][j]);
			}System.out.println();
		}
		System.out.println("-------");*/
		for (int i = 0 ; i < 8 ; i++) {
			for (int j = 0 ; j < 8 ; j++) {
				if ( map[i][j] != originW[i][j]) {
					diffW++;
				}
				if ( map[i][j] != originB[i][j]) {
					diffB++;
				}
			}
		}
		
		int arr[] = {diffW,diffB};
		return arr;
	}
	
	public static void init() {
		for (int i = 0 ; i < 8 ; i++) {
			
			for (int j = 0 ; j < 8 ; j++) {
				if ( i%2 == 0) {
					if ( j%2 == 0) {
						originW[i][j] = 'B';
					}else {
						originW[i][j] = 'W';
					}	
				}
				else {
					if ( j%2 == 0) {
						originW[i][j] = 'W';
					}else {
						originW[i][j] = 'B';
					}
				}
				
			}
		}
		
		
		for (int i = 0 ; i < 8 ; i++) {
			
			for (int j = 0 ; j < 8 ; j++) {
				if ( i%2 == 0) {
					if ( j%2 == 0) {
						originB[i][j] = 'W';
					}else {
						originB[i][j] = 'B';
					}	
				}
				else {
					if ( j%2 == 0) {
						originB[i][j] = 'B';
					}else {
						originB[i][j] = 'W';
					}
				}
			}
		}
	}
	
}
