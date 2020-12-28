package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author simple
 * <p>
 * 给定一个无重复元素的有序整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 * <p>
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 示例 3：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 4：
 * <p>
 * 输入：nums = [-1]
 * 输出：["-1"]
 * 示例 5：
 * <p>
 * 输入：nums = [0]
 * 输出：["0"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return List.of();
        if (nums.length == 1) return List.of(String.valueOf(nums[0]));
        List<String> res = new ArrayList<>();

        // 类似双指针解法
        int pre = 0, last = 0;
        int len = 0;
        while (last < nums.length + 1) {
            if (last < nums.length && nums[pre] - nums[last] == pre - last) {
                last++;
                len++;
            } else if (len == 0) {
                res.add(String.valueOf(nums[pre]));
                pre++;
                last++;
            } else {
                res.add(nums[pre] + "->" + nums[last - 1]);
                pre = last;
                last++;
                len = 0;
            }
        }

        return res;
    }

    // 官方解法
    // public List<String> summaryRanges(int[] nums) {
    //        List<String> summary = new ArrayList<>();
    //        for (int i = 0, j = 0; j < nums.length; ++j) {
    //            // check if j + 1 extends the range [nums[i], nums[j]]
    //            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1)
    //                continue;
    //            // put the range [nums[i], nums[j]] into the list
    //            if (i == j)
    //                summary.add(nums[i] + "");
    //            else
    //                summary.add(nums[i] + "->" + nums[j]);
    //            i = j + 1;
    //        }
    //        return summary;
    //    }

    public static void main(String[] args) {
        List<String> strings = new SummaryRanges().summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        System.out.println();

    }
}
