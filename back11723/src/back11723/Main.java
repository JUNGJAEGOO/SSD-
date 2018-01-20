package back11723;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<Integer> hs = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < N ; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String com = st.nextToken();
			int x = 0;
			if ( !com.equals("all")  ) {
				if ( !com.equals("empty")) {
					x = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
			switch (com) {
			
			case "add" : hs.add(x);
						 break;
			case "remove" : if ( hs.contains(x) ) {
								hs.remove(x);
							}
							break;
			case "check" : if ( hs.contains(x) ) {
								sb.append("1\n");
							}
							else{
								sb.append("0\n");
							};
							break;
			case "toggle" : if ( hs.contains(x)) {
								hs.remove(x);
							}else{
								hs.add(x);
							};
							break;
			case "all" : hs = new HashSet<>();
						 for ( int j = 1 ; j<= 20 ; j++) {
							 hs.add(j);
						 }
						 break;
			case "empty" : hs = new HashSet<>(); 
						   break;
			
			}
			
			
		}
		System.out.print(sb);
	}
}
