package easy;

/**
 * @author simple
 */
public class LiangGeLianBiaoDeDiYiGeGongGongJieDianLcof {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 算出长度差x,然后让长的先走x步,然后再一起走,遍历完 有相交则返回
        if (headA == null || headB == null) return null;
        int aLen = 0;
        ListNode temp = headA;
        while (temp != null) {
            temp = temp.next;
            aLen++;
        }
        int bLen = 0;
        temp = headB;
        while (temp != null) {
            temp = temp.next;
            bLen++;
        }

        if (aLen > bLen) {
            int i = aLen - bLen;
            while (i-- > 0) {
                headA = headA.next;
            }
        }

        if (bLen > aLen) {
            int i = bLen - aLen;
            while (i-- > 0) {
                headB = headB.next;
            }
        }

        while (headA != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
