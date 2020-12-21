package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @author simple
 * <p>
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个3叉树:
 * <p>
 * <p>
 *       1
 *   /  |  \
 *  3  2    4
 * / \
 * 5  6
 * <p>
 * <p>
 * 返回其后序遍历: [5,6,3,2,4,1].
 * <p>
 * <p>
 * <p>
 * 说明:递归法很简单，你可以使用迭代法完成此题吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class NAryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
//        解法一 递归
//        if (root == null) return List.of();
//        List<Integer> res = new ArrayList<>();
//        for (Node node : root.children) {
//            res.addAll(postorder(node));
//        }
//        res.add(root.val);
//        return res;

//        解法二 迭代
        // 默认 空数组
        if (root == null) return List.of();
        // 双端堆栈
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            Node lastNode = stack.pollLast();
            output.addFirst(lastNode.val);
            for (Node node : lastNode.children) {
                if (node != null) {
                    stack.addLast(node);
                }
            }
        }
        return output;
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
