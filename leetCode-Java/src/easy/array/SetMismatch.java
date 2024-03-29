package easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 645. 错误的集合
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，
 * 导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，
 * 导致集合 丢失了一个数字 并且 有一个数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * <p>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^4
 *
 * @author simple
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int num : nums) {
            memo.put(num, memo.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[2];
        int cnt;
        for (int i = 1; i <= nums.length; i++) {
            cnt = memo.getOrDefault(i, 0);
            if (cnt == 2) {
                res[0] = i;
            } else if (cnt == 0) {
                res[1] = i;
            }
        }
        return res;
    }
}
