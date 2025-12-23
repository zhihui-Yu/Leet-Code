package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2054. 两个最好的不重叠活动
 * 给你一个下标从 0 开始的二维整数数组 events ，其中 events[i] = [startTimei, endTimei, valuei] 。
 * 第 i 个活动开始于 startTimei ，结束于 endTimei ，如果你参加这个活动，那么你可以得到价值 valuei 。
 * 你 最多 可以参加 两个时间不重叠 活动，使得它们的价值之和 最大 。
 * <p>
 * 请你返回价值之和的 最大值 。
 * <p>
 * 注意，活动的开始时间和结束时间是 包括 在活动时间内的，也就是说，你不能参加两个活动且它们之一的开始时间等于另一个活动的结束时间。
 * 更具体的，如果你参加一个活动，且结束时间为 t ，那么下一个活动必须在 t + 1 或之后的时间开始。
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入：events = [[1,3,2],[4,5,2],[2,4,3]]
 * 输出：4
 * 解释：选择绿色的活动 0 和 1 ，价值之和为 2 + 2 = 4 。
 * 示例 2：
 * <p>
 * Example 1 Diagram
 * <p>
 * 输入：events = [[1,3,2],[4,5,2],[1,5,5]]
 * 输出：5
 * 解释：选择活动 2 ，价值和为 5 。
 * 示例 3：
 * <p>
 * <p>
 * 输入：events = [[1,5,3],[1,5,1],[6,6,5]]
 * 输出：8
 * 解释：选择活动 0 和 2 ，价值之和为 3 + 5 = 8 。
 * <p>
 * 提示：
 * <p>
 * 2 <= events.length <= 10^5
 * events[i].length == 3
 * 1 <= startTimei <= endTimei <= 10^9
 * 1 <= valuei <= 10^6
 *
 * @author simple
 */
public class TwoBestNonOverlappingEvents {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        // 结束时间递增，价值递增
        List<int[]> st = new ArrayList<>();
        // 哨兵, 不需要判空
        st.add(new int[]{0, 0});

        int ans = 0;
        for (int[] event : events) {
            // 最后一个结束时间 < event 开始时间的 下标
            int i = search(st, event[0]);
            int value = event[2];
            ans = Math.max(ans, value + st.get(i)[1]);

            // 有更高的价值，入栈
            if (value > st.getLast()[1]) {
                st.add(new int[]{event[1], value});
            }
        }
        return ans;
    }

    // 二分法
    private int search(List<int[]> st, int startTime) {
        int left = -1, right = st.size();
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (st.get(mid)[0] < startTime) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
