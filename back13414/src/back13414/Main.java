package back13414;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp[] = br.readLine().split(" ");
		int K = Integer.parseInt(tmp[0]);
		int L = Integer.parseInt(tmp[1]);
		HashMap<String,Integer> hm = new HashMap<>();
		int cnt = 0;
		for (int i = 0 ; i < L  ; i++) {
			String inner = br.readLine();
			if ( hm.get(inner) == null) {
				hm.put(inner,cnt);
				cnt++;
			}else {
				hm.replace(inner,cnt);
				cnt++;
			}
		}
		
		Iterator it = sortByValue(hm).iterator();
		int COUNT = 0;
		StringBuilder sb = new StringBuilder();
		while ( it.hasNext() ) {
			String KEY = (String)it.next();
			sb.append(KEY+"\n");
			if ( COUNT == K-1) {
				break;
			}
			COUNT++;
		}
		
		System.out.print(sb);
	}
	
	public static List<String> sortByValue(HashMap map) {
		
		List<String> list = new ArrayList<>();
		list.addAll(map.keySet());
		
		Collections.sort(list,new Comparator() {

			@Override
			public int compare(Object arg0, Object arg1) {
				Object v1 = map.get(arg0);
				Object v2 = map.get(arg1);
				return ((Comparable)v1).compareTo(v2);
			}
			
		});
		
		return list;
	}
}
