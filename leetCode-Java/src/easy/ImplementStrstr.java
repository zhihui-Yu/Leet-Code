package easy;

/**
 * @author simple
 * <p>
 * 实现strStr()函数。
 * <p>
 * 给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与C语言的strstr()以及 Java的indexOf()定义相符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ImplementStrstr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int index = 0;
        int max = haystack.length() - needle.length();
        for (int i = 0; i <= max; i++) {
            if (haystack.charAt(i) == needle.charAt(index)) {
                for (int j = i; index < needle.length() && haystack.charAt(j) == needle.charAt(index); j++, index++) ;
                if (index == needle.length()) {
                    return i;
                } else index = 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new ImplementStrstr().strStr("aaa","a");
    }
}
