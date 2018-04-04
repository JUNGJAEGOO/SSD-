package back14929;

import java.util.*;

public class Main {
	static long tree[];
	static int arr[];
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int H = (int)Math.ceil(Math.log(N)/Math.log(2));
		tree = new long[1<<(H+1)];
		arr = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		init(1,0,N-1);
		long sum = 0;
		for ( int i = 0 ; i < N-1 ; i++) {
			
			if ( i != N-2) {
				sum += arr[i] * sum(1,0,N-1,i+1,N);
			}else {
				sum += arr[i] * arr[i+1];
			}
		}
		
		System.out.println(sum);
	}
	
	public static long init(int node,int left,int right) {
		
		if ( left == right ) {
			return tree[node] = arr[left];  
		}else {
			return tree[node] = init(node*2,left,(left+right)/2) + init(node*2+1,(left+right)/2+1,right);
		}
	}
	
	public static long sum (int node,int start,int end,int left,int right) {
		if ( left > end || start > right ) {
			return 0;
		}
		if ( start >= left && right >= end) {
			return tree[node];
		}
		
		return sum(node*2,start,(start+end)/2,left,right) + sum(node*2+1,(start+end)/2+1,end,left,right);
	}
}
