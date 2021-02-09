package easy;

/**
 * @author simple
 * <p>
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 ture ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 * <p>
 * 输入：x = -101
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231<= x <= 231- 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        int len = num.length();
        for (int i = 0; i < len / 2; i++) {
            if (num.charAt(i) != num.charAt(len - i - 1)) return false;
        }
        return true;
    }
}
