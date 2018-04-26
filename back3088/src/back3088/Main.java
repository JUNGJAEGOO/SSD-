package back3088;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N =in.nextInt();
		
		ArrayList<Integer> list[] = new ArrayList[1_000_001];
		for ( int i = 0 ; i < 1_000_001  ; i++ ) {
			list[i] = new ArrayList<>();
		}
		
		int arr1[] = new int[N];
		int arr2[] = new int[N];
		int arr3[] = new int[N];
		
		for ( int i = 0 ; i < N ; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			list[a].add(i);
			list[b].add(i);
			list[c].add(i);
			arr1[i] = a;
			arr2[i] = b;
			arr3[i] = c;
		}
		
		int cnt = 0;
		boolean crushed[] = new boolean[N+1];
		for ( int i = 0 ; i < N  ; i++) {
			
			 //System.out.println(i+" "+crushed[i]);
			
			 if ( crushed[i] == true) {
				 
			 }
			 else {
				 cnt++;
			 }
			 
			 for( int j = 0 ; j < list[arr1[i]].size() ; j++) {
				 //System.out.println(list[arr1[i]].get(j));
				 if ( list[arr1[i]].get(j) >= i) {
					 crushed[list[arr1[i]].get(j)] = true;
				 }
			 }
			 for( int j = 0 ; j < list[arr2[i]].size() ; j++) {
				 //System.out.println(list[arr2[i]].get(j));
				 if ( list[arr2[i]].get(j) >= i) {
					 crushed[list[arr2[i]].get(j)] = true;
				 }
			 }
			 for( int j = 0 ; j < list[arr3[i]].size() ; j++) {
				 //System.out.println(list[arr3[i]].get(j));
				 if ( list[arr3[i]].get(j) >= i) {
					 crushed[list[arr3[i]].get(j)] = true;
				 }
			 }
			 
		}
		System.out.print(cnt);
	}
}
