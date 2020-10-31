package easy;

/**
 * @author simple
 * <p>
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[4,2,1]
 * <p>
 * 输出：4
 * <p>
 * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 * <p>
 * 示例 2：
 * <p>
 * 输入：[2,3,10]
 * <p>
 * 输出：8
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 4
 * 1 <= coins[i] <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/na-ying-bi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NaYingBi {
    public int minCount(int[] coins) {
        int count = 0;
        for (int coin : coins) {
            int i = coin / 2;
            int mod = coin % 2;
            count = count + i + mod;
        }
        return count;
    }
}
