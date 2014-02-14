package LeetCode;


// Definition for binary tree
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
      
      public void insert(TreeNode node, int value) {
    	    if (value < node.val)
    	    {
    	        if (node.left != null)
    	        {
    	            insert(node.left, value);
    	        } 
    	        else
    	        {     
    	            node.left = new TreeNode(value);
    	        }
    	    } 
    	    else if (value > node.val)
    	    {
    	        if (node.right != null)
    	        {
    	            insert(node.right, value);
    	        }
    	        else
    	        {
    	            node.right = new TreeNode(value);
    	        }
    	    }
    	}
      
  }
 
