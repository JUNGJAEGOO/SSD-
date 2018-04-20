package back4606;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		while ( true ) {
			
			String str = in.nextLine();
			if ( str.equals("#")) {
				break;
			}
			
			ArrayList<String> list = new ArrayList<>();
			for ( int i = 0 ; i < str.length() ; i++) {
				list.add(String.valueOf(str.charAt(i)));
			}
			
			for ( int i = 0 ; i < list.size() ; i++) {
				if ( list.get(i).equals("%")) {
					list.set(i, "%25");
				}else if ( list.get(i).equals(" ")) {
					list.set(i, "%20");
				}else if ( list.get(i).equals("!")) {
					list.set(i, "%21");
				}else if ( list.get(i).equals(")")) {
					list.set(i, "%29");
				}else if ( list.get(i).equals("(")) {
					list.set(i, "%28");
				}else if ( list.get(i).equals("$")) {
					list.set(i, "%24");
				}else if ( list.get(i).equals("*")) {
					list.set(i, "%2a");
				}
			}
			//System.out.println(list);
			
			String res = "";
			
			for ( int i = 0 ; i < list.size() ; i++) {
				res = res.concat(list.get(i));
			}
			
			sb.append(res+"\n");
		}
		
		System.out.print(sb);
	}
}
