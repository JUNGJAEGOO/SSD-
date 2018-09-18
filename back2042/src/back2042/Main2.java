package back2042;

import java.io.*;
import java.util.*;

public class Main2 {
	static int N;
	static int M;
	static int K;
	static long arr[],tree[];
	static int H;
	
	public static long init(int node,int left,int right) {
		
		if ( left == right) {
			return tree[node] = arr[left];
		}
		int mid = (left+right)/2;
		
		return tree[node] = init(node*2,left,mid) + init(node*2+1,mid+1,right);
	}
	
	public static long update(int node,int idx,int val,int start,int end) {
		
		if ( idx < start || idx > end) {
			return tree[node];
		}
		
		if  ( start == end) {
			return tree[node] = val;
		}
		
		return tree[node] = update(node*2,idx,val,start,(start+end)/2) + update(node*2+1,idx,val,
				(start+end)/2+1,end);
	}
	
	public static long sum(int node,int left,int right,int start,int end) {
		
		if ( left > end || right < start) {
			return 0;
		}
		
		if ( start >= left && right >= end) {
			return tree[node];
		}
		
		return sum(node*2,left,right,start,(start+end)/2) + sum(node*2+1,left,right,(start+end)/2+1,end);
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new long[N+1];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
		}
		H = (int)Math.ceil(Math.log(N)/Math.log(2));
		tree = new long[(1<<(H+1))];
		
		init(1,0,N-1);
		
		for ( int i = 0 ; i < M+K ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int com = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if ( com == 1) {
				
				update(1,b-1,c,0,N-1);
				
			}else {
				
				System.out.println(sum(1,b-1,c-1,0,N-1));
			}
		}
		
	}
}
