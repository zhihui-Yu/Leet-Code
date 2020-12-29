package easy;

/**
 * @author simple
 * <p>
 * 每个非负整数N都有其二进制表示。例如，5可以被表示为二进制"101"，11 可以用二进制"1011"表示，依此类推。注意，除N = 0外，任何二进制表示中都不含前导零。
 * <p>
 * 二进制的反码表示是将每个1改为0且每个0变为1。例如，二进制数"101"的二进制反码为"010"。
 * <p>
 * 给你一个十进制数N，请你返回其二进制表示的反码所对应的十进制整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：5
 * 输出：2
 * 解释：5 的二进制表示为 "101"，其二进制反码为 "010"，也就是十进制中的 2 。
 * 示例 2：
 * <p>
 * 输入：7
 * 输出：0
 * 解释：7 的二进制表示为 "111"，其二进制反码为 "000"，也就是十进制中的 0 。
 * 示例 3：
 * <p>
 * 输入：10
 * 输出：5
 * 解释：10 的二进制表示为 "1010"，其二进制反码为 "0101"，也就是十进制中的 5 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= N < 10^9
 * 本题与 476：https://leetcode-cn.com/problems/number-complement/ 相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/complement-of-base-10-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ComplementOfBase10Integer {
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        // 先求N的二进制位数
        int bitCount = 0;
        int NCopy = N;
        while (N != 0) {
            N = N >> 1;
            bitCount++;
        }
        // 求 全是1的二进制数
        int num = (int) Math.pow(2, bitCount) - 1;
        // 111 ^ 101 (异或)
        return num ^ NCopy;
    }
}
