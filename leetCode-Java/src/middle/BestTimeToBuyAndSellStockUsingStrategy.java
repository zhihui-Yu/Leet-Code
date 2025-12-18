package middle;

/**
 * 3652. 按策略买卖股票的最佳时机
 * 给你两个整数数组 prices 和 strategy，其中：
 * <p>
 * prices[i] 表示第 i 天某股票的价格。
 * strategy[i] 表示第 i 天的交易策略，其中：
 * -1 表示买入一单位股票。
 * 0 表示持有股票。
 * 1 表示卖出一单位股票。
 * 同时给你一个 偶数 整数 k，你可以对 strategy 进行 最多一次 修改。一次修改包括：
 * <p>
 * 选择 strategy 中恰好 k 个 连续 元素。
 * 将前 k / 2 个元素设为 0（持有）。
 * 将后 k / 2 个元素设为 1（卖出）。
 * 利润 定义为所有天数中 strategy[i] * prices[i] 的 总和 。
 * <p>
 * 返回你可以获得的 最大 可能利润。
 * <p>
 * 注意： 没有预算或股票持有数量的限制，因此所有买入和卖出操作均可行，无需考虑过去的操作。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： prices = [4,2,8], strategy = [-1,0,1], k = 2
 * <p>
 * 输出： 10
 * <p>
 * 解释：
 * <p>
 * 修改	策略	利润计算	利润
 * 原始	[-1, 0, 1]	(-1 × 4) + (0 × 2) + (1 × 8) = -4 + 0 + 8	4
 * 修改 [0, 1]	[0, 1, 1]	(0 × 4) + (1 × 2) + (1 × 8) = 0 + 2 + 8	10
 * 修改 [1, 2]	[-1, 0, 1]	(-1 × 4) + (0 × 2) + (1 × 8) = -4 + 0 + 8	4
 * 因此，最大可能利润是 10，通过修改子数组 [0, 1] 实现。
 * <p>
 * 示例 2：
 * <p>
 * 输入： prices = [5,4,3], strategy = [1,1,0], k = 2
 * <p>
 * 输出： 9
 * <p>
 * 解释：
 * <p>
 * 修改	策略	利润计算	利润
 * 原始	[1, 1, 0]	(1 × 5) + (1 × 4) + (0 × 3) = 5 + 4 + 0	9
 * 修改 [0, 1]	[0, 1, 0]	(0 × 5) + (1 × 4) + (0 × 3) = 0 + 4 + 0	4
 * 修改 [1, 2]	[1, 0, 1]	(1 × 5) + (0 × 4) + (1 × 3) = 5 + 0 + 3	8
 * 因此，最大可能利润是 9，无需任何修改即可达成。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= prices.length == strategy.length <= 10^5
 * 1 <= prices[i] <= 10^5
 * -1 <= strategy[i] <= 1
 * 2 <= k <= prices.length
 * k 是偶数
 *
 * @author simple
 */
public class BestTimeToBuyAndSellStockUsingStrategy {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long[] total = new long[n + 1];
        long[] priceSum = new long[n + 1];
        // 统计价格前缀和
        for (int i = 0; i < n; i++) {
            total[i + 1] = total[i] + (long) strategy[i] * prices[i];
            priceSum[i + 1] = priceSum[i] + prices[i];
        }

        long ans = total[n];
        for (int i = k; i <= n; i++) {
            long leftTotal = total[i - k];
            long rightTotal = total[n] - total[i];
            // 将后 k / 2 个元素设为 1（卖出）
            long changed = priceSum[i] - priceSum[i - k / 2];
            ans = Math.max(ans, leftTotal + rightTotal + changed);
        }
        return ans;
    }
}
