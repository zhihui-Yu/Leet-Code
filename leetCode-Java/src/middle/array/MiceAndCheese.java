package middle.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 2611. 老鼠和奶酪
 * 有两只老鼠和 n 块不同类型的奶酪，每块奶酪都只能被其中一只老鼠吃掉。
 * <p>
 * 下标为 i 处的奶酪被吃掉的得分为：
 * <p>
 * 如果第一只老鼠吃掉，则得分为 reward1[i] 。
 * 如果第二只老鼠吃掉，则得分为 reward2[i] 。
 * 给你一个正整数数组 reward1 ，一个正整数数组 reward2 ，和一个非负整数 k 。
 * <p>
 * 请你返回第一只老鼠恰好吃掉 k 块奶酪的情况下，最大 得分为多少。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：reward1 = [1,1,3,4], reward2 = [4,4,1,1], k = 2
 * 输出：15
 * 解释：这个例子中，第一只老鼠吃掉第 2 和 3 块奶酪（下标从 0 开始），第二只老鼠吃掉第 0 和 1 块奶酪。
 * 总得分为 4 + 4 + 3 + 4 = 15 。
 * 15 是最高得分。
 * 示例 2：
 * <p>
 * 输入：reward1 = [1,1], reward2 = [1,1], k = 2
 * 输出：2
 * 解释：这个例子中，第一只老鼠吃掉第 0 和 1 块奶酪（下标从 0 开始），第二只老鼠不吃任何奶酪。
 * 总得分为 1 + 1 = 2 。
 * 2 是最高得分。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == reward1.length == reward2.length <= 105
 * 1 <= reward1[i], reward2[i] <= 1000
 * 0 <= k <= n
 *
 * @author simple
 */
public class MiceAndCheese {
    // 作者：力扣官方题解: 贪心 + 优先队列， 老鼠2吃完全部，计算需要吐出的部分，给老鼠1
    public int miceAndCheese_2(int[] reward1, int[] reward2, int k) {
        int ans = 0;
        int n = reward1.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < n; i++) {
            ans += reward2[i];
            pq.offer(reward1[i] - reward2[i]);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        // 只有两只老鼠，每个老鼠吃k块蛋糕
        // 难点： 如果A，B相同，则跳过，需要取下个最大值
        int n = reward1.length;
        Integer[] tmp = new Integer[n];
        for (int i = 0; i < n; i++) tmp[i] = i;
        Arrays.sort(tmp, (i, j) -> (reward1[j] - reward2[j]) - (reward1[i] - reward2[i])); // 1,2 不相同的最大值

        Set<Integer> mem = new HashSet<>(Arrays.asList(tmp).subList(0, k));

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (k > 0 && mem.contains(i)) {
                k--;
                sum += reward1[i];
            } else sum += reward2[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new MiceAndCheese().miceAndCheese(new int[]{1}, new int[]{4}, 1)); // 1
        System.out.println(new MiceAndCheese().miceAndCheese(new int[]{1, 4, 4, 6, 4}, new int[]{6, 5, 3, 6, 1}, 1)); // 24
        System.out.println(new MiceAndCheese().miceAndCheese_2(new int[]{1, 1, 3, 4}, new int[]{4, 4, 1, 1}, 2));
        System.out.println(new MiceAndCheese().miceAndCheese(new int[]{1, 1}, new int[]{1, 1}, 2));
    }
}
