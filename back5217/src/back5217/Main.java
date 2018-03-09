package back5217;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		StringBuilder sb = new StringBuilder();
		while ( T > 0) {
			
			
			int target = in.nextInt();
			
			ArrayList<node> list = new ArrayList<>();
			
			for (int i = 1 ; i < target ; i++) {
				for (int j = i+1 ; j < target ; j++) {
					if ( i!=j && i + j == target) {
						
						list.add(new node(i,j));
					}
				}
			}
			
			sb.append("Pairs for "+target+": ");
			for (int i = 0 ; i < list.size() ; i++) {
				int x = list.get(i).x;
				int y = list.get(i).y;
				if ( i == list.size()-1 ) {
					sb.append(x+" "+y);
				}else {
					sb.append(x+" "+y+", ");
				}
			}
			sb.append("\n");
			
			T--;
		}
		System.out.print(sb);
	}
	
	public static class node{
		int x,y;
		node (int x,int y){
			this.x = x;
			this.y = y;
		}
	}
}
