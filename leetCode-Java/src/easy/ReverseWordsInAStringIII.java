package easy;

/**
 * @author simple
 * <p>
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        StringBuilder res = new StringBuilder(s.length());
        for (String word : str) {
            int len = word.length();
            char[] chars = word.toCharArray();
            for (int i = 0; i < len / 2; i++) {
                char ch = chars[i];
                chars[i] = chars[len - 1 - i];
                chars[len - 1 - i] = ch;
            }
            res.append(chars).append(" ");
        }
        return res.deleteCharAt(res.length() - 1).toString();
        // 官方解法也不错， 可以用空格找到每个字符串，然后进行字符串的反转
    }
}
