package back11656;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		char now[] = str.toCharArray();
		
		TreeSet<String> list = new TreeSet<>();
		for ( int i = 0 ; i < now.length ; i++) {
			
			list.add(str.substring(i,str.length()));
			
		}
		
		Iterator itr = list.iterator();
		while ( itr.hasNext() ) {
			
			System.out.println(itr.next());
			
		}
		
		
	}
}
