package tag.linked;

import tag.ListNode;

public class ReverseListII {
    // https://leetcode.com/problems/reverse-linked-list-ii/description/
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int c = 1;
        ListNode p = null;
        ListNode q = head;
        ListNode t, x, y;

        while(c < m) {
            p = q;
            q = q.next;
            c++;
        }
        x = p;
        y = q;

        while(c <= n) {
            t = q.next;
            q.next = p;
            p = q;
            q = t;
            c++;
        }

        y.next = q;

        if(x == null) return p;
        else {
            x.next = p;
            return head;
        }
    }
}
