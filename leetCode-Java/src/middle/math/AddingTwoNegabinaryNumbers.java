package middle.math;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 1073. 负二进制数相加
 * 给出基数为 -2 的两个数 arr1 和 arr2，返回两数相加的结果。
 * <p>
 * 数字以 数组形式 给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排列。
 * 例如，arr = [1,1,0,1] 表示数字 (-2)^3 + (-2)^2 + (-2)^0 = -3。数组形式 中的数字 arr 也同样不含前导零：即 arr == [0] 或 arr[0] == 1。
 * <p>
 * 返回相同表示形式的 arr1 和 arr2 相加的结果。两数的表示形式为：不含前导零、由若干 0 和 1 组成的数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr1 = [1,1,1,1,1], arr2 = [1,0,1]
 * 输出：[1,0,0,0,0]
 * 解释：arr1 表示 11，arr2 表示 5，输出表示 16 。
 * 示例 2：
 * <p>
 * 输入：arr1 = [0], arr2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：arr1 = [0], arr2 = [1]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length <= 1000
 * arr1[i] 和 arr2[i] 都是 0 或 1
 * arr1 和 arr2 都没有前导0
 *
 * @author simple
 */
public class AddingTwoNegabinaryNumbers {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        if (arr1.length == 1 && arr1[0] == 0) return arr2;
        if (arr2.length == 1 && arr2[0] == 0) return arr1;

        List<Integer> res = new LinkedList<>();
        int i = arr1.length - 1, j = arr2.length - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) sum += arr1[i--];
            if (j >= 0) sum += arr2[j--];

            if (sum >= 2) {
                res.add(sum - 2);
                carry = -1;
            } else if (sum >= 0) {
                res.add(sum);
                carry = 0;
            } else {
                res.add(1);
                carry = 1;
            }
        }
        while (res.size() > 1 && res.get(res.size() - 1) == 0) {
            res.remove(res.size() - 1);
        }
        Collections.reverse(res);
        return res.stream().mapToInt(x -> x).toArray();
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AddingTwoNegabinaryNumbers().addNegabinary(new int[]{1}, new int[]{1,1,0,1})));
        System.out.println(Arrays.toString(new AddingTwoNegabinaryNumbers().addNegabinary(new int[]{1}, new int[]{1})));
        System.out.println(Arrays.toString(new AddingTwoNegabinaryNumbers().addNegabinary(new int[]{0}, new int[]{1, 0})));
        System.out.println(Arrays.toString(new AddingTwoNegabinaryNumbers().addNegabinary(new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 1})));
    }
}
