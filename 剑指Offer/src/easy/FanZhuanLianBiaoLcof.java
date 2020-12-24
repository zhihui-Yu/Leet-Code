package easy;

/**
 * @author simple
 * <p>
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FanZhuanLianBiaoLcof {
    public ListNode reverseList(ListNode head) {
        // 双指针
        ListNode cur = null, pre = head;
        while (pre != null) {
            ListNode node = pre.next;
            pre.next = cur;
            cur = pre;
            pre = node;
        }
        return cur;

        // 递归
//        if (head.next == null) return head;
//        ListNode node = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return node;

        // 自解
//        if (head == null) return head;
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        while (head != null) {
//            linkedList.addLast(head.val);
//            head = head.next;
//        }
//        int size = linkedList.size();
//        ListNode res = new ListNode(linkedList.pollLast());
//        ListNode other = res;
//        for (int i = 1; i < size; i++) {
//            other.next = new ListNode(linkedList.pollLast());
//            other = other.next;
//        }
//        return res;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(5);
        new FanZhuanLianBiaoLcof().reverseList(node);
    }
}
