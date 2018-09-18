package back1476;

import java.util.*;
public class Main{
	public static void main(String[]a){
		Scanner in=new Scanner(System.in);
		int E=in.nextInt();
		int S=in.nextInt();
		int M=in.nextInt();
		int i=1,j=1,k=1,cnt=1;
		while(1==1) {
			if(i==E&&j==S&&k==M){System.out.print(cnt);return;}
			i++;j++;k++;cnt++;
			if(i>15){i=1;}
			if(j>28){j=1;}
			if(k>19){k=1;}
		}
	}
}
