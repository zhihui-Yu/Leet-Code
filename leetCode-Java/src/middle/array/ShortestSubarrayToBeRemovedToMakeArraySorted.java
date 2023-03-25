package middle.array;

/**
 * 1574. 删除最短的子数组使剩余数组有序
 * 给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。
 * <p>
 * 一个子数组指的是原数组中连续的一个子序列。
 * <p>
 * 请你返回满足题目要求的最短子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,10,4,2,3,5]
 * 输出：3
 * 解释：我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
 * 另一个正确的解为删除子数组 [3,10,4] 。
 * 示例 2：
 * <p>
 * 输入：arr = [5,4,3,2,1]
 * 输出：4
 * 解释：由于数组是严格递减的，我们只能保留一个元素。所以我们需要删除长度为 4 的子数组，要么删除 [5,4,3,2]，要么删除 [4,3,2,1]。
 * 示例 3：
 * <p>
 * 输入：arr = [1,2,3]
 * 输出：0
 * 解释：数组已经是非递减的了，我们不需要删除任何元素。
 * 示例 4：
 * <p>
 * 输入：arr = [1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * 0 <= arr[i] <= 10^9
 *
 * @author simple
 */
public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    public static void main(String[] args) {
        System.out.println(new ShortestSubarrayToBeRemovedToMakeArraySorted().findLengthOfShortestSubarray(new int[]{6, 3, 10, 11, 15, 20, 13, 3, 18, 12}));
        System.out.println(new ShortestSubarrayToBeRemovedToMakeArraySorted().findLengthOfShortestSubarray(new int[]{5, 4, 3, 2, 1}));
        System.out.println(new ShortestSubarrayToBeRemovedToMakeArraySorted().findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 4, 2, 3, 5}));
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        if (arr.length == 1) return 0;

        // 左侧最长
        int left = 0;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] <= arr[i + 1]) left++;
            else break;
        }
        // 右侧最长
        int right = len - 1;
        for (int i = right; i > 0; i--) {
            if (arr[i] >= arr[i - 1]) right--;
            else break;
        }

        if (right <= left) return 0; // 重合说明整个数组都是非递减
        int ans = Math.min(len - left - 1, right); // 删除右边， 删除左边

        // 从左边的最右数字开始往前遍历
        for (int i = left; i >= 0; i--) {
            int num = arr[i];
            // 递增的后缀中哪个开始可以让前后数组拼接后是非递减
            for (int j = right; j < len; j++) {//可用二分查找节约时间
                if (num <= arr[j]) {
                    ans = Math.min(ans, j - i - 1);
                }
            }
        }
        return ans;
    }
}
