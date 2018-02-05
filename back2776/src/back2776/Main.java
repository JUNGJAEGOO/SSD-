package back2776;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[])throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while ( T > 0) {
			
			
			int N = Integer.parseInt(br.readLine());
			HashMap<Integer,Integer> list = new HashMap<>();
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0 ; i < N ; i++) {
				list.put( Integer.parseInt(st.nextToken()) , 1 );
			}
			int M = Integer.parseInt(br.readLine());
			StringBuilder sb =new StringBuilder();
			st = new StringTokenizer(br.readLine()," ");
			
			for (int i = 0 ; i < M ; i++) {
				if ( list.get( Integer.parseInt(st.nextToken()) ) != null ) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
			}
			System.out.print(sb);
			
			T--;
		}
	}
}
