package hard;

/**
 * 1012. 至少有 1 位重复的数字
 * 给定正整数 n，返回在 [1, n] 范围内具有 至少 1 位 重复数字的正整数的个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 20
 * 输出：1
 * 解释：具有至少 1 位重复数字的正数（<= 20）只有 11 。
 * 示例 2：
 * <p>
 * 输入：n = 100
 * 输出：10
 * 解释：具有至少 1 位重复数字的正数（<= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
 * 示例 3：
 * <p>
 * 输入：n = 1000
 * 输出：262
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^9
 *
 * @author simple
 */
public class NumbersWithRepeatedDigits {
    public int numDupDigitsAtMostN(int n) {
        return n + 1 - f(0, String.valueOf(n), 0, true);
    }

    //整数掩码 mask 记录前面已经填入过的数字
    public int f(int mask, String sn, int i, boolean same) {
        if (i == sn.length()) {
            return 1;
        }
        int t = same ? sn.charAt(i) - '0' : 9;
        int res = 0;
        int c = Integer.bitCount(mask) + 1;

        for (int k = 0; k <= t; k++) {
            if ((mask & (1 << k)) != 0) {
                continue;
            }
            if (same && k == t) {
                res += f(mask | (1 << t), sn, i + 1, true);
            } else if (mask == 0 && k == 0) {
                res += f(0, sn, i + 1, false);
            } else {
                res += A(sn.length() - 1 - i, 10 - c);
            }
        }
        return res;
    }

    public int A(int x, int y) {
        int res = 1;
        for (int i = 0; i < x; i++) {
            res *= y--;
        }
        return res;
    }

    // 超时
    public int numDupDigitsAtMostN2(int n) {
        int cnt = 0;
        for (int i = 10; i <= n; i++) {
            int[] nums = new int[10];
            int x = i;
            while (x > 0) {
                if (nums[x % 10]++ != 1) {
                    x /= 10;
                } else {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new NumbersWithRepeatedDigits().numDupDigitsAtMostN(20));
        System.out.println(new NumbersWithRepeatedDigits().numDupDigitsAtMostN(7022376));
    }
}
