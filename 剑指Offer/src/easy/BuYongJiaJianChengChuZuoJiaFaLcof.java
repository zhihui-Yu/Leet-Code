package easy;

/**
 * @author simple
 * <p>
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * 示例:
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 * <p>
 * <p>
 * 提示：
 * <p>
 * a,b均可能是负数或 0
 * 结果不会溢出 32 位整数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuYongJiaJianChengChuZuoJiaFaLcof {
    public int add(int a, int b) {
        // 最差情况下（例如 a = 0x7fffffff , b = 1 时），需循环 32 次
        if (b == 0) return a;
        // 非进位(异或相当于把非进位的bit都加了) + 进位(与-> 求出要进位的地方, << 1 右移一位,相当于告知下次加的数)
        return add(a ^ b, (a & b) << 1);
    }
}
