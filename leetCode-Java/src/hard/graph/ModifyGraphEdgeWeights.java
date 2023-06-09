package hard.graph;

import java.util.Arrays;

/**
 * 2699. 修改图中的边权
 * 给你一个 n 个节点的 无向带权连通 图，节点编号为 0 到 n - 1 ，再给你一个整数数组 edges ，其中 edges[i] = [ai, bi, wi] 表示节点 ai 和 bi 之间有一条边权为 wi 的边。
 * <p>
 * 部分边的边权为 -1（wi = -1），其他边的边权都为 正 数（wi > 0）。
 * <p>
 * 你需要将所有边权为 -1 的边都修改为范围 [1, 2 * 109] 中的 正整数 ，使得从节点 source 到节点 destination 的 最短距离 为整数 target 。
 * 如果有 多种 修改方案可以使 source 和 destination 之间的最短距离等于 target ，你可以返回任意一种方案。
 * <p>
 * 如果存在使 source 到 destination 最短距离为 target 的方案，请你按任意顺序返回包含所有边的数组（包括未修改边权的边）。如果不存在这样的方案，请你返回一个 空数组 。
 * <p>
 * 注意：你不能修改一开始边权为正数的边。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, edges = [[4,1,-1],[2,0,-1],[0,3,-1],[4,3,-1]], source = 0, destination = 1, target = 5
 * 输出：[[4,1,1],[2,0,1],[0,3,3],[4,3,1]]
 * 解释：上图展示了一个满足题意的修改方案，从 0 到 1 的最短距离为 5 。
 * 示例 2：
 * <p>
 * 输入：n = 3, edges = [[0,1,-1],[0,2,5]], source = 0, destination = 2, target = 6
 * 输出：[]
 * 解释：上图是一开始的图。没有办法通过修改边权为 -1 的边，使得 0 到 2 的最短距离等于 6 ，所以返回一个空数组。
 * 示例 3：
 * <p>
 * 输入：n = 4, edges = [[1,0,4],[1,2,3],[2,3,5],[0,3,-1]], source = 0, destination = 2, target = 6
 * 输出：[[1,0,4],[1,2,3],[2,3,5],[0,3,1]]
 * 解释：上图展示了一个满足题意的修改方案，从 0 到 2 的最短距离为 6 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * 1 <= edges.length <= n * (n - 1) / 2
 * edges[i].length == 3
 * 0 <= ai, bi < n
 * wi = -1 或者 1 <= wi <= 10^7
 * ai != bi
 * 0 <= source, destination < n
 * source != destination
 * 1 <= target <= 10^9
 * 输入的图是连通图，且没有自环和重边。
 *
 * @author simple
 */
public class ModifyGraphEdgeWeights {
    // 难点：
    // 1. 如果有某条路径权重小于target，则说明target不会是最小的，则返回空数组
    // 2. 在找到一条路径后，要确保其他权重为 -1的路径上，将该权重赋予一个较大的值以确保目标路径最小。

    long[] fromDestination;
    int target;

    // 作者：力扣官方题解
    // 方法二：动态修改边权的 Dijkstra 算法
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        this.target = target;
        int[][] adjMatrix = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(adjMatrix[i], -1);
        }
        // 邻接矩阵中存储边的下标
        for (int i = 0; i < edges.length; ++i) {
            int u = edges[i][0], v = edges[i][1];
            adjMatrix[u][v] = adjMatrix[v][u] = i;
        }
        fromDestination = dijkstra(0, destination, edges, adjMatrix);
        if (fromDestination[source] > target) {
            return new int[0][];
        }
        long[] fromSource = dijkstra(1, source, edges, adjMatrix);
        if (fromSource[destination] != target) {
            return new int[0][];
        }
        return edges;
    }

    public long[] dijkstra(int op, int source, int[][] edges, int[][] adjMatrix) {
        // 朴素的 dijkstra 算法
        // adjMatrix 是一个邻接矩阵
        int n = adjMatrix.length;
        long[] dist = new long[n];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        boolean[] used = new boolean[n];
        dist[source] = 0;

        for (int round = 0; round < n - 1; ++round) {
            int u = -1;
            for (int i = 0; i < n; ++i) {
                if (!used[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }
            used[u] = true;
            for (int v = 0; v < n; ++v) {
                if (!used[v] && adjMatrix[u][v] != -1) {
                    if (edges[adjMatrix[u][v]][2] != -1) {
                        dist[v] = Math.min(dist[v], dist[u] + edges[adjMatrix[u][v]][2]);
                    } else {
                        if (op == 0) {
                            dist[v] = Math.min(dist[v], dist[u] + 1);
                        } else {
                            int modify = (int) (target - dist[u] - fromDestination[v]);
                            if (modify > 0) {
                                dist[v] = Math.min(dist[v], dist[u] + modify);
                                edges[adjMatrix[u][v]][2] = modify;
                            } else {
                                edges[adjMatrix[u][v]][2] = target;
                            }
                        }
                    }
                }
            }
        }

        return dist;
    }
}
