package back6986;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		double arr[] = new double[N];
		for (int i = 0 ; i < N ; i++) {
			arr[i] = in.nextDouble();
		}
		
		Arrays.sort(arr);
		double jeol = 0;
		for (int i = K ; i < N-K ; i++) {
			jeol += arr[i];
		}
		jeol = jeol/(N-2*K);
		
		double bojeong = 0;
		for (int i = 0 ; i < K ; i++) {
			arr[i] = arr[K];
		}
		for (int i = N-K ;  i < N ; i++) {
			arr[i] = arr[N-K-1];
		}
		for (int i = 0 ; i < N ; i++) {
			bojeong += arr[i];
		}
		bojeong = bojeong / N ;
		System.out.format("%.2f\n",jeol);
		System.out.format("%.2f\n",bojeong);
	}
}
