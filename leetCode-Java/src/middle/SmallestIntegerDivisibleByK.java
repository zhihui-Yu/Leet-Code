package middle;

import java.util.HashSet;
import java.util.Set;

/**
 * 1015. 可被 K 整除的最小整数
 * 给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最小正整数 n 的长度。
 * <p>
 * 返回 n 的长度。如果不存在这样的 n ，就返回-1。
 * <p>
 * 注意： n 可能不符合 64 位带符号整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 1
 * 输出：1
 * 解释：最小的答案是 n = 1，其长度为 1。
 * 示例 2：
 * <p>
 * 输入：k = 2
 * 输出：-1
 * 解释：不存在可被 2 整除的正整数 n 。
 * 示例 3：
 * <p>
 * 输入：k = 3
 * 输出：3
 * 解释：最小的答案是 n = 111，其长度为 3。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 10^5
 *
 * @author simple
 */
public class SmallestIntegerDivisibleByK {
    public int smallestRepunitDivByK(int k) {
        Set<Integer> seen = new HashSet<>();
        int x = 1 % k; // 如果k=1，则直接返回seen+1
        // 如果重复则说明余数开始循环
        while (x > 0 && seen.add(x)) {
            x = (x * 10 + 1) % k;
        }
        return x > 0 ? -1 : seen.size() + 1;
    }
}
