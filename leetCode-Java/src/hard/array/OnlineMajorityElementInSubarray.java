package hard.array;

import java.util.Arrays;

/**
 * 1157. 子数组中占绝大多数的元素
 * 设计一个数据结构，有效地找到给定子数组的 多数元素 。
 * <p>
 * 子数组的 多数元素 是在子数组中出现 threshold 次数或次数以上的元素。
 * <p>
 * 实现 MajorityChecker 类:
 * <p>
 * MajorityChecker(int[] arr) 会用给定的数组 arr 对 MajorityChecker 初始化。
 * int query(int left, int right, int threshold) 返回子数组中的元素  arr[left...right] 至少出现 threshold 次数，
 * 如果不存在这样的元素则返回 -1。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["MajorityChecker", "query", "query", "query"]
 * [[[1, 1, 2, 2, 1, 1]], [0, 5, 4], [0, 3, 3], [2, 3, 2]]
 * 输出：
 * [null, 1, -1, 2]
 * <p>
 * 解释：
 * MajorityChecker majorityChecker = new MajorityChecker([1,1,2,2,1,1]);
 * majorityChecker.query(0,5,4); // 返回 1
 * majorityChecker.query(0,3,3); // 返回 -1
 * majorityChecker.query(2,3,2); // 返回 2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 2 * 10^4
 * 1 <= arr[i] <= 2 * 10^4
 * 0 <= left <= right < arr.length
 * threshold <= right - left + 1
 * 2 * threshold > right - left + 1
 * 调用 query 的次数最多为 10^4
 *
 * @author simple
 */
public class OnlineMajorityElementInSubarray {
    static class MajorityChecker {
        int[] arr;

        public MajorityChecker(int[] arr) {
            this.arr = arr;
        }

        public int query(int left, int right, int threshold) {
            int[] tmp = new int[20001];

            // 投票算法，可得出绝对众数
            int cnt = 1, idx = left;
            tmp[arr[left]]++;
            for (int i = left + 1; i <= right; i++) {
                if (arr[idx] == arr[i]) {
                    cnt++;
                } else cnt--;

                if (cnt < 0) {
                    idx = i;
                    cnt = 1;
                }
                tmp[arr[i]]++;
            }
            if (tmp[arr[idx]] >= threshold) {
                return arr[idx];
            }
            return -1;
        }

        // 超时 31 / 32 个通过的测试用例
        public int query2(int left, int right, int threshold) {
            int[] tmp = new int[right - left + 1];
            int k = 0;
            for (int i = left; i < right + 1; i++) tmp[k++] = arr[i];

            Arrays.sort(tmp);
            for (int i = 0, j = threshold - 1; i < tmp.length && j < tmp.length; i++, j++) {
                if (tmp[i] == tmp[j]) return tmp[i]; // 2 * threshold > right - left + 1: 肯定是众数
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        MajorityChecker checker2 = new MajorityChecker(new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1});
        System.out.println(checker2.query(3, 12, 6));

        MajorityChecker checker = new MajorityChecker(new int[]{1, 1, 2, 2, 1, 1});
        System.out.println(checker.query(0, 5, 4));
        System.out.println(checker.query(0, 3, 3));
        System.out.println(checker.query(2, 3, 2));
    }
}
