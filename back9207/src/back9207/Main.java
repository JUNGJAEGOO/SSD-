package back9207;

import java.util.*;

public class Main {

	static char origin[][];
	static int inf = 1000000000;
	static int COUNT,PIN;
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		
		
		for (int s = 0 ; s < T ; s++) {
			PIN = inf;
			COUNT = inf;
			origin = new char[5][9];
			for (int i = 0 ; i < 5 ; i++) {
				char[] input = in.nextLine().toCharArray();
				for (int j = 0 ; j <  9 ; j++) {
					origin[i][j] = input[j];
				}
			}
			BFS();
			System.out.println(PIN+" "+COUNT);
			if ( s == T-1) {
				break;
			}
			in.nextLine();
		}
		
	}
	
	public static void BFS() {
		
		int cnt = inf;
		int pin = inf;
		Queue<node> q = new LinkedList<>();
		for (int i = 0 ; i < 5 ; i++) {
			for (int j = 0 ; j <  9  ; j++) {
				if ( origin[i][j] == 'o') {
					
					int a[] = right(i,j,origin);
					int b[] = left(i,j,origin);
					int c[] = up(i,j,origin);
					int d[] = down(i,j,origin);

					if ( a[0] != -1 || a[1] != -1) {
						char tmp[][] = new char[5][9];
						for (int s = 0 ; s < 5 ; s++) {
							for (int k = 0 ; k < 9 ; k++) {
								tmp[s][k] = origin[s][k];
							}
						}
						q.add(new node(i,j,tmp,0));
					}
					if ( b[0] != -1 || b[1] != -1) {
						char tmp[][] = new char[5][9];
						for (int s = 0 ; s < 5 ; s++) {
							for (int k = 0 ; k < 9 ; k++) {
								tmp[s][k] = origin[s][k];
							}
						}
						q.add(new node(i,j,tmp,0));
					}if ( c[0] != -1 || c[1] != -1) {
						char tmp[][] = new char[5][9];
						for (int s = 0 ; s < 5 ; s++) {
							for (int k = 0 ; k < 9 ; k++) {
								tmp[s][k] = origin[s][k];
							}
						}
						q.add(new node(i,j,tmp,0));
					}if ( d[0] != -1 || d[1] != -1) {
						char tmp[][] = new char[5][9];
						for (int s = 0 ; s < 5 ; s++) {
							for (int k = 0 ; k < 9 ; k++) {
								tmp[s][k] = origin[s][k];
							}
						}
						q.add(new node(i,j,tmp,0));
					}

				}
			}
		}
		
		while ( !q.isEmpty() ) {
			
			node now = q.poll();
			int x = now.x;
			int y = now.y;
	
			char map[][] = now.map;
			int count = now.count;
			System.out.println(x+" "+y+" "+count);
			int a[] = right(x,y,map);
			int b[] = left(x,y,map);
			int c[] = up(x,y,map);
			int d[] = down(x,y,map);
			
			for (int i = 0 ; i < 5 ; i++) {
				for (int j = 0 ; j < 9 ; j++) {
					System.out.print(map[i][j]);
				}System.out.println();
			}System.out.println();
			

			if ( a[0] == -1 && a[1] == -1 && b[0] == -1 && b[1] == -1 && c[0] == -1 && c[1] == -1 
					&& d[0] == -1 && d[1] == -1) {
				
				
				for (int i = 0 ; i < 5 ; i++) {
					for (int j = 0 ; j <  9  ; j++) {
						if ( map[i][j] == 'o') {
							
							int A[] = right(i,j,map);
							int B[] = left(i,j,map);
							int C[] = up(i,j,map);
							int D[] = down(i,j,map);

							if ( A[0] != -1 || A[1] != -1) {
								char tmp[][] = new char[5][9];
								for (int s = 0 ; s < 5 ; s++) {
									for (int k = 0 ; k < 9 ; k++) {
										tmp[s][k] = map[s][k];
									}
								}
								q.add(new node(i,j,tmp,count));
							}
							if ( B[0] != -1 || B[1] != -1) {
								char tmp[][] = new char[5][9];
								for (int s = 0 ; s < 5 ; s++) {
									for (int k = 0 ; k < 9 ; k++) {
										tmp[s][k] = map[s][k];
									}
								}
								q.add(new node(i,j,tmp,count));
							}if ( C[0] != -1 || C[1] != -1) {
								char tmp[][] = new char[5][9];
								for (int s = 0 ; s < 5 ; s++) {
									for (int k = 0 ; k < 9 ; k++) {
										tmp[s][k] = map[s][k];
									}
								}
								q.add(new node(i,j,tmp,count));
							}if ( D[0] != -1 || D[1] != -1) {
								char tmp[][] = new char[5][9];
								for (int s = 0 ; s < 5 ; s++) {
									for (int k = 0 ; k < 9 ; k++) {
										tmp[s][k] = map[s][k];
									}
								}
								q.add(new node(i,j,tmp,count));
							}

						}
					}
				}
				
				
				int nowpin = 0;
				for (int i = 0 ; i < 5 ; i++) {
					for (int j = 0 ; j < 9 ; j++) {
						if ( map[i][j] == 'o') {
							nowpin++;
						}
					}
				}
				
				if ( nowpin < pin) {
					pin = nowpin;
					cnt = count;
				}
				
				continue;
			}
			
			if ( a[0] != -1 || a[1] != -1) {
				char tmp[][] = new char[5][9];
				for (int s = 0 ; s < 5 ; s++) {
					for (int k = 0 ; k < 9 ; k++) {
						tmp[s][k] = map[s][k];
					}
				}
				tmp[x][y] = '.';
				tmp[a[0]][a[1]] = '.';
				tmp[a[0]][a[1]+1] = 'o';
				q.add(new node(a[0],a[1]+1,tmp,count+1));
			}
			if ( b[0] != -1 || b[1] != -1) {
				char tmp[][] = new char[5][9];
				for (int s = 0 ; s < 5 ; s++) {
					for (int k = 0 ; k < 9 ; k++) {
						tmp[s][k] = map[s][k];
					}
				}
				tmp[x][y] = '.';
				tmp[b[0]][b[1]] = '.';
				tmp[b[0]][b[1]-1] = 'o';
				q.add(new node(b[0],b[1]-1,tmp,count+1));
			}if ( c[0] != -1 || c[1] != -1) {
				char tmp[][] = new char[5][9];
				for (int s = 0 ; s < 5 ; s++) {
					for (int k = 0 ; k < 9 ; k++) {
						tmp[s][k] = map[s][k];
					}
				}
				tmp[x][y] = '.';
				tmp[c[0]][c[1]] = '.';
				tmp[c[0]-1][c[1]] = 'o';
				q.add(new node(c[0]-1,c[1],tmp,count+1));
			}if ( d[0] != -1 || d[1] != -1) {
				char tmp[][] = new char[5][9];
				for (int s = 0 ; s < 5 ; s++) {
					for (int k = 0 ; k < 9 ; k++) {
						tmp[s][k] = map[s][k];
					}
				}
				tmp[x][y] = '.';
				tmp[d[0]][d[1]] = '.';
				tmp[d[0]+1][d[1]] = 'o';
				q.add(new node(d[0]+1,d[1],tmp,count+1));
			}
				
			
		}
		
		COUNT = cnt;
		PIN = pin;
	}
	
	public static int[] right(int x,int y,char mat[][]) {
		
		int res[] = new int[2];
		for (int i = y+1 ; i < 8 ; i++) {
			if ( mat[x][i] == 'o' && mat[x][i+1] == '.') {
				res[0] = x;
				res[1] = i;
				return res;
			}
		}
		
		res[0] = -1;
		res[1] = -1;
		return res;
	}
	
	public static int[] left(int x,int y,char[][] mat) {
		int res[] = new int[2];
		for (int i = y-1 ; i > 0 ; i--) {
			if ( mat[x][i] == 'o' && mat[x][i-1] == '.') {
				res[0] = x;
				res[1] = i;
				return res;
			}
		}
		res[0] = -1;
		res[1] = -1;
		return res;
	}
	
	public static int[] up(int x,int y,char mat[][]) {
		int res[] = new int[2];
		for (int i = x-1 ; i > 0 ; i--) {
			if ( mat[i][y] == 'o' && mat[i-1][y] == '.') {
				res[0] = i;
				res[1] = y;
				return res;
			}
		}
		res[0] = -1;
		res[1] = -1;
		return res;
	}
	
	public static int[] down(int x,int y,char mat[][]) {
		int res[] = new int[2];
		for (int i = x+1 ; i < 4 ; i++) {
			if ( mat[i][y] == 'o' && mat[i+1][y] == '.') {
				res[0] = i;
				res[1] = y;
				return res;
			}
		}
		res[0] = -1;
		res[1] = -1;
		return res;
	}
	
	public static class node{
		int x,y;
		char map[][];
		int count;
		node (int x,int y,char[][] map,int count) {
			this.x = x;
			this.y = y;
			this.map = map;
			this.count = count;
		}
	}
}
