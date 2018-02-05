package back10999;

import java.util.Scanner;

public class Main {
	static int arr[];
	static long tree[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		
		int H = (int)Math.ceil(Math.log(N)/Math.log(2)); 
		
		arr = new int[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		int M = in.nextInt();
		tree = new long[1<<(H+1)];
		init(1,0,N-1);
		for (int i = 0 ; i < M ; i++) {
			int from = in.nextInt();
			int to = in.nextInt();
			System.out.println(sum(1,0,N-1,from-1,to-1));
			
		}
	}
	
	public static long init(int node,int start,int end) {
		if (start == end) {
			return tree[node] = arr[start];
		}else {
			return tree[node] = init(node*2,start,(start+end)/2) +init(node*2+1,(start+end)/2+1,end);
		}
	}
	
	public static long update(int node,int start,int end,int idx,int val) {
		if ( idx < start || idx > end) {
			return tree[node];
		}
		if ( start == end) {
			return tree[node] = val;
		}
		return tree[node] = update(node*2,start,(start+end)/2,idx,val) + update(node*2+1,(start+end)/2+1,end,idx,val);
	}
	
	public static long sum(int node,int start,int end,int left,int right ) {
		if ( left > end || right < start) {
			return 0;
		}
		if ( left <= start && right >= end) {
			return tree[node];
		}
		
		return sum(node*2,start,(start+end)/2,left,right)+sum(node*2+1,(start+end)/2+1,end,left,right);
	}
}
