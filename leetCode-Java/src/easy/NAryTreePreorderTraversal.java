package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author simple
 * <p>
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * <p>
 * 例如，给定一个3叉树:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * <p>
 * <p>
 * <p>
 * 说明:递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NAryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
//        递归
//        if (root == null) return List.of();
//        List<Integer> res = new ArrayList<>();
//        res.add(root.val);
//        for (int i = 0; i < root.children.size(); i++) {
//            res.addAll(preorder(root.children.get(i)));
//        }
//        return res;


        // 利用栈 来实现迭代
        if (root == null) return List.of();
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Node> stack = new LinkedList<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollFirst();
            res.add(node.val);
            // 保证第一个永远是最左边
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.addFirst(item);
            }
        }
        return res;
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
