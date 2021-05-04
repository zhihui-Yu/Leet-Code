package middle;

/**
 * @author simple
 * <p>
 * 给你一个整数数组nums，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个nums[i]，删除它并获得nums[i]的点数。之后，你必须删除每个等于nums[i] - 1或nums[i] + 1的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例2：
 * <p>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 10^4
 * 1 <= nums[i] <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-and-earn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }
        int[] bucket = new int[max + 1];
        for (int i : nums) {
            bucket[i]++;
        }

        // dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
        // 如 [0,1,2,3] -> dp[3] = Math.max(dp[2], dp[1] + 3 * 3); -> 当前的最大值就是等于取中间还是取两侧的一个抉择
        int[] dp = new int[max + 1];
        dp[1] = bucket[1];
        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + bucket[i] * i);
        }
        return dp[max];
    }

    public static void main(String[] args) {
        new DeleteAndEarn().deleteAndEarn(new int[]{3, 4, 2});
    }
}
