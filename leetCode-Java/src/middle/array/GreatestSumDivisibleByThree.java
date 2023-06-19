package middle.array;

/**
 * 1262. 可被三整除的最大和
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 * <p>
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 *
 * @author simple
 */
public class GreatestSumDivisibleByThree {

    // 贪心： 将数组分成三类，余数为 0，1，2的。将数组全部累加，判断和余多少，余1，则两种可能，余2 也有两种可能，计算出舍弃的最小值，就得出最大值

    // 动态规划：定义f(i,j) => max { f(i-1, j), f(i-1, (j+x)%3 ) + x}
    // 第i个数字 当余数为 j 时，最和为多少。
    // 两种情况： 选与不选，
    // -- 不选则最大值为 f(i-1, j)
    // -- 选则为 f(i-1, (j+x)%3 ) + x [已知当前数x的余数，只需要加入 余数为（（j+x） % 3）% 3 的的最大值即可满足条件]
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][3];
        dp[0] = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE}; // 设置最小值，目的是为了 选的情况下 不用判断 dp[i][(j + x) % 3] 是否为0， 是0时候，是不能加x的
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = 0; j < 3; j++) {
                dp[i + 1][j] = Math.max(dp[i][j], dp[i][(j + x) % 3] + x);
            }
        }
        return dp[n][0];
    }

    public static void main(String[] args) {
        System.out.println(new GreatestSumDivisibleByThree().maxSumDivThree(new int[]{3, 6, 5, 1, 8}));
        System.out.println(1 + 2 % 3);
    }
}
