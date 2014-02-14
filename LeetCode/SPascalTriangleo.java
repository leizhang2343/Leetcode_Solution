package LeetCode;

import java.util.ArrayList;

public class SPascalTriangleo {
	public ArrayList<Integer> getRow(int rowIndex) {
        rowIndex = rowIndex + 1;
        if(rowIndex == 0){
            return new ArrayList<Integer>();
        } 
        if(rowIndex == 1){
        	ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            tmp1.add(1);
            return tmp1;
        }
        ArrayList<Integer> tmp2 = new ArrayList<Integer>();
        tmp2.add(1);
        tmp2.add(1);
        if(rowIndex == 2){
            return tmp2;
        }
        for(int i = 3; i <= rowIndex; i++){
            ArrayList<Integer> newTmpArray = new ArrayList<Integer>();
            newTmpArray.add(1);
            for(int j = 1; j < tmp2.size(); j++){
                int n = tmp2.get(j) + tmp2.get(j - 1); 
                newTmpArray.add(n);
            }
            newTmpArray.add(1);
            tmp2 = newTmpArray;
        }
    
        return tmp2;
    }
	
	
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0){
            return all;
        }
        ArrayList<Integer> tmp1 = new ArrayList<Integer>();
        tmp1.add(1);
        all.add(tmp1);
        if(numRows == 1){
            return all;
        }
        ArrayList<Integer> tmp2 = new ArrayList<Integer>();
        tmp2.add(1);
        tmp2.add(1);
        all.add(tmp2);
        if(numRows == 2){
            return all;
        }
        for(int i = 3; i <= numRows; i++){
            ArrayList<Integer> newTmpArray = new ArrayList<Integer>();
            newTmpArray.add(1);
            for(int j = 1; j < all.get(i -2).size(); j++){
                int n = all.get(i -2).get(j) + all.get(i -2).get(j - 1); 
                newTmpArray.add(n);
            }
            newTmpArray.add(1);
            all.add(newTmpArray);
        }
    
        return all;
    }
    
    public static void main(String[] args){
    	SPascalTriangleo test = new SPascalTriangleo();
    	for(ArrayList<Integer> A:test.generate(6)){
    		System.out.println();
    		for(int n: A){
    			System.out.print(n+",");
    		}
    	}
    	for(int n: test.getRow(5)){
			System.out.print(n+",");
		}
    }
}
