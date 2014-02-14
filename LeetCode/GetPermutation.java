package LeetCode;

import java.util.ArrayList;

public class GetPermutation {
    public String getPermutation(int n, int k) {
    	k = k-1;
        int[] N = new int[n];
        ArrayList<Integer> all = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++){
            all.add(i);
        }
        getDigit(all, n, k, N);
        String s = "";
        for(int i = n -1; i >= 0; i--){
        	s = s + N[i];
        }
        return s;
    }
    
    int getFactorial(int n){
        int all = 1;
        for(int i = 1; i<=n;i++){
            all = all*i;
        }
        return all;
    }
    
    void getDigit(ArrayList<Integer> allNumbers,int n,int k,int[] N){
        int factorail = getFactorial(n-1);
        int quotient = k/factorail;
        int remainder = k%factorail;
        N[n-1] = allNumbers.get(quotient);
        allNumbers.remove(quotient);
        if(allNumbers.isEmpty()){
            return;
        }
        if(remainder == 0){
        	for(int i = 0; i <= n - 2; i++){
        		N[i] = allNumbers.get(n - 2 - i);
        	}
        	return;
        }
        getDigit(allNumbers,n - 1,remainder,N);
    }
    
    public static void main(String[] args){
    	GetPermutation test = new GetPermutation();
    	System.out.print(test.getPermutation(3, 6));
    }
}
