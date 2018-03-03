package back10825;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<node> list = new ArrayList<>();
		for (int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String name = st.nextToken();
			int kor = Integer.parseInt(st.nextToken());
			int eng = Integer.parseInt(st.nextToken());
			int math = Integer.parseInt(st.nextToken());
			list.add(new node(name,kor,eng,math));
		}
		
		Collections.sort(list);
		StringBuilder res = new StringBuilder();
		for (int i = 0 ; i < N ; i++) {
			res.append(list.get(i).name+"\n");
			//System.out.println(list.get(i).name+" "+list.get(i).kor+" "+list.get(i).eng+" "+list.get(i).math);
		}
		System.out.print(res);
	}
	
	public static class node implements Comparable<node>{
		String name;
		int kor;
		int eng;
		int math;
		
		node (String name,int kor,int eng,int math){
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		
		public int compareTo(node o) {
			if ( this.kor < o.kor) {
				return 1;
			}else if ( this.kor == o.kor) {
				if ( this.eng > o.eng) {
					return 1;
				}else if ( this.eng == o.eng) {
					if ( this.math < o.math) {
						return 1;
					}else if ( this.math == o.math) {
						if ( this.name.compareTo(o.name) >= 0) {
							return 1;
						}else {
							return -1;
						}
					}else {
						return -1;
					}
				}
			}
			return -1;
		}
		
		
	}
}
