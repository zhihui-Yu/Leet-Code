package middle;

/**
 * @author simple
 * <p>
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        // 统计 字符串中相同字符数量
        int[] numBucket = new int[26];
        for (char i : s.toCharArray()) {
            numBucket[i - 'a']++;
        }

        // 统计字母是否以及被访问
        boolean[] visited = new boolean[26];
        // 结果构建
        StringBuilder res = new StringBuilder();
        // 遍历字符串 逐个压栈并且判断是否 i < i + 1, 如果否，则将 i 出栈并将 i + 1 入栈
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!visited[ch - 'a']) {
                // 判断 res 是否 存在值  并且最后一个ch > 准备插入的ch
                while (res.length() > 0 && res.charAt(res.length() - 1) > ch) {
                    // 如果 res 中最后一个ch 的数量 > 0 则将该ch 出栈 并将该字母设置为 未访问。
                    if (numBucket[res.charAt(res.length() - 1) - 'a'] > 0) {
                        visited[res.charAt(res.length() - 1) - 'a'] = false;
                        res.deleteCharAt(res.length() - 1);
                    } else break;
                }
                // 将当前字母压栈
                res.append(ch);
                // 将当前字母设置为 已访问
                visited[ch - 'a'] = true;
            }
            // 将字母 数量减一
            numBucket[ch - 'a']--;
        }
        // 返回结果
        return res.toString();
    }
}
