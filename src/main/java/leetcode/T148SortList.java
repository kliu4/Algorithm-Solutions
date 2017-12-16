package leetcode;

import util.ListNode;

public class T148SortList {
	private ListNode findMid(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode fast = head.next;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	private ListNode merge(ListNode left, ListNode right) {
		if (left == null)
			return right;
		if (right == null)
			return left;

		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		while (left != null && right != null) {
			if (left.val < right.val) {
				pre.next = left;
				left = left.next;
			} else {
				pre.next = right;
				right = right.next;
			}
			pre = pre.next;
		}

		if (left != null) {
			pre.next = left;
		}

		if (right != null) {
			pre.next = right;
		}

		return dummy.next;
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode mid = findMid(head);
		ListNode right = mid.next;
		mid.next = null;

		ListNode leftS = sortList(head);
		ListNode rightS = sortList(right);

		return merge(leftS, rightS);
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		new T148SortList().sortList(head);
	}
}
