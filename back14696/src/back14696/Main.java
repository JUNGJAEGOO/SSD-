package back14696;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		for ( int i = 0 ; i < N ; i++) {
			
			int arrA[] = new int[5];
			int arrB[] = new int[5];
			
			int a = in.nextInt();
			for  (int j = 0 ; j < a ; j++) {
				arrA[in.nextInt()]++;
			}
			
			int b = in.nextInt();
			for  (int j = 0 ; j < b ; j++) {
				arrB[in.nextInt()]++;
			}
			
			if ( arrA[4] > arrB[4]) {
				System.out.println("A");
			}else if ( arrA[4] < arrB[4]) {
				System.out.println("B");
			}else {
				if ( arrA[3] > arrB[3]) {
					System.out.println("A");
				}else if ( arrA[3] < arrB[3]) {
					System.out.println("B");
				}else {
					if ( arrA[2] > arrB[2]) {
						System.out.println("A");
					}else if ( arrA[2] < arrB[2]) {
						System.out.println("B");
					}else {
						if ( arrA[1] > arrB[1]) {
							System.out.println("A");
						}else if ( arrA[1] < arrB[1]) {
							System.out.println("B");
						}else {
							System.out.println("D");
						}
					}
				}
			}
			
		}
	}
}
