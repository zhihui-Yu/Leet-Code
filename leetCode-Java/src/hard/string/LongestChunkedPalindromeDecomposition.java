package hard.string;

/**
 * 1147. 段式回文
 * 你会得到一个字符串 text 。你应该把它分成 k 个子字符串 (subtext1, subtext2，…， subtextk) ，要求满足:
 * <p>
 * subtexti 是 非空 字符串
 * 所有子字符串的连接等于 text ( 即subtext1 + subtext2 + ... + subtextk == text )
 * 对于所有 i 的有效值( 即 1 <= i <= k ) ，subtexti == subtextk - i + 1 均成立
 * 返回k可能最大值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "ghiabcdefhelloadamhelloabcdefghi"
 * 输出：7
 * 解释：我们可以把字符串拆分成 "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)"。
 * 示例 2：
 * <p>
 * 输入：text = "merchant"
 * 输出：1
 * 解释：我们可以把字符串拆分成 "(merchant)"。
 * 示例 3：
 * <p>
 * 输入：text = "antaprezatepzapreanta"
 * 输出：11
 * 解释：我们可以把字符串拆分成 "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 1000
 * text 仅由小写英文字符组成
 *
 * @author simple
 */
public class LongestChunkedPalindromeDecomposition {
    public int longestDecomposition(String text) {
        int len = text.length();
        if (len == 0) return 0;

        for (int j = 0; j < len / 2; j++) {
            while (text.charAt(len - j - 1) != text.charAt(0)) j++;
            if (j + 1 != len && text.substring(0, j + 1).equals(text.substring(len - j - 1))) {
                return 2 + longestDecomposition(text.substring(j + 1, len - j - 1));
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new LongestChunkedPalindromeDecomposition().longestDecomposition("vwsuvmbwknmnvwsuvmbwk"));
        System.out.println(new LongestChunkedPalindromeDecomposition().longestDecomposition("antaprezatepzapreanta"));
        System.out.println(new LongestChunkedPalindromeDecomposition().longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"));
        System.out.println(new LongestChunkedPalindromeDecomposition().longestDecomposition("merchant"));
    }
}
