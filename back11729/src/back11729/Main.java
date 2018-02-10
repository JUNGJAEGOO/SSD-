package back11729;

import java.util.Scanner;

public class Main {
	static int sum = -1;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int K = in.nextInt();
		
		hanoi(K,1,2,3);
		System.out.println(sum);
		System.out.print(sb);
	}
	
	public static void hanoi(int cnt,int from,int by,int to) {
		
		if ( cnt == 0) {
			sum++;
			return;
		}
		
		hanoi(cnt-1,from,to,by);
		//System.out.println(from+" ¿¡¼­ "+to);
		sb.append(from+" "+to+"\n");
		hanoi(cnt-1,by,from,to);
		
	}
}
