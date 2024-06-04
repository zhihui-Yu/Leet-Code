package middle.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3067. 在带权树网络中统计可连接服务器对数目
 * 给你一棵无根带权树，树中总共有 n 个节点，分别表示 n 个服务器，服务器从 0 到 n - 1 编号。
 * 同时给你一个数组 edges ，其中 edges[i] = [ai, bi, weighti] 表示节点 ai 和 bi 之间有一条双向边，边的权值为 weighti 。再给你一个整数 signalSpeed 。
 * <p>
 * 如果两个服务器 a ，b 和 c 满足以下条件，那么我们称服务器 a 和 b 是通过服务器 c 可连接的 ：
 * <p>
 * a < b ，a != c 且 b != c 。
 * 从 c 到 a 的距离是可以被 signalSpeed 整除的。
 * 从 c 到 b 的距离是可以被 signalSpeed 整除的。
 * 从 c 到 b 的路径与从 c 到 a 的路径没有任何公共边。
 * 请你返回一个长度为 n 的整数数组 count ，其中 count[i] 表示通过服务器 i 可连接 的服务器对的 数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：edges = [[0,1,1],[1,2,5],[2,3,13],[3,4,9],[4,5,2]], signalSpeed = 1
 * 输出：[0,4,6,6,4,0]
 * 解释：由于 signalSpeed 等于 1 ，count[c] 等于所有从 c 开始且没有公共边的路径对数目。
 * 在输入图中，count[c] 等于服务器 c 左边服务器数目乘以右边服务器数目。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：edges = [[0,6,3],[6,5,3],[0,3,1],[3,2,7],[3,1,6],[3,4,2]], signalSpeed = 3
 * 输出：[2,0,0,0,0,0,2]
 * 解释：通过服务器 0 ，有 2 个可连接服务器对(4, 5) 和 (4, 6) 。
 * 通过服务器 6 ，有 2 个可连接服务器对 (4, 5) 和 (0, 5) 。
 * 所有服务器对都必须通过服务器 0 或 6 才可连接，所以其他服务器对应的可连接服务器对数目都为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 1000
 * edges.length == n - 1
 * edges[i].length == 3
 * 0 <= ai, bi < n
 * edges[i] = [ai, bi, weight_i]
 * 1 <= weight_i <= 106
 * 1 <= signalSpeed <= 106
 * 输入保证 edges 构成一棵合法的树。
 *
 * @author simple
 */
public class CountPairsOfConnectableServersInAWeightedTreeNetwork {
    // 题目含义：一个无根的树，假设节点i为根节点，树中符合条件的组合有几种，返回各个节点为根节时，所对应的组合数
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        List<int[]>[] graph = new ArrayList[n];
        Arrays.setAll(graph, x -> new ArrayList<>());

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        int[] res = new int[n];
        // 假设 i 为根节点，去计算符合条件的数量
        for (int i = 0; i < n; i++) {
            int pre = 0;
            for (int[] e : graph[i]) {
                int cnt = dfs(e[0], i, e[1] % signalSpeed, signalSpeed, graph);
                res[i] += pre * cnt; // pre相当于a的个数，cnt相当于b的个数， (a,b)的组合有 a * b种, 注意：左1右2 和 左2右1是一样的，所以不能算两种
                pre += cnt;
            }
        }
        return res;
    }

    /**
     * dfs计算从当前节点开始，有多少符合条件的值
     *
     * @param node        当前节点
     * @param root        根节点
     * @param remain      路径加权/signalSpeed 的余数
     * @param signalSpeed signalSpeed
     * @param graph       graph
     * @return
     */
    private int dfs(int node, int root, int remain, int signalSpeed, List<int[]>[] graph) {
        int res = 0;
        if (remain == 0) {
            res++;
        }

        for (int[] e : graph[node]) {
            int next = e[0];
            int weight = e[1];
            if (next != root) {
                res += dfs(next, node, (remain + weight) % signalSpeed, signalSpeed, graph);
            }
        }
        return res;
    }
}
