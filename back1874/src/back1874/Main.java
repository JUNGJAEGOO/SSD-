package back1874;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		int list[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			list[i] = i+1;
		}
		Stack<Integer> st = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		st.push(1);
		sb.append("+\n");
		
		int cnt = 0;
		int y = 1;
		int res = 0;
		while ( true ) {
			//System.out.println("ÇöÀç ¶Ñ²±Àº "+st.peek());
			
			if ( st.isEmpty() || arr[cnt] > st.peek() ) {
				if ( y >= list.length ) {
					break;
				}
				st.push(list[y]);
				sb.append("+\n");
				y++;
			}else if ( arr[cnt] < st.peek()) {
				st.pop();
				sb.append("-\n");
			}else if ( arr[cnt] == st.peek() ) {
				st.pop();
				sb.append("-\n");
				cnt++;
				res++;
			}
			
			if ( cnt == arr.length ) {
				break;
			}
			
		}
		
		if ( res != N) {
			System.out.println("NO");
		}else {
			System.out.print(sb);
		}
		
	}
}
