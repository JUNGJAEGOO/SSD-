package back15788;

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		Scanner in = new Scanner(System.in);
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		BigInteger mat[][] = new BigInteger[N][N];
		
		int X=0,Y=0;
		for ( int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for ( int j = 0 ; j < N ; j++) {
				mat[i][j] = new BigInteger(st.nextToken());
				if( mat[i][j].compareTo(BigInteger.valueOf(0)) == 0){
					X = i;
					Y = j;
				}
			}
		}
		
		BigInteger sum = BigInteger.ZERO;
		if ( X == 0) {
			for ( int i = 0 ; i < N ; i++) {
				sum = sum.add(mat[1][i]);
			}
		}else {
			for ( int i = 0 ; i < N ; i++) {
				sum = sum.add(mat[0][i]);
			}
		}
		
		BigInteger sum2 = BigInteger.ZERO;
		for ( int i = 0 ; i < N ; i++) {
			sum2 = sum2.add(mat[X][i]);
		}
		
		BigInteger diff = sum.subtract(sum2);
		
		mat[X][Y] = diff;
		
		
		for ( int i = 0 ; i < N ; i++) {
			BigInteger tmpsum = BigInteger.ZERO;
			for ( int j = 0 ; j < N ; j++) {
				tmpsum = tmpsum.add(mat[i][j]);
			}
			
			if ( tmpsum.compareTo(sum) != 0 ) {
				System.out.println(-1);
				return;
			}
		}
	
		for ( int i = 0 ; i < N ; i++) {
			BigInteger tmpsum = BigInteger.ZERO;
			for ( int j = 0 ; j < N ; j++) {
				tmpsum = tmpsum.add(mat[j][i]);
			}
			
			if ( tmpsum.compareTo(sum) != 0 ) {
				System.out.println(-1);
				return;
			}
		}
		
		int nx = 0;
		int ny = 0;
		BigInteger tmpsum = BigInteger.ZERO;
		while ( true ) {
			
			tmpsum = tmpsum.add(mat[nx][ny]);
			
			nx++;
			ny++;
			
			if ( nx >= N || ny >= N) {
				break;
			}
			
		}
		
		if ( tmpsum.compareTo(sum) != 0) {
			System.out.print(-1);
			return;
		}
		
		nx = 0;
		ny = N-1;
		tmpsum = BigInteger.ZERO;
		while ( true ) {
			
			tmpsum = tmpsum.add(mat[nx][ny]);
			
			nx++;
			ny--;
			
			if ( nx >= N || ny < 0) {
				break;
			}
			
		}
		
		if ( tmpsum.compareTo(sum) != 0) {
			System.out.print(-1);
			return;
		}
		
		System.out.print(diff);
		
	}
}
