package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

public class PostorderTraversal {
	
	public void postortTraversalIterrative(TreeNode root, ArrayList<Integer> all){
        if(root == null){
            return;
        }
        Stack<TreeNode> parentStack = new Stack<TreeNode>();
        TreeNode lastVistNode = null;
        TreeNode node = root;
        while(node != null || !parentStack.isEmpty()){
            if(node != null){
                parentStack.push(node);
                node = node.left;
            } else {
                TreeNode peekNode = parentStack.peek();
                if(peekNode.right != null && lastVistNode != peekNode.right){
                    /*if taversing nood from left child and right child exists, move right*/
                    node = peekNode.right;
                } else {
                	System.out.print("ddd");
                    lastVistNode = peekNode;
                    all.add(parentStack.pop().val);
                }
            }
        }
    }
	
	public static void  main(String arg[]) {
		TreeNode aNode = new TreeNode(3);
		aNode.right = new TreeNode(4);
		PostorderTraversal test = new PostorderTraversal();
		ArrayList<Integer> all = new ArrayList<>();
		test.postortTraversalIterrative(aNode,all);
		for(Integer n : all){
			System.out.println(n);
		}
	}
}
