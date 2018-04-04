package back12844;

import java.util.Scanner;

public class Main {
	static int tree[];
	static int arr[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		arr = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		int H = (int)Math.ceil(Math.log(N)/Math.log(2));
		
		tree = new int[(1<<H+1)];
		init(1,0,N-1);
		
		int M = in.nextInt();
		for ( int i = 0 ; i < M ; i++) {
			int com = in.nextInt();
			if ( com == 1) {
				int a = in.nextInt();
				int b = in.nextInt();
				int c = in.nextInt();
				
			}else {
				int a = in.nextInt();
				int b = in.nextInt();
				System.out.print(xor(1,0,N-1,a,b));
			}
		}
		
	}
	
	public static int init(int node,int start,int end) {
		if ( start == end) {
			return tree[node] = arr[start];
		}else {
			return tree[node] = init(node*2,start,(start+end)/2)^init(node*2+1,(start+end)/2+1,end);
		}
	}
	
	public static int update(int node,int start,int end,int idx,int value) {
		if ( idx < start || idx > end) {
			return tree[node];
		}
		if ( start == end ) {
			return tree[node] = value;
		}
		
		return tree[node] = update(node*2,start,(start+end)/2,idx,value) ^ update(node*2+1,(start+end)/2+1,end,idx,value);
		
	}
	
	public static int xor(int node,int start,int end,int left,int right) {
		if ( left > end || right < start) {
			return 0;
		}
		if ( left <= start && end <= right) {
			return tree[node];
		}
		
		return xor(node*2,start,(start+end)/2,left,right)^xor(node*2,(start+end)/2+1,end,left,right);
	}
}
