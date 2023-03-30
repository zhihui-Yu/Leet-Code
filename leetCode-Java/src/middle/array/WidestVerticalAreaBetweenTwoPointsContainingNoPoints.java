package middle.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 1637. 两点之间不包含任何点的最宽垂直区域
 * 给你 n 个二维平面上的点 points ，其中 points[i] = [xi, yi] ，请你返回两点之间内部不包含任何点的 最宽垂直区域 的宽度。
 * <p>
 * 垂直区域 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直区域 为宽度最大的一个垂直区域。
 * <p>
 * 请注意，垂直区域 边上 的点 不在 区域内。
 * 输入：points = [[8,7],[9,9],[7,4],[9,7]]
 * 输出：1
 * 解释：红色区域和蓝色区域都是最优区域。
 * 示例 2：
 * <p>
 * 输入：points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == points.length
 * 2 <= n <= 105
 * points[i].length == 2
 * 0 <= xi, yi <= 109
 *
 * @author simple
 */
public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int[] xs = new int[n];
        for (int i = 0; i < n; i++) {
            xs[i] = points[i][0];
        }
        Arrays.sort(xs);
        int ans = 0;
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, xs[i] - xs[i - 1]);
        }
        return ans;
    }

    // 使用了set 导致资源消耗大
    public int maxWidthOfVerticalArea2(int[][] points) {
        Set<Integer> set = new TreeSet<>();
        for (var point : points) {
            set.add(point[0]);
        }

        int ans = 0;

        Iterator<Integer> iterator = set.iterator();
        Integer pre = iterator.next();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            ans = Math.max(ans, next - pre);
            pre = next;
        }
        return ans;
    }
}
