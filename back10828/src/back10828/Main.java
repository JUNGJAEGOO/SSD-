package back10828;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<Integer>();
		for ( int start = 0 ; start < N ; start++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			String com = st.nextToken();
			
			if ( com.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				s.push(x);
			}else if ( com.equals("top")) {
				if ( s.isEmpty() ) {
					System.out.println(-1);
				}else {
					System.out.println(s.peek());
				}
				
			}else if ( com.equals("size")) {
				System.out.println(s.size());
			}else if ( com.equals("empty")) {
				if ( s.isEmpty() ) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}else if ( com.equals("pop")) {
				if ( s.isEmpty() ) {
					System.out.println(-1);
				}else {
					System.out.println(s.pop());
				}
			}
			
		}
	}
}
