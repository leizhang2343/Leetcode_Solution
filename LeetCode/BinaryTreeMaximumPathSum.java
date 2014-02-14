package LeetCode;

import java.util.ArrayList;

public class BinaryTreeMaximumPathSum {
    class keepMax{
        int max;
        public keepMax(){
            max = Integer.MIN_VALUE;
        }
        void add(Integer n){
            if(n > this.max)
            this.max = n;
        }
    }
    
    public int maxPathSum(TreeNode root) {
        keepMax maxKeeper = new keepMax();
        maxSubNodeValue(root,maxKeeper);
        return maxKeeper.max;
    }
    
    public int maxSubNodeValue(TreeNode root,keepMax maxKeeper){
        if(root == null){
            return 0;
        }
        int leftMax = maxSubNodeValue(root.left,maxKeeper);
        int rightMax = maxSubNodeValue(root.right,maxKeeper);
        maxKeeper.add(Math.max(leftMax,0) + Math.max(rightMax,0) + root.val);
       
        return Math.max(Math.max(leftMax,rightMax),0) + root.val;
    }
    
    public static void main(String[] args) {
    	BinaryTreeMaximumPathSum test = new BinaryTreeMaximumPathSum();
    	TreeNode root = new TreeNode(-2);
    	root.left = new TreeNode(1);
//    	root.right = new TreeNode(8);
    	System.out.print(test.maxPathSum(root));
	}
}
