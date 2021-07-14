package easy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author simple
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * 示例1:
 * <p>
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= 数组长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {
    public int majorityElement(int[] nums) {
        int mid = nums.length / 2;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            if (count >= mid) return num;
            map.put(num, count + 1);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
