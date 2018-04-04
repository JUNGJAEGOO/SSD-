package back14905;

import java.util.*;

public class Main {
	static ArrayList<Integer> list = new ArrayList<>();
	static boolean isPrime[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		isPrime = new boolean[100000001];
		eratos();
		
		while( in.hasNext() ) {
			int N = in.nextInt();
			if ( N < 8) {
				sb.append("Impossible.\n");
				continue;
			}else {
				if ( N % 2 == 0) {
					sb.append("2 2 ");
					find(N-4);
				}else {
					sb.append("2 3 ");
					find(N-5);
				}
			}
		}
		System.out.print(sb);
	}
	
	public static void eratos() {
		isPrime[1] = true;
		isPrime[0] = true;
		for ( int i = 2 ; i<= 100000000  ; i++) {
			if ( isPrime[i] == false) {
				list.add(i);
				for ( int j = i + i ; j <= 100000000 ; j = j + i) {
					if ( j > 100000000) {
						break;
					}
					isPrime[j] = true;
				}
			}
			
		}
	}
	
	public static void find(int x) {
		
		for ( int i = 0 ; i < list.size() ; i ++) {
			for ( int j = 0 ; j < list.size() ; j++) {
				if ( list.get(i) + list.get(j) == x){
					sb.append(list.get(i)+" "+list.get(j)+"\n");
					return;
				}
			}
			
		}
		
	}
}
