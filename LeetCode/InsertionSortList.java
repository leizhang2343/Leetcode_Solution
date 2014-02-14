package LeetCode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ListNode begin = null;
        ListNode current = head;
        ListNode next = head.next;
        current.next = null;
        while(current != null){
            //insert current;
            if(begin == null){
                begin = current;
            } else {
                if(begin.val > current.val){
                    ListNode tmpNext = begin;
//                    begin = null;
                    begin = current;
                    begin.next = tmpNext;
                }
                ListNode tmpBegin = begin;
                while( tmpBegin != null){
                    if( tmpBegin.next == null||tmpBegin.next.val > current.val){
                        ListNode tmpBeginNext = tmpBegin.next;
//                        tmpBegin.next = null;
                        tmpBegin.next = current;
                        tmpBegin.next.next = tmpBeginNext;
                        break;
                    }
                    tmpBegin = tmpBegin.next;
                }
            }
            if(next == null)
            	return begin;
            ListNode tmpNextAll = next.next;
            current = next;
            if(current != null)
            current.next = null;
            next = tmpNextAll;
        }
        return begin;
    }
    
    
    public static void main(String[] args){
    	ListNode head = new ListNode(12);
    	ListNode node = head;
    	for(int i = 11; i > 0; i--){
    		node.next = new ListNode(i);
    		node = node.next;
    	}
    	node = head;
    	while(node != null){
    		System.out.print(node.val+",");
    		node = node.next;
    	}
    	System.out.println();
    	InsertionSortList text = new InsertionSortList();
    	head = text.insertionSortList(head);
    	node = head;
    	while(node != null){
    		System.out.print(node.val+",");
    		node = node.next;
    	}
    }
}
