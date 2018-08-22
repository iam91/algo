package tag.linked;

import tag.ListNode;

public class ReverseList {
    // https://leetcode.com/problems/reverse-linked-list/description/
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode q = head;
        ListNode t;
        while(q != null) {
            t = q.next;
            q.next = p;
            p = q;
            q = t;
        }
        return p;
    }
}
