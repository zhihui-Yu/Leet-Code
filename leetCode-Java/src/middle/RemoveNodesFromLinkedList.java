package middle;

import java.util.List;

/**
 * 2487. 从链表中移除节点
 * 给你一个链表的头节点 head 。
 * 移除每个右侧有一个更大数值的节点。
 * 返回修改后链表的头节点 head 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [5,2,13,3,8]
 * 输出：[13,8]
 * 解释：需要移除的节点是 5 ，2 和 3 。
 * - 节点 13 在节点 5 右侧。
 * - 节点 13 在节点 2 右侧。
 * - 节点 8 在节点 3 右侧。
 * 示例 2：
 * <p>
 * 输入：head = [1,1,1,1]
 * 输出：[1,1,1,1]
 * 解释：每个节点的值都是 1 ，所以没有需要移除的节点。
 * <p>
 * 提示：
 * 给定列表中的节点数目在范围 [1, 10^5] 内
 * 1 <= Node.val <= 10^5
 *
 * @author simple
 */
public class RemoveNodesFromLinkedList {
    // 方法一： 递归，先处理右侧的，递归来回来右侧就是结果了，每次只要比较head 和 head.next
    public ListNode removeNodes(ListNode head) {
        if (head == null) return null;
        head.next = removeNodes(head.next);
        if (head.next != null && head.val < head.next.val) {
            return head.next; // 返回更大值
        } else {
            return head;
        }
    }

    // 方法二： 将链表反转 -> 处理 -> 再反转

    public static void main(String[] args) {
        var nodes = List.of(1, 1, 2, 1, 1);
//        var nodes = List.of(5, 2, 13, 3, 8);
        ListNode header = new ListNode();
        ListNode headerCp = header;
        for (int i = 0; i < nodes.size() - 1; i++) {
            header.val = nodes.get(i);
            header.next = new ListNode(nodes.get(i + 1));

            header = header.next;
        }

        new RemoveNodesFromLinkedList().removeNodes(headerCp);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
