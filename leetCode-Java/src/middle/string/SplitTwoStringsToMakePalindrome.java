package middle.string;

/**
 * 1616. 分割两个字符串得到回文串
 * 给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。
 * 由 a 可以得到两个字符串：
 * aprefix 和 asuffix ，满足 a = aprefix + asuffix ，同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = bprefix + bsuffix 。
 * 请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。
 * <p>
 * 当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。比方说， s = "abc" 那么 "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割。
 * <p>
 * 如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。
 * <p>
 * 注意， x + y 表示连接字符串 x 和 y 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = "x", b = "y"
 * 输出：true
 * 解释：如果 a 或者 b 是回文串，那么答案一定为 true ，因为你可以如下分割：
 * aprefix = "", asuffix = "x"
 * bprefix = "", bsuffix = "y"
 * 那么 aprefix + bsuffix = "" + "y" = "y" 是回文串。
 * 示例 2：
 * <p>
 * 输入：a = "abdef", b = "fecab"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：a = "ulacfd", b = "jizalu"
 * 输出：true
 * 解释：在下标为 3 处分割：
 * aprefix = "ula", asuffix = "cfd"
 * bprefix = "jiz", bsuffix = "alu"
 * 那么 aprefix + bsuffix = "ula" + "alu" = "ulaalu" 是回文串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= a.length, b.length <= 105
 * a.length == b.length
 * a 和 b 都只包含小写英文字母
 *
 * @author simple
 */
public class SplitTwoStringsToMakePalindrome {
    public boolean checkPalindromeFormation(String a, String b) {
        int n = b.length();
        if (n == 1) return true;
        int index = 0;
        for (int left = 0, right = n - 1; a.charAt(left) == b.charAt(right); left++, right--, index++) {
            if (right - left <= 2) return true;
        }
        // 找到切割点有两处，a的一处 b的一处。
        if (isPalindrome(a.substring(0, index) + b.substring(index, n)) ||
            isPalindrome(a.substring(0, n - index) + b.substring(n - index))) return true;
        index = 0;
        for (int left = 0, right = n - 1; b.charAt(left) == a.charAt(right); left++, right--, index++) {
            if (right - left <= 2) return true;
        }
        return isPalindrome(b.substring(0, index) + a.substring(index, n)) ||
            isPalindrome(b.substring(0, n - index) + a.substring(n - index));
    }

    public boolean isPalindrome(String s) {
        for (int l = 0, r = s.length() - 1; s.charAt(l) == s.charAt(r); l++, r--) {
            if (r - l < 2) return true;
        }
        return false;
    }

    // 超时
    public boolean checkPalindromeFormation2(String a, String b) {
        for (int i = 0; i <= a.length(); i++) {
            if (isPalindrome2(i, a, b)) return true;
        }
        return false;
    }

    /**
     * 判断下标 i 开始是不是回文
     */
    private boolean isPalindrome2(int i, String a, String b) {
        String aPre = a.substring(0, i);
        String aSuf = a.substring(i);
        String bPre = b.substring(0, i);
        String bSuf = b.substring(i);
        String newA = aPre + bSuf;
        String newB = bPre + aSuf;

        boolean is = true;
        for (int left = 0, right = newA.length() - 1; left < right; left++, right--) {
            if (newA.charAt(left) != newA.charAt(right)) {
                is = false;
                break;
            }
        }
        if (is) return is;

        for (int left = 0, right = newA.length() - 1; left < right; left++, right--) {
            if (newB.charAt(left) != newB.charAt(right)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SplitTwoStringsToMakePalindrome().checkPalindromeFormation(
            "aejbaalflrmkswrydwdkdwdyrwskmrlfqizjezd", "uvebspqckawkhbrtlqwblfwzfptanhiglaabjea"));
        System.out.println(new SplitTwoStringsToMakePalindrome().checkPalindromeFormation("pvhmupgqeltozftlmfjjde", "yjgpzbezspnnpszebzmhvp"));
        System.out.println(new SplitTwoStringsToMakePalindrome().checkPalindromeFormation("x", "y"));
        System.out.println(new SplitTwoStringsToMakePalindrome().checkPalindromeFormation("abdef", "fecab"));
    }
}
