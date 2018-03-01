package back11866;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for ( int i = 1 ; i <= N ; i++) {
			list.add(i);
		}
		int len = list.size(); 
		int idx = M-1;
		ArrayList<Integer> ans = new ArrayList<>();
		while ( true ) {
			
			if ( list.size() == 1) {
				break;
			}
			
			ans.add(list.get(idx));
			list.remove(idx);
			idx = ((idx+M-1)%list.size());
			
		}
		
		System.out.print("<");
		for (int i = 0 ; i < ans.size() ; i++) {
			System.out.print(ans.get(i)+", ");
		}
		System.out.print(list.get(0)+">");
	}
}
