package back2352;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		//ArrayList<Integer> list = new ArrayList<>();
		int arr[] = new int[N];
		for ( int i = 0 ; i < N ; i++) {
			arr[i] = in.nextInt();
		}
		
		int list[] = new int[N];
		list[0] = arr[0];
		int size = 1;
		for ( int i = 1 ; i < N ; i++) {
			if ( list[size-1] < arr[i]){
				list[size] = arr[i];
				size++;
			}else if ( arr[1] < list[0] ){   
				list[0] = arr[1];
			}else {
				int idx = Arrays.binarySearch(list, 0,size,arr[i]);
				//System.out.println(idx);  // 들어갈 최적의 자리 구하기
				if ( idx < 0) {
					idx = -idx-1;
				}
				list[idx] = arr[i];
			}
		}
		
		/*for ( int i = 0 ; i < list.length ; i++) {
			System.out.print(list[i]+" ");
		}*/
		System.out.println(size);
	}
}
