package back16430;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int A  = Integer.parseInt(st.nextToken());
		int B  = Integer.parseInt(st.nextToken());
		
		int sum = B;
		
		sum -= A;
		
		System.out.print(sum+" "+B);
		
	}
}
