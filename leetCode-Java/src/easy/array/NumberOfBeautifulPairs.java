package easy.array;

/**
 * 6466. 美丽下标对的数目
 * 给你一个下标从 0 开始的整数数组 nums 。如果下标对 i、j 满足 0 ≤ i < j < nums.length ，
 * 如果 nums[i] 的 第一个数字 和 nums[j] 的 最后一个数字 互质 ，则认为 nums[i] 和 nums[j] 是一组 美丽下标对 。
 * <p>
 * 返回 nums 中 美丽下标对 的总数目。
 * <p>
 * 对于两个整数 x 和 y ，如果不存在大于 1 的整数可以整除它们，则认为 x 和 y 互质 。
 * 换而言之，如果 gcd(x, y) == 1 ，则认为 x 和 y 互质，其中 gcd(x, y) 是 x 和 k 最大公因数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,1,4]
 * 输出：5
 * 解释：nums 中共有 5 组美丽下标对：
 * i = 0 和 j = 1 ：nums[0] 的第一个数字是 2 ，nums[1] 的最后一个数字是 5 。2 和 5 互质，因此 gcd(2,5) == 1 。
 * i = 0 和 j = 2 ：nums[0] 的第一个数字是 2 ，nums[1] 的最后一个数字是 1 。2 和 5 互质，因此 gcd(2,1) == 1 。
 * i = 1 和 j = 2 ：nums[0] 的第一个数字是 5 ，nums[1] 的最后一个数字是 1 。2 和 5 互质，因此 gcd(5,1) == 1 。
 * i = 1 和 j = 3 ：nums[0] 的第一个数字是 5 ，nums[1] 的最后一个数字是 4 。2 和 5 互质，因此 gcd(5,4) == 1 。
 * i = 2 和 j = 3 ：nums[0] 的第一个数字是 1 ，nums[1] 的最后一个数字是 4 。2 和 5 互质，因此 gcd(1,4) == 1 。
 * 因此，返回 5 。
 * 示例 2：
 * <p>
 * 输入：nums = [11,21,12]
 * 输出：2
 * 解释：共有 2 组美丽下标对：
 * i = 0 和 j = 1 ：nums[0] 的第一个数字是 1 ，nums[1] 的最后一个数字是 1 。gcd(1,1) == 1 。
 * i = 0 和 j = 2 ：nums[0] 的第一个数字是 1 ，nums[1] 的最后一个数字是 2 。gcd(1,2) == 1 。
 * 因此，返回 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * 1 <= nums[i] <= 9999
 * nums[i] % 10 != 0
 *
 * @author simple
 */
public class NumberOfBeautifulPairs {
    public int countBeautifulPairs(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                cnt += pairs(nums[i], nums[j]);
            }
        }
        return cnt;
    }

    private int pairs(int i, int j) {
        while (i / 10 != 0) {
            i /= 10;
        }
        while (j / 10 != 0) {
            j %= 10;
        }

        // 辗转相除法
        int max = Math.max(i, j);
        int min = Math.min(i, j);
        int m; // 余数
        while (min != 0) {
            m = max % min;
            max = min;
            min = m;
        }
        return max == 1 ? 1 : 0; // 最大公约数是否为1
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfBeautifulPairs().countBeautifulPairs(new int[]{11, 21, 12}));
    }
}
