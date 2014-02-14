package LeetCode;

import java.util.ArrayList;


public class divideString {
	ArrayList<ArrayList<String>> divide(String s){
		ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
		if(s==null||s.length()<1)
			return result;
		for(int i=0;i<s.length()-1;i++){
			ArrayList<ArrayList<String>> recursiveResult=divide(s.substring(i+1));
			for(ArrayList<String> element:recursiveResult){
				ArrayList<String> newElement=new ArrayList<String>();
				newElement.add(s.substring(0,i+1));
				System.out.println("0->i+1:"+s.substring(0,i+1));
				newElement.addAll(element);
				System.out.println("element"+element);
				result.add(newElement);
			}
		}
		ArrayList<String> newElement=new ArrayList<String>();
		newElement.add(s);
		result.add(newElement);
		System.out.println("result"+result);
		return result;
	}
	
    public ArrayList<ArrayList<String>> divideStringRecursive(String s){
        
        if(s == null || s.length() < 1){
            return null;
        }
        ArrayList<ArrayList<String>> all = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < s.length() -1;i++){
            ArrayList<ArrayList<String>> recursiveResult = divideStringRecursive(s.substring(i+1));
            for(ArrayList<String> tmpResult : recursiveResult){
                ArrayList<String> newResult = new ArrayList<String>();
                newResult.add(s.substring(0,i+1));
                newResult.addAll(tmpResult);
                all.add(newResult);
            }
        }
        ArrayList<String> newString = new ArrayList<String>();
        newString.add(s);
        all.add(newString);
        return all;
    }
	
	public static void main(String[] args){
		System.out.println(new divideString().divide("lei"));
		System.out.println(new divideString().divideStringRecursive("lei"));
	}
}
