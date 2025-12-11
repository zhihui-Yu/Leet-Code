package middle;

import java.util.Arrays;

/**
 * 3531. 统计被覆盖的建筑
 * 给你一个正整数 n，表示一个 n x n 的城市，同时给定一个二维数组 buildings，其中 buildings[i] = [x, y] 表示位于坐标 [x, y] 的一个 唯一 建筑。
 * <p>
 * 如果一个建筑在四个方向（左、右、上、下）中每个方向上都至少存在一个建筑，则称该建筑 被覆盖 。
 * <p>
 * 返回 被覆盖 的建筑数量。
 * <p>
 * 示例 1：
 * 输入: n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]]
 * <p>
 * 输出: 1
 * <p>
 * 解释:
 * <p>
 * 只有建筑 [2,2] 被覆盖，因为它在每个方向上都至少存在一个建筑：
 * 上方 ([1,2])
 * 下方 ([3,2])
 * 左方 ([2,1])
 * 右方 ([2,3])
 * 因此，被覆盖的建筑数量是 1。
 * <p>
 * 示例 2：
 * 输入: n = 3, buildings = [[1,1],[1,2],[2,1],[2,2]]
 * 输出: 0
 * 解释:
 * <p>
 * 没有任何一个建筑在每个方向上都有至少一个建筑。
 * <p>
 * 示例 3：
 * 输入: n = 5, buildings = [[1,3],[3,2],[3,3],[3,5],[5,3]]
 * 输出: 1
 * 解释:
 * 只有建筑 [3,3] 被覆盖，因为它在每个方向上至少存在一个建筑：
 * 上方 ([1,3])
 * 下方 ([5,3])
 * 左方 ([3,2])
 * 右方 ([3,5])
 * 因此，被覆盖的建筑数量是 1。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 10^5
 * 1 <= buildings.length <= 10^5
 * buildings[i] = [x, y]
 * 1 <= x, y <= n
 * buildings 中所有坐标均 唯一 。
 *
 * @author simple
 */
public class CountCoveredBuildings {
    public int countCoveredBuildings(int n, int[][] buildings) {
        // 维护四个数组来缓存每行/列的点最小/大值
        int[] rowMin = new int[n + 1];
        int[] rowMax = new int[n + 1];
        int[] colMin = new int[n + 1];
        int[] colMax = new int[n + 1];

        // 初始化最小值=n+1, 保证遍历时值正确
        Arrays.fill(rowMin, n + 1);
        Arrays.fill(colMin, n + 1);

        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            rowMin[y] = Math.min(rowMin[y], x);
            rowMax[y] = Math.max(rowMax[y], x);
            colMin[x] = Math.min(colMin[x], y);
            colMax[x] = Math.max(colMax[x], y);
        }

        int ans = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            if (rowMin[y] < x && x < rowMax[y] && colMin[x] < y && y < colMax[x]) ans++;
        }
        return ans;
    }
}
