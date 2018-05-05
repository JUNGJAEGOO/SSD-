package back2045;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int mat[][] = new int[3][3];
		ArrayList<node> list = new ArrayList<>();
		
		for (int i = 0 ; i < 3 ; i++) {
			for (int j = 0 ; j < 3 ; j++) {
				mat[i][j] = in.nextInt();
				if ( mat[i][j] == 0) {
					list.add(new node(i,j));
					//System.out.println(i+" "+j);
				}
			}
		}
		
		
		if (list.size() == 0) {
			
			for ( int i = 0 ; i < 3 ; i++) {
				for ( int j = 0 ; j < 3 ; j++) {
					System.out.print(mat[i][j]+" ");
				}System.out.println();
			}
			
		}else if ( list.size() == 1) {
			
			for ( int i = 1 ; i <= 20000 ; i++) {
				
				mat[list.get(0).x][list.get(0).y] = i;
				
				if ( mat[0][0] + mat[0][1] + mat[0][2] == mat[1][0] + mat[1][1] + mat[1][2] && 
						mat[2][0] + mat[2][1] + mat[2][2] == mat[1][0] + mat[1][1] + mat[1][2] ) {
					
					if ( mat[0][0] + mat[1][0] + mat[2][0] == mat[0][1] + mat[1][1] + mat[2][1] &&
							 mat[0][2] + mat[1][2] + mat[2][2] == mat[0][1] + mat[1][1] + mat[2][1] ) {
						
						if ( mat[0][0] + mat[1][1] + mat[2][2] == mat[0][2] + mat[1][1] + mat[2][0]) {
							
							for ( int s = 0 ; s < 3 ; s++) {
								for ( int k = 0 ; k < 3 ; k++) {
									System.out.print(mat[s][k]+" ");
								}System.out.println();
							}
							
							break;
							
						}
					
					}
					
				}
			}
			
		}else if (list.size() == 2) {
			
			lop:
			for ( int i = 1 ; i <= 20000 ; i++) {
				
				for ( int j = 1 ; j <= 20000 ; j++) {
					
				mat[list.get(0).x][list.get(0).y] = i;
				mat[list.get(1).x][list.get(1).y] = j;
				
				if ( mat[0][0] + mat[0][1] + mat[0][2] == mat[1][0] + mat[1][1] + mat[1][2] && 
						mat[2][0] + mat[2][1] + mat[2][2] == mat[1][0] + mat[1][1] + mat[1][2] ) {
					
					if ( mat[0][0] + mat[1][0] + mat[2][0] == mat[0][1] + mat[1][1] + mat[2][1] &&
							 mat[0][2] + mat[1][2] + mat[2][2] == mat[0][1] + mat[1][1] + mat[2][1] ) {
						
						if ( mat[0][0] + mat[1][1] + mat[2][2] == mat[0][2] + mat[1][1] + mat[2][0]) {
							
							for ( int s = 0 ; s < 3 ; s++) {
								for ( int k = 0 ; k < 3 ; k++) {
									System.out.print(mat[s][k]+" ");
								}System.out.println();
							}
							
							break lop;
							
						}
					
					}
					
				}
					
				}
			}
			
			
			
		}else if ( list.size() == 3) {
			
			
			lop:
				for ( int i = 1 ; i <= 20000 ; i++) {
					
					for ( int j = 1 ; j <= 20000 ; j++) {
						
					mat[list.get(0).x][list.get(0).y] = i;
					mat[list.get(1).x][list.get(1).y] = j;
					
					//System.out.println(i+" "+j);
					
					if ( list.get(0).x != list.get(2).x) {
						
						int sum = mat[list.get(0).x][0] +  mat[list.get(0).x][1] +  mat[list.get(0).x][2];
						int SUM = mat[list.get(2).x][0] + mat[list.get(2).x][1] + mat[list.get(2).x][2];
						int diff = sum - SUM;
						
						//System.out.println("sum :"+sum+" "+SUM);
						
						if ( diff <= 0 ) {
							mat[list.get(2).x][list.get(2).y] = 0;
							continue;
						}else {
							
							mat[list.get(2).x][list.get(2).y] = diff;
							
						}
						
					}else {
						
						int sum = mat[0][list.get(0).y] +  mat[1][list.get(0).y] +  mat[2][list.get(0).y];
						int SUM = mat[0][list.get(2).y] + mat[1][list.get(2).y] + mat[2][list.get(2).y];
						int diff = sum - SUM;
						
						if ( diff <= 0 ) {
							continue;
						}else {
							
							mat[list.get(2).x][list.get(2).y] = diff;
							
						}
						
					}
					
					
					if ( mat[0][0] + mat[0][1] + mat[0][2] == mat[1][0] + mat[1][1] + mat[1][2] && 
							mat[2][0] + mat[2][1] + mat[2][2] == mat[1][0] + mat[1][1] + mat[1][2] ) {
						
						if ( mat[0][0] + mat[1][0] + mat[2][0] == mat[0][1] + mat[1][1] + mat[2][1] &&
								 mat[0][2] + mat[1][2] + mat[2][2] == mat[0][1] + mat[1][1] + mat[2][1] ) {
							
							if ( mat[0][0] + mat[1][1] + mat[2][2] == mat[0][2] + mat[1][1] + mat[2][0]) {
								
								for ( int s = 0 ; s < 3 ; s++) {
									for ( int k = 0 ; k < 3 ; k++) {
										System.out.print(mat[s][k]+" ");
									}System.out.println();
								}
								
								break lop;
								
							}
						
						}
						
					}
						
					mat[list.get(2).x][list.get(2).y] = 0;
					
					}
				}
			
		}
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x =x ;
			this.y =y;
		}
	}
}
