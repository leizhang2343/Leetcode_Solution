package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	
	TreeNode buildTreeRecursive(int[] postorder,int poststart,int postend,int[] inorder,int instart,int inend){
        if(poststart > postend)
            return null;
        TreeNode root = new TreeNode(postorder[postend]);
        int index = instart;
        while(inorder[index] != root.val)
            index++;
        root.left = buildTreeRecursive(postorder,poststart,poststart + index - instart -1,inorder,instart,index-1);
        root.right = buildTreeRecursive(postorder,postend-inend+index,postend -1,inorder,index + 1,inend);
        return root;
        String.format(l, format, args);
	}
	
	  public TreeNode buildTree(int[] inorder, int[] postorder) {
	        // Note: The Solution object is instantiated only once and is reused by each test case.
	        if(postorder == null || postorder.length < 1){
	            return null;
	        }
	        HashMap<Integer,Integer> inorderMap = new HashMap<Integer,Integer>();
	        for(int i = 0; i < inorder.length; i++){
	            inorderMap.put(inorder[i],i);
	        }
	        HashMap<Integer,Integer> postorderMap = new HashMap<Integer,Integer>();
	        for(int i = 0; i < postorder.length; i++){
	            postorderMap.put(postorder[i],i);
	        }
	        return (getTreePostorder(postorder,0,postorder.length-1,inorderMap,postorderMap));
	    }
	    
	TreeNode getTreePostorder(int[] P,int begin,int end,HashMap<Integer,Integer> inorderMap,HashMap<Integer,Integer> postorderMap){
	        TreeNode root = new TreeNode(P[end]);
	        if(begin == end){
	            return root;
	        }
	        if(end - begin ==1){
	        	if(inorderMap.get(P[end]) > inorderMap.get(P[begin])){
	        		root.left = new TreeNode(P[begin]);
	        		return root;
	        	} else {
					root.right = new TreeNode(P[begin]);
					return root;
				}
	        }
	        //get the number of node which lesser then root in rang of begin and end 
	        int lessThenRoot = inorderMap.get(P[end]) -begin; 
	        if(lessThenRoot < 1){
	        	root.left = null;
	        	root.right = getTreePostorder(P,begin,end - 1,inorderMap,postorderMap);
	        } else if(begin + lessThenRoot -1 >= end -1){
	        	root.right = null;
	        	root.left =  getTreePostorder(P,begin,end - 1,inorderMap,postorderMap);
	        } else {
	        	root.left = getTreePostorder(P,begin,begin+lessThenRoot -1,inorderMap,postorderMap);
	        	root.right = getTreePostorder(P,begin+lessThenRoot,end - 1,inorderMap,postorderMap);
	        }
	        
	        return root;
	    }
	    
	    public static void main(String[] args){
	    	ConstructBinaryTreefromInorderandPostorderTraversal test = new ConstructBinaryTreefromInorderandPostorderTraversal();
	    	int[] inorder = {2,3,1};
	    	int[] postorder = {3,2,1};
//	    	int n = 0;
//	    	for(int i = -999; i <= 2000; i++){
//	    		inorder[n] = i;
//	    		postorder[n] = i;
//	    		n++;
//	    	}
	    	
	    	Long beginLong = System.currentTimeMillis();
	    	test.buildTree(inorder, postorder);
	    	System.out.print(System.currentTimeMillis() - beginLong);
	    }
}
