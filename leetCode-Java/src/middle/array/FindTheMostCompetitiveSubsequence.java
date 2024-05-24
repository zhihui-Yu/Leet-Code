package middle.array;

/**
 * 1673. 找出最具竞争力的子序列
 * 给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。
 * <p>
 * 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
 * <p>
 * 在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。
 * 例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,5,2,6], k = 2
 * 输出：[2,6]
 * 解释：在所有可能的子序列集合 {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 最具竞争力。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,3,3,5,4,9,6], k = 4
 * 输出：[2,3,3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^9
 * 1 <= k <= nums.length
 *
 * @author simple
 */
public class FindTheMostCompetitiveSubsequence {
    // 题目翻译成人话就是： 数组顺序不能变的情况下，寻找长度为k的最小字典序子数组
    // 比如： [3,5,2,6] k=2 -> 长度为2的最小字典序，当然就是 [2,6] 了
    public int[] mostCompetitive(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[k];
        int cur = 0; // 栈的大小
        for (int i = 0; i < len; i++) {
            int x = nums[i];
            // 当栈有数据，且当前x 小于栈顶元素， 并且栈内元素+数组剩余元素 大于 k时，栈顶弹出
            while (cur > 0 && x < res[cur - 1] && cur + len - i > k) {
                cur--;
            }

            // 要将不需要的元素弹出栈后 x才能入站
            if (cur < k) {
                res[cur++] = x;
            }
        }
        return res;
    }
}
