package easy;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author simple
 * 找出数组中重复的数字。
 * <p>
 * <p>
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShuZuZhongZhongFuDeShuZiLcof {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int i : nums) {
            if (!set.add(i)) return i;
        }
        return -1;

        // 思路二： 原地置换
        // 前置条件： 必须从0开始往后找i!=num[i]的。
        // 将所有数字与下标对应， 如果在进行置换时发现 -> num[i] = num[num[i]] 则return num[i]
    }
}
