package tag.tree;

import tag.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    // https://leetcode.com/problems/binary-tree-postorder-traversal/description/
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();

        TreeNode curr = root, lastVisited = null;
        while(curr != null || !s.isEmpty()) {
            while(curr != null) {
                s.push(curr);
                curr = curr.left;
            }

            curr = s.peek();
            if(curr.right == null || curr.right == lastVisited) {
                res.add(curr.val);
                s.pop();
                lastVisited = curr;
                curr = null;
            } else {
                curr = curr.right;
            }
        }

        return res;
    }
}
