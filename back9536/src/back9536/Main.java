package back9536;

import java.util.*;

// what the fXXk say?
public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		while ( T > 0) {
			
			String said[] = in.nextLine().split(" ");
			ArrayList<String> delete = new ArrayList<>();
			
			while ( true ) {
				
				String input[] = in.nextLine().split(" ");
				if ( input[0].equals("what") ) {
					break;
				}
				delete.add(input[2]);
				
			}
			
			ArrayList<String> ans = new ArrayList<>();
			for (int i = 0 ; i < said.length ; i++) {
				for ( int j = 0 ; j < delete.size() ; j++) {
					if ( said[i].equals(delete.get(j)) ) {
						said[i] = "";
						break;
					}
				}
			}
			
			for (int i = 0 ; i < said.length ; i++) {
				if ( !said[i].equals("")) {
					ans.add(said[i]+" ");
				}
			}
			
			for (int i = 0 ; i < ans.size() ; i++) {
				System.out.print(ans.get(i));
			}
			
			T--;
		}
	}
}
