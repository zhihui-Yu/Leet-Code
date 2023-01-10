package middle;

/**
 * @author simple
 * <p>
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 * <p>
 * 2 <= n <= 58
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jian-sheng-zi-lcof/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JianShengZiLcof {
    // 尽量让n分为3n，如果不行就是3n+2x
    public int cuttingRope(int n) {
        if (n < 4) return n - 1;
        int x = n % 3;
        int y = n / 3;
        if (x == 0) return (int) Math.pow(3, y);
        if (x == 1) return (int) (Math.pow(3, (y) - 1) * 4);
        return (int) (Math.pow(3, y) * 2);
    }

    public static void main(String[] args) {
        System.out.println(new JianShengZiLcof().cuttingRope(4));
        System.out.println(new JianShengZiLcof().cuttingRope(10));
    }
}
