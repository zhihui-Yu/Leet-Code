package middle;

/**
 * 2483. 商店的最少代价
 * 给你一个顾客访问商店的日志，用一个下标从 0 开始且只包含字符 'N' 和 'Y' 的字符串 customers 表示：
 * <p>
 * 如果第 i 个字符是 'Y' ，它表示第 i 小时有顾客到达。
 * 如果第 i 个字符是 'N' ，它表示第 i 小时没有顾客到达。
 * 如果商店在第 j 小时关门（0 <= j <= n），代价按如下方式计算：
 * <p>
 * 在开门期间，如果某一个小时没有顾客到达，代价增加 1 。
 * 在关门期间，如果某一个小时有顾客到达，代价增加 1 。
 * 请你返回在确保代价 最小 的前提下，商店的 最早 关门时间。
 * <p>
 * 注意，商店在第 j 小时关门表示在第 j 小时以及之后商店处于关门状态。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：customers = "YYNY"
 * 输出：2
 * 解释：
 * - 第 0 小时关门，总共 1+1+0+1 = 3 代价。
 * - 第 1 小时关门，总共 0+1+0+1 = 2 代价。
 * - 第 2 小时关门，总共 0+0+0+1 = 1 代价。
 * - 第 3 小时关门，总共 0+0+1+1 = 2 代价。
 * - 第 4 小时关门，总共 0+0+1+0 = 1 代价。
 * 在第 2 或第 4 小时关门代价都最小。由于第 2 小时更早，所以最优关门时间是 2 。
 * 示例 2：
 * <p>
 * 输入：customers = "NNNNN"
 * 输出：0
 * 解释：最优关门时间是 0 ，因为自始至终没有顾客到达。
 * 示例 3：
 * <p>
 * 输入：customers = "YYYY"
 * 输出：4
 * 解释：最优关门时间是 4 ，因为每一小时均有顾客到达。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= customers.length <= 10^5
 * customers 只包含字符 'Y' 和 'N' 。
 *
 * @author simple
 */
public class MinimumPenaltyForAShop {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        // 都不营业的话，代价总和
        int[] close = new int[n + 1];
        int[] open = new int[n + 1];
        for (int i = 0; i < n; i++) {
            open[i + 1] = open[i] + (customers.charAt(i) == 'N' ? 1 : 0);
            close[i + 1] = close[i] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }


        // cnt 为i小时在营业时的代价和
        int min = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i <= n; i++) {
            // i 小时关门后的代价
            int c = close[n] - close[i];

            if (min > c + open[i]) {
                min = c + open[i];
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumPenaltyForAShop().bestClosingTime("YYNY"));
        System.out.println(new MinimumPenaltyForAShop().bestClosingTime("NNNNN"));
        System.out.println(new MinimumPenaltyForAShop().bestClosingTime("YYYY"));
    }
}
