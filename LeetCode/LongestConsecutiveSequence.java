package LeetCode;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] num) {
		HashSet<Integer> all = new HashSet<Integer>();
		for(int n : num){
			all.add(n);
		}
		int max = 0;
		
		for(int n:num){
			if(all.contains(n)){
				all.remove(n);
				counter = 1;
				int tmp = getConsecutive(all, n);
				if( tmp > max){
					max = tmp;
				}
			}
		}
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        return max;
    }
    
    static int counter= 0;
    
    public static int getConsecutive(HashSet<Integer> all,int num){
    	while(!all.isEmpty()){
    		if(all.contains(num+1)){
    			all.remove(num+1);
    			counter++;
    			getConsecutiveRight(all,num+1);
    		} else if(all.contains(num-1)){
        			all.remove(num-1);
        			counter++;
        			getConsecutiveLeft(all,num-1);
        		
			} else {
				return counter;
			}
    		
    	}
    	return counter;
    }
    
    public static void getConsecutiveLeft(HashSet<Integer> all,int num){
    	while(!all.isEmpty()){
    		if(all.contains(num-1)){
    			all.remove(num-1);
    			counter++;
    			getConsecutive(all,num-1);
    		} else {
				return;
			}
    	}
    	return;
    }
    
    public static void getConsecutiveRight(HashSet<Integer> all,int num){
    	while(!all.isEmpty()){
    		if(all.contains(num+1)){
    			all.remove(num+1);
    			counter++;
    			getConsecutive(all,num+1);
    		} else {
				return;
			}
    	}
    	return;
    }
    
    public static void main(String[] args){
    	int[] A = new int[10000];
    	int n = 0;
    	for(int i = 9000; i > -1000;i--){
    		A[n] = i;
//    		System.out.println("n:"+n+" i:"+i);
    		n++;
    	}
    	System.out.print(longestConsecutive(A));
    }
}
