package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersinEachNode {
	public class TreeLinkNode {
		 int val;
		    TreeLinkNode left, right, next;
		    TreeLinkNode(int x) { val = x; }
		 }
	
	public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        Queue<TreeLinkNode> bfsQueue = new LinkedList<TreeLinkNode>();
        bfsQueue.add(root);
        traverseByLevel(bfsQueue);
    }
    void traverseByLevel(Queue<TreeLinkNode> bfsQueue){
        Queue<TreeLinkNode> bfsQueueNext = new LinkedList<TreeLinkNode>();
        while(!bfsQueue.isEmpty()){
            TreeLinkNode tmp = bfsQueue.poll();
            if(tmp.left != null)
            bfsQueueNext.add(tmp.left);
            if(tmp.right != null)
            bfsQueueNext.add(tmp.right);
            tmp.next = bfsQueue.peek();
        }
        if(!bfsQueueNext.isEmpty()){
        	traverseByLevel(bfsQueueNext);
        }
        
    }
    
    public static void main(String[] args){
    	PopulatingNextRightPointersinEachNode test = new PopulatingNextRightPointersinEachNode();
    	TreeLinkNode t = test.new TreeLinkNode(0);
    	test.connect(t);
    }
}
