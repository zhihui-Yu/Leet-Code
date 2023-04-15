package middle.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1042. 不邻接植花
 * 有 n 个花园，按从 1 到 n 标记。另有数组 paths ，
 * 其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径。
 * 在每个花园中，你打算种下四种花之一。
 * <p>
 * 另外，所有花园 最多 有 3 条路径可以进入或离开.
 * <p>
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 * <p>
 * 以数组形式返回 任一 可行的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。
 * 花的种类用  1、2、3、4 表示。保证存在答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 解释：
 * 花园 1 和 2 花的种类不同。
 * 花园 2 和 3 花的种类不同。
 * 花园 3 和 1 花的种类不同。
 * 因此，[1,2,3] 是一个满足题意的答案。其他满足题意的答案有 [1,2,4]、[1,4,2] 和 [3,2,1]
 * 示例 2：
 * <p>
 * 输入：n = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 * 示例 3：
 * <p>
 * 输入：n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 104
 * 0 <= paths.length <= 2 * 104
 * paths[i].length == 2
 * 1 <= xi, yi <= n
 * xi != yi
 * 每个花园 最多 有 3 条路径可以进入或离开
 *
 * @author simple
 */
public class FlowerPlantingWithNoAdjacent {
    // 可以将对象优化成数组，减少空间消耗
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] ans = new int[n];
        if (paths.length == 0) {
            Arrays.fill(ans, 1);
            return ans;
        }
        Map<Integer, Garden> map = new HashMap<>();
        for (var path : paths) {
            int i = path[0];
            int j = path[1];

            var garden = map.getOrDefault(i, new Garden(i));
            var next = map.getOrDefault(j, new Garden(j));
            garden.addNeighbor(next);
            next.addNeighbor(garden);

            map.put(i, garden);
            map.put(j, next);
        }

        Garden empty = new Garden(-1);
        empty.flowerIdx = 1;
        for (int i = 0; i < n; i++) {
            ans[i] = map.getOrDefault(i + 1, empty).calcFlowerIdx();
        }
        return ans;
    }

    public static class Garden {
        public int idx;
        public int flowerIdx = -1;
        public Set<Garden> neighbors = new HashSet<>();

        public Garden(int idx) {
            this.idx = idx;
        }

        public void addNeighbor(Garden garden) {
            neighbors.add(garden);
        }

        public int calcFlowerIdx() {
            var neighborFlowers = neighbors.stream()
                .map(n -> n.flowerIdx)
                .filter(x -> x != -1)
                .toList();
            if (neighborFlowers.size() == 0) flowerIdx = 1; // whatever
            int id = 0;
            while (true) {
                id++;
                if (!neighborFlowers.contains(id)) {
                    flowerIdx = id;
                    break;
                }
            }
            return flowerIdx;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FlowerPlantingWithNoAdjacent().gardenNoAdj(3, new int[][]{{1, 2}, {2, 3}, {3, 1}})));
    }
}
