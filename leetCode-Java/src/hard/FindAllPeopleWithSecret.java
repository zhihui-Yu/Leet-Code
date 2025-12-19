package hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 2092. 找出知晓秘密的所有专家
 * 给你一个整数 n ，表示有 n 个专家从 0 到 n - 1 编号。另外给你一个下标从 0 开始的二维整数数组 meetings ，
 * 其中 meetings[i] = [xi, yi, timei] 表示专家 xi 和专家 yi 在时间 timei 要开一场会。一个专家可以同时参加 多场会议 。
 * 最后，给你一个整数 firstPerson 。
 * <p>
 * 专家 0 有一个 秘密 ，最初，他在时间 0 将这个秘密分享给了专家 firstPerson 。
 * 接着，这个秘密会在每次有知晓这个秘密的专家参加会议时进行传播。
 * 更正式的表达是，每次会议，如果专家 xi 在时间 timei 时知晓这个秘密，那么他将会与专家 yi 分享这个秘密，反之亦然。
 * <p>
 * 秘密共享是 瞬时发生 的。也就是说，在同一时间，一个专家不光可以接收到秘密，还能在其他会议上与其他专家分享。
 * <p>
 * 在所有会议都结束之后，返回所有知晓这个秘密的专家列表。你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
 * 输出：[0,1,2,3,5]
 * 解释：
 * 时间 0 ，专家 0 将秘密与专家 1 共享。
 * 时间 5 ，专家 1 将秘密与专家 2 共享。
 * 时间 8 ，专家 2 将秘密与专家 3 共享。
 * 时间 10 ，专家 1 将秘密与专家 5 共享。
 * 因此，在所有会议结束后，专家 0、1、2、3 和 5 都将知晓这个秘密。
 * 示例 2：
 * <p>
 * 输入：n = 4, meetings = [[3,1,3],[1,2,2],[0,3,3]], firstPerson = 3
 * 输出：[0,1,3]
 * 解释：
 * 时间 0 ，专家 0 将秘密与专家 3 共享。
 * 时间 2 ，专家 1 与专家 2 都不知晓这个秘密。
 * 时间 3 ，专家 3 将秘密与专家 0 和专家 1 共享。
 * 因此，在所有会议结束后，专家 0、1 和 3 都将知晓这个秘密。
 * 示例 3：
 * <p>
 * 输入：n = 5, meetings = [[3,4,2],[1,2,1],[2,3,1]], firstPerson = 1
 * 输出：[0,1,2,3,4]
 * 解释：
 * 时间 0 ，专家 0 将秘密与专家 1 共享。
 * 时间 1 ，专家 1 将秘密与专家 2 共享，专家 2 将秘密与专家 3 共享。
 * 注意，专家 2 可以在收到秘密的同一时间分享此秘密。
 * 时间 2 ，专家 3 将秘密与专家 4 共享。
 * 因此，在所有会议结束后，专家 0、1、2、3 和 4 都将知晓这个秘密。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 10^5
 * 1 <= meetings.length <= 10^5
 * meetings[i].length == 3
 * 0 <= xi, yi <= n - 1
 * xi != yi
 * 1 <= timei <= 10^5
 * 1 <= firstPerson <= n - 1
 *
 * @author simple
 */
public class FindAllPeopleWithSecret {
    // 超时
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // 每个时刻，有哪些成员在同时开会
        Map<Integer, List<Integer>[]> map = new HashMap<>();
        for (var m : meetings) {
            List<Integer>[] g = map.computeIfAbsent(m[2], k -> new ArrayList[n]);
            if (g[m[0]] == null) {
                g[m[0]] = new ArrayList<>();
            }
            g[m[0]].add(m[1]);

            if (g[m[1]] == null) {
                g[m[1]] = new ArrayList<>();
            }
            g[m[1]].add(m[0]);
        }
        Set<Integer> known = new HashSet<>();
        known.add(0);
        known.add(firstPerson);
        map.keySet().stream().sorted(Comparator.comparing(x -> x)).forEach(time -> {
            List<Integer>[] g = map.get(time);
            for (int i = 0; i < g.length; i++) {
                List<Integer> members = g[i];
                if (members != null &&  (members.stream().anyMatch(known::contains) || known.contains(i))) {
                    known.addAll(members);
                    known.add(i);
                }
            }
        });
        return new ArrayList<>(known);
    }

    //    作者：ylb
    //    链接：https://leetcode.cn/problems/find-all-people-with-secret/solutions/3860582/python3javacgotypescript-yi-ti-yi-jie-mo-k6gw/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public List<Integer> findAllPeople_(int n, int[][] meetings, int firstPerson) {
        boolean[] vis = new boolean[n];
        vis[0] = true;
        vis[firstPerson] = true;
        int m = meetings.length;
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));
        for (int i = 0; i < m;) {
            int j = i;
            // 时间一致 需要放一起处理
            for (; j + 1 < m && meetings[j + 1][2] == meetings[i][2];) {
                ++j;
            }
            // 同时间参会的人
            Map<Integer, List<Integer>> g = new HashMap<>();
            Set<Integer> s = new HashSet<>();
            for (int k = i; k <= j; ++k) {
                int x = meetings[k][0], y = meetings[k][1];
                g.computeIfAbsent(x, key -> new ArrayList<>()).add(y);
                g.computeIfAbsent(y, key -> new ArrayList<>()).add(x);
                s.add(x);
                s.add(y);
            }

            // 参会人员中 已知秘密的人
            Deque<Integer> q = new ArrayDeque<>();
            for (int u : s) {
                if (vis[u]) {
                    q.offer(u);
                }
            }

            // BFS 找到有秘密的人传播给谁
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int v : g.getOrDefault(u, List.of())) {
                    if (!vis[v]) {
                        vis[v] = true;
                        q.offer(v);
                    }
                }
            }
            i = j + 1;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (vis[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // [0, 1, 2, 3, 5]
        int[][] meetings = new int[][]{{1, 2, 5}, {2, 3, 8}, {1, 5, 10}};
        System.out.println(new FindAllPeopleWithSecret().findAllPeople(6, meetings, 1));

        // [0,1,3]
        meetings = new int[][]{{3, 1, 3}, {1, 2, 2}, {0, 3, 3}};
        System.out.println(new FindAllPeopleWithSecret().findAllPeople(4, meetings, 3));

        // [0,1,2,3,4]
        meetings = new int[][]{{3, 4, 2}, {1, 2, 1}, {2, 3, 1}};
        System.out.println(new FindAllPeopleWithSecret().findAllPeople(5, meetings, 1));

        // [0,1,2,3]
        meetings = new int[][]{{0, 2, 1}, {1, 3, 1}, {4, 5, 1}};
        System.out.println(new FindAllPeopleWithSecret().findAllPeople(6, meetings, 1));

        // [0,1,2,3,4]
        meetings = new int[][]{{1, 3, 3}, {2, 0, 3}, {2, 3, 3}};
        System.out.println(new FindAllPeopleWithSecret().findAllPeople(5, meetings, 4));
    }
}
