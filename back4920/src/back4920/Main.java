package back4920;

import java.util.*;

public class Main {
	static int Ix[] = {0,0,0,0};
	static int Iy[] = {0,1,2,3};
	static int revIx[] = {0,1,2,3};
	static int revIy[] = {0,0,0,0};
	static int squareX[] = {0,0,1,1};
	static int squareY[] = {0,1,0,1};
	
	static int L1X[] = {0,1,1,1};
	static int L1Y[] = {0,0,1,2};
	static int L2X[] = {0,1,2,2};
	static int L2Y[] = {0,0,0,-1};
	static int L3X[] = {0,0,0,1};
	static int L3Y[] = {0,1,2,2};
	static int L4X[] = {0,0,1,2};
	static int L4Y[] = {0,1,0,0};
	
	static int Fuck1X[] = {0,0,-1,0};
	static int Fuck1Y[] = {0,1,1,2};
	static int Fuck2X[] = {0,1,1,2};
	static int Fuck2Y[] = {0,0,1,0};
	static int Fuck3X[] = {0,1,1,2};
	static int Fuck3Y[] = {0,0,-1,0};
	static int Fuck4X[] = {0,0,1,0};
	static int Fuck4Y[] = {0,1,1,2};
	
	static int S1X[] = {0,-1,-1,-2};
	static int S1Y[] = {0,0,1,1};
	static int S2X[] = {0,0,1,1};
	static int S2Y[] = {0,1,1,2};
	static int S3X[] = {0,0,-1,-1};
	static int S3Y[] = {0,1,1,2};
	static int S4X[] = {0,1,1,2};
	static int S4Y[] = {0,0,1,1};
	
	static int mat[][];
	static int N;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = 1;
		
