package easy;

/**
 * @author simple
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, m = 3
 * 输出:3
 * 示例 2：
 * <p>
 * 输入: n = 10, m = 17
 * 输出:2
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= n<= 10^5
 * 1 <= m <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class YuanQuanZhongZuiHouShengXiaDeShuZiLcof {
    public int lastRemaining2(int n, int m) {
        //Krahets -> 从最后剩下两个数字开始递归，计算出最后删除数字的原始位置
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }

    public int lastRemaining(int n, int m) {
        // 思路一 创建一个回环链表， 然后做删除操作
        Node head = new Node(0, null, null);
        Node tmp = head;
        for (int i = 1; i < n; i++) {
            tmp.next = new Node(i, null, tmp);
            tmp = tmp.next;
        }
        tmp.next = head;
        head.pre = tmp;

        int pos = 0;
        while (head.val != head.next.val) {
            if (++pos == m) {
                head.pre.next = head.next;
                head.next.pre = head.pre;
                pos = 0;
            }
            head = head.next;
        }
        return head.val;
    }

    public static class Node {
        public int val;
        public Node next;
        public Node pre;

        public Node(int val, Node next, Node pre) {
            this.val = val;
            this.next = next;
            this.pre = pre;
        }
    }

    public static void main(String[] args) {
        //64165
        System.out.println(new YuanQuanZhongZuiHouShengXiaDeShuZiLcof().lastRemaining2(70866, 116922));
        System.out.println(new YuanQuanZhongZuiHouShengXiaDeShuZiLcof().lastRemaining(5, 1));
        System.out.println(new YuanQuanZhongZuiHouShengXiaDeShuZiLcof().lastRemaining(5, 3));
        System.out.println(new YuanQuanZhongZuiHouShengXiaDeShuZiLcof().lastRemaining(10, 17));
    }
}
