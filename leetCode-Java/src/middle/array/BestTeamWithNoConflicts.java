package middle.array;

import java.util.Arrays;

/**
 * 1626. 无矛盾的最佳球队
 * 假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
 * <p>
 * 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
 * <p>
 * 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：scores = [1,3,5,10,15], ages = [1,2,3,4,5]
 * 输出：34
 * 解释：你可以选中所有球员。
 * 示例 2：
 * <p>
 * 输入：scores = [4,5,6,5], ages = [2,1,2,1]
 * 输出：16
 * 解释：最佳的选择是后 3 名球员。注意，你可以选中多个同龄球员。
 * 示例 3：
 * <p>
 * 输入：scores = [1,2,3,5], ages = [8,9,10,1]
 * 输出：6
 * 解释：最佳的选择是前 3 名球员。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= scores.length, ages.length <= 1000
 * scores.length == ages.length
 * 1 <= scores[i] <= 106
 * 1 <= ages[i] <= 1000
 *
 * @author simple
 */
public class BestTeamWithNoConflicts {
    public int bestTeamScore(int[] scores, int[] ages) {
        int len = ages.length;
        int[][] peoples = new int[len][2];
        for (int i = 0; i < len; i++) {
            peoples[i] = new int[]{scores[i], ages[i]};
        }
        Arrays.sort(peoples, (p1, p2) -> p1[0] != p2[0] ? p1[0] - p2[0] : p1[1] - p2[1]); // 按照 score,age asc
        int[] dp = new int[len];
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) { // 分数必然是当前最大的
                if (peoples[i][1] >= peoples[j][1]) // 如果当前球员的年纪大于等于前面的球员年纪，则添加前面队员分数
                    dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += peoples[i][0]; // 如果年纪小，但是分数高，则说明dp[i]只是当前队员的分数，没有累加其他人的
            res = Math.max(dp[i], res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new BestTeamWithNoConflicts().bestTeamScore(new int[]{10, 6, 6}, new int[]{1, 5, 4}));
    }
}
