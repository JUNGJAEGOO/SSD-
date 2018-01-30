package back5670;

import java.util.Scanner;

public class Main {
	static String arr[];
	static node root;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		while ( in.hasNext() ) {
			int N = Integer.parseInt(in.nextLine());
			if ( N == 0) {
				break;
			}
			
			root = new node();
			
			arr = new String[N];
			for (int i = 0 ; i < N ; i++) {
				arr[i] = in.nextLine();
				/*if ( root.childs[arr[i].charAt(0)-'a'] == null) {
					root.childs[arr[i].charAt(0)-'a'] = new node();
					root.child++;
				}*/
				makeTrie(root,arr[i],-1);
			}
			
		
			int tmp = 0;
			tmp += N;
			
			
			for (int i = 0 ; i < N ; i++) {
				int ans;
				tmp += searchTrie(root.childs[arr[i].charAt(0)-'a'],arr[i],0,0);
				//System.out.println(tmp);
			}
			
			System.out.format("%.2f\n",(double)tmp/N);
			
		}
	}
	
	public static void makeTrie(node now,String input,int idx) {
		
		if ( idx == input.length()-1 ) {
			now.terminal = true;
			return;
		}
		else {

			if ( now.childs[input.charAt(idx+1)-'a'] == null) {
				now.childs[input.charAt(idx+1)-'a'] = new node();
				//System.out.println("up");
				now.child++;
			}
			makeTrie(now.childs[input.charAt(idx+1)-'a'],input,idx+1);
		}
		
	}
	
	public static int searchTrie(node now,String input,int cnt,int idx) {
		
		//System.out.println(input+" "+idx);
		
		if ( idx == input.length()-1) {
			return cnt;
		}
		else if ( now.terminal  ) {
			//System.out.println("term "+input+" "+idx);
			return searchTrie(now.childs[input.charAt(idx+1)-'a'],input,cnt+1,idx+1);
		}
		else if (now.child >= 2){
			//System.out.println("chil "+input+" "+idx);	
			return searchTrie(now.childs[input.charAt(idx+1)-'a'],input,cnt+1,idx+1);
		}else {
			return searchTrie(now.childs[input.charAt(idx+1)-'a'],input,cnt,idx+1);
		}
		
	}
	
	public static class node{
		int child = 0;
		char now;
		boolean terminal = false;
		node[] childs = new node[26]; // a ดย 0 z ดย 25
		
		node() {
			for (int i = 0 ; i < 26 ; i++) {
				childs[i] = null;
			}
		}
	}
}
