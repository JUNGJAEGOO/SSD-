package back11720;
import java.io.*;
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char arr[] = br.readLine().toCharArray();
		long sum = 0;
		for ( int i = 0 ; i < N ; i++) {
			sum += Integer.parseInt(String.valueOf(arr[i]));
		}
		System.out.println(sum);
	}
}
