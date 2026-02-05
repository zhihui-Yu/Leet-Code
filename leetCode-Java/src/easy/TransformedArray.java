package easy;

import java.util.Arrays;

/**
 * 3379. 转换数组
 * 给你一个整数数组 nums，它表示一个循环数组。请你遵循以下规则创建一个大小 相同 的新数组 result ：
 * <p>
 * 对于每个下标 i（其中 0 <= i < nums.length），独立执行以下操作：
 * 如果 nums[i] > 0：从下标 i 开始，向 右 移动 nums[i] 步，在循环数组中落脚的下标对应的值赋给 result[i]。
 * 如果 nums[i] < 0：从下标 i 开始，向 左 移动 abs(nums[i]) 步，在循环数组中落脚的下标对应的值赋给 result[i]。
 * 如果 nums[i] == 0：将 nums[i] 的值赋给 result[i]。
 * 返回新数组 result。
 * <p>
 * 注意：由于 nums 是循环数组，向右移动超过最后一个元素时将回到开头，向左移动超过第一个元素时将回到末尾。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [3,-2,1,1]
 * <p>
 * 输出： [1,1,1,3]
 * <p>
 * 解释：
 * <p>
 * 对于 nums[0] 等于 3，向右移动 3 步到 nums[3]，因此 result[0] 为 1。
 * 对于 nums[1] 等于 -2，向左移动 2 步到 nums[3]，因此 result[1] 为 1。
 * 对于 nums[2] 等于 1，向右移动 1 步到 nums[3]，因此 result[2] 为 1。
 * 对于 nums[3] 等于 1，向右移动 1 步到 nums[0]，因此 result[3] 为 3。
 * 示例 2：
 * <p>
 * 输入： nums = [-1,4,-1]
 * <p>
 * 输出： [-1,-1,4]
 * <p>
 * 解释：
 * <p>
 * 对于 nums[0] 等于 -1，向左移动 1 步到 nums[2]，因此 result[0] 为 -1。
 * 对于 nums[1] 等于 4，向右移动 4 步到 nums[2]，因此 result[1] 为 -1。
 * 对于 nums[2] 等于 -1，向左移动 1 步到 nums[1]，因此 result[2] 为 4。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 *
 * @author simple
 */
public class TransformedArray {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int k = nums[i];
            // 等价 ((i + nums[i]) % n + n) % n [0,n)
            int x = (i + k + 100 * n) % n;
            res[i] = nums[x];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TransformedArray().constructTransformedArray(new int[]{-10, -10})));
        System.out.println(Arrays.toString(new TransformedArray().constructTransformedArray(new int[]{3, -2, 1, 1})));
    }
}
