package back10811;

import java.util.*;

public class Maion {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		
		int list[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			list[i] = i+1;
		}
		
		for ( int i = 0 ; i < M ; i++) {
			int start = in.nextInt();
			int end = in.nextInt();
			//System.out.println(start+" "+end);
			ArrayList<Integer> tmp = new ArrayList<>();
			for ( int j = start ; j <= end ; j++) {
				//System.out.println(j+" "+list[j-1]);
				tmp.add(list[j-1]);
			}
			//System.out.println(tmp);
			Collections.reverse(tmp);
			//System.out.println(tmp);
			
			for (int j = start ; j <= end ; j++) {
				list[j-1] = tmp.get(j-start);
			}
		}
		for (int i = 0 ; i < list.length ; i++) {
			System.out.print(list[i]+" ");
		}
	}
}
