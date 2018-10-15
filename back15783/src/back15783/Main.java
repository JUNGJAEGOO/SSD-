package back15783;

import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> adj[];
	static boolean visit[];
	static int p[];
    static int cnt[];
	
	public static void main(String args[]) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

        cnt = new int[N];
		p = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			p[i] = i;
            cnt[i] = 1;
		}
		
		for ( int i = 0 ; i < M ; i++) {
			st  = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
            
			if (find(from) != find(to) ){
				merge(from,to);
            }
		
		}
	
		int ans = 0;

		for ( int i = 0 ; i < N ; i++) {
			if ( p[i] == i) {
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	public static void merge(int x,int y) {
		int A = find(x);
		int B = find(y);
		if ( A == B) {
			return;
		}
		
		p[B] = A;
	}
	
	public static int find(int x) {
		if ( p[x] == x ) {
			return x;
		}else {
			return p[x] =find(p[x]);
		}
	}
}
