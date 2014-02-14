package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeBalanced {
	 public boolean isBalanced(TreeNode root) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(root == null){
	            return true;
	        }
	         Queue<TreeNode> allLeft = new LinkedList<TreeNode>();
	         Queue<TreeNode> allRight = new LinkedList<TreeNode>();
	         int left = 0;
	         int right = 0;
	         
	         if(root.right != null){
	        	 if(!isBalanced(root.right)){
	        		 return false;
	        	 }
	             allRight.add(root.right);
	             right = getDepth(allRight,1);
	         }
	         if(root.left != null){
	        	 if(!isBalanced(root.right)){
	        		 return false;
	        	 }
	             allLeft.add(root.left);
	             left = getDepth(allLeft,1);
	         }
	         
	         System.out.println("left:"+left+"  right:" + right);
	       return Math.abs(left - right) <= 1;
	    }
	    
	    int getDepth(Queue<TreeNode> all,Integer finalDepth){
	        Queue<TreeNode> newAll = new LinkedList<TreeNode>();
	        while(!all.isEmpty()){
	            TreeNode tmp = all.poll();
	            if(tmp.left != null){
	                newAll.add(tmp.left);
	            }
	            if(tmp.right != null){
	                newAll.add(tmp.right);
	            }
	        }
	        
	        if(!newAll.isEmpty()){
	        	System.out.println(finalDepth);
	        	return getDepth(newAll,finalDepth+1);
	        }   
	        
	        return finalDepth;
	    }
    
    public static void main(String[] args){
    	
    	ArrayList<Integer> teArrayList = new ArrayList<>();
    	teArrayList.r
    	TreeBalanced test = new TreeBalanced();
    	TreeNode rootNode = new TreeNode(2);
    	rootNode.left = new TreeNode(3);
//    	rootNode.right = new TreeNode(1);
    	rootNode.left.left = new TreeNode(4);
//    	rootNode.left.left.left = new TreeNode(5);
    	System.out.print(test.isBalanced(rootNode));
    }
}
