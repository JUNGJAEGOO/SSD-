package back1298;

import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<Integer> list[];
	static int A[];
	static int B[];
	static int N;
	static boolean visit[];
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		
		list = new ArrayList[5001];
		visit = new boolean[101];
		A = new int[101];
		B = new int[101];
		
		for(int i=0;i< 5001;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		Arrays.fill(A, -1);
		Arrays.fill(B, -1);
		
		StringTokenizer st;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end	= Integer.parseInt(st.nextToken()) - 1;
			list[start].add(end);
		}
		
		int result = 0;
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<N;j++) { visit[j] = false; }
			if(DFS(i)) { result++; }
		}
		
		System.out.print(result);
		
		
	}
	
	
	
	public static boolean DFS(int start) {
		
		if( visit[start] ) { return false;}
		visit[start] = true;
		
		for(int i = 0 ; i < list[start].size() ; i++) {
		int tmp = list[start].get(i);
		
			if( B[tmp] == -1 || DFS(B[tmp]) ) {
				A[start] = tmp;
				B[tmp] = start;
				return true;
			}
		
		}
		
		return false;
		
	}
}