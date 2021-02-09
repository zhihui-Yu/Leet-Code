package hard;

/**
 * @author simple
 * <p>
 * 给定一个正整数数组 A，如果 A的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 * <p>
 * （例如，[1,2,3,1,2] 中有3个不同的整数：1，2，以及3。）
 * <p>
 * 返回A中好子数组的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,1,2,3], K = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * 示例 2：
 * <p>
 * 输入：A = [1,2,1,3,4], K = 3
 * 输出：3
 * 解释：恰好由 3 个不同整数组成的子数组：[1,2,1,3], [2,1,3], [1,3,4].
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubArraysWithKDifferentIntegers {
    public int subarraysWithKDistinct(int[] A, int K) {
        return distinct(A, K) - distinct(A, K - 1);
    }

    private int distinct(int[] a, int k) {
        int len = a.length;
        int left = 0, right = 0;
        int res = 0;
        int count = 0; // [left, right) 中包含不同整数的个数
        int[] freq = new int[len + 1];

        while (right < len) {
            if (freq[a[right]] == 0) {
                count++;
            }
            freq[a[right]]++;
            right++;
            while (count > k) {
                if (--freq[a[left]] == 0) {
                    count--;
                }
                left++;
            }
            res += right - left;
        }
        return res;
    }

    public static void main(String[] args) {
        new SubArraysWithKDifferentIntegers().subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 3);
    }
}
