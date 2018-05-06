package back2784;

import java.util.*;

public class Main {
	static String arr[];
	static boolean visit[];
	static ArrayList<ArrayList<String>> res = new ArrayList<>();
	
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		arr = new String[6];
		for (int i = 0 ; i < 6 ; i++) {
			arr[i] = in.nextLine();
		}
		
		visit = new boolean[6];
		
		make(0,new ArrayList<String>());
		
		//System.out.println(res.size());
		
		ArrayList<String> ANS = new ArrayList<>();
		
		if ( res.size() == 0) {
			System.out.print(0);
			return;
		}
		
		for ( int i = 0 ; i < res.size() ; i++) {
			String tmp = "";
			for ( int j = 0 ; j < res.get(i).size() ; j++) {
				tmp += res.get(i).get(j);
			}
			
			if ( !ANS.contains(tmp) ) {
				ANS.add(tmp);
			}
		}
		
		Collections.sort(ANS);
		System.out.println(ANS);
		String A = ANS.get(0);
		
		String a = A.substring(0, 3);
		String b = A.substring(3, 6);
		String c = A.substring(6, 9);
		
		System.out.print(a+"\n"+b+"\n"+c);
	}
	
	public static void make(int len,ArrayList<String> str) {
		if ( len == 3) {
			
			boolean pass = ok(str);
			if ( pass ) {
				ArrayList<String> tmp = new ArrayList<>();
				for ( int i = 0 ; i < 3 ; i++) {
					tmp.add(str.get(i));
				}
				res.add(tmp);
			}
			
			return;
		}
		
		for ( int i = 0 ; i < 6 ; i++) {
			if ( !visit[i]) {
				
				visit[i] = true;
				str.add(arr[i]);
				make(len+1,str);
				str.remove(str.size()-1);
				visit[i] = false;
				
			}
		}
	}
	
	public static boolean ok(ArrayList<String> list) {
		
		//System.out.println(list);
		
		String word[] = new String[6];
		word[0] = list.get(0);
		word[1] = list.get(1);
		word[2] = list.get(2);
		word[3] = String.valueOf(list.get(0).charAt(0)) + 
				String.valueOf(list.get(1).charAt(0)) + 
				String.valueOf(list.get(2).charAt(0));
		word[4] = String.valueOf(list.get(0).charAt(1)) + 
				String.valueOf(list.get(1).charAt(1)) + 
				String.valueOf(list.get(2).charAt(1));
		word[5] = String.valueOf(list.get(0).charAt(2)) + 
				String.valueOf(list.get(1).charAt(2)) + 
				String.valueOf(list.get(2).charAt(2));
		
		//System.out.println(word[3]+" "+word[4]+" "+word[5]);
		
		boolean OK[] = new boolean[6];
		boolean use[] = new boolean[6];
		
		for ( int i = 0 ; i < 6 ; i++) {
			
			for ( int j = 0 ; j < 6 ; j++) {
				
				if ( use[j] == false) {
					if ( arr[i].equals(word[j]) ) {
						OK[i] = true;
						use[j] = true;
						break;
					}
				}
				
			}
		
		}
		int ans = 0;
		for ( int i = 0 ; i < 6 ; i++) {
			if ( OK[i]) {
				ans++;
			}
		}
		
		if ( ans == 6) {
			return true;
		}else {
			return false;
		}
		
	}
}
