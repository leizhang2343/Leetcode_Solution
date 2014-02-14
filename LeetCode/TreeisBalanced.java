package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeisBalanced {
    public boolean isBalanced(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(root == null){
            return true;
        }
         Queue<TreeNode> all = new LinkedList<TreeNode>();
       return isBalancedRecusive(all,null);
    }
    
    boolean isBalancedRecusive(Queue<TreeNode> all,Integer finalDepth){
        Queue<TreeNode> newAll = new LinkedList<TreeNode>();
        while(all.isEmpty()){
            TreeNode tmp = all.poll();
            if(tmp.left == null && tmp.right == null){
                if(finalDepth == null){
                    finalDepth = 0;
                }else{
                    if(finalDepth > 1){
                        return false;
                    }
                }
            }
            if(tmp.left != null){
                newAll.add(tmp.left);
            }
            if(tmp.right != null){
                newAll.add(tmp.right);
            }
        }
        if(!newAll.isEmpty()){
            if(finalDepth != null){
                finalDepth++;
                 }   
            isBalancedRecusive(newAll,finalDepth);
        }
        
         return true;
    }
}
