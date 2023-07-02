package middle;

/**
 * 2. 两数相加
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
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author simple
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 尾插法 + 进位制
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        int sum;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            sum = val1 + val2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            // 尾插node， val -> 链表相应位置的和的余数
            if (head == null) {
                head = tail = new ListNode(sum);
            } else {
                tail.next = new ListNode(sum);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 如果最后还有进位 则多加一个node在尾部
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    // 用于long 长度 > 链表的长度
    public ListNode addTwoNumbersV1(ListNode l1, ListNode l2) {
        long l1Number = 0;
        long l2Number = 0;
        long i = 1;
        while (l1 != null) {
            l1Number += i * l1.val;
            l1 = l1.next;
            i = i * 10;
        }
        i = 1;
        while (l2 != null) {
            l2Number += i * l2.val;
            l2 = l2.next;
            i = i * 10;
        }
        long count = l1Number + l2Number;
        ListNode res = null;
        String num = String.valueOf(count);
        for (int j = 0; j < num.length(); j++) {
            ListNode head = new ListNode();
            head.next = res;
            head.val = num.charAt(j) - 48;
            res = head;
        }
        return res;
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

