package LeetCode;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;

public class JumpGame {
		
	

	    public int canJump(int[] A) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	       int[] dp = new int[A.length];
	       return canJump(A,0);
	    }
	    
	    public int getMaxIndex(int[] A,int index) {
	    	int maxIndex = 0;
	    	int maxval = 0;
	    	for(int i = 1; i <= A[index];i++){
//	    		System.out.println("i:" + i + " index" + index);
	    		
	    		if(index + i >= A.length){
//	    			System.out.print("dayu length");
		    		return index +i;
		    	}
	    		
	    		if((A[i + index] + i) > maxval){
//	    			System.out.println("A[i+index] = "+A[ i + index] +" maxIndex _ in" + maxIndex);
	    			maxval = A[i + index] + i;
	    			maxIndex = i + index;
//	    			System.out.println("maxIndex =" + maxIndex);
	    		}
	    		
	    	}
//	    	System.out.println("return maxIndex" + maxIndex);
	    	return maxIndex;
		}
	    public int canJump(int [] A, int n){
	        if(n >= A.length - 1 || A[n] >= A.length - 1 - n){
	            return 1;
	        }
	        int max = getMaxIndex(A,n);
	        if(max < 1){
	        	return -1;
	        }
	        int tmp = canJump(A,max);
	        if(tmp >= 0 ){
                return tmp+1;
             }
	        return tmp - 1;
	    }
	    
	    public boolean canJump(int [] A, int n,int[] dp){
	        if(n >= A.length -1){
	           
	            return true;
	        }
	        if(dp[n] == 1){
	        	return true;
	        }else if(dp[n] == 2){
	        	return false;
	        }
	        int max = 0;
	        for(int i = A[n]; i > 0; i--){
//	        	System.out.println(n+i);
	            if(n+i > A.length -1){
	            	return true;
	            }
	            if((A[n+i] + i)> max){
	                max = A[n+i] +i;
	                boolean tmp = canJump(A,n+i,dp);
	                if(tmp == true){
	                    dp[n + i] = 1;
	                    return true;
	                 } else {
	                    dp[n + i] = 2;
	                }
	            }
	        }
	        return false;
	    }
	    
	public static void main(String[] args){
		int[] A = {2,3,1,1};
		JumpGame test = new JumpGame();
		System.out.print(test.canJump(A));
	}
}
    
