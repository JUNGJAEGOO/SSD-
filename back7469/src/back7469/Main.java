package back7469;

import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer> tree[];
	
	public static void update ( int node,int start,int end,int idx,int val) {
		
		if ( idx < start || idx > end) {
			return;
		}

		tree[node].add(val);
		
		if ( start != end) {
			int mid = (start+end) >> 1;
			update(node*2,start,mid,idx,val);
			update(node*2+1,mid+1,end,idx,val);
		}
		
	}
	
	public static int upper(int node,int l,int r,int x) {
		
		int L = l;
		int R = r;
		int ans = 0;
		System.out.print(tree[node]+" "+x);
		
		while ( L <= R ) {
			
			int M = (L+R) >> 1;
			
			if ( tree[node].get(M) > x) {
				R = M - 1;
			}else {
				L = M + 1;
				ans = M;
			}
			
		}
		
		return ans;
		
	}
	
	public static int query(int node,int start,int end,int left,int right,int w) {
		
		if ( left > end || right < start) {
			return 0;
		}
		if ( start <= left && right <= end) {
			return upper(node,tree[node].get(0),tree[node].get(tree[node].size()-1),w) 
					- tree[node].get(0);
		}
		
		int mid = (start+end)>>1;
		return query(node*2,start,mid,left,right,w) + query(node*2,mid+1,end,left,right,w);
		
	}
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int H = (int)Math.ceil(Math.log(n)/Math.log(2));
		tree = new ArrayList[1<<(H+1)];
		
		for ( int i = 0 ; i < 1<<(H+1) ; i++) {
			tree[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine()," ");
		int arr[] = new int[n];
		for ( int i = 0 ; i < n ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			update(1,0,n-1,i,arr[i]);
		}
		
		for ( int i = 0 ; i < n ; i++) {
			Collections.sort(tree[i]);
		}
		
		
		for ( int i = 0 ; i < m ; i++) {
			
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			
			int l = (int) -1e9;
			int r = (int) 1e9;
			
			while ( l <= r) {
				
				int mid = (l+r) >> 1;
				if( query(1,0,n-1,from-1,to-1,mid) >= target ) {
					r = mid;
				}else {
					l = mid + 1;
				}
				
			}
			
			System.out.println(l);
		}
		
		
		
	}
}
