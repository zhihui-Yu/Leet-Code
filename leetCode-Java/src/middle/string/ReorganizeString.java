package middle.string;

import middle.array.DistantBarcodes;

import java.util.HashMap;
import java.util.Map;

/**
 * 767. 重构字符串
 * 给定一个字符串 s ，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 返回 s 的任意可能的重新排列。若不可行，返回空字符串 "" 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "aab"
 * 输出: "aba"
 * 示例 2:
 * <p>
 * 输入: s = "aaab"
 * 输出: ""
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 500
 * s 只包含小写字母
 * <p>
 * 相同题目：
 * {@link DistantBarcodes}
 *
 * @author simple
 */
public class ReorganizeString {
    // 统计字符数量，区分奇偶位插入， 考虑几个场景：
    // - 1. 某个字符超过n/2: 放偶数位，偶数位保证了最可以存放相邻不相同字符的最大数量，如长度为5时，偶数为可以放3个字符（0，2，4）
    // - 2. 奇数位满了：奇数满了放偶数
    // - 3. 偶数位满了：偶数满了放奇数
    public String reorganizeString(String s) {
        int n = s.length();
        if (n < 2) return s;

        Map<Character, Integer> counts = new HashMap<>();
        int max = 0;
        for (var c : s.toCharArray()) {
            int cnt = counts.getOrDefault(c, 0) + 1;
            counts.put(c, cnt);
            max = Math.max(max, cnt);
        }

        if ((n + 1) / 2 < max) return ""; // 超过一半 必然有相邻数是一样的 （长度为5时，最大可以3个一样的字符）

        char[] ans = new char[n];
        int halfLen = n / 2;
        int odd = 1, even = 0;
        for (var entry : counts.entrySet()) {
            char ch = entry.getKey();
            int cnt = entry.getValue();
            while (cnt > 0 && cnt <= halfLen && odd < n) {
                ans[odd] = ch;
                cnt--;
                odd += 2;
            }

            while (cnt > 0) {
                ans[even] = ch;
                cnt--;
                even += 2;
            }
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        System.out.println(new ReorganizeString().reorganizeString("aaab"));
    }
}
