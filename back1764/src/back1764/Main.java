package back1764;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String,Integer> hm = new HashMap<>();
		
		for ( int  i = 0 ; i < N ; i++) {
			String tmp = br.readLine();
			hm.put(tmp,1);
		}
		
		int length = 0;
		for ( int  i = 0 ; i < M ; i++) {
			String tmp = br.readLine();
			if ( hm.get(tmp) == null ) {
				hm.put(tmp,1);
			}else {
				int tmpnum = hm.get(tmp);
				hm.remove(tmp);
				hm.put(tmp,tmpnum+1);
				length++;
			}
		}
		
		Iterator<String> it = hm.keySet().iterator();
		String result[] = new String[length];
		int count = 0;
		while ( it.hasNext() ) {
			String tmp =it.next();
				
				if ( hm.get(tmp) >= 2) {
					//System.out.println(hm.get(tmp)+" "+tmp);
					result[count] = tmp;
					count++;
				}
			
		}
		
		Arrays.sort(result);
		StringBuilder sb = new StringBuilder();
		System.out.println(result.length);
		for (int i = 0 ; i < result.length ; i++) {
			sb.append(result[i]+"\n");
		}
		System.out.println(sb);
		
	}
}
