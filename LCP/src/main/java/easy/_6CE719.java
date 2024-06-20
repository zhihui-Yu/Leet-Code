package easy;

/**
 * LCP 61. 气温变化趋势
 * 力扣城计划在两地设立「力扣嘉年华」的分会场，气象小组正在分析两地区的气温变化趋势，对于第 i ~ (i+1) 天的气温变化趋势，将根据以下规则判断：
 * <p>
 * 若第 i+1 天的气温 高于 第 i 天，为 上升 趋势
 * 若第 i+1 天的气温 等于 第 i 天，为 平稳 趋势
 * 若第 i+1 天的气温 低于 第 i 天，为 下降 趋势
 * 已知 temperatureA[i] 和 temperatureB[i] 分别表示第 i 天两地区的气温。 组委会希望找到一段天数尽可能多，且两地气温变化趋势相同的时间举办嘉年华活动。请分析并返回两地气温变化趋势相同的最大连续天数。
 * <p>
 * 即最大的 n，使得第 i~i+n 天之间，两地气温变化趋势相同
 * <p>
 * 示例 1：
 * <p>
 * 输入： temperatureA = [21,18,18,18,31] temperatureB = [34,32,16,16,17]
 * <p>
 * 输出：2
 * <p>
 * 解释：如下表所示， 第 2～4 天两地气温变化趋势相同，且持续时间最长，因此返回 4-2=2image.png
 * <p>
 * 示例 2：
 * <p>
 * 输入： temperatureA = [5,10,16,-6,15,11,3] temperatureB = [16,22,23,23,25,3,-16]
 * <p>
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * 2 <= temperatureA.length == temperatureB.length <= 1000
 * -20 <= temperatureA[i], temperatureB[i] <= 40
 *
 * @author simple
 */
public class _6CE719 {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        // -1 下降  0 平稳  1 上升

        int an = temperatureA.length;
        int[] a = new int[an - 1];
        int[] b = new int[an - 1];

        for (int i = 0; i < an - 1; i++) {
            if (temperatureA[i] > temperatureA[i + 1]) a[i] = -1;
            if (temperatureA[i] < temperatureA[i + 1]) a[i] = 1;
        }

        for (int i = 0; i < an - 1; i++) {
            if (temperatureB[i] > temperatureB[i + 1]) b[i] = -1;
            if (temperatureB[i] < temperatureB[i + 1]) b[i] = 1;
        }

        int ans = 0;
        for (int i = 0; i < an - 1; i++) {
            int cnt = 0;
            while (i < an - 1 && a[i] == b[i]) {
                cnt++;
                i++;
            }
            ans = Math.max(cnt, ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new _6CE719().temperatureTrend(new int[]{1, -15, 3, 14, -1, 4, 35, 36}, new int[]{-15, 32, 20, 9, 33, 4, -1, -5}));
        System.out.println(new _6CE719().temperatureTrend(new int[]{21, 18, 18, 18, 31}, new int[]{34, 32, 16, 16, 17}));
    }
}
