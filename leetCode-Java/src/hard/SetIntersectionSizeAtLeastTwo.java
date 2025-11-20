package hard;

import java.util.Arrays;

/**
 * 757. 设置交集大小至少为2
 * 给你一个二维整数数组 intervals ，其中 intervals[i] = [starti, endi] 表示从 starti 到 endi 的所有整数，包括 starti 和 endi 。
 * <p>
 * 包含集合 是一个名为 nums 的数组，并满足 intervals 中的每个区间都 至少 有 两个 整数在 nums 中。
 * <p>
 * 例如，如果 intervals = [[1,3], [3,7], [8,9]] ，那么 [1,2,4,7,8,9] 和 [2,3,4,8,9] 都符合 包含集合 的定义。
 * 返回包含集合可能的最小大小。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[3,7],[8,9]]
 * 输出：5
 * 解释：nums = [2, 3, 4, 8, 9].
 * 可以证明不存在元素数量为 4 的包含集合。
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,3],[1,4],[2,5],[3,5]]
 * 输出：3
 * 解释：nums = [2, 3, 4].
 * 可以证明不存在元素数量为 2 的包含集合。
 * 示例 3：
 * <p>
 * 输入：intervals = [[1,2],[2,3],[2,4],[4,5]]
 * 输出：5
 * 解释：nums = [1, 2, 3, 4, 5].
 * 可以证明不存在元素数量为 4 的包含集合。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 3000
 * intervals[i].length == 2
 * 0 <= starti < endi <= 108
 *
 * @author simple
 */
public class SetIntersectionSizeAtLeastTwo {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int k1 = -1, k2 = -1, ans = 0;
        for (int[] p : intervals) {
            int l = p[0], r = p[1];
            // k1 k2 在 l和r的范围内
            if (l <= k1) continue;
            // 如果left > k2, 说明k1,k2 都不在数组范围里，ans+2， 重置k1,k2
            if (l > k2) {
                ans += 2;
                k1 = r - 1;
                k2 = r;
            } else {
                // 只有k2在范围内，将k1=k2, k2=r
                ans += 1;
                k1 = k2;
                k2 = r;
            }
        }
        return ans;
    }
}
