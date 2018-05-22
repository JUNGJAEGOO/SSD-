package back14931;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int arr[] = new int[N];
		long sum = 0;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
			sum += arr[i];
		}
		
		if ( N >= 2) {
		int diff = 2;
		
		while ( true ) {
			
			long tmp = 0;
			for ( int j = diff-1 ; j < N ; j += diff) {
				tmp += arr[j];
			}
			
			if ( tmp > sum) {
				sum = tmp;
				list = new ArrayList<>();
				list.add(diff);
			}else if ( tmp == sum) {
				list.add(diff);
			}
			
			//System.out.println(diff+" "+tmp);
			
			diff++;
			if ( diff > N) {
				break;
			}
		}
		}
		
		Collections.sort(list);
		if ( sum < 0 ) {
			System.out.print("0 0");
		}else {
			System.out.print(list.get(0)+" "+sum);
		}
	}
}
