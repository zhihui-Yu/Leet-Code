package easy;

/**
 * 2928. 给小朋友们分糖果 I
 * 给你两个正整数 n 和 limit 。
 * <p>
 * 请你将 n 颗糖果分给 3 位小朋友，确保没有任何小朋友得到超过 limit 颗糖果，请你返回满足此条件下的 总方案数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, limit = 2
 * 输出：3
 * 解释：总共有 3 种方法分配 5 颗糖果，且每位小朋友的糖果数不超过 2 ：(1, 2, 2) ，(2, 1, 2) 和 (2, 2, 1) 。
 * 示例 2：
 * <p>
 * 输入：n = 3, limit = 3
 * 输出：10
 * 解释：总共有 10 种方法分配 3 颗糖果，且每位小朋友的糖果数不超过 3 ：
 * (0, 0, 3) ，(0, 1, 2) ，(0, 2, 1) ，(0, 3, 0) ，(1, 0, 2) ，(1, 1, 1) ，(1, 2, 0) ，(2, 0, 1) ，(2, 1, 0) 和 (3, 0, 0) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 50
 * 1 <= limit <= 50
 *
 * @author simple
 */
public class DistributeCandiesAmongChildrenI {
    // 假设第一个小朋友拿了 x， 第二个拿了 y， 第三个拿了 n-x-y，只要三者符合小于limit，就属于合格方案
    public int distributeCandies(int n, int limit) {
        int ans = 0;
        for (int x = 0; x <= limit; x++) {
            for (int y = 0; y <= limit; y++) {
                if (x + y > n)
                    break;
                if (n - x - y <= limit) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
