package middle;

import java.util.Arrays;
import java.util.Map;

/**
 * 611. 有效三角形的个数
 * 给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,2,3,4]
 * 输出: 3
 * 解释:有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 示例 2:
 * <p>
 * 输入: nums = [4,2,3,4]
 * 输出: 4
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 *
 * @author simple
 */
public class ValidTriangleNumber {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            for (int j = i + 1; j < n; j++) {
                int k = j + 1;
                int x = 0;
                while (k < n) {
                    if (nums[i] + nums[j] <= nums[k]) {
                        break;
                    }
                    x++;
                    k++;
                }
                ans += x;
            }
        }
        return ans;
    }

    // j在右移动时，k从i+1开始移动，匹配所有nums[k + 1] < nums[i] + nums[j]
    public int triangleNumber_2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int k = i + 1;
            for (int j = i + 1; j < n; j++) {
                while (k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                    k++;
                }
                // 由于存在num[i/j/k]=0的情况， k-j可能小于0
                ans += Math.max(0, k - j);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ValidTriangleNumber().triangleNumber(new int[]{2, 2, 3, 4}));
        System.out.println(new ValidTriangleNumber().triangleNumber(new int[]{2, 3, 4, 4}));
    }
}
