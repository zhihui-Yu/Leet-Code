package easy.link;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * <p>
 * 「快乐数」 定义为：
 * <p>
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= (2^31) - 1
 *
 * @author simple
 */
public class HappyNumber {
    // 三种情况：
    // 1. 计算到某个值后进入循环，
    // 2. 计算到1
    // 3. 无限计算但到不了1
    public boolean isHappy(int n) {
        // 解法一： hash 表存储已经计算过的值，如果有重复说明进入循环，直接返回

        // 解法二： 快慢指针
        int l = n;
        int f = getNext(n);
        while (f != 1 && f != l) {
            f = getNext(getNext(f));
            l = getNext(l);
        }
        return f == 1;
    }

    public int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            var i = n % 10;
            n = n / 10;
            sum += i * i;
        }
        return sum;
    }
}
