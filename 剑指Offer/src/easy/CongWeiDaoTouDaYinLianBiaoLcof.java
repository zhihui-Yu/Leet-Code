package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author simple
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 */
public class CongWeiDaoTouDaYinLianBiaoLcof {
    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        int size = res.size();
        int[] result = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            result[size - i - 1] = res.get(i);
        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
