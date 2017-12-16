package leetcode;

import util.ListNode;

public class T025ReverseNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2)
            return head;
        
        ListNode fastHead = head;
        int count = k;
        while(count > 0 && fastHead != null){
            fastHead = fastHead.next;
            count--;
        }
        
        if(count > 0)
            return head;
        
        ListNode[] group = reverse(head, fastHead);
        ListNode newHead = group[0];
        ListNode newTail = group[1];
        newTail.next = reverseKGroup(fastHead, k);
        return newHead;
    }
    
    public ListNode[] reverse(ListNode head, ListNode next) {
        if(head == null)
            return new ListNode[]{head, head};
        
        ListNode oldHead = head;
        ListNode pre = null;
        while(head != next){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        return new ListNode[]{pre, oldHead};
    }
}
