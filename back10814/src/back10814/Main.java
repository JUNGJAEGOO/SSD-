package back10814;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int T = Integer.parseInt(in.nextLine());
		ArrayList<node> list = new ArrayList<>();
		for (int i = 0 ; i < T ; i++) {
			
			String tmp[] = in.nextLine().split(" ");
			list.add(new node(Integer.parseInt(tmp[0]),i,tmp[1]));
			
		}
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < list.size(); i++) {
			sb.append(list.get(i).age+" "+list.get(i).name+"\n");
		}
		System.out.print(sb);
	}
	
	public static class node implements Comparable<node>{
		int age;
		int cnt;
		String name;
		node(int age,int cnt,String name){
			this.age = age;
			this.name = name;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(node o) {
			if ( this.age > o.age) {
				return 1;
			}else if ( this.age == o.age) {
				if ( this.cnt > o.cnt) {
					return 1;
				}else {
					return -1;
				}
			}
			return -1;
		}
	}
}
