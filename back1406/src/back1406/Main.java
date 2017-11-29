package back1406;
import java.io.*;
import java.util.*;

public class Main {

	static LinkedList<Character> list;
	static ListIterator<Character> it;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new LinkedList<>();
		
		//char input[] = br.readLine().toCharArray();
		String input  = br.readLine();
		
		/*String input = "";
		for ( int i = 0 ; i <  5000 ; i++) {
			input+="a";
		}*/
		
		for ( int i = 0 ; i < input.length() ; i++) {
			list.add(input.charAt(i));
		}
		
		it = list.listIterator(list.size());
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		
		for ( int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			char command = st.nextToken().charAt(0);
			char want = 0;
			if ( command == 'P') {
				want = st.nextToken().charAt(0);
			}
			switch (command) {
			case 'L': if (it.hasPrevious()) {it.previous(); }  break; 
			case 'D': if (it.hasNext()) {it.next();}  break;
			case 'B': delete(); break;
			case 'P': insert(want); break;
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		for ( char c : list) {
			sb.append(c);
		}
		
		System.out.print(sb);
	}
	
	public static void delete( ) {
		if ( it.hasPrevious() ) {
			it.previous();
			it.remove();
		}
		
	}
	
	public static void insert(char in) {
		it.add(in);
	}
}
