package back1713;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int X = in.nextInt();
		int arr[] = new int[X];
		
		for ( int i = 0 ;  i < X ; i++) {
			arr[i] = in.nextInt();
		}
		
		ArrayList<node> list = new ArrayList<>();
		
		for ( int i = 0 ; i < X ; i++) {
			
			
			if ( list.size() < N) {
				boolean pass = true;
				for ( int j = 0 ; j < list.size() ; j++) {
					if  ( list.get(j).num == arr[i] ) {
						pass = false;
						list.get(j).recom++;
					}
				}
				
				if ( pass ) {
					list.add(new node(arr[i],1,i));
				}
				
			}else {
				
				boolean pass = true;
				for ( int j = 0 ; j < list.size() ; j++) {
					if ( list.get(j).num == arr[i]) {
						list.get(j).recom++;
						pass = false;
					}
				}
				
				//System.out.println(arr[i]+" "+pass);
				
				if ( pass ) {
					
					ArrayList<Integer> MINrecom = new ArrayList<>();
					int min = 100000;
					for ( int j = 0 ; j < list.size() ; j++) {
						if ( list.get(j).recom < min ) {
							min = list.get(j).recom;
							MINrecom = new ArrayList<>();
							MINrecom.add(list.get(j).num);
						}else if ( list.get(j).recom == min) {
							MINrecom.add(list.get(j).num);
						}
					}
					//System.out.println(MINrecom);
					
					int older = 1000000;
					int olderidx = 1000000;
					for ( int j = 0 ; j < list.size() ; j++) {
						if ( MINrecom.contains(list.get(j).num) ) {
							if ( list.get(j).past < older ) {
								older = list.get(j).past;
								olderidx = list.get(j).num;
							}
						}
					}
					
					//System.out.println(older+" "+olderidx);
					
					for ( int j = 0 ; j < list.size() ; j++) {
						if ( list.get(j).num == olderidx) {
							list.remove(j);
							break;
						}
					}
					
					list.add(new node(arr[i],1,i));
				}
				
			}
			
			
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		for ( int i = 0 ; i < list.size() ; i++) {
			//System.out.print(list.get(i).num+" ");
			ans.add(list.get(i).num);
		}
		
		Collections.sort(ans);
		
		for ( int i = 0 ; i < ans.size(); i++) {
			System.out.print(ans.get(i)+" ");
		}
	}
	
	public static class node{
		int num;
		int recom;
		int past;
		node (int num,int recom,int past) {
			this.num = num;
			this.recom = recom;
			this.past = past;
		}
	}
}
