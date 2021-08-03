package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author simple
 * <p>
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: True
 * <p>
 * <p>
 * 示例2:
 * <p>
 * 输入: [0,0,1,2,5]
 * 输出: True
 * <p>
 * <p>
 * 限制：
 * <p>
 * 数组长度为 5
 * <p>
 * 数组的数取值为 [0, 13] .
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuKePaiZhongDeShunZiLcof {
    // 本题中的 0 是可以当做任意牌的意思
    public boolean isStraight(int[] nums) {
        // 顺子就是最大数和最小数差小于5且5张牌没有重复的
        int max = 0, min = 14;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            if (nums[i] != 0 && !set.add(nums[i])) return false;
            else if (nums[i] > 0) {
                max = Math.max(nums[i], max);
                min = Math.min(nums[i], min);
            }
        }
        return max - min < 5;
    }

    public static void main(String[] args) {
        System.out.println(new BuKePaiZhongDeShunZiLcof().isStraight(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new BuKePaiZhongDeShunZiLcof().isStraight(new int[]{0, 0, 1, 2, 5}));
        System.out.println(new BuKePaiZhongDeShunZiLcof().isStraight(new int[]{0, 0, 8, 5, 4}));
    }
}
