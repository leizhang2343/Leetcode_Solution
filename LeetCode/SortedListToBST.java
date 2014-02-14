package LeetCode;

public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        return listToBSTRecusive(head);
    }
    
    TreeNode listToBSTRecusive(ListNode head){
    	if(head == null){
    		return null;
    	}
        if(head.next == null){
            return new TreeNode(head.val);
        }
        if(head.next.next == null){
            TreeNode root = new TreeNode(head.val);
            root.right = new TreeNode(head.next.val);
            return root;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        ListNode beforeSlow = head;
        while(fast != null && fast.next != null){
        	beforeSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        beforeSlow.next = null;
        root.left = listToBSTRecusive(head);
        root.right = listToBSTRecusive(slow.next);
        
       
        return root;
    }
    
    public static void main(String[] args){
    	SortedListToBST test = new SortedListToBST();
    	ListNode head = new ListNode(-1);
    	head.next = new ListNode(0);
    	head.next.next = new ListNode(1);
    	head.next.next.next = new ListNode(2);
    	test.listToBSTRecusive(head);
    }
}
