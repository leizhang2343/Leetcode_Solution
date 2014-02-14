package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Palindrome {
	boolean checkPalindrome(int n){
		String s = Integer.toString(n);
		for(int i = 0, j = s.length() - 1; i < j; i++,j--){
			char before = s.charAt(i);
			char behand = s.charAt(j);
			if(before != behand){
				return false;
			}
		}
		return true;
	}
	
	public List<String> search(String fileString,String searchString){
		List<String> allList = new ArrayList<>();
		String[] dirStrings = fileString.split(" ");
		for(String fileNmae : dirStrings){
			if(stringAContainB(fileNmae, searchString)){
				allList.add(fileNmae);
			}
		}
		Collections.sort(allList);
		return allList;
	}
	
	public boolean stringAContainB(String A,String B) {
		int lengthB = B.length();
		int lengthA = A.length();
		for(int i = 0; i < lengthA; i++){
			if((lengthA - i >= lengthB)){
					for(int j = 0; j < lengthB;j++){
						if(A.charAt(i+j) != B.charAt(j)){
							i = i + j;
							break;
						}
						if(j == B.length() - 1){
							return true;
						}
					}
			} else if(lengthA - i < lengthB) {
				return false;
			}
		}
		return false;
	}
	
	public String balancingParenthesis(String s){
		int parenthesisNeeded = 0;
		for(int i = 0;i < s.length(); i++){
			char tmp = s.charAt(i);
			if(tmp == '('){
				parenthesisNeeded++;
			} else if(tmp == ')') {
				parenthesisNeeded--;
			}
		}
		if(parenthesisNeeded > 0){
			for(int i = 0; i < parenthesisNeeded;i++){
				s = s+")";
			}
		} else if (parenthesisNeeded < 0) {
			for(int i = 0; i > parenthesisNeeded;i--){
				s = "("+s;
			}
		}
		System.out.println(parenthesisNeeded);
		
		return s;
	}
	
    public void rotate(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int n = matrix.length;
        int[][] tmp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                tmp[i][j] = matrix[j][n - i -1];
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = tmp[i][j];
            }
        }
        
    }
	
	boolean checkPalindrome(String s){
		if(s == null){
			return true;
		}
		for(int i = 0, j = s.length() - 1; i < j; i++,j--){
			char before = s.charAt(i);
			char behand = s.charAt(j);
			
			while(before == ' '){
				i++;
				if(i >= j){
					return true;
				}
				before = s.charAt(i);
			}
			while(behand == ' '){
				j--;
				if(i >= j){
					return true;
				}
				behand = s.charAt(j);
			}
			
			if(before != behand){
				return false;
			}
			
		}
		
		return true;
	}
	
	public static void main(String[] args){
		String s = null;
		Palindrome tmPalindrome = new Palindrome();
		int[][] testint = new int[2][2];
		testint[0][0] = 1;
		testint[0][1] = 2;
		testint[1][0] = 3;
		testint[1][1] = 4;
		tmPalindrome.rotate(testint);
		System.out.print(tmPalindrome.checkPalindrome(s));
		for(int i = 100; i < 200; i++){
			System.out.println(i+" "+tmPalindrome.checkPalindrome(i));
		}
		
		System.out.println(tmPalindrome.balancingParenthesis("dada(dada(d)))"));
		System.out.println(tmPalindrome.stringAContainB("ZhangLei", "angs"));
	}
}
