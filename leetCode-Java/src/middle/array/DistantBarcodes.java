package middle.array;

import middle.string.ReorganizeString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1054. 距离相等的条形码
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 * <p>
 * 请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：barcodes = [1,1,1,2,2,2]
 * 输出：[2,1,2,1,2,1]
 * 示例 2：
 * <p>
 * 输入：barcodes = [1,1,1,1,2,2,3,3]
 * 输出：[1,3,1,3,2,1,2,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= barcodes.length <= 10000
 * 1 <= barcodes[i] <= 10000
 * 相同题：
 *   {@link ReorganizeString }
 * @author simple
 */
public class DistantBarcodes {
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        if (n < 2) return barcodes;

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (var i : barcodes) {
            int cnt = map.getOrDefault(i, 0) + 1;
            map.put(i, cnt);
            max = Math.max(max, cnt);
        }

        int[] ans = new int[n];
        int halfLen = n / 2;
        int odd = 1, even = 0;
        for (var entry : map.entrySet()) {
            Integer num = entry.getKey();
            Integer cnt = entry.getValue();

            // 元素数量小于或者等于数组一半时，可奇可偶
            // 两种情况放奇数位，1：cnt本来就小于N/2; 2: cnt由于放在偶数位满了，溢出的放到奇数位
            while (cnt > 0 && cnt <= halfLen && odd < n) {
                cnt--;
                ans[odd] = num;
                odd += 2;
            }

            // 元素数量大于数组一半时，必须放在偶数下标。 最多有且只有一个元素会超过数组一半。 也有可能是奇数位满了就都放偶数位
            // 由于是顺序存放，必然不会出现奇数位满了，放偶数位导致相邻数一样的情况！！
            while (cnt > 0) {
                cnt--;
                ans[even] = num;
                even += 2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DistantBarcodes().rearrangeBarcodes(new int[]{2, 2, 9, 9, 9, 9, 10, 10, 10, 9})));
        System.out.println(Arrays.toString(new DistantBarcodes().rearrangeBarcodes(new int[]{2, 2, 2, 1, 5})));
        System.out.println(Arrays.toString(new DistantBarcodes().rearrangeBarcodes(new int[]{2, 2, 1, 3})));
        System.out.println(Arrays.toString(new DistantBarcodes().rearrangeBarcodes(new int[]{1, 1, 2})));
        System.out.println(Arrays.toString(new DistantBarcodes().rearrangeBarcodes(new int[]{1, 2})));
        System.out.println(Arrays.toString(new DistantBarcodes().rearrangeBarcodes(new int[]{1, 1, 1, 2, 2, 2})));
    }
}
