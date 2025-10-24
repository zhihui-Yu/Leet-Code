package middle;

/**
 * 2048. 下一个更大的数值平衡数
 * 如果整数  x 满足：对于每个数位 d ，这个数位 恰好 在 x 中出现 d 次。那么整数 x 就是一个 数值平衡数 。
 * <p>
 * 给你一个整数 n ，请你返回 严格大于 n 的 最小数值平衡数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：22
 * 解释：
 * 22 是一个数值平衡数，因为：
 * - 数字 2 出现 2 次
 * 这也是严格大于 1 的最小数值平衡数。
 * 示例 2：
 * <p>
 * 输入：n = 1000
 * 输出：1333
 * 解释：
 * 1333 是一个数值平衡数，因为：
 * - 数字 1 出现 1 次。
 * - 数字 3 出现 3 次。
 * 这也是严格大于 1000 的最小数值平衡数。
 * 注意，1022 不能作为本输入的答案，因为数字 0 的出现次数超过了 0 。
 * 示例 3：
 * <p>
 * 输入：n = 3000
 * 输出：3133
 * 解释：
 * 3133 是一个数值平衡数，因为：
 * - 数字 1 出现 1 次。
 * - 数字 3 出现 3 次。
 * 这也是严格大于 3000 的最小数值平衡数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 10^6
 *
 * @author simple
 */
public class NextGreaterNumericallyBalancedNumber {
    public int nextBeautifulNumber(int n) {
        // ans最大值为1224444 > 10^6
        for (int i = n + 1; i <= 1224444; i++) {
            int[] cnt = new int[10];
            String x = String.valueOf(i);
            for (int j = 0; j < x.length(); j++) {
                cnt[x.charAt(j) - '0']++;
            }


            boolean balance = true;
            for (int j = 0; j < cnt.length; j++) {
                if (cnt[j] > 0 && cnt[j] != j) {
                    balance = false;
                    break;
                }
            }

            if (balance) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new NextGreaterNumericallyBalancedNumber().nextBeautifulNumber(9));
    }
}
