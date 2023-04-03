package easy.array;

import java.util.Arrays;

/**
 * 1053. 交换一次的先前排列
 * 给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 arr 的最大排列。
 * <p>
 * 如果无法这么操作，就请返回原数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1]
 * 输出：[3,1,2]
 * 解释：交换 2 和 1
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,5]
 * 输出：[1,1,5]
 * 解释：已经是最小排列
 * 示例 3：
 * <p>
 * 输入：arr = [1,9,4,6,7]
 * 输出：[1,7,4,6,9]
 * 解释：交换 9 和 7
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 104
 * 1 <= arr[i] <= 104
 *
 * @author simple
 */
public class PreviousPermutationWithOneSwap {
    // 字典序排列: arr[i]<=arr[i+1]
    // 字典序排列小于 arr 的最大排列: 1,9,4,6,7 -> 1,7,4,6,9; 9换成小于它的最大值7，便是最大排列
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        // 右侧最大的数与左侧最大的数交换，既字典序排列小于 arr 的最大排列
        for (int i = n - 2; i >= 0; i--) { // 倒序遍历，保证右侧非递减
            if (arr[i] > arr[i + 1]) { // 找到 arr[i] > arr[j]中最大的 arr[j]值
                int j = n - 1;
                for (; arr[j] >= arr[i] || arr[j] == arr[j - 1]; j--) { // 找到小于 arr[i] 的右侧最大值 arr[j], 交换位置. 如果 arr[j] = arr[j - 1]，为了最大排列， i位置要尽可能前。
                }
                arr[i] ^= arr[j];
                arr[j] ^= arr[i];
                arr[i] ^= arr[j];
                break; // 只交互一次
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PreviousPermutationWithOneSwap().prevPermOpt1(new int[]{3, 1, 1, 3})));
        System.out.println(Arrays.toString(new PreviousPermutationWithOneSwap().prevPermOpt1(new int[]{3, 2, 1})));
        System.out.println(Arrays.toString(new PreviousPermutationWithOneSwap().prevPermOpt1(new int[]{1, 9, 4, 6, 7})));
    }
}
