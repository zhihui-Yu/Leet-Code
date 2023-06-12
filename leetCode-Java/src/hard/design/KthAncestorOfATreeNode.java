package hard.design;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 1483. 树节点的第 K 个祖先
 * 给你一棵树，树上有 n 个节点，按从 0 到 n-1 编号。树以父节点数组的形式给出，其中 parent[i] 是节点 i 的父节点。树的根节点是编号为 0 的节点。
 * <p>
 * 树节点的第 k 个祖先节点是从该节点到根节点路径上的第 k 个节点。
 * <p>
 * 实现 TreeAncestor 类：
 * <p>
 * TreeAncestor（int n， int[] parent） 对树和父数组中的节点数初始化对象。
 * getKthAncestor(int node, int k) 返回节点 node 的第 k 个祖先节点。如果不存在这样的祖先节点，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
 * [[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]
 * <p>
 * 输出：
 * [null,1,0,-1]
 * <p>
 * 解释：
 * TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
 * <p>
 * treeAncestor.getKthAncestor(3, 1);  // 返回 1 ，它是 3 的父节点
 * treeAncestor.getKthAncestor(5, 2);  // 返回 0 ，它是 5 的祖父节点
 * treeAncestor.getKthAncestor(6, 3);  // 返回 -1 因为不存在满足要求的祖先节点
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 5 * 10^4
 * parent[0] == -1 表示编号为 0 的节点是根节点。
 * 对于所有的 0 < i < n ，0 <= parent[i] < n 总成立
 * 0 <= node < n
 * 至多查询 5 * 10^4 次
 *
 * @author simple
 */
public class KthAncestorOfATreeNode {
    public static void main(String[] args) {
        TreeAncestor treeAncestor = new TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(treeAncestor.getKthAncestor(3, 1));
        System.out.println(treeAncestor.getKthAncestor(5, 2));
        System.out.println(treeAncestor.getKthAncestor(6, 3));
    }

    //    作者：力扣官方题解
    static class TreeAncestor {
        static int LOG;
        int[][] ancestors;

        public TreeAncestor(int n, int[] parent) {
            LOG = 32 - Integer.numberOfLeadingZeros(n); // n 的最高位 1 的位置

            ancestors = new int[n][LOG];
            for (int i = 0; i < n; i++) {
                Arrays.fill(ancestors[i], -1); // 先将所有置位 -1
            }
            for (int i = 0; i < n; i++) {
                ancestors[i][0] = parent[i]; // 节点 i 的第 2^0 parent 是 parent[i]
            }
            for (int j = 1; j < LOG; j++) {
                for (int i = 0; i < n; i++) {
                    if (ancestors[i][j - 1] != -1) {
                        var p = ancestors[i][j - 1]; // 当前节点的父节点
                        // 第2^j个祖先结点一定是第2^j-1祖先结点的第2^j-1个祖先结点
                        // eg: 2^2 个祖先，一定是 2^1 祖先的 2^1 祖先
                        ancestors[i][j] = ancestors[p][j - 1]; // 配置 2^j 位置的 父节点值
                    }
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            // 比如k=13=8+4+1，也就是node的第13个祖先结点是第8个祖先结点的第4个祖先结点的第1个祖先结点，依次查询，如果出现-1则表示不存在，查询终止，否则直至返回结果。
            for (int j = 0; j < LOG; j++) {
                if (((k >> j) & 1) != 0) {
                    node = ancestors[node][j];
                    if (node == -1) {
                        return -1;
                    }
                }
            }
            return node;
        }
    }


    // 超时
    static class TreeAncestor2 {
        Map<Integer, List<Integer>> node = new HashMap<>();

        public TreeAncestor2(int n, int[] parent) {
            for (int i = 1; i < n; i++) {
                var p = parent[i];

                var x = node.getOrDefault(p, new LinkedList<>()); // 父节点的父节点
                LinkedList<Integer> newOne = new LinkedList<>();
                newOne.add(p);
                newOne.addAll(x);
                node.put(i, newOne);
            }
        }

        public int getKthAncestor(int node, int k) {
            List<Integer> res = this.node.getOrDefault(node, List.of());
            if (res.size() >= k) {
                return res.get(k - 1);
            }
            return -1;
        }
    }
}
