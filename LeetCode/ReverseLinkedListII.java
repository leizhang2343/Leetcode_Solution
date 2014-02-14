package LeetCode;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode nodeBeforHead = new ListNode(0);
        nodeBeforHead.next = head;
        ListNode node = nodeBeforHead;
        int counter = 1;
        while(node != null){
            if(counter == m){
            	swapMtoN(node,n - m); 
            }
            node = node.next;
            counter++;
        }
        return nodeBeforHead.next;
    }
    
    void swapMtoN(ListNode head,int nMinusM){
        int counter = 0;
        if(nMinusM == 0) return;
        ListNode node = head;
        while(counter < nMinusM){
            swapTowtoThree(node);
            node = node .next;
            counter++;
        }
        nMinusM--;
        swapMtoN(head,nMinusM);
    }
    
    void swapTowtoThree(ListNode head){
        ListNode tmp = head.next;
        ListNode tmpTail = head.next.next.next;
//        tmp.next = null;
        head.next = head.next.next;
        head.next.next = tmp;
        tmp.next = tmpTail;
    }
    
    public static void main(String[] args){
    	ReverseLinkedListII test = new ReverseLinkedListII();
    	ListNode head = new ListNode(-1);
    	head.next = new ListNode(0);
    	head.next.next = new ListNode(1);
    	head.next.next.next = new ListNode(2);
    	test.reverseBetween(head, 1, 2);
    }
}
