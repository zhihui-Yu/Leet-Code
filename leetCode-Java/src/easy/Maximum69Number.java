package easy;

/**
 * @author simple
 * <p>
 * 给你一个仅由数字 6 和 9 组成的正整数num。
 * <p>
 * 你最多只能翻转一位数字，将 6 变成9，或者把9 变成6 。
 * <p>
 * 请返回你可以得到的最大数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 9669
 * 输出：9969
 * 解释：
 * 改变第一位数字可以得到 6669 。
 * 改变第二位数字可以得到 9969 。
 * 改变第三位数字可以得到 9699 。
 * 改变第四位数字可以得到 9666 。
 * 其中最大的数字是 9969 。
 * 示例 2：
 * <p>
 * 输入：num = 9996
 * 输出：9999
 * 解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
 * 示例 3：
 * <p>
 * 输入：num = 9999
 * 输出：9999
 * 解释：无需改变就已经是最大的数字了。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 10^4
 * num每一位上的数字都是 6 或者9 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-69-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Maximum69Number {
    public int maximum69Number(int num) {
        // 方法一 直接用Java 提供的方法 但速度较慢
        String numStr = String.valueOf(num);
        return Integer.parseInt(numStr.replaceFirst("6", "9"));
        // 方法二 因为最大 num = 10000, 则可以找出num中6在哪一位，然后把6 -> 9
        // 如 96 -> return 96 + 3
    }
}
