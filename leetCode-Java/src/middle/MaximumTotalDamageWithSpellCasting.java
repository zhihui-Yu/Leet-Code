package middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 3186. 施咒的最大总伤害
 * 一个魔法师有许多不同的咒语。
 * <p>
 * 给你一个数组 power ，其中每个元素表示一个咒语的伤害值，可能会有多个咒语有相同的伤害值。
 * <p>
 * 已知魔法师使用伤害值为 power[i] 的咒语时，他们就不能使用伤害为 power[i] - 2 ，power[i] - 1 ，power[i] + 1 或者 power[i] + 2 的咒语。
 * <p>
 * 每个咒语最多只能被使用 一次 。
 * <p>
 * 请你返回这个魔法师可以达到的伤害值之和的 最大值 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：power = [1,1,3,4]
 * <p>
 * 输出：6
 * <p>
 * 解释：
 * <p>
 * 可以使用咒语 0，1，3，伤害值分别为 1，1，4，总伤害值为 6 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：power = [7,1,6,6]
 * <p>
 * 输出：13
 * <p>
 * 解释：
 * <p>
 * 可以使用咒语 1，2，3，伤害值分别为 1，6，6，总伤害值为 13 。
 * 提示：
 * <p>
 * 1 <= power.length <= 10^5
 * 1 <= power[i] <= 10^9
 *
 * @author simple
 */
public class MaximumTotalDamageWithSpellCasting {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : power) {
            cnt.merge(x, 1, Integer::sum); // cnt[x]++
        }

        int n = cnt.size();
        int[] a = new int[n];
        int k = 0;
        for (int x : cnt.keySet()) {
            a[k++] = x;
        }
        Arrays.sort(a);

        long[] f = new long[n + 1];
        int j = 0;
        for (int i = 0; i < n; i++) {
            int x = a[i];
            while (a[j] < x - 2) {
                j++;
            }
            f[i + 1] = Math.max(f[i], f[j] + (long) x * cnt.get(x));
        }
        return f[n];
    }

    public long maximumTotalDamage_2(int[] power) {
        Arrays.sort(power);
        int len = power.length;
        long max = 0;
        int j = 0;
        long[] dp = new long[len];

        dp[0] = power[0];
        for (int i = 1; i < len; i++) {
            if (power[i] == power[i - 1]) {
                dp[i] = power[i] + dp[i - 1];
            } else {
                for (; power[j] < power[i] - 2; j++) max = Math.max(max, dp[j]);
                dp[i] = power[i] + max;
            }
        }

        for (; j < len; j++) max = Math.max(max, dp[j]);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumTotalDamageWithSpellCasting().maximumTotalDamage(new int[]{5, 9, 2, 10, 2, 7, 10, 9, 3, 8}));
        System.out.println(new MaximumTotalDamageWithSpellCasting().maximumTotalDamage(new int[]{7, 1, 6, 3}));
        System.out.println(new MaximumTotalDamageWithSpellCasting().maximumTotalDamage(new int[]{1, 1, 3, 4}));
        System.out.println(new MaximumTotalDamageWithSpellCasting().maximumTotalDamage(new int[]{7, 1, 6, 6}));
    }
}
