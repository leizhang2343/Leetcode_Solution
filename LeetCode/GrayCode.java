package LeetCode;

import java.util.ArrayList;

public class GrayCode {
    public ArrayList<Integer> grayCode(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(n == 0){
            return null;
        } else {
            return grayCodeRecursion(n);
        }
        
    }
    
    public ArrayList<Integer> grayCodeRecursion(int n){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(n == 1){
            result.add(0);
            result.add(1);
            return result;
        } else {
             ArrayList<Integer> resultN_1 = grayCodeRecursion( n-1);
             result.addAll(resultN_1);
             
             for(int i = n - 1 -1; i > 0;i--){
                 result.add((int) (resultN_1.get(i) + Math.pow(2,n)));
             }
             return result;
        }
    }
    public static void main(String[] args){
    	GrayCode tent = new GrayCode();
    	tent.grayCode(3);
    }
}
