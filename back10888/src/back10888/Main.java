package back10888;

import java.io.*;
import java.util.*;

public class Main {
	
	static int parent[];
	static int cnt[];
	static long sum[];
	
	public static int find(int x) {
		if ( parent[x] == x) {
			return x;
		}else {
			return parent[x] = find(parent[x]);
		}
	}
	
	public static void merge(int a,int b) {
		int A = find(a);
		int B = find(b);
		
		if ( A != B) {
			parent[B] = A;
			cnt[A] += cnt[B];
			cnt[B] = 1;
		}
		
	}
	
	public static long new_sum(int x) {
		return (long)x * (long)( x - 1 ) * (long)( x + 1 ) / 6 ;
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		cnt = new int[N+1];
		sum = new long[N+1];
	
		for ( int i = 1 ; i <= N ; i++) {
			parent[i] = i;
			cnt[i] = 1;
			sum[i] = sum[i-1] + i;
		}
		
		long pairs = 0;
		long bridges = 0;

		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < N-1 ; i++) {
			
			int k = Integer.parseInt(br.readLine());
			
			int k1 = find(k);
			int k2 = find(k+1);
			
			pairs -= sum[cnt[k1]] + sum[cnt[k2]];
			bridges -= new_sum(cnt[k1]) + new_sum(cnt[k2]);
			merge(k1,k2);
			bridges += new_sum(cnt[k1]);
			pairs += sum[cnt[k1]] * sum[cnt[k2]];
			sb.append(pairs+" "+bridges+"\n");
			
		}
		
		System.out.print(sb);
	}
}
