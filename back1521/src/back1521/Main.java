package back1521;

import java.util.*;

public class Main {
	static int target[];
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		target = new int[N];
		
		
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
			target[i] = arr[i];
		}
		
		Arrays.sort(target);
		
		make(arr,0);
		
		System.out.println(list);
		int sum = 0;
		for ( int i = 0 ; i < list.size() ; i++) {
			sum += list.get(i);
		}
		
		System.out.println((double)sum/list.size());
	}
	
	
	public static void make(int[] arr,int sum) {
		
		int cnt = 0;
		for (int i = 0 ; i < arr.length ; i++) {
			if ( target[i] == arr[i]) {
				cnt++;
			}
		}
		
		for ( int i = 0 ; i < arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}System.out.println();
		
		if ( cnt == arr.length ) {
			System.out.println("Bye "+sum);
			list.add(sum);
			return;
		}
		
		for (int i = 0 ; i < arr.length ; i++) {
			
			for ( int j = i+1 ; j < arr.length ; j++ ) {
				
				if ( arr[i] > arr[j] ) {
					
					int[] NEW = new int[arr.length];
					for ( int k = 0 ; k < arr.length ; k++) {
						NEW[k] = arr[k];
					}
					
					int tmp = NEW[i];
					NEW[i] = NEW[j];
					NEW[j] = tmp;
					
					make(NEW,sum+1);
				}
				
			}
			
		}
		
	}
}
