package back4889;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int k = 1;
		while( true) {
			
			char[] now = in.nextLine().toCharArray();
			if ( now[0] == '-') {
				return;
			}
			
			int cnt = 0;
			Stack<Character> st = new Stack<>();
			for (int i = 0 ; i < now.length ; i++) {
				
				
				if ( i > 0 && st.size() > 0) {
					
						if ( st.peek() == '{' && now[i] == '}') {
							st.pop();
						}else {
							st.add(now[i]);
						}
					
				}else if ( i == 0 || st.size() == 0) {
					st.add(now[i]);
				}

			}
			
			while ( !st.isEmpty() ) {
				
				char cur = st.pop();
				
				if ( st.peek() == '{' && cur == '}') {
					st.pop();
				}else if ( st.peek() == '{' && cur == '{') {
					st.pop();
					cnt++;
				}else if ( st.peek() == '}' && cur == '{') {
					st.pop();
					cnt+=2;
				}else if ( st.peek() == '}' && cur == '}') {
					st.pop();
					cnt++;
				}
				
			}
			
			System.out.println(k+". "+cnt);
			k++;
		}
	}
}
