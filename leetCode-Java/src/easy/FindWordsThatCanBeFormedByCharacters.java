package easy;

/**
 * @author simple
 * <p>
 * 给你一份『词汇表』（字符串数组）words和一张『字母表』（字符串）chars。
 * <p>
 * 假如你可以用chars中的『字母』（字符）拼写出 words中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 * <p>
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 * <p>
 * 返回词汇表words中你掌握的所有单词的 长度之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 * <p>
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length<= 100
 * 所有字符串中都仅包含小写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] letter = new int[26];
        for (char c : chars.toCharArray()) {
            letter[c - 'a']++;
        }
        int count = 0;
        int[] cloneLetter;
        boolean match;
        for (String word : words) {
            cloneLetter = letter.clone();
            match = true;
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                if (--cloneLetter[c - 'a'] < 0) {
                    match = false;
                    break;
                }
            }
            if (match) {
                count += length;
            }
        }
        return count;
    }
}
