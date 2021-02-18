package easy;

/**
 * @author simple
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleNumber {
    // | -----------------------------------------------------------------
    // | 1. 任何数和 00 做异或运算，结果仍然是原来的数，即a ⊕0 = a。
    // | 2. 任何数和其自身做异或运算，结果是 0，即 a ⊕ a = 0。
    // | 3. 异或运算满足交换律和结合律，即a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
    // | -----------------------------------------------------------------
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int i : nums) {
            num ^= i;
        }
        return num;
    }

    public static void main(String[] args) {
        int i = new SingleNumber().singleNumber(new int[]{0, 0, 3, 3, 2});
        System.out.println(i);
    }
}
