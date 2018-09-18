package back7570;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int arr[] = new int[N+1];
		int r = 0;
		
		for ( int i = 0 ; i < N ; i++) {
			int x  = Integer.parseInt(st.nextToken());
			arr[x] = arr[x-1] + 1;
			if ( arr[x] > r) r = arr[x];
		}
		
		System.out.print(N-r);
	}

}