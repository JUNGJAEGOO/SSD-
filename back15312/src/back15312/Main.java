package back15312;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int heoik[] = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
		
		char[] A = in.nextLine().toCharArray();
		char[] B = in.nextLine().toCharArray();
		
		int numA[] = new int[A.length];
		for ( int i = 0 ; i < A.length ; i++) {
			numA[i] = heoik[A[i]-'A'];
		}
		int numB[] = new int[B.length];
		for ( int i = 0 ; i < B.length ; i++) {
			numB[i] = heoik[B[i]-'A'];
		}
		
		ArrayList<Integer> go = new ArrayList<>();
		ArrayList<Integer> tmp = new ArrayList<>();
		
		for ( int i = 0 ; i < A.length ; i++) {
			go.add(numA[i]);
			go.add(numB[i]);
		}
		
		
		while ( true ) {
			
			System.out.println(go);
			
			if ( go.size() == 2) {
				System.out.println(go.get(0)+""+go.get(1));
				break;
			}else {
				
				tmp = new ArrayList<>();
				for ( int i = 1 ; i< go.size() ; i++) {
					tmp.add((go.get(i)+go.get(i-1))%10);
				}
				
				go = new ArrayList<Integer>();
				for ( int i = 0 ; i < tmp.size() ; i++ ) {
					go.add(tmp.get(i));
				}
			}
			
		}
		
	}
}
