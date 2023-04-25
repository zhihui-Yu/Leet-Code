package easy.array;

import java.util.Arrays;

/**
 * 2418. 按身高排序
 * 给你一个字符串数组 names ，和一个由互不相同的正整数组成的数组 heights 。两个数组的长度均为 n 。
 * <p>
 * 对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。
 * <p>
 * 请按身高 降序 顺序返回对应的名字数组 names 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：names = ["Mary","John","Emma"], heights = [180,165,170]
 * 输出：["Mary","Emma","John"]
 * 解释：Mary 最高，接着是 Emma 和 John 。
 * 示例 2：
 * <p>
 * 输入：names = ["Alice","Bob","Bob"], heights = [155,185,150]
 * 输出：["Bob","Alice","Bob"]
 * 解释：第一个 Bob 最高，然后是 Alice 和第二个 Bob 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == names.length == heights.length
 * 1 <= n <= 10^3
 * 1 <= names[i].length <= 20
 * 1 <= heights[i] <= 10^5
 * names[i] 由大小写英文字母组成
 * heights 中的所有值互不相同
 *
 * @author simple
 */
public class SortThePeople {

    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        Arrays.sort(idx, (i, j) -> heights[j] - heights[i]); // 降序

        String[] res = new String[n];
        for (int i = 0; i < n; i++) res[i] = names[idx[i]];

        return res;
    }

    // 手动实现排序算法
    public String[] sortPeople2(String[] names, int[] heights) {
        quickSort(names, heights, 0, names.length - 1);
        return names;
    }

    void quickSort(String[] names, int[] heights, int i, int j) {
        if (i >= j) return; // 左侧 >= 右侧, 不需要遍历
        int base = i;
        int p = j;

        while (base != p) { // 当base == p 说明已经遍历完数组了
            // 从右往左遍历 找比当前数大的数，并交换位置
            while (base < p && heights[base] > heights[p]) p--;
            if (base < p) {
                swap(names, heights, base, p); // 找到交换
                p ^= base;
                base ^= p;
                p ^= base;
            }

            // 从左往右遍历，找比当前数小的，并交换位置
            while (base > p && heights[base] < heights[p]) p++;
            if (base > p) {
                swap(names, heights, base, p); // 找到交换
                p ^= base;
                base ^= p;
                p ^= base;
            }
        }
        quickSort(names, heights, i, base - 1); // 排序base左边
        quickSort(names, heights, base + 1, j); // 排序base右边
    }

    void swap(String[] names, int[] heights, int i, int j) {
        String tmp = names[i];
        names[i] = names[j];
        names[j] = tmp;

        heights[i] ^= heights[j];
        heights[j] ^= heights[i];
        heights[i] ^= heights[j];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortThePeople().sortPeople(new String[]{"IEO", "Sgizfdfrims", "QTASHKQ", "Vk", "RPJOFYZUBFSIYp", "EPCFFt", "VOYGWWNCf", "WSpmqvb"}, new int[]{17233, 32521, 14087, 42738, 46669, 65662, 43204, 8224})));
        System.out.println(Arrays.toString(new SortThePeople().sortPeople(new String[]{"Mary", "John", "Emma"}, new int[]{180, 165, 170})));
    }
}
