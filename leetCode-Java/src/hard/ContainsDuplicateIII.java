package hard;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author simple
 * 给你一个整数数组 nums 和两个整数k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 * <p>
 * 如果存在则返回 true，不存在返回 false。
 * <p>
 * 示例1：
 * <p>
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 2 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^4
 * 0 <= t <= 2^31 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainsDuplicateIII {
    // 超时
//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
//        // abs(nums[i] - nums[j]) <= t && abs(i - j) <= k
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (i == j) continue;
//                if (Math.abs(nums[i] - nums[j]) <= t && Math.abs(i - j) <= k) return true;
//            }
//        }
//        return false;
//    }

    // 滑动窗口 + 二分
    // TreeSet 当窗口，size <= k,保证了 abs(i-j)<=k,  每个数添加入窗口时，
    // 判断当前数x与 y (<=x), z (>=x)是否有一个满足条件， 最后保证窗口size，要判断i>=k时删除集合中num[i-k]
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long num = (long) nums[i];
            Long y = treeSet.floor(num);
            Long z = treeSet.ceiling(num);
            if (y != null && num - y <= t) return true;
            if (z != null && z - num <= t) return true;
            treeSet.add(num);
            if (i >= k) {
                treeSet.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    // 滑动窗口 + 桶
    // HashMap当窗口，每个值放入桶中(对于正数 x 桶下标为 x/t+1, 负数y为 (y+1)/(t+1) - 1 [-1是因为0被正数用调用了])， 查看桶小标z是否在map中，
    // 如果在则说明存在同一个桶的数，则 num[i]-num[j] <= t, 否则查看相邻桶是否存在，不相邻的桶一定不存在，因为每个桶都是t的倍数，不相邻表示t的倍数>1,不满足条件
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        HashMap<Long, Long> window = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Long x = (long) nums[i];
            Long bulkIndex = getIndex(x, t + 1);
            if (window.containsKey(bulkIndex)) return true;
            if (window.containsKey(bulkIndex - 1) && Math.abs(x - window.get(bulkIndex - 1)) <= t) return true;
            if (window.containsKey(bulkIndex + 1) && Math.abs(x - window.get(bulkIndex + 1)) <= t) return true;
            window.put(bulkIndex, x);
            if (i >= k) {
                window.remove(getIndex(nums[i - k], t + 1));
            }
        }
        return false;
    }

    private Long getIndex(long x, int size) {
        if (x >= 0) return x / size;
        return (x + 1) / size - 1;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[]{2, 0, -2, 2}, 2, 1));
    }
}
