package middle.string;

import java.util.Arrays;

/**
 * 1641. 统计字典序元音字符串的数目
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 * <p>
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：5
 * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：15
 * 解释：仅由元音组成的 15 个字典序字符串为
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 * 示例 3：
 * <p>
 * 输入：n = 33
 * 输出：66045
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 50
 *
 * @author simple
 */
public class CountSortedVowelStrings {
    // 比如：n=3, a = a + e; e = e + i; i = i + o; o = o + u; u = 1;
    // 字符计算都是包含重复的计算，计算 iii = iii, iio, iiu, ioo, iou, iuu = i(n2) + o(n3).  o(n3)-> 因为ooo能走的，ioo肯定能走
    public int countVowelStrings(int n) {
        int[] dp = new int[5];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 3; j >= 0; j--) {
                dp[j] += dp[j + 1];
            }
        }
        return Arrays.stream(dp).sum();
    }

    // 思路2： nxn的方格， 每行 a e i o u, 计算从(0,[0,4])走到 (n-1,x) 或者 (x,n-1)有几条路。不能向左。
    public static void main(String[] args) {
        System.out.println(new CountSortedVowelStrings().countVowelStrings(33));
    }
}
