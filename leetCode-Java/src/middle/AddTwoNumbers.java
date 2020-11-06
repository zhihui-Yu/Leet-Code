package middle;

/**
 * @author simple
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Number = 0;
        int l2Number = 0;
        int i = 1;
        while (l1.next != null) {
            l1Number += i * l1.val;
            l1 = l1.next;
            i = i * 10;
        }
        i = 1;
        while (l2.next != null) {
            l2Number += i * l2.val;
            l2 = l2.next;
            i = i * 10;
        }
        int count = l1Number + l2Number;
        ListNode res = new ListNode();
        return null;
    }

    static class ListNode {
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

