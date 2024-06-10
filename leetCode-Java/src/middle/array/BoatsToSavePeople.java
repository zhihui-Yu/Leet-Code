package middle.array;

import java.util.Arrays;

/**
 * 881. 救生艇
 * 给定数组 people 。people[i]表示第 i 个人的体重 ，船的数量不限，每艘船可以承载的最大重量为 limit。
 * <p>
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * <p>
 * 返回 承载所有人所需的最小船数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * 示例 2：
 * <p>
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * 示例 3：
 * <p>
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= people.length <= 5 * 10^4
 * 1 <= people[i] <= limit <= 3 * 10^4
 *
 * @author simple
 */
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int ans = 0, heavy = people.length - 1, light = 0;
        while (heavy >= light) {
            // 最重+最轻能坐一艘船最好，不能就最重的单独一艘船
            if (people[heavy] + people[light] <= limit) {
                light++;
            }
            heavy--;
            ans++;
        }

        return ans;
    }
}
