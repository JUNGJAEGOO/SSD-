package back2866;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String info[] = in.nextLine().split(" ");
		int R = Integer.parseInt(info[0]);
		int C = Integer.parseInt(info[1]);
		char mat[][] = new char[R][C];
		for ( int i = 0 ; i < R ;i ++) {
			char tmp[] = in.nextLine().toCharArray();
			for ( int j = 0 ; j < C ; j++) {
				mat[i][j] = tmp[j];
			}
		}
		
		
		HashSet<String> hs[] = null;
		int cnt = 0;
		int idx = 0 ;
		
		hs = new HashSet[R];
		
		for ( int i = 0 ; i < R ; i++) {
			hs[i] = new HashSet<>();
		}
		
		for ( int s = 0 ; s < R ;s++) {
			for ( int i = 0 ; i < C ; i++) {
				StringBuilder str = new StringBuilder();
				for ( int j = idx ; j < R ; j++) {
				
					str.append(mat[j][i]);
				
				}
				//System.out.print(str+" ");
				hs[s].add(str.toString());
				
			}//System.out.println();
			idx++;
		}
		
		for ( int i = 0 ; i < R ; i++) {
			//System.out.println(hs[i].size());
			if ( hs[i].size() != C ) {
				System.out.println(i-1);
				break;
			}
		}
		
		
		
	}
}
