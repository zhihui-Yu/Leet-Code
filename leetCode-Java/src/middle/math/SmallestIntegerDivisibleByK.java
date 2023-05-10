package middle.math;

/**
 * 1015. 可被 K 整除的最小整数
 * 给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最 小 正整数 n 的长度。
 * <p>
 * 返回 n 的长度。如果不存在这样的 n ，就返回-1。
 * <p>
 * 注意： n 不符合 64 位带符号整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 1
 * 输出：1
 * 解释：最小的答案是 n = 1，其长度为 1。
 * 示例 2：
 * <p>
 * 输入：k = 2
 * 输出：-1
 * 解释：不存在可被 2 整除的正整数 n 。
 * 示例 3：
 * <p>
 * 输入：k = 3
 * 输出：3
 * 解释：最小的答案是 n = 111，其长度为 3。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 105
 *
 * @author simple
 */
public class SmallestIntegerDivisibleByK {
    public int smallestRepunitDivByK(int k) {
        // 2 4 5 6 8 0 结尾的数字，不论与任何数字相乘都不会以1结尾
        if (k % 2 == 0 || k % 5 == 0) return -1;
        int x = 1 % k;
        for (int i = 1; ; i++) { // 一定有解， 且i<=k 费马小定理
            if (x == 0)
                return i;
            x = (x * 10 + 1) % k;
        }

//        int n = 1 % k;
//        for (int i = 1; i <= k; i++) { //
//            if (n == 0) return i;
//            n = (n * 10 + 1) % k;
//        }
//        return -1;
    }
}
