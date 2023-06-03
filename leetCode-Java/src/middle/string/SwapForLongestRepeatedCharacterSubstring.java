package middle.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 1156. 单字符重复子串的最大长度
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 * <p>
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。回其中最长的子串的长度返。
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "ababa"
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：text = "aaabaaa"
 * 输出：6
 * 示例 3：
 * <p>
 * 输入：text = "aaabbaaa"
 * 输出：4
 * 示例 4：
 * <p>
 * 输入：text = "aaaaa"
 * 输出：5
 * 示例 5：
 * <p>
 * 输入：text = "abcdef"
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 20000
 * text 仅由小写英文字母组成。
 *
 * @author simple
 */
public class SwapForLongestRepeatedCharacterSubstring {

    // 双指针，对于text[i], 查找text[i..j]是否一样，
    //   - 如果一样，判断前后是否有空位，且有多余的其他字符可以填补
    //     - 如果有 则继续 j+1的位置往后遍历直到不相同，这里需要注意 max(count[text[i]], cnt), 因为可能是最后一个字符来填补了空缺
    //     - 比较当前计数最大值和当前字符最大取大
    //   - 没有不一样，则i后移
    public int maxRepOpt1(String text) {
        Map<Character, Integer> counts = new HashMap<>();
        for (var c : text.toCharArray()) {
            counts.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }

        int res = 0, i = 0, j;
        int len = text.length();
        while (i < len) {
            var target = text.charAt(i);
            j = i;
            while (j < len && target == text.charAt(j)) j++;


            int k = j;
            if (counts.get(target) > j - i && (i > 0 || j < len - 1)) {
                k++;
                while (k < len && target == text.charAt(k)) k++;
            }

            res = Math.max(res, Math.min(k - i, counts.get(target)));

            i = j;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new SwapForLongestRepeatedCharacterSubstring().maxRepOpt1("aaabaaa"));
    }
}