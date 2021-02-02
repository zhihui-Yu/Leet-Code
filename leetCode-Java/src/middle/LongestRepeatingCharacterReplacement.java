package middle;

/**
 * @author simple
 * <p>
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换k次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 * <p>
 * 注意：字符串长度 和 k 不会超过104。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 * <p>
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int left = 0, right = 0;
        int[] tab = new int[26];
        int maxLen = 0;
        while (right < len) {
            tab[s.charAt(right) - 'A']++;
            maxLen = Math.max(maxLen, tab[s.charAt(right) - 'A']);
            // 限制滑动窗口的大小，如果超过了，就往右移且长度不会减小(后面可能增大或者不变)
            if (right - left + 1 - maxLen > k) {
                tab[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }

    public static void main(String[] args) {
        int res = new LongestRepeatingCharacterReplacement().characterReplacement("ABCDACCDDBBBB", 1);
        System.out.println(res);
    }
}
