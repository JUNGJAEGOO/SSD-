package back1068;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static tree root;
	static tree ans;
	static int res = 0;
	static int node = 0;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int arr[] = new int[N];
		int rootnum = -1;
		
		for ( int i = 0 ; i < N ; i++) {
			int x = in.nextInt();
			arr[i] = x;
			if ( x == -1) {
				rootnum = i;
				root = new tree(i);
			}
		}
		
		while ( node < N-1) {
		for ( int i = 0 ; i < N ; i++) {
			if ( arr[i] == -1) {
				continue;
			}
			root.make(root, i, arr[i]);
		}
		//System.out.println("노드 수: "+node);
		}

		int want = in.nextInt();
		if ( want == rootnum ) {
			System.out.print(0);
			return;
		}
		root.delete(root,want,root);
		root.count(root);
		System.out.println(res);
		
	}
	
	public static class tree{
		int num;
		ArrayList<tree> child = new ArrayList<>();
		
		tree(int num){
			this.num = num;
		}
		
		public static void make(tree tmp,int num,int parent) {
			if ( tmp.num == parent ) {
				boolean pass = true;
				for ( int i = 0 ; i < tmp.child.size() ; i++) {
					if ( tmp.child.get(i).num == num ) {
						pass = false;
						break;
					}
				}
				if ( pass) {
					//System.out.println(num+" 의 부모는 "+tmp.num);
					node++;
					tmp.child.add(new tree(num));
				}
				
			}else {
				for ( int i = 0 ; i < tmp.child.size() ; i++) {
					make(tmp.child.get(i),num,parent);
				}
			}
		}
		
		public static void count(tree tmp) {
			if ( tmp.child.size() == 0 ) {
				//System.out.println(tmp.num+" 은 리프노드");
				res++;
			}else {
				for ( int i = 0 ; i < tmp.child.size() ; i++) {
					count(tmp.child.get(i));
				}
			}
		}
		
		public static void delete(tree tmp,int num,tree parent) {
			if ( tmp.num == num ) {
				
				for ( int i = 0 ; i < parent.child.size() ; i++) {
					if ( parent.child.get(i).num == num) {
						//System.out.println(parent.child.get(i).num+" 삭제 "+" 부모는 "+parent.num);
						parent.child.remove(i);
						break;
					}
				}
				
				/*for ( int i = 0 ; i < parent.child.size() ; i++) {
					System.out.println("hi "+parent.child.get(i).num);
				}
				for ( int i = 0 ; i < parent.child.get(0).child.size() ; i++) {
					System.out.println("hi "+parent.child.get(0).child.get(i).num);
				}*/
				//tmp = null;
			}else {
				for ( int i = 0 ; i < tmp.child.size() ; i++) {
					delete(tmp.child.get(i),num,tmp);
				}
			}
		}
	}
}
