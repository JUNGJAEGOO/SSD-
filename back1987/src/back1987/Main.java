package back1987;

import java.io.*;
import java.util.*;

public class Main {
	static char mat[][];
	static int max = 0;
	static int R,C;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		mat = new char[R+2][C+2];
		for ( int i = 1 ; i <= R ; i++) {
			char[] tmp = br.readLine().toCharArray();
			for ( int j = 1 ; j <= C ; j++ ) {
				mat[i][j] = tmp[j-1];
			}
		}
		//System.out.println('Z'+0);
		int[] inner = new int[92];
		for ( int i = 0 ; i <= 64 ; i++) {
			inner[i] = 1;
		}
		//System.out.println(' '+0);
		inner[mat[1][1]]++;
		back(inner,1,1,1);
		
		System.out.println(max);
	}
	
	public static void back(int alpha[],int x,int y,int sum) {
		
		//System.out.println(alpha.length+" "+sum+" "+x+","+y);
//		for ( int i = 65 ; i<=90 ; i++) {
//			System.out.print(alpha[i]+" ");
//		}System.out.println();
		
		//System.out.println(mat[x+1][y]+" "+mat[x-1][y]+" "+mat[x][y+1]+" "+mat[x][y-1]);
		//System.out.println(alpha[mat[x+1][y]]+" "+alpha[mat[x-1][y]]+" "+alpha[mat[x][y+1]]+" "+alpha[mat[x][y-1]]);
		
		if ( alpha[mat[x+1][y]] > 0 && alpha[mat[x-1][y]] > 0 && 
				alpha[mat[x][y+1]] > 0 && alpha[mat[x][y-1]] > 0) {
			if ( sum > max ) {
				max = sum;
			}
			//return;
		}
		
		
		if ( alpha[mat[x+1][y]+0] == 0) {
			if ( x+1 <= R ) {
				int tmp[] = new int[92];
				for ( int i = 0 ; i < 92 ; i++) {
					tmp[i] = alpha[i];
				}
				tmp[mat[x+1][y]+0]++;
				back(tmp,x+1,y,sum+1);
			}
		}
		if ( alpha[mat[x-1][y]+0] == 0) {
			if ( x-1 >= 1) {
				int tmp[] = new int[92];
				for ( int i = 0 ; i < 92 ; i++) {
					tmp[i] = alpha[i];
				}
				tmp[mat[x-1][y]]++;
				back(tmp,x-1,y,sum+1);
			}
		}
		if ( alpha[mat[x][y+1]+0] == 0) {
			if ( y+1 <= C) {
				int tmp[] = new int[92];
				for ( int i = 0 ; i < 92 ; i++) {
					tmp[i] = alpha[i];
				}
				tmp[mat[x][y+1]]++;
				back(tmp,x,y+1,sum+1);
			}
		}
		if ( alpha[mat[x][y-1]+0] == 0) {
			if ( y-1 >= 1) {
				int tmp[] = new int[92];
				for ( int i = 0 ; i < 92 ; i++) {
					tmp[i] = alpha[i];
				}
				tmp[mat[x][y-1]]++;
				back(tmp,x,y-1,sum+1);
			}
		}
		
	}
}
