package back2675;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while ( T > 0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int banbok = Integer.parseInt(st.nextToken());
			char[] str = st.nextToken().toCharArray();
			ArrayList<String> ans = new ArrayList<>();
			for (int i = 0 ; i < str.length ; i++) {
				String tmp = "";
				for (int j = 0 ; j < banbok ; j++) {
					tmp += str[i];
				}
				ans.add(tmp);
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0 ; i < ans.size() ; i++) {
				sb.append(ans.get(i));
			}
			
			System.out.println(sb);
			T--;
		}
		
	}
}
