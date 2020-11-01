package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author simple
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums11 = new TreeSet<>();
        List<Integer> result = new ArrayList<>();
        for (int num : nums1) {
            nums11.add(num);
        }
        for (int num : nums2) {
            if (nums11.contains(num) && !result.contains(num)) {
                result.add(num);
            }
        }
//        return result.stream().mapToInt(Integer::intValue).toArray();

        int[] res = new int[result.size()];
        int i = 0;
        for (Integer num : result) {
            res[i++] = num;
        }
        return res;
    }
}
