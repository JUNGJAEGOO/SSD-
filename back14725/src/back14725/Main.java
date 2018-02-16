package back14725;

import java.util.*;

public class Main {
	static TreeMap<String,tree> hm = new TreeMap<>();
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = Integer.parseInt(in.nextLine());

		for ( int i = 0 ; i < N ; i++) {
			String inner[] = in.nextLine().split(" ");
			int num = Integer.parseInt(inner[0]);
			TreeMap<String,tree> sub = hm;
			for (int j = 1 ; j <= num ; j++) {
					if ( !sub.containsKey(inner[j])) {
						sub.put(inner[j],new tree());
					}
					sub = sub.get(inner[j]).child;
			}
			
		}
		
		for( String name : hm.keySet()){
			
			DFS(name,"",hm);
			
		}
		
	}
	
	public static void DFS(String name,String depth,TreeMap<String,tree> tree ) {
		System.out.println(depth+name);
		
		for (String subname : tree.get(name).child.keySet() ) {
			DFS(subname,depth+"--",tree.get(name).child);
		}
	}
	
	public static class tree{
		TreeMap<String,tree> child;
		tree(){
			this.child = new TreeMap<>();
		}
	}

}
