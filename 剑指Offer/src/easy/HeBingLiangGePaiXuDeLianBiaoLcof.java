package easy;

/**
 * @author simple
 * <p>
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 1000
 * <p>
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HeBingLiangGePaiXuDeLianBiaoLcof {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while (true) {
            if (l1 != null && l2 != null && l1.val > l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else if (l1 != null && l2 != null) {
                head.next = l1;
                l1 = l1.next;
            } else if (l1 != null) {
                head.next = l1;
                break;
            } else {
                head.next = l2;
                break;
            }
            head = head.next;
        }
        return tmp.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(4);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        new HeBingLiangGePaiXuDeLianBiaoLcof().mergeTwoLists(node, node2);
    }
}
