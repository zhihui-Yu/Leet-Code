package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1617. 统计子树中城市之间最大距离
 * <p>
 * 给你 n 个城市，编号为从 1 到 n 。同时给你一个大小为 n-1 的数组 edges ，其中 edges[i] = [ui, vi] 表示城市 ui 和 vi 之间有一条双向边。题目保证任意城市之间只有唯一的一条路径。换句话说，所有城市形成了一棵 树 。
 * <p>
 * 一棵 子树 是城市的一个子集，且子集中任意城市之间可以通过子集中的其他城市和边到达。两个子树被认为不一样的条件是至少有一个城市在其中一棵子树中存在，但在另一棵子树中不存在。
 * <p>
 * 对于 d 从 1 到 n-1 ，请你找到城市间 最大距离 恰好为 d 的所有子树数目。
 * <p>
 * 请你返回一个大小为 n-1 的数组，其中第 d 个元素（下标从 1 开始）是城市间 最大距离 恰好等于 d 的子树数目。
 * <p>
 * 请注意，两个城市间距离定义为它们之间需要经过的边的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, edges = [[1,2],[2,3],[2,4]]
 * 输出：[3,4,0]
 * 解释：
 * 子树 {1,2}, {2,3} 和 {2,4} 最大距离都是 1 。
 * 子树 {1,2,3}, {1,2,4}, {2,3,4} 和 {1,2,3,4} 最大距离都为 2 。
 * 不存在城市间最大距离为 3 的子树。
 * 示例 2：
 * <p>
 * 输入：n = 2, edges = [[1,2]]
 * 输出：[1]
 * 示例 3：
 * <p>
 * 输入：n = 3, edges = [[1,2],[2,3]]
 * 输出：[2,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 15
 * edges.length == n-1
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * 题目保证 (ui, vi) 所表示的边互不相同。
 *
 * @author simple
 */
public class CountSubtreesWithMaxDistanceBetweenCities {
    private List<Integer>[] g;
    private int msk;
    private int nxt;
    private int mx;

    /**
     * @param n     城市数量
     * @param edges 城市路径
     * @return 1..n-1的城市的最大路径为n的子路径个数
     */
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        // from https://leetcode.cn/problems/count-subtrees-with-max-distance-between-cities/solutions/2162766/python3javacgotypescript-yi-ti-yi-jie-er-foqs/
        g = new List[n]; // 邻接表, 每个数的相邻数有哪些
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0] - 1, v = e[1] - 1;
            g[u].add(v);
            g[v].add(u);
        }
        int[] ans = new int[n - 1];
        for (int mask = 1; mask < 1 << n; ++mask) {
            // mask是否只有一位数为1，是则说明不存在其他节点，则继续循环
            if ((mask & (mask - 1)) == 0) { // & 相同为1，不同为0
                continue;
            }
            msk = mask;
            mx = 0;
            int cur = 31 - Integer.numberOfLeadingZeros(msk); // 计算出最高位 1 的位置
            dfs(cur, 0);
            if (msk == 0) {
                msk = mask;
                mx = 0;
                dfs(nxt, 0);
                ++ans[mx - 1];
            }
        }
        return ans;
    }

    private void dfs(int u, int d) {
        msk ^= 1 << u; // ^ 不同为1，相同为0
        if (mx < d) {
            mx = d;
            nxt = u;
        }
        for (int v : g[u]) {
            if ((msk >> v & 1) == 1) {
                dfs(v, d + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountSubtreesWithMaxDistanceBetweenCities().countSubgraphsForEachDiameter(4, new int[][]{{1, 2}, {2, 3}, {2, 4}})));
    }
}
