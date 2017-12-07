package back1726;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int mat[][];
	static int endX,endY,endD;
	static int result = Integer.MAX_VALUE;
	static int visit[][][];
	static int N,M;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		mat = new int[N+2][M+2];
		visit = new int[N+2][M+2][5];
		for ( int i = 0 ; i <= N+1 ; i++) {
			for ( int j = 0 ; j <= M+1 ; j++) {
				mat[i][j] = -1;
				for ( int k = 0 ; k <= 4 ; k++) {
					visit[i][j][k] = 190000000;
				}
			}
		}
		for ( int i = 1 ; i <= N ; i++) {
			for ( int j = 1 ; j <= M ; j++) {
				mat[i][j] = in.nextInt();
			}
		}
		// 1 2 3 4 
		// 동 서 남 북
		int startX = in.nextInt();
		int startY = in.nextInt();
		int startD = in.nextInt();
		endX = in.nextInt();
		endY = in.nextInt();
		endD = in.nextInt();
		BFS(startX,startY,startD);
		System.out.println(result);
	}
	public static void BFS(int x,int y,int d) {
		Queue<data> q = new LinkedList<>();
		q.add(new data(x,y,d,0));
		visit[x][y][d] = 0;
		
		while ( !q.isEmpty() ) {
			data tmp = q.poll();
			int X = tmp.x;
			int Y = tmp.y;
			int D = tmp.d;
			int cost = tmp.cost;
			System.out.println(X+","+Y+": "+D);
			if ( X == endX && Y == endY ) {
				System.out.println(X+"하하하"+Y+": "+cost);
				if ( endD == 1) {
					if ( D == 3 || D == 4) {
						//System.out.println(cost+1);
						result = Math.min(result,cost+1);
					}else if ( D == 2) {
						//System.out.println(cost+2);
						result = Math.min(result,cost+2);
					}else {
						//System.out.println(cost);
						result = Math.min(result,cost);
					}
				}else if ( endD == 2) {
					if ( D == 3 || D == 4) {
						//System.out.println(cost+1);
						result = Math.min(result,cost+1);
					}else if ( D == 2) {
						//System.out.println(cost);
						result = Math.min(result,cost);
					}else {
						//System.out.println(cost+2);
						result = Math.min(result,cost+2);
					}
				}else if ( endD == 3) {
					if ( D == 1 || D == 2) {
						//System.out.println(cost+1);
						result = Math.min(result,cost+1);
					}else if ( D == 4) {
						//System.out.println(cost+2);
						result = Math.min(result,cost+2);
					}else {
						//System.out.println(cost);
						result = Math.min(result,cost);
					}
				}else if ( endD == 4) {
					if ( D == 1 || D == 2) {
						//System.out.println(cost+1);
						result = Math.min(result,cost+1);
					}else if ( D == 3) {
						//System.out.println(cost+2);
						result = Math.min(result,cost+2);
					}else {
						//System.out.println(cost);
						result = Math.min(result,cost);
					}
				}
				
				continue;
			}
			
			cost++;
			for ( int i = 1 ; i <= 3 ; i++) {
				if ( X+i<= N) {
				if ( mat[X+i][Y] == 0 ) {
					if ( i == 2) {
						if ( mat[X+1][Y] == 0) {
							int newcost=cost;
							if ( D==1) {
								newcost+=1;
							}else if ( D==2) {
								newcost+=1;
							}else if ( D==3) {
								
							}else if ( D==4) {
								newcost+=2;
							}
							if ( newcost < visit[X+i][Y][3] ) {
							q.add(new data(X+i,Y,3,newcost));
							visit[X+i][Y][3] = newcost;
							}
						}
					}
					else if ( i == 3) {
						if ( mat[X+1][Y] == 0 && mat[X+2][Y] == 0) {
							int newcost=cost;
							if ( D==1) {
								newcost+=1;
							}else if ( D==2) {
								newcost+=1;
							}else if ( D==3) {
								
							}else if ( D==4) {
								newcost+=2;
							}
							if ( newcost < visit[X+i][Y][3] ) {
							q.add(new data(X+i,Y,3,newcost));
							visit[X+i][Y][3] = newcost;
							}
						}
					}else if ( i == 1){
						if ( mat[X+1][Y] == 0) {
							int newcost=cost;
							if ( D==1) {
								newcost+=1;
							}else if ( D==2) {
								newcost+=1;
							}else if ( D==3) {
								
							}else if ( D==4) {
								newcost+=2;
							}
							if ( newcost < visit[X+i][Y][3]) {
							q.add(new data(X+i,Y,3,newcost));
							visit[X+i][Y][3] = newcost;
							}
						}
					}
					
				}
				
				
						
				}
				
				if ( X-i>=1) {
				if ( mat[X-i][Y] == 0) {
					if ( i == 2) {
						if ( mat[X-1][Y] == 0) {
						int newcost=cost;
						if ( D==1) {
							newcost+=1;
						}else if ( D==2) {
							newcost+=1;
						}else if ( D==3) {
							newcost+=2;
						}else if ( D==4) {
							
						}
						if ( newcost < visit[X-i][Y][4]) {
						q.add(new data(X-i,Y,4,newcost));
						visit[X-i][Y][4] = newcost;
						}
						}
					}
					else if ( i == 3) {
						if ( mat[X-1][Y] == 0 && mat[X-2][Y] == 0) {
						int newcost=cost;
						if ( D==1) {
							newcost+=1;
						}else if ( D==2) {
							newcost+=1;
						}else if ( D==3) {
							newcost+=2;
						}else if ( D==4) {
							
						}
						if ( newcost < visit[X-i][Y][4]  ) {
							q.add(new data(X-i,Y,4,newcost));
							visit[X-i][Y][4] = newcost;
						}
						}
					}else if ( i == 1) {
					int newcost=cost;
					if ( D==1) {
						newcost+=1;
					}else if ( D==2) {
						newcost+=1;
					}else if ( D==3) {
						newcost+=2;
					}else if ( D==4) {
						
					}
					if ( newcost < visit[X-i][Y][4] ) {
						q.add(new data(X-i,Y,4,newcost));
						visit[X-i][Y][4] = newcost;
					}
					}
				}
				
				}
				
				if ( Y+i <= M) {
				if ( mat[X][Y+i] == 0 ) {
					if ( i == 1) {
						int newcost=cost;
						if ( D==1) {
							
						}else if ( D==2) {
							newcost+=2;
						}else if ( D==3) {
							newcost+=1;
						}else if ( D==4) {
							newcost+=1;
						}
						if ( newcost< visit[X][Y+i][1] ) {
						q.add(new data(X,Y+i,1,newcost));
						visit[X][Y+i][1] = newcost;
						}
					}else if ( i == 2) {
						if ( mat[X][Y+1] == 0) {
							int newcost=cost;
							if ( D==1) {
								
							}else if ( D==2) {
								newcost+=2;
							}else if ( D==3) {
								newcost+=1;
							}else if ( D==4) {
								newcost+=1;
							}
							if ( newcost <visit[X][Y+i][1]  ) {
								q.add(new data(X,Y+i,1,newcost));
								visit[X][Y+i][1] = newcost;
								}
						}
					}else if ( i == 3) {
						if ( mat[X][Y+1] == 0 & mat[X][Y+2] == 0) {
							int newcost=cost;
							if ( D==1) {
								
							}else if ( D==2) {
								newcost+=2;
							}else if ( D==3) {
								newcost+=1;
							}else if ( D==4) {
								newcost+=1;
							}
							if  ( newcost <visit[X][Y+i][1] ) {
								q.add(new data(X,Y+i,1,newcost));
								visit[X][Y+i][1] = newcost;
								}
						}
					}
				}
				
				}
				
				if ( Y-i >= 1) {
				if ( mat[X][Y-i] == 0  ) {
					if ( i == 1) {
						int newcost=cost;
						if ( D==1) {
							newcost+=2;
						}else if ( D==2) {
							
						}else if ( D==3) {
							newcost+=1;
						}else if ( D==4) {
							newcost+=1;
						}
						if ( newcost < visit[X][Y-i][2] ) {
						q.add(new data(X,Y-i,2,newcost));
						visit[X][Y-i][2] = newcost;
						}
					}else if ( i == 2) {
						if ( mat[X][Y-1] == 0) {
							int newcost=cost;
							if ( D==1) {
								newcost+=2;
							}else if ( D==2) {
								
							}else if ( D==3) {
								newcost+=1;
							}else if ( D==4) {
								newcost+=1;
							}
							if ( newcost < visit[X][Y-i][2] ) {
								q.add(new data(X,Y-i,2,newcost));
								visit[X][Y-i][2] = newcost;
								}
						}
					}else if ( i == 3 ) {
						if ( mat[X][Y-1] == 0 && mat[X][Y-2] == 0) {
							int newcost=cost;
							if ( D==1) {
								newcost+=2;
							}else if ( D==2) {
								
							}else if ( D==3) {
								newcost+=1;
							}else if ( D==4) {
								newcost+=1;
							}
							if ( newcost < visit[X][Y-i][2] ) {
								q.add(new data(X,Y-i,2,newcost));
								visit[X][Y-i][2] = newcost;
								}
						}
					}
				}
				
				}
			}
		}
	}
	
	public static class data{
		int x;
		int y;
		int d;
		int cost;
		data(int x, int y, int d,int cost){
			this.x = x;
			this.y = y;
			this.d = d;
			this.cost = cost;
		}
	}
}
