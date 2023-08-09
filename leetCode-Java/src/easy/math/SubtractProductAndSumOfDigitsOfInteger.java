package easy.math;

/**
 * @author simple
 * <p>
 * 给你一个整数n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubtractProductAndSumOfDigitsOfInteger {
    public int subtractProductAndSum(int n) {
        // 转为字符串 截取每个数字来比较
        // 也可以用 % 来算出每位数的数字
        String nums = String.valueOf(n);
        int sub = 1;
        int count = 0;
        for (int i = 0; i < nums.length(); i++) {
            int integer = Integer.parseInt(String.valueOf(nums.charAt(i)));
            sub *= integer;
            count += integer;
        }
        return sub - count;
    }

    public int subtractProductAndSum_2(int n) {
        int x, sum = 0, sub = 1;
        while (n > 0) {
            x = n % 10;
            n = n / 10;
            sum += x;
            sub *= x;
        }

        return sub - sum;
    }

    public static void main(String[] args) {
        System.out.println(new SubtractProductAndSumOfDigitsOfInteger().subtractProductAndSum_2(705));
    }
}
