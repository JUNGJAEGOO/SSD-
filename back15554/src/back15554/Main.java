package back15554;

import java.math.BigInteger;
import java.util.*;

public class Main {
	static int maxtree[];
	static int mintree[];
	static long arr[][];
	
	public static int maxinit(int node,int start,int end) {
		if ( start == end) {
			return maxtree[node] = (int)arr[start][1];
		}else {
			return maxtree[node] = Math.max(maxinit(node*2,start,(start+end)/2), maxinit(node*2+1,(start+end)/2+1,end));
		}
	}
	
	public static int max(int node,int start,int end,int left,int right) {
		if ( start > right || end < left ) {
			return -1;
		}
		if ( start >= left && right >= end) {
			return maxtree[node];
		}
		return Math.max(max(node*2,start,(start+end)/2,left,right), max(node*2+1,(start+end)/2+1,end,left,right) );
	}
	
	public static int mininit(int node,int start,int end) {
		if ( start == end) {
			return mintree[node] = (int)arr[start][1];
		}else {
			return mintree[node] = Math.min(mininit(node*2,start,(start+end)/2), mininit(node*2+1,(start+end)/2+1,end));
		}
	}
	
	public static int min(int node,int start,int end,int left,int right) {
		if ( start > right || end < left ) {
			return 1000000001;
		}
		if ( start >= left && right >= end) {
			return mintree[node];
		}
		return Math.min(min(node*2,start,(start+end)/2,left,right), min(node*2+1,(start+end)/2+1,end,left,right) );
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int H = (int)Math.ceil(Math.log(N)/Math.log(2));
		mintree = new int[1<<(H+1)];
		maxtree = new int[1<<(H+1)];
		
		arr = new long[N][2];
		for (int i = 0 ; i < N ; i++) {
			arr[i][0] = in.nextInt(); // 크기
			arr[i][1] = in.nextInt(); // 가치
		}
		
		mininit(1,0,N-1);
		maxinit(1,0,N-1);
		int left = 0;
		int right = 0;
		BigInteger sum = BigInteger.valueOf(arr[0][0]);
		BigInteger ans = BigInteger.ZERO;
		while ( true ) {
			
			int max = max(1,0,N-1,left,right);
			int min = min(1,0,N-1,left,right);
			BigInteger tmp = sum.subtract( BigInteger.valueOf(max).subtract(BigInteger.valueOf(min)) );
			if ( tmp.compareTo(ans) >= 0 ) {
				ans = tmp;
			}
			System.out.println(sum+" "+tmp+" "+max+","+min);
			
			if ( tmp.compareTo(sum) > 0 ) {
				right++;
				if ( right == N) {
					break;
				}
				sum.add(BigInteger.valueOf(arr[right][0]));
			}else if ( tmp.compareTo(sum) == 0){
				right++;
				if ( right == N) {
					break;
				}
				sum.add(BigInteger.valueOf(arr[right][0]));
			}else {
				sum.subtract(BigInteger.valueOf(arr[left][0]));
				left++;
			}

			
			
		}
	}
	
	
}
