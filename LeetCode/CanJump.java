package LeetCode;

public class CanJump {
    public boolean canJump(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
    	
    	return true;
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
        for(int i = A[n]; i > 0; i--){
//        	System.out.println(n+i);
           
            if(n+i > A.length -1){
            	return true;
            }
            boolean tmp = canJump(A,n+i,dp);
            if(tmp == true){
                dp[n + i] = 1;
                return true;
            } else {
                dp[n + i] = 2;
            }
        }
        return false;
    }
    
    
    public static void main(String[] args){
    	int[] A = {2,0};
    	int[] dp = new int[A.length];
    	CanJump testCanJump = new CanJump();
    	System.out.print(testCanJump.canJump(A, 0,dp));
    }
}
