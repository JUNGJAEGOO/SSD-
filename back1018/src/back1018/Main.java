package back1018;

import java.util.*;
import java.io.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static int N;
	static int M;
	
	static char oriboard[][];
	
	public static void main(String args[]) throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		oriboard = new char[N+2][M+2];
		for( int i = 1 ; i <= N ; i++){
			String s = br.readLine();
			char tmp[] = s.toCharArray();
			for ( int j = 1 ; j<= M ; j ++ ){
				 
				 oriboard[i][j] = tmp[j-1];
			}
		}
		

		int mincount = 100000;
		int x = 1;
		int y = 1;
		
		while ( true ){
			
			
			int tmpcount = BFS(x,y);
			System.out.println(tmpcount);
			if ( mincount > tmpcount ) { mincount = tmpcount; }
			
			if ( x+7 < N){ x++; }
			else if( y+7 < M ){ y++; }
			else{ break; }
			
		}
		
		System.out.print(mincount);
		
	}
	
	public static int BFS(int startX,int startY){

		char board[][] = new char[10][10];
		for( int i = 1 ; i <= 8 ; i++){
			for ( int j = 1 ; j<= 8 ; j ++ ){
				 board[i][j] = oriboard[startX+i][startY+j];
			}
		}
		
		
		int count = 0;
		
		for ( int x = 1 ; x <= 8 ; x ++){
			for ( int y = 1 ; y <= 8 ; y++){
		
			if ( board[x][y] == 'W'){

				if ( board[x][y+1] == 'W' ){
					board[x][y+1] = 'B';
					count++;
				}
					
			}
			else if ( board[x][y] == 'B'){
				if ( board[x][y+1] == 'B'){
					board[x][y+1] = 'W';
					count++;
					}
				}
			}
		}
		
		for(int i = 1 ; i<=8 ;i++) {
			for (int j = 1 ; j<=8 ;j++) {
				System.out.print(board[i][j]);
			}System.out.println();
		}

		return count;
	}
	
}
