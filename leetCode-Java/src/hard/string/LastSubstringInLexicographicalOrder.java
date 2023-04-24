package hard.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 1163. 按字典序排在最后的子串
 * 给你一个字符串 s ，找出它的所有子串并按字典序排列，返回排在最后的那个子串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abab"
 * 输出："bab"
 * 解释：我们可以找出 7 个子串 ["a", "ab", "aba", "abab", "b", "ba", "bab"]。按字典序排在最后的子串是 "bab"。
 * 示例 2：
 * <p>
 * 输入：s = "leetcode"
 * 输出："tcode"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 4 * 10^5
 * s 仅含有小写英文字符。
 *
 * @author simple
 */
public class LastSubstringInLexicographicalOrder {

    // 双指针 O(n)
    public String lastSubstring(String s) {
        int n = s.length();
        // i指向的是当前找到字典序最大的字符，
        // j指向的是当前要进行比较的字符。
        // 使用一个位移指针k，来比较i和j构成的子串[i,..,i + k]和[j,...,j + k]的顺序。
        int k = 0;
        int i = 0, j = 1; // i..j 的串
        char ch1, ch2;

        while (j + k < n) {
            ch1 = s.charAt(i + k);
            ch2 = s.charAt(j + k);

            if (ch1 == ch2) {
                k++;
            } else if (ch1 < ch2) {
                // 为什么确定当i+k>j时，仍可以将i+=k+1: 因为如果有重叠说明，[i+k,j+k] 必定有一个和i一样的字母，所以在 [i+k+1,j+k]字串中必有最大字典序
                i += k + 1; // [j..j+k] 的字典序更大， 跳过[i..i+k], 当 i+k>j时， j被重置为 i+1
                k = 0;
                if (i >= j) j = i + 1;
            } else {
                j += k + 1; // [i..i+k] 的字典序更大， 跳过[j..j+k]
                k = 0;
            }
        }
        return s.substring(i);
    }

    // 把字母变成数字，找到最大的数字，并比较每个字串，取最大 => 超时 O(n^2)
    public String lastSubstring2(String s) {
        int n = s.length();
        ArrayList<Integer>[] table = new ArrayList[26];

        for (int i = 0; i < 26; i++) {
            table[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            table[s.charAt(i) - 'a'].add(i);
        }

        List<Integer> maxLetter = List.of();
        for (int i = 25; i >= 0; i--) {
            if (table[i].size() > 0) {
                maxLetter = table[i];
                break;
            }
        }
        if (maxLetter.size() == n) return s;

        int p = 1;
        List<Integer> queue = new ArrayList<>(); // 存放下一轮需要找的idx

        while (maxLetter.size() != 1) {
            int max = -1;
            queue.clear();
            for (Integer idx : maxLetter) {
                if (idx + p < n) {
                    int val = s.charAt(idx + p) - 'a';
                    if (val > max) {
                        queue.clear();
                        queue.add(idx);
                        max = val;
                    } else if (val == max) {
                        queue.add(idx);
                    }
                }
            }
            maxLetter = queue;
            p++;
        }
        return s.substring(maxLetter.get(0));
    }

    public static void main(String[] args) {
        System.out.println(new LastSubstringInLexicographicalOrder().lastSubstring("caacaacb")); // "cb"
        System.out.println(new LastSubstringInLexicographicalOrder().lastSubstring("cbcbzaa"));
        System.out.println(new LastSubstringInLexicographicalOrder().lastSubstring("zrziy")); // "zrziy"
        System.out.println(new LastSubstringInLexicographicalOrder().lastSubstring("abab"));
        System.out.println(new LastSubstringInLexicographicalOrder().lastSubstring("leetcode"));
    }
}
