package LeetCode;

import java.util.ArrayList;

public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	if(triangle.isEmpty()){
    		return 0;
    	}
        if(triangle.size() < 2){
            return triangle.get(0).get(0);
        }
        for(int i = triangle.size() - 2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                triangle.get(i).set(j, Math.min(triangle.get(i+1).get(j),triangle.get(i+1).get(j+1)) + triangle.get(i).get(j));
                
            }
        }
        return triangle.get(0).get(0);
    }
    public static void  main(String[] args) {
    	ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> tmp0 = new ArrayList<>();
    	tmp0.add(1);
    	ArrayList<Integer> tmp1 = new ArrayList<>();
    	tmp1.add(3);
    	tmp1.add(4);
    	ArrayList<Integer> tmp2 = new ArrayList<>();
    	tmp2.add(7);
    	tmp2.add(8);
    	tmp2.add(9);
    	triangle.add(tmp0);
    	triangle.add(tmp1);
    	triangle.add(tmp2);
    	Triangle testTriangle = new Triangle();
    	System.out.println(testTriangle.minimumTotal(triangle));
	}
}
