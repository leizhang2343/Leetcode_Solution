package LeetCode;

import java.util.HashSet;

public class Can_not_vist {
	static int canNotVist(int[] A){
		HashSet<Integer> all = new HashSet<>();
		for(int i = 0; i < A.length;i++){
			all.add(i);
		}
		int k = 0;
		while (k >= 0 && k < A.length) {
			if(all.contains(k)){
				all.remove(k);
			} else {
				break;
			}
			k += A[k];
			
		}
		int n = all.size();
		return n; 
	}
	
	public static void main(String[] args) {
		int[] A = {5,2,3};
		System.out.print(canNotVist(A));
	}
}
