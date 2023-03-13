package middle;

import java.util.Map;

/**
 * 12. 整数转罗马数字
 * <p>
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: num = 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: num = 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 3999
 *
 * @author simple
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        Map<Integer, String> romanMap = Map.of(
            1, "I",
            5, "V",
            10, "X",
            50, "L",
            100, "C",
            500, "D",
            1000, "M"
        );
        Map<Integer, String> specMap = Map.of(
            4, "IV",
            9, "IX",
            40, "XL",
            90, "XC",
            400, "CD",
            900, "CM"
        );
        StringBuilder ans = new StringBuilder();
        int k = 0;
        while (num != 0) {
            int i = num % 10;
            int x = (int) (i * Math.pow(10, k));
            if (specMap.containsKey(x)) {
                ans.insert(0, specMap.get(x));
            } else {
                StringBuilder tmp = new StringBuilder();
                while (i != 0) {
                    if (i >= 5) {
                        tmp.append(romanMap.get((int) (5 * Math.pow(10, k))));
                        i -= 5;
                    } else {
                        tmp.append(romanMap.get((int) Math.pow(10, k)));
                        i -= 1;
                    }
                }
                ans.insert(0, tmp.toString());
            }
            k++;
            num /= 10;
        }
        return ans.toString();
    }


    /**
     *  作者：力扣官方题解
     *  链接：https://leetcode.cn/problems/integer-to-roman/solutions/774611/zheng-shu-zhuan-luo-ma-shu-zi-by-leetcod-75rs/
     *  来源：力扣（LeetCode）
     *  著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman2(int num) { // 直接枚举
        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }



    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(1994)); // MCMXCIV
        System.out.println(new IntegerToRoman().intToRoman(27));
        System.out.println(new IntegerToRoman().intToRoman(4));
    }
}
