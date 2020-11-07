package middle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author simple
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 * 示例1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口法
        int maxCount = 0;
        int len = s.length();
        // 利用map 存储 key -> 字符， val -> 下标 + 1 (start)
        Map<Character, Integer> map = new HashMap<>();
        // 定义窗口初始值。
        for (int start = 0, end = 0; end < len; end++) {
            char alpha = s.charAt(end);
            // 如果map中有重复的字符，则窗口的 start 需要重新定义
            if (map.containsKey(alpha)) {
                // start = MAX (以前重复值的下标 + 1 , 当前start)
                start = Math.max(map.get(alpha), start);
            }
            // 最大不重复的字符串长度 窗口的大小(从零开始 所以加一)
            maxCount = Math.max(maxCount, end - start + 1);
            // 将字符存到map
            map.put(alpha, end + 1);
        }
        return maxCount;
    }
}
