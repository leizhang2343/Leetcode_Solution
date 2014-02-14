package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PreorderTraversal {
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
		
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
    	ArrayList<Integer> all = new ArrayList<Integer>();
        recursiveSolution(root,all);
        return all;
    }
    
    
    
    public static void recursiveSolution(TreeNode root,ArrayList<Integer> all) {
    	if(root == null){
    		return;
    	}
    	Queue<TreeNode> iijNodes = new LinkedList<TreeNode>();
    	iijNodes.poll();
		recursiveSolution(root.left,all);
		all.add(root.val);
		recursiveSolution(root.right, all);
	}
    
    public void iterativeSolution(TreeNode root,ArrayList<Integer> all){
    	Stack<TreeNode> tmpStack = new Stack<TreeNode>();
    	tmpStack.push(root);
    	while (!tmpStack.isEmpty()) {
			TreeNode tmpNode = tmpStack.pop();
			all.add(tmpNode.val);
			if(tmpNode.right != null){
				tmpStack.push(tmpNode.right);
			}
			if(tmpNode.left != null){
				tmpStack.push(tmpNode.left);
			}
		}
    	
    	class stackTree{
            TreeNode t;
            int mark;
            stackTree(TreeNode tree,int m){
                t=tree;
                mark=m;
            }
        
        public ArrayList<Integer> postorderTraversal(TreeNode root) {
            // IMPORTANT: Please reset any member data you declared, as
            // the same Solution instance will be reused for each test case.
            ArrayList<Integer> result=new ArrayList<Integer>();
            if(root==null)
                return result;
            Stack<stackTree> backTrace=new Stack<stackTree>();
            backTrace.push(new stackTree(root,0));
            while(!backTrace.isEmpty()){
                stackTree getFromStack=backTrace.pop();
                if(getFromStack.mark==2)
                    result.add(getFromStack.t.val);
                else if(getFromStack.mark==0){
                    getFromStack.mark=1;
                    backTrace.push(getFromStack);
                    if(getFromStack.t.left!=null)
                        backTrace.push(new stackTree(getFromStack.t.left,0));
                }
                else{
                    getFromStack.mark=2;
                    backTrace.push(getFromStack);
                    if(getFromStack.t.right!=null)
                        backTrace.push(new stackTree(getFromStack.t.right,0));
                }
            }
            return result;
        	}
    	}
    }
    
    public static void  main(String arg[]) {
		TreeNode aNode = new TreeNode(3);
		aNode.right = new TreeNode(4);
		ArrayList<Integer> all = preorderTraversal(aNode);
		for(Integer n : all){
			System.out.println(n);
		}
	}
}
