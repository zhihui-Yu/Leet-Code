package middle.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 1019. 链表中的下一个更大节点
 * 给定一个长度为 n 的链表 head
 * <p>
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，
 * 设置 answer[i] = 0 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：head = [2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数为 n
 * 1 <= n <= 10^4
 * 1 <= Node.val <= 10^9
 *
 * @author simple
 */
public class NextGreaterNodeInLinkedList {
    // O(n)
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> queue = new LinkedList<>();
        while (head != null) {
            queue.add(head.val);
            head = head.next;
        }

        int len = queue.size();
        // 维护一个单调递减的栈
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            Integer num = queue.get(i);
            while (!stack.isEmpty() && stack.peek() <= num) stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(num);
        }
        return ans;
    }

    // O(n^2)
    public int[] nextLargerNodes2(ListNode head) {
        Deque<Integer> queue = new LinkedList<>();
        while (head != null) {
            queue.add(head.val);
            head = head.next;
        }
        int len = queue.size();
        int[] array = queue.stream().mapToInt(x -> x).toArray();

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int x = array[i];
            for (int j = i; j < len; j++) {
                if (x < array[j]) {
                    ans[i] = array[j];
                    break;
                }
            }
        }
        return ans;
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
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
