package easy;

/**
 * 1437. 是否所有 1 都至少相隔 k 个元素
 * 给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [1,0,0,0,1,0,0,1], k = 2
 * 输出：true
 * 解释：每个 1 都至少相隔 2 个元素。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [1,0,0,1,0,1], k = 2
 * 输出：false
 * 解释：第二个 1 和第三个 1 之间只隔了 1 个元素。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * 0 <= k <= nums.length
 * nums[i] 的值为 0 或 1
 *
 * @author simple
 */
public class CheckIfAll1sAreAtLeastLengthKPlacesAway {
    public boolean kLengthApart(int[] nums, int k) {
        int i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] == 1) {
                int cnt0 = 0;
                i++;
                while (i < n && nums[i] == 0) {
                    cnt0++;
                    i++;
                }
                if (i < n && nums[i] == 1 && cnt0 < k) return false;
            } else {
                i++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CheckIfAll1sAreAtLeastLengthKPlacesAway().kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2));
        System.out.println(new CheckIfAll1sAreAtLeastLengthKPlacesAway().kLengthApart(new int[]{1, 0, 0, 0, 1, 0, 0, 1, 0}, 2));
        System.out.println(new CheckIfAll1sAreAtLeastLengthKPlacesAway().kLengthApart(new int[]{0, 1, 0, 1}, 1));
        System.out.println(new CheckIfAll1sAreAtLeastLengthKPlacesAway().kLengthApart(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2));
    }
}
