package middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 17.05. 字母与数字
 * <p>
 * 给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。
 * <p>
 * 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 * <p>
 * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 * 示例 2:
 * <p>
 * 输入: ["A","A"]
 * <p>
 * 输出: []
 * 提示：
 * <p>
 * array.length <= 100000
 *
 * @author simple
 */
public class FindLongestSubarrayLcci {
    public String[] findLongestSubarray(String[] array) {
        int len = array.length;
        int[] arr = new int[array.length];
        // 字母为 1，数字 -1
        arr[0] = Character.isDigit(array[0].charAt(0)) ? -1 : 1;
        for (int i = 1; i < len; i++) {
            if (Character.isDigit(array[i].charAt(0))) {
                arr[i] = arr[i - 1] - 1;
            } else {
                arr[i] = arr[i - 1] + 1;
            }
        }

        int ansLen = 0; // 长度
        int ansIndex = 0; // 结果的最左下标
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        // 与arr[i]值相等的最早的下标
        for (int i = 0; i < arr.length; i++) {
            Integer index = map.get(arr[i]);
            if (index != null) {
                int tmp = Math.max(ansLen, i - index);
                ansIndex = tmp == ansLen ? ansIndex : index + 1;
                ansLen = tmp;
            } else {
                map.put(arr[i], i);
            }
        }
        // 比如 1,0,1， 当遍历最后一个1时，截取的数组应该是0,1, ansIndex = 1， len = 2
        return Arrays.copyOfRange(array, ansIndex, ansIndex + ansLen);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindLongestSubarrayLcci().findLongestSubarray(new String[]{"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"})));
        System.out.println(Arrays.toString(new FindLongestSubarrayLcci().findLongestSubarray(new String[]{"A", "A"})));
    }
}
