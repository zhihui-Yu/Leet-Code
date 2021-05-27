package easy;

/**
 * @author simple
 * <p>
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 * <p>
 * 示例:
 * <p>
 * 输入: x = 1, y = 4
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * 上面的箭头指出了对应二进制位不同的位置
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        // x ^ y 计算1的数量即是答案
        int xy = x ^ y;

//  1. 原生api
//      return Integer.bitCount(xy);

        // 右移且判断是否为1
//        int cnt = 0;
//        while (xy != 0) {
//            cnt += xy & 1; // 判断时候为1，是就加1，不是加0
//            xy >>= 1;
//        }

        // 3. Brian Kernighan 算法
        int cnt = 0;
        while (xy != 0) {
            xy &= xy - 1;
            cnt++;
        }
        return cnt;
    }
}
