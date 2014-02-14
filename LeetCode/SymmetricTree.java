package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree  {
	 public boolean isSymmetric(TreeNode root) {
	        if(root == null){
	            return false;
	        }
	        Queue<TreeNode> leftSub = new LinkedList<TreeNode>();
	        Queue<TreeNode> rightSub = new LinkedList<TreeNode>();
	        if(root.right!= null && root.left != null){
	            leftSub.add(root.left);
	            rightSub.add(root.right);
	        } else if(root.left ==null && root.right == null){
	            return true;
	        } else {
	            return false;
	        }
	        while(!leftSub.isEmpty()&&!rightSub.isEmpty()){
	            TreeNode tmpLeft = leftSub.poll();
	            TreeNode tmpRight = rightSub.poll();
	            if(tmpLeft.val != tmpRight.val){
	                return false;
	            }
	            if(tmpLeft.left != null && tmpRight.right != null){
	                leftSub.add(tmpLeft.left);
	                rightSub.add(tmpRight.right);
	            } else if(tmpLeft.left == null ^ tmpRight.right == null){
	                return false;
	            }
	            if(tmpLeft.right != null && tmpRight.left != null){
	                leftSub.add(tmpLeft.right);
	                rightSub.add(tmpRight.left);
	            } else if(tmpLeft.right == null ^ tmpRight.left == null){
	                return false;
	            }
	        }
	       if(!leftSub.isEmpty()^!rightSub.isEmpty()){
	           return false;
	       }
	       return true;
	    }
}
