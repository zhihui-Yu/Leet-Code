package easy.math;

/**
 * 3005. 最大频率元素计数
 * 给你一个由 正整数 组成的数组 nums 。
 * <p>
 * 返回数组 nums 中所有具有 最大 频率的元素的 总频率 。
 * <p>
 * 元素的 频率 是指该元素在数组中出现的次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,3,1,4]
 * 输出：4
 * 解释：元素 1 和 2 的频率为 2 ，是数组中的最大频率。
 * 因此具有最大频率的元素在数组中的数量是 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：5
 * 解释：数组中的所有元素的频率都为 1 ，是最大频率。
 * 因此具有最大频率的元素在数组中的数量是 5 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 *
 * @author simple
 */
public class CountElementsWithMaximumFrequency {
    public static void main(String[] args) {
        System.out.println(new CountElementsWithMaximumFrequency().maxFrequencyElements(new int[]{42,29,100,55,70,28,63,78,4,73,32,2,98,22,78,64,43,28,90,42,100,56,85,32,39,54,33,27,7,68,4,77,81,71,49,39,76,95,37,7,2}));
    }
    public int maxFrequencyElements(int[] nums) {
        int[] arr = new int[101];
        for (int i : nums) {
            arr[i]++;
        }
        int maxCnt = 0, total = 0;
        for (int i = 0; i <= 100; i++) {
            if (arr[i] > maxCnt) {
                maxCnt = arr[i];
                total = maxCnt;
            } else if (arr[i] == maxCnt) {
                total += maxCnt;
            }
        }
        return total;
    }
}
