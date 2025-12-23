package hard;

/**
 * 960. 删列造序 III
 * 给定由 n 个小写字母字符串组成的数组 strs ，其中每个字符串长度相等。
 * <p>
 * 选取一个删除索引序列，对于 strs 中的每个字符串，删除对应每个索引处的字符。
 * <p>
 * 比如，有 strs = ["abcdef","uvwxyz"] ，删除索引序列 {0, 2, 3} ，删除后为 ["bef", "vyz"] 。
 * <p>
 * 假设，我们选择了一组删除索引 answer ，那么在执行删除操作之后，
 * 最终得到的数组的行中的 每个元素 都是按字典序排列的
 * （ 即 (strs[0][0] <= strs[0][1] <= ... <= strs[0][strs[0].length - 1]) 和 (strs[1][0] <= strs[1][1] <= ... <= strs[1][strs[1].length - 1]) ，依此类推）。
 * <p>
 * 请返回 answer.length 的最小可能值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["babca","bbazb"]
 * 输出：3
 * 解释：
 * 删除 0、1 和 4 这三列后，最终得到的数组是 strs = ["bc", "az"]。
 * 这两行是分别按字典序排列的（即，strs[0][0] <= strs[0][1] 且 strs[1][0] <= strs[1][1]）。
 * 注意，strs[0] > strs[1] —— 数组 strs 不一定是按字典序排列的。
 * 示例 2：
 * <p>
 * 输入：strs = ["edcba"]
 * 输出：4
 * 解释：如果删除的列少于 4 列，则剩下的行都不会按字典序排列。
 * 示例 3：
 * <p>
 * 输入：strs = ["ghi","def","abc"]
 * 输出：0
 * 解释：所有行都已按字典序排列。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == strs.length
 * 1 <= n <= 100
 * 1 <= strs[i].length <= 100
 * strs[i] 由小写英文字母组成
 *
 * @author simple
 */
public class DeleteColumnsToMakeSortedIII {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        // 定义 f[i] 表示每个子序列都以 i 列结尾时，最多保留的列数。
        int[] f = new int[n];
        int maxF = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (f[i] < f[j] && less(strs, i, j)) {
                    f[i] = f[j];
                }
            }
            f[i]++;
            maxF = Math.max(maxF, f[i]);
        }
        return n - maxF;
    }

    private boolean less(String[] strs, int i, int j) {
        for (String str : strs) {
            if (str.charAt(i) < str.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new DeleteColumnsToMakeSortedIII().minDeletionSize(new String[]{"babca","bbazb"}));
        System.out.println(new DeleteColumnsToMakeSortedIII().minDeletionSize(new String[]{"edcba"}));
        System.out.println(new DeleteColumnsToMakeSortedIII().minDeletionSize(new String[]{"ghi","def","abc"}));
    }
}
