package LeetCode;

import java.util.ArrayList;

public class PathSumII {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return all;
        }
        
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        getSum(root,0,tmp,all,sum);
        return all;
    }
    
    void getSum(TreeNode root, int sumUntilNow,ArrayList<Integer> integerUntillNow,ArrayList<ArrayList<Integer>> all,int sumNeeded){
        if(root.left != null){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(root.val,0);
            tmp.addAll(integerUntillNow);
            getSum(root.left,sumUntilNow+root.val,tmp,all,sumNeeded);
        }
        if(root.right != null){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            tmp.add(0,root.val);
            tmp.addAll(integerUntillNow);
            getSum(root.right,sumUntilNow+root.val,tmp,all,sumNeeded);
        }
        if(root.right == null && root.left == null){
            
            if(sumUntilNow + root.val == sumNeeded){
                 ArrayList<Integer> tmp = new ArrayList<Integer>();
                tmp.add(root.val,0);
                 tmp.addAll(integerUntillNow);
                all.add(tmp);
            }
        }
    }
}
