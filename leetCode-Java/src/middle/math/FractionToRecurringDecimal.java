package middle.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 166. 分数到小数
 * 给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
 * <p>
 * 如果小数部分为循环小数，则将循环的部分括在括号内。
 * <p>
 * 如果存在多个答案，只需返回 任意一个 。
 * <p>
 * 对于所有给定的输入，保证 答案字符串的长度小于 104 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numerator = 1, denominator = 2
 * 输出："0.5"
 * 示例 2：
 * <p>
 * 输入：numerator = 2, denominator = 1
 * 输出："2"
 * 示例 3：
 * <p>
 * 输入：numerator = 4, denominator = 333
 * 输出："0.(012)"
 * <p>
 * <p>
 * 提示：
 * <p>
 * -2^31 <= numerator, denominator <= 2^31 - 1
 * denominator != 0
 *
 * @author simple
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();
        if ((numerator > 0) ^ (denominator > 0)) {
            result.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        result.append(num / den);
        long remainder = num % den;

        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");
        Map<Long, Integer> remainderMap = new HashMap<>();

        while (remainder != 0) {
            if (remainderMap.containsKey(remainder)) {
                result.insert(remainderMap.get(remainder), "(");
                result.append(")");
                break;
            }

            remainderMap.put(remainder, result.length());

            remainder *= 10;
            result.append(remainder / den);
            remainder = remainder % den;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(-2147483648, -1));
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(-1, -2147483648));
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(7, -12));
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(-50, 8));
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(1, 6));
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(1, 2));
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(2, 1));
        System.out.println(new FractionToRecurringDecimal().fractionToDecimal(4, 333));
    }
}
