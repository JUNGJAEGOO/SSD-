package back1405;

import java.util.*;

public class Main {
	static double east,west,south,north;
	static double sum = 0;
	static int N;
	static boolean visit[][];
	static int X[] = {-1,0,1,0};
	static int Y[] = { 0,1,0,-1};
	static double P[] = new double[4];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		east = in.nextDouble()/100;
		west = in.nextDouble()/100;
		south = in.nextDouble()/100;
		north = in.nextDouble()/100;
		visit = new boolean [31][31];
		visit[15][15] = true;
		P[0] = north;
		P[1] = east;
		P[2] = south;
		P[3] = west;

		double b = System.currentTimeMillis();
		DFS(0,15,15,1);
		double a = System.currentTimeMillis();
		System.out.println(sum);
		System.out.println(a-b);
	}
	
	public static void DFS(int n,int x,int y,double p) {
		//System.out.println(x+","+y);
		if ( n == N) {
			sum += p;
			return;
		}
		
		for ( int i = 0 ; i < 4; i++) {
			
			if ( visit[x+X[i]][y+Y[i]] == false ) {
			visit[x+X[i]][y+Y[i]] = true;
				DFS(n+1,x+X[i],y+Y[i],p*P[i]);
			visit[x+X[i]][y+Y[i]] = false;
			}
		}
		
	}
	
}
