package back14719;

import java.util.*;

public class Main {
	public static void main(String arg[]) {
		Scanner in = new Scanner(System.in);
		int H = in.nextInt();
		int W = in.nextInt();
		int arr[] = new int[W];
		for (int i = 0 ; i < W ; i++) {
			arr[i] = in.nextInt();
		}
		
		Stack<Integer> st = new Stack<>();
		for (int i = 0 ; i < W ; i++) {
			
				st.add(arr[i]);
			
		}
		
		int standard = 0;
		int sum = 0;
		ArrayList<Integer> blocks = new ArrayList<>();
		
		while ( !st.isEmpty() ) {
			
			while ( standard == 0) {
				standard = st.pop();
			}
			
			while (true) {
				if ( st.size() == 0 || st.peek() > standard )  {
					break;
				}else {
					blocks.add(st.pop());
				}
			}
			
			//System.out.println(blocks);
			
			if ( blocks.size() == 0) {
				break;
			}
			
			if ( st.size() != 0) {
				int min = Math.min(standard, st.peek());
				for (int i = 0 ; i < blocks.size(); i++) {
					sum += ( min - blocks.get(i) );
				}
			}else {
				int min = Math.min(standard,blocks.get(blocks.size()-1));
				for (int i = 0 ; i < blocks.size(); i++) {
					sum += ( min - blocks.get(i) );
				}
			}
			
			if ( st.size() != 0) {
				st.pop();
			}
			blocks = new ArrayList<>();
			standard = 0;
		}
		
		System.out.println(sum);
	}
}
