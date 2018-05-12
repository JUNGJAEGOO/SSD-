package back9437;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while  (true ) {
			
			int N = in.nextInt();
			
			if ( N == 0) {
				break;
			}
			
			int P = in.nextInt();
		
			ArrayList<Integer> page[] = new ArrayList[301];
			
			for ( int i = 0 ; i < 301 ; i++) {
				page[i] = new ArrayList<>();
			}
			
			int cnt = 0;
			int first = 1;
			int last = N;
			while ( true ) {
			
				page[cnt].add(first);
				first++;
				page[cnt].add(last);
				last--;
				
				
				page[cnt].add(first);
				page[cnt].add(last);
				first++;
				last--;
				
				if (  first+1 == last) {
					break;
				}
				cnt++;
				if ( cnt > 300) {
					break;
				}
			}
			
			/*for ( int i = 0 ; i < 10 ; i++) {
				System.out.println(page[i]);
			}*/
			
			for ( int i = 0 ; i < 301 ; i++) {
				if ( page[i].contains(P)) {
					
					Collections.sort(page[i]);
					for ( int j = 0 ; j < page[i].size() ; j++) {
						if ( page[i].get(j) == P) {
							continue;
						}
						System.out.print(page[i].get(j)+" ");
					}
					System.out.println();
					break;
				}
			}
		}
	}
}
