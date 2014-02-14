package LeetCode;

import java.util.HashSet;

public class Bit {
	static int getIntegerComplement(int n) {
		int index = 0;
		int resultNum = 0;
		for(int k = n; k > 0;k >>= 1){
			if((k&0)==0){
				resultNum += Math.pow(2, index);
			}
			index++;
		}
		
		return resultNum;
	}
	
	int reverse(int k){
   	 int i=Integer.toBinaryString(k).length();
   	 k=~k;
   	 k=k<<(32-i)>>(32-i);
   	 return k;
    }
	
	public String removeCharsFromString(String B,String A){
	    if(B == null || A == null){
	        return A;
	    }
	    HashSet<Character> allInB = new HashSet<Character>();
	    // put all the char in a HashSet;
	    for(int i = 0; i < B.length();i++){
	        allInB.add(B.charAt(i));
	    }
	    
	    char[] arrayOfA = A.toCharArray();
	    String s ="ss";
	    s.toStringBuffer;
	    for(int i = 0; i < A.length(); i++){
	        if(allInB.contains(A.charAt(i))){
	            arrayOfA[i] = '';
	        }
	    }
	    
	    return arrayOfA.toString();
	}
	
	public String removeCharsFromString(String B,String A){
	    if(B == null || A == null){
	        return A;
	    }
	    HashSet<Character> allInB = new HashSet<Character>();
	    // put all the char in a HashSet;
	    for(int i = 0; i < B.length();i++){
	        allInB.add(B.charAt(i));
	    }
	    
	    StringBuffer buffA = new StringBuffer();
	    
	        
	    for(int i = 0; i < A.length(); i++){
	        if(!allInB.contains(A.charAt(i))){
	           buffA.append(A.charAt(i));
	        }
	    }
	    buffA.toString()
	    return buffA.toString();
	}
	
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        try {
			 int n = Integer.parseInt(args[0]);
            
            for(int i = 1; i < n; i++){
                if(i%3 == 0){
                    if(i%5 == 0){
                        System.out.println("FizzBuzz");
                    } else {
                        System.out.println("Fizz");
                    }
                } else if(i%5 == 0){
                    System.out.println("Buzz");
                } else {
                      System.out.println(i);
                }
            }
		} catch (Exception e) {
			System.out.println("Please input an integer less then 10^7");
		}
    }
}
