package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;


public class tripAdvisor {
	
	private  Integer time;
	private String locationString;
	@Override
	public int hashCode(){
		
		return time.hashCode()+ locationString.hashCode();
	}
	
	public boolean equals(tripAdvisor t) {
	      return time.equals(t.time)&&locationString.equals(t.locationString);
	 }
	
	public static Integer reversedOperation(String s){
		if(s == null){
			return null;
		}
		int i = s.charAt(0)-'0';
		return getNext(i,s.substring(1));
	}
	
	public static Integer eval(String s){
		Stack<Integer> all = new Stack<Integer>();
		for(char c: s.toCharArray()){
			if(c=='+'){
				int n1 = all.pop();
				int n2 = all.pop();
				if(n1+n2 > 2<<12){
					return -1;
				}
	
				all.add(n1 + n2);
			} else if(c=='*'){
				int n1 = all.pop();
				int n2 = all.pop();
				if(n1*n2 > 2<<12){
					return -1;
				}
				all.add(n1 * n2);
			}else {
				all.add(c-'0');
			}
		}
		return all.pop();
	}
	
    public static int solution(String S) {
        // write your code in Java SE 6
        if(S.length() < 1) return -1;
        Stack<Integer> all = new Stack<Integer>();
        for(char c: S.toCharArray()){
            if(c == '+'){
                if(all.isEmpty()){
                    return -1;
                }
                int n1 = all.pop();
                if(all.isEmpty()){
                    return -1;
                }
                int n2 = all.pop();
                int n3 = n1+n2;
                if(n3 >= 1<<12){
                    return -1;
                }
                all.push(n3);
            }else if(c == '*'){
                if(all.isEmpty()){
                    return -1;
                }
                int n1 = all.pop();
                if(all.isEmpty()){
                    return -1;
                }
                int n2 = all.pop();
                int n3 = n1*n2;
                if(n3 >= 1<<12){
                    return -1;
                }
                all.push(n3);
            } else {
                all.push(c-'0');
            }
        }
        if(all.isEmpty()){
            return -1;
        } else {
            return all.pop();
        }
    }
	
	
	public static Integer getNext(int i,String s) {
		if(s.length() < 1){
			return i;
		}
		int iNew = 0;
		if(s.charAt(1)=='+'){
			iNew = i + s.charAt(0)-'0';
		} else if(s.charAt(1)=='*') {
			iNew = i * (s.charAt(0)-'0');
		} else {
			iNew = s.charAt(1) - '0';
		}
		return iNew>2048?-1:getNext(iNew,s.substring(2));
	}
	
	public static Integer getGeater(ArrayList<Integer> all) {
		if(all.size() < 1) return null;
		int max = Integer.MIN_VALUE;
		HashMap<Integer, Integer> allBigger = new HashMap<Integer,Integer>();
		for(int i = 0;i<all.size();i++){
			if(all.get(i) >= max){
				allBigger.put(i, all.get(i));
				max = all.get(i);
			}
			System.out.println("i "+i+" Num:"+all.get(i)+" max:"+max);
		}
		int min = Integer.MAX_VALUE;
		for(int i = all.size() - 1; i >= 0;i--){
			if(all.get(i) <= min){
				min = all.get(i);
				if(allBigger.containsKey(i)){
					return i;
				}
			}
		}
		
		return null;
	}
	
    public int solution(int[] A) {
        // write your code in Java SE 6
        if(A.length < 1) return -1;
        int max = Integer.MIN_VALUE;
        HashMap<Integer,Integer> allBigger = new HashMap<Integer,Integer>();
        for(int i = 0; i < A.length;i++){
            if(A[i] >= max){
                allBigger.put(i,A[i]);
                max = A[i];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = A.length-1; i >= 0;i--){
            if(A[i] <= min){
                min = A[i];
                if(allBigger.containsKey(i)){
                    return i;
                }
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		String s= "12*3*321+233+7*";
		int i = eval(s);
		System.out.println(eval(s));
		System.out.println(solution(s));
		
//		ArrayList<Integer> all = new ArrayList<>();
//		all.add(3);
//		all.add(2);
//		all.add(5);
//		all.add(8);
//		all.add(6);
//		all.add(5);
//		System.out.println(getGeater(all));
	}
	
}
