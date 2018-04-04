package back1969;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input[] = in.nextLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		String arr[] = new String[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextLine();
		}
		
		int A[] = new int [M];
		int C[] = new int [M];
		int T[] = new int [M];
		int G[] = new int [M];
		
		for ( int i = 0 ; i < N ; i++) {
			
			for ( int j = 0 ; j < M ; j++) {
				if ( arr[i].charAt(j) == 'A') {
					A[j]++;
				}else if ( arr[i].charAt(j) == 'C') {
					C[j]++;
				}else if ( arr[i].charAt(j) == 'T') {
					T[j]++;
				}else if ( arr[i].charAt(j) == 'G') {
					G[j]++;
				}
			}
		}
		
		String res = "";
		for ( int i = 0 ; i < M ; i++) {
			
			int same = 0;
			ArrayList<Character> select = new ArrayList<>();
			
			int max = -1;
			
			if ( A[i] > max) {
				max = A[i];
				select.add('A');
			}
			
			if ( C[i] > max) {
				max = C[i];
				select = new ArrayList<>();
				select.add('C');
				same = 0;
			}else if( C[i] == max) {
				select.add('C');
				same++;
			}
			
			if ( G[i] > max) {
				max = G[i];
				select = new ArrayList<>();
				select.add('G');
				same = 0;
			}else if ( G[i] == max) {
				select.add('G');
				same++;
			}
			
			if ( T[i] > max) {
				max = T[i];
				select = new ArrayList<>();
				select.add('T');
				same = 0;
			}else if ( T[i] == max) {
				select.add('T');
				same++;
			}
			
			//System.out.println(i+" "+select);
			//System.out.println(select.contains('A'));
			
			if ( same == 0) {
				res += select.get(0);
			}else {
				
				if( select.contains('A') ) {
					res += "A";
				}else if ( select.contains('C')) {
					res += "C";
				}else if ( select.contains('G')) {
					res += "G";
				}else if ( select.contains('T')) {
					res += "T";
				}
				
			}
			
			
		}
		
		//System.out.println(A[9]+" "+T[9]);
		int sum = 0;
		System.out.println(res);
		for ( int i = 0 ; i < N ; i++) {
			
			for ( int j = 0 ; j < M ; j++) {
				if ( arr[i].charAt(j) != res.charAt(j) ) {
					sum++;
				}
			}
		}
		System.out.println(sum);
		
	}
}
