package tag.math.random;

import tag.ListNode;

import java.util.Random;

public class RandomListNode {
    // https://leetcode.com/problems/linked-list-random-node/description/
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */

    private ListNode head;
    private Random rand;

    public RandomListNode(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int c = 0;
        ListNode curr = head, res = null;
        while(curr != null) {
            res = rand.nextInt(++c) == 0 ? curr : res;
            curr = curr.next;
        }
        return res.val;
    }
}