		while (true) {
			
			N = in.nextInt();
			if ( N == 0) {
				break;
			}
			mat = new int[N][N];
			for (int i = 0 ; i < N ; i++) {
				for (int j = 0 ; j < N ; j++) {
					mat[i][j] = in.nextInt();
				}
			}
			
			long ans = 0;
			int num = 0;
			
			for (int i = 0 ; i < N ; i++) {
				long sum = 0;
				
				for (int j = 0 ; j < N ; j++) {
					//System.out.println(i+","+j);
					sum = 0;
					for (int s = 0 ; s < 4 ; s++) {
						if ( i+ Ix[s] < 0 || i+Ix[s] >= N || j+Iy[s] < 0 || j+Iy[s] >= N  ) {
							sum = 0;
							break;
						}
						sum += mat[i+Ix[s]][j+Iy[s]];
					}
					if ( sum != 0 ) {
						num++;
					}
					//System.out.println(sum);
					ans = Math.max(ans, sum);
					
					sum = 0;
					for (int s = 0 ; s < 4 ; s++) {
						if ( i+ revIx[s] < 0 || i+revIx[s] >= N || j+revIy[s] < 0 || j+revIy[s] >= N  ) {
							sum = 0;
							break;
						}
						sum += mat[i+revIx[s]][j+revIy[s]];
					}
					if ( sum != 0 ) {
						num++;
					}
					//System.out.println(sum);
					ans = Math.max(ans, sum);
					
					sum = 0;
					for (int s = 0 ; s < 4 ; s++) {
						if ( i+ squareX[s] < 0 || i+squareX[s] >= N || j+squareY[s] < 0 || j+squareY[s] >= N  ) {
							sum = 0;
							break;
						}
						sum += mat[i+squareX[s]][j+squareY[s]];
					}
					if ( sum != 0 ) {
						num++;
					}
					//System.out.println(sum);
					ans = Math.max(ans, sum);
					
					sum = 0;
					for (int s = 0 ; s < 4 ; s++) {
						if ( i+ L1X[s] < 0 || i+L1X[s] >= N || j+L1Y[s] < 0 || j+L1Y[s] >= N  ) {
							sum = 0;
							break;
						}
						sum += mat[i+L1X[s]][j+L1Y[s]];
					}
					if ( sum != 0 ) {
						num++;
					}
					//System.out.println(sum);
					ans = Math.max(ans, sum);
					
					sum = 0;
					for (int s = 0 ; s < 4 ; s++) {
						if ( i+ L2X[s] < 0 || i+L2X[s] >= N || j+L2Y[s] < 0 || j+L2Y[s] >= N  ) {
							sum = 0;
							break;
						}
						sum += mat[i+L2X[s]][j+L2Y[s]];
					}
					if ( sum != 0 ) {
						num++;
					}
					//System.out.println(sum);
					ans = Math.max(ans, sum);
					
					sum = 0;
					for (int s = 0 ; s < 4 ; s++) {
						if ( i+ L3X[s] < 0 || i+L3X[s] >= N || j+L3Y[s] < 0 || j+L3Y[s] >= N  ) {
							sum = 0;
							break;
						}
						sum += mat[i+L3X[s]][j+L3Y[s]];
					}
					if ( sum != 0 ) {
						num++;
					}
					//System.out.println(sum);
					ans = Math.max(ans, sum);
					
					sum = 0;
					for (int s = 0 ; s < 4 ; s++) {
						if ( i+ L4X[s] < 0 || i+L4X[s] >= N || j+L4Y[s] < 0 || j+L4Y[s] >= N  ) {
							sum = 0;
							break;
						}
						sum += mat[i+L4X[s]][j+L4Y[s]];
					}
					if ( sum != 0 ) {
						num++;
					}
					//System.out.println(sum);
					ans = Math.max(ans, sum);
					
					
					sum = 0;
					for (int s = 0 ; s < 4 ; s++) {
						if ( i+ Fuck1X[s] < 0 || i+Fuck1X[s] >= N || j+Fuck1Y[s] < 0 || j+Fuck1Y[s] >= N  ) {
							sum = 0;
							break;
						}
						sum += mat[i+Fuck1X[s]][j+Fuck1Y[s]];
					}
					if ( sum != 0 ) {
						num++;
					}
					//System.out.println(sum);
					ans = Math.max(ans, sum);
					
					sum = 0;
					for (int s = 0 ; s < 4 ; s++) {
						if ( i+ Fuck2X[s] < 0 || i+Fuck2X[s] >= N || j+Fuck2Y[s] < 0 || j+Fuck2Y[s] >= N  ) {
							sum = 0;
							break;
						}
						sum += mat[i+Fuck2X[s]][j+Fuck2Y[s]];
					}
					if ( sum != 0 ) {
						num++;
					}
					//System.out.println(sum);
					ans = Math.max(ans, sum);
					
					sum = 0;
					for (int s = 0 ; s < 4 ; s++) {
						if ( i+ Fuck3X[s] < 0 || i+Fuck3X[s] >= N || j+Fuck3Y[s] < 0 || j+Fuck3Y[s] >= N  ) {
							sum = 0;
							break;
						}
						sum += mat[i+Fuck3X[s]][j+Fuck3Y[s]];
					}
					if ( sum != 0 ) {
						num++;
					}
					//System.out.println(sum);
					ans = Math.max(ans, sum);
					
					sum = 0;
					for (int s = 0 ; s < 4 ; s++) {
						if ( i+ Fuck4X[s] < 0 || i+Fuck4X[s] >= N || j+Fuck4Y[s] < 0 || j+Fuck4Y[s] >= N  ) {
							sum = 0;
							break;
						}
						sum += mat[i+Fuck4X[s]][j+Fuck4Y[s]];
					}
					if ( sum != 0 ) {
						num++;
					}
					//System.out.println(sum);
					ans = Math.max(ans, sum);
					
					sum = 0;
					for (int s = 0 ; s < 4 ; s++) {
						if ( i+ S1X[s] < 0 || i+S1X[s] >= N || j+S1Y[s] < 0 || j+S1Y[s] >= N  ) {
							sum = 0;
							break;
						}
						sum += mat[i+S1X[s]][j+S1Y[s]];
					}
					if ( sum != 0 ) {
						num++;
					}
					//System.out.println(sum);
					ans = Math.max(ans, sum);
					
					sum = 0;
					for (int s = 0 ; s < 4 ; s++) {
						if ( i+ S2X[s] < 0 || i+S2X[s] >= N || j+S2Y[s] < 0 || j+S2Y[s] >= N  ) {
							sum = 0;
							break;
						}
						sum += mat[i+S2X[s]][j+S2Y[s]];
					}
					if ( sum != 0 ) {
						num++;
					}
					//System.out.println(sum);
					ans = Math.max(ans, sum);
					
					sum = 0;
					for (int s = 0 ; s < 4 ; s++) {
						if ( i+ S3X[s] < 0 || i+S3X[s] >= N || j+S3Y[s] < 0 || j+S3Y[s] >= N  ) {
							sum = 0;
							break;
						}
						sum += mat[i+S3X[s]][j+S3Y[s]];
					}
					if ( sum != 0 ) {
						num++;
					}
					//System.out.println(sum);
					ans = Math.max(ans, sum);
					
					sum = 0;
					for (int s = 0 ; s < 4 ; s++) {
						if ( i+ S4X[s] < 0 || i+S4X[s] >= N || j+S4Y[s] < 0 || j+S4Y[s] >= N  ) {
							sum = 0;
							break;
						}
						sum += mat[i+S4X[s]][j+S4Y[s]];
					}
					if ( sum != 0 ) {
						num++;
					}
					//System.out.println(sum);
					ans = Math.max(ans, sum);
				}
			}
			
			System.out.println(num);
			System.out.println(T+". "+ans);
			T++;
		
		}
	}
}
