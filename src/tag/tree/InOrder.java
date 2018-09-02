package tag.tree;

import tag.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InOrder {
    // https://leetcode.com/problems/binary-tree-inorder-traversal/description/
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> s = new Stack<>();

        TreeNode curr = root;
        while(curr != null || !s.isEmpty()) {
            while(curr != null) {
                s.push(curr);
                curr = curr.left;
            }

            curr = s.peek();
            res.add(curr.val);
            curr = curr.right;
            s.pop();
        }

        return res;
    }

}
