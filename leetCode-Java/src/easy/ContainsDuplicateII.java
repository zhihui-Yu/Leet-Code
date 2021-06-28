package easy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author simple
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new LinkedList<>());
            list.add(i);
            if (list.size() > 1 && Math.abs(list.get(list.size() - 1) - list.get(list.size() - 2)) <= k) return true;
            if (list.size() == 1) map.put(nums[i], list);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2)); // false
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1)); // true
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3)); //true
    }
}
