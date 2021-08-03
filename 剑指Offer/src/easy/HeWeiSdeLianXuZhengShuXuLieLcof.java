package easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @author simple
 * <p>
 * 输入一个正整数 target，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * <p>
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= target <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HeWeiSdeLianXuZhengShuXuLieLcof {
    // 枚举出和为 target 的所有 连续正整数序列。
    public int[][] findContinuousSequence(int target) {
        // 滑动窗口， left, right 以及sum， 这样就能一直增大或减少窗口以达到sum == target 目标
        List<int[]> res = new LinkedList<>();
        int l = 1, r = 2, sum = 3;
        while (l < r) {
            if (sum == target) {
                int[] ints = new int[r - l + 1];
                for (int i = l; i <= r; i++) {
                    ints[i - l] = i;
                }
                res.add(ints);
            }
            if (sum <= target) {
                r++;
                sum += r;
            } else {
                sum -= l;
                l++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
