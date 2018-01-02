package back1662;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		char inner[] = input.toCharArray();
		
		Stack<Character> st = new Stack<>();
		
		int cnt = 0;
		int num  = 0;
		for ( int i = 0 ; i < inner.length ; i++) {
			if ( inner[i] == '(' ) {
				num++;
			}
		}
		System.out.println(num);
		while ( true ) {
			if ( inner[cnt] != ')' ) {
				st.push(inner[cnt]);
				cnt++;
			}else {
				int len = 0;
				while ( st.peek() != '(') {
					len++;
				}
				System.out.println(len);
				
				st.pop(); // '(' Á¦°Å
				num--;
				int banbok = Integer.parseInt(String.valueOf(st.pop()));
				System.out.println("banbok is "+banbok);
				for ( int i = 0 ; i < banbok ; i++) {
					
				}
			}
			
			if ( num == 0) {
				break;
			}
		}
		
		int ans = 0;
		while ( !st.isEmpty() ) {
			//System.out.print(st.peek());
			st.pop();
			ans++;
		}
		System.out.println();
		System.out.println(ans);
		
	}
}
