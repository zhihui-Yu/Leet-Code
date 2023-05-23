package middle.array;

import java.util.Arrays;

/**
 * 1090. 受标签影响的最大值
 * 我们有一个 n 项的集合。给出两个整数数组 values 和 labels ，第 i 个元素的值和标签分别是 values[i] 和 labels[i]。还会给出两个整数 numWanted 和 useLimit 。
 * <p>
 * 从 n 个元素中选择一个子集 s :
 * <p>
 * 子集 s 的大小 小于或等于 numWanted 。
 * s 中 最多 有相同标签的 useLimit 项。
 * 一个子集的 分数 是该子集的值之和。
 * <p>
 * 返回子集 s 的最大 分数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
 * 输出：9
 * 解释：选出的子集是第一项，第三项和第五项。
 * 示例 2：
 * <p>
 * 输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2
 * 输出：12
 * 解释：选出的子集是第一项，第二项和第三项。
 * 示例 3：
 * <p>
 * 输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], numWanted = 3, useLimit = 1
 * 输出：16
 * 解释：选出的子集是第一项和第四项。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == values.length == labels.length
 * 1 <= n <= 2 * 10^4
 * 0 <= values[i], labels[i] <= 2 * 10^4
 * 1 <= numWanted, useLimit <= n
 *
 * @author simple
 */
public class LargestValuesFromLabels {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        var n = values.length;
        var idx = new Integer[n];
        var labelUsed = new int[2 * 10000 + 1];

        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (i, j) -> values[j] - values[i]); // 倒序

        int sum = 0;
        int k = 0;
        while (k < n) {
            var id = idx[k];
            var val = values[id];
            var label = labels[id];
            if (labelUsed[label] < useLimit && numWanted > 0) {
                sum += val;
                numWanted--;
                labelUsed[label]++;
            }
            k++;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LargestValuesFromLabels().largestValsFromLabels(new int[]{9, 8, 8, 7, 6}, new int[]{0, 0, 0, 1, 1}, 3, 1));
    }
}
