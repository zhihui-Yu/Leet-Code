package easy;

/**
 * 3370. 仅含置位位的最小整数
 * 给你一个正整数 n。
 * <p>
 * 返回 大于等于 n 且二进制表示仅包含 置位 位的 最小 整数 x 。
 * <p>
 * 置位 位指的是二进制表示中值为 1 的位。
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 5
 * <p>
 * 输出： 7
 * <p>
 * 解释：
 * <p>
 * 7 的二进制表示是 "111"。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 10
 * <p>
 * 输出： 15
 * <p>
 * 解释：
 * <p>
 * 15 的二进制表示是 "1111"。
 * <p>
 * 示例 3：
 * <p>
 * 输入： n = 3
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 3 的二进制表示是 "11"。
 * 提示：
 * <p>
 * 1 <= n <= 1000
 *
 * @author simple
 */
public class SmallestNumberWithAllSetBits {
    public int smallestNumber(int n) {
        int m = 0;
        while (n != 0) {
            n = n >> 1;
            m++;
        }
        return (int) Math.pow(2, m) - 1;
    }

    public static void main(String[] args) {
        System.out.println(new SmallestNumberWithAllSetBits().smallestNumber(3));
        System.out.println(new SmallestNumberWithAllSetBits().smallestNumber(5));
        System.out.println(new SmallestNumberWithAllSetBits().smallestNumber(10));
    }
}
