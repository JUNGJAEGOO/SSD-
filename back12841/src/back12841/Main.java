package back12841;

import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int inf = 100000000;
	static long sumA[];
	static long sumB[];
	static int bridge[];
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		
		bridge = new int[100010];
		for ( int i = 1 ; i <= N ; i++) {
			int cost = in.nextInt();
			bridge[i] = cost;
		}
		
		sumA= new long[100010];
		for  (int i = 1 ; i < N ; i++) {
			int cost = in.nextInt();
			sumA[i] = cost + sumA[i-1];
		}
		sumB = new long[100010];;
		for  (int i = 1 ; i < N ; i++) {;
			int cost = in.nextInt();
			sumB[i] = cost + sumB[i-1];
		}
		
		long min = Long.MAX_VALUE;
		int ans = 0;
		
		for ( int i = 0 ; i <= N-1 ; i++) {

			long tmp = sumA[i] + bridge[i+1] + sumB[N-1] - sumB[i];
			if ( tmp < min) {
				min = tmp;
				ans = i+1;
			}
			
		}
		
		System.out.print(ans+" "+min);
		
	}

}
