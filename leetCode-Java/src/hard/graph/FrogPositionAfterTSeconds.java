package hard.graph;

import java.util.ArrayList;

/**
 * 1377. T 秒后青蛙的位置
 * 给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下：
 * <p>
 * 在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。
 * 青蛙无法跳回已经访问过的顶点。
 * 如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。
 * 如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。
 * 无向树的边用数组 edges 描述，其中 edges[i] = [ai, bi] 意味着存在一条直接连通 ai 和 bi 两个顶点的边。
 * <p>
 * 返回青蛙在 t 秒后位于目标顶点 target 上的概率。与实际答案相差不超过 10-5 的结果将被视为正确答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
 * 输出：0.16666666666666666
 * 解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，第 1 秒 有 1/3 的概率跳到顶点 2 ，然后第 2 秒 有 1/2 的概率跳到顶点 4，
 * 因此青蛙在 2 秒后位于顶点 4 的概率是 1/3 * 1/2 = 1/6 = 0.16666666666666666 。
 * 示例 2：
 * <p>
 * 输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
 * 输出：0.3333333333333333
 * 解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，有 1/3 = 0.3333333333333333 的概率能够 1 秒 后跳到顶点 7 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * edges.length == n - 1
 * edges[i].length == 2
 * 1 <= ai, bi <= n
 * 1 <= t <= 50
 * 1 <= target <= n
 *
 * @author simple
 */
public class FrogPositionAfterTSeconds {
    // 官方答案
    public double frogPosition(int n, int[][] edges, int t, int target) {
        ArrayList<Integer>[] G = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            G[i] = new ArrayList<>();
        for (var e : edges) {
            // 双向图
            G[e[0]].add(e[1]);
            G[e[1]].add(e[0]);
        }

        boolean[] seen = new boolean[n + 1];
        return dfs(G, seen, 1, t, target); // 从1开始跳
    }

    private double dfs(ArrayList<Integer>[] g, boolean[] seen, int n, int t, int target) {
        int next = n == 1 ? g[n].size() : g[n].size() - 1; // 是起点可以跳全部，非起点不能回跳，所以-1
        if (t == 0 || next == 0) { // 没时间或者无下一跳了
            return n == target ? 1 : 0;
        }
        seen[n] = true;
        double ans = 0;
        for (int i : g[n]) {
            if (!seen[i]) {
                ans += dfs(g, seen, i, t - 1, target);
            }
        }
        return ans / next;
    }
}
