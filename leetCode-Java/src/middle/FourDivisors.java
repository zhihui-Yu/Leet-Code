package middle;

import java.util.HashSet;
import java.util.Set;

/**
 * 1390. 四因数
 * 给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。如果数组中不存在满足题意的整数，则返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [21,4,7]
 * 输出：32
 * 解释：
 * 21 有 4 个因数：1, 3, 7, 21
 * 4 有 3 个因数：1, 2, 4
 * 7 有 2 个因数：1, 7
 * 答案仅为 21 的所有因数的和。
 * 示例 2:
 * <p>
 * 输入: nums = [21,21]
 * 输出: 64
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,4,5]
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^5
 *
 * @author simple
 */
public class FourDivisors {
    public int sumFourDivisors(int[] nums) {
        Set<Integer>[] mem = new Set[100001];

        int sum = 0;
        for (int n : nums) {
            if (mem[n] == null) {
                mem[n] = new HashSet<>();
                // [1, sqrt(x)] 内枚举即可
                for (int i = 1; i * i < n; i++) {
                    if (n % i == 0) {
                        int x = n / i;
                        mem[n].add(x);
                        mem[n].add(i);
                    }
                }
            }

            if (mem[n].size() == 4) {
                sum += mem[n].stream().mapToInt(x -> x).sum();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new FourDivisors().sumFourDivisors(new int[]{21, 4, 7}));
        System.out.println(new FourDivisors().sumFourDivisors(new int[]{21, 21}));
        System.out.println(new FourDivisors().sumFourDivisors(new int[]{1, 2, 3, 4, 5}));
    }
}
