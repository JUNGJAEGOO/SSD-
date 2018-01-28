package back10868;

import java.util.*;
import java.io.*;

public class Main {
	static int arr[];
	static int tree[];
	static int inf = 1000000000;
	static void update(int node,int start,int end,int idx,int diff) {
		if ( start < idx || idx > end) {
			return;
		}
		//tree[idx] = Math.min(, b)
		if ( start != end) {
			update(node*2,start,(start+end)/2,idx,diff);
			update(node*2+1,(start+end)/2+1,end,idx,diff);
		}
	}
	
	static int init(int idx,int start,int end) {
		if ( start == end) {
			return tree[idx] = arr[start];
		}
		return tree[idx] = Math.min(init(idx*2,start,(start+end)/2), init(idx*2+1,(start+end)/2+1,end));
	}
	
	static long MIN(int node,int start,int end,int left,int right) {
		if ( left > end || right < start) {
			return inf; 
		}
		if ( start >= left && right >= end) {
			return tree[node];
		}
		return Math.min(MIN(node*2,start,(start+end)/2,left,right),MIN(node*2+1,(start+end)/2+1,end,left,right));
	}
	
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		//Scanner in = new Scanner(System.in);
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		int H = (int)Math.ceil((Math.log(N)/Math.log(2)));
		//System.out.println(H);
		//System.out.println(1<<(H+1));
		tree = new int[1<<(H+1)];
		
		for (int i = 0 ; i < N ; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		init(1,0,N-1);
		
		StringBuilder sb = new StringBuilder();
		
		for ( int i = 0 ; i < M ; i++) {
			st= new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			sb.append((MIN(1,0,N-1,x-1,y-1))+"\n");
		}
		
		System.out.print(sb);
	}
}
