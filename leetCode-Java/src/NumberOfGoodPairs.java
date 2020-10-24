/**
 * @author simple
 * 给你一个整数数组 nums 。
 * <p>
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * <p>
 * 返回好数对的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-good-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfGoodPairs {
    /**
     * 思路：利用两层循环，取第一层循环的值跟第二层循环中当前值的后面的值比较，如果有相等的则++count；
     * 执行用时：1 ms, 在所有 Java 提交中击败了82.24%的用户
     * 内存消耗：35.6 MB, 在所有 Java 提交中击败了97.93%的用户
     */
    public int numIdenticalPairs(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) count += 1;
            }
        }
        return count;
    }
}
