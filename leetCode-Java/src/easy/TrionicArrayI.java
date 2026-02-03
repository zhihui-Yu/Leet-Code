package easy;

/**
 * 3637. 三段式数组 I
 * 给你一个长度为 n 的整数数组 nums。
 * <p>
 * 如果存在索引 0 < p < q < n − 1，使得数组满足以下条件，则称其为 三段式数组（trionic）：
 * <p>
 * nums[0...p] 严格 递增，
 * nums[p...q] 严格 递减，
 * nums[q...n − 1] 严格 递增。
 * 如果 nums 是三段式数组，返回 true；否则，返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,4,2,6]
 * <p>
 * 输出: true
 * <p>
 * 解释:
 * <p>
 * 选择 p = 2, q = 4：
 * <p>
 * nums[0...2] = [1, 3, 5] 严格递增 (1 < 3 < 5)。
 * nums[2...4] = [5, 4, 2] 严格递减 (5 > 4 > 2)。
 * nums[4...5] = [2, 6] 严格递增 (2 < 6)。
 * 示例 2:
 * <p>
 * 输入: nums = [2,1,3]
 * <p>
 * 输出: false
 * <p>
 * 解释:
 * <p>
 * 无法选出能使数组满足三段式要求的 p 和 q 。
 * <p>
 * 提示:
 * <p>
 * 3 <= n <= 100
 * -1000 <= nums[i] <= 1000
 *
 * @author simple
 */
public class TrionicArrayI {
    public boolean isTrionic(int[] nums) {
        if (nums[0] >= nums[1]) return false;

        int n = nums.length;
        int p = 1;
        while (p < n && nums[p - 1] < nums[p]) p++;
        if (p == 1) return false;

        int q = p;
        while (q < n && nums[q - 1] > nums[q]) q++;
        if (q == p || q == n) return false;

        while (q < n && nums[q - 1] < nums[q]) q++;
        return q == n;
    }

    public static void main(String[] args) {
        System.out.println(new TrionicArrayI().isTrionic(new int[]{2,1,3}));
        System.out.println(new TrionicArrayI().isTrionic(new int[]{1,3,5,4,2,6}));
    }
}
