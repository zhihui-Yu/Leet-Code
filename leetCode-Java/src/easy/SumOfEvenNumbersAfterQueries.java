package easy;

/**
 * @author simple
 * <p>
 * 给出一个整数数组A和一个查询数组queries。
 * <p>
 * 对于第i次查询，有val =queries[i][0], index= queries[i][1]，我们会把val加到A[index]上。然后，第i次查询的答案是 A 中偶数值的和。
 * <p>
 * （此处给定的index = queries[i][1]是从 0 开始的索引，每次查询都会永久修改数组A。）
 * <p>
 * 返回所有查询的答案。你的答案应当以数组answer给出，answer[i]为第i次查询的答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * 1 <= queries.length <= 10000
 * -10000 <= queries[i][0] <= 10000
 * 0 <= queries[i][1] < A.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-even-numbers-after-queries
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        // 如果在遍历queries 中去循环计算A的偶数 会超时
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) sum += A[i];
        }
        int[] ans = new int[queries.length];
        int ansIndex = 0;
        for (int[] arr : queries) {
            int index = arr[1];
            int val = arr[0];
            // 原来是偶数 则可能加完变基数 所以减去
            if (A[index] % 2 == 0) sum -= A[index];
            A[index] += val;
            // 加完变偶数的 则加上加后的数
            if (A[index] % 2 == 0) sum += A[index];
            ans[ansIndex++] = sum;
        }
        return ans;
    }
}
