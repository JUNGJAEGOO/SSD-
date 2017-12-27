package back11570;

import java.util.Scanner;

public class Main {
	static int d[][];
	static int arr[];
	static int N;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		arr = new int[2000];
		d = new int[2001][2001];
		for ( int i =  1 ; i <= N ; i++) {
			arr[i] = in.nextInt();
		}
		for ( int i = 0 ; i < 2001 ; i++) {
			for ( int j = 0 ; j < 2001 ; j++){
				d[i][j] = -1;
			} 
		}
		System.out.println(f(0,0));
		
	}
	
	public static int f(int A,int B) {
		
		if ( A == N || B == N ) {
			return 0;
		}
		
		int ret = d[A][B];
		if ( ret != -1 ) {
			return ret;
		}
		
		int nxt = Math.max(A, B)+1;
		//System.out.println(nxt);
		ret = 200000001;
		ret = Math.min(ret, f(nxt,B) + (A > 0 ? Math.abs(arr[A]-arr[nxt]):0));
		ret = Math.min(ret, f(A,nxt) + (B > 0 ? Math.abs(arr[B]-arr[nxt]):0));
		
		return ret;
	}
}
