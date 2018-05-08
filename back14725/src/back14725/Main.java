package back14725;

import java.util.*;

public class Main {
	static TreeMap<String,tree> root = new TreeMap<>();
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());

		for ( int i = 0 ; i < N ; i++) {
			
			StringTokenizer st = new StringTokenizer(in.nextLine()," ");
			
			int x = Integer.parseInt(st.nextToken());
			String key = st.nextToken();
			tree before = root.get(key);
			if ( before == null) {
				root.put(key, new tree() );
				before = root.get(key);
			}
			//System.out.println(root.get(key)+" "+before);
			
			while ( st.hasMoreTokens() ) {
				
				key = st.nextToken();
				//System.out.println("key is "+key);
				tree now = before.tr.get(key);
				if ( now == null) {
					before.tr.put(key, new tree());
					before = before.tr.get(key);
				}else {
					before = now;
				}
				
			}
		}
		
		Iterator itr = root.keySet().iterator();
		while(  itr.hasNext() ) {
			
			String key = (String)itr.next();
			
			print(root.get(key),key,"");
			
			
		}
		
	}
	
	public static void print(tree TREE,String k,String str) {
		if ( TREE.tr.size() == 0)  {
			System.out.println(str+k);
		}else {
			System.out.println(str+k);
			Iterator itr = TREE.tr.keySet().iterator();
			while ( itr.hasNext()) {
				
				String Key = (String)itr.next();
				print(TREE.tr.get(Key),Key,str+"--");
				
			}
		}
	}
	
	public static class tree{
		
		TreeMap<String,tree> tr = new TreeMap<>();
		
	}

}
