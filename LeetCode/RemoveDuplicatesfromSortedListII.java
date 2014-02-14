package LeetCode;

public class RemoveDuplicatesfromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode node = newHead;
        while(node.next != null){
            if(node.next.next != null){
                if(node.next.val == node.next.next.val){
                    node.next = checkNext(node.next,node.next.val);
                    continue;
                }
            }
            node = node.next;
        }
        return newHead.next;
    }
    
     public ListNode checkNext(ListNode head,int n){
       while(head != null && head.val == n){
           head = head.next;
       }
        return head;
    }
     public static void main(String[] args){
    	 RemoveDuplicatesfromSortedListII test = new RemoveDuplicatesfromSortedListII();
    	 ListNode head = new ListNode(1);
    	 head.next = new ListNode(1);
    	 test.deleteDuplicates(head);
     }
}
