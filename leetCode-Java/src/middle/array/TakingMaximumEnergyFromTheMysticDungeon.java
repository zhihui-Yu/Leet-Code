package middle.array;

/**
 * 3147. 从魔法师身上吸取的最大能量
 * 在神秘的地牢中，n 个魔法师站成一排。每个魔法师都拥有一个属性，这个属性可以给你提供能量。有些魔法师可能会给你负能量，即从你身上吸取能量。
 * <p>
 * 你被施加了一种诅咒，当你从魔法师 i 处吸收能量后，你将被立即传送到魔法师 (i + k) 处。这一过程将重复进行，直到你到达一个不存在 (i + k) 的魔法师为止。
 * <p>
 * 换句话说，你将选择一个起点，然后以 k 为间隔跳跃，直到到达魔法师序列的末端，在过程中吸收所有的能量。
 * <p>
 * 给定一个数组 energy 和一个整数k，返回你能获得的 最大 能量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： energy = [5,2,-10,-5,1], k = 3
 * <p>
 * 输出： 3
 * <p>
 * 解释：可以从魔法师 1 开始，吸收能量 2 + 1 = 3。
 * <p>
 * 示例 2：
 * <p>
 * 输入： energy = [-2,-3,-1], k = 2
 * <p>
 * 输出： -1
 * <p>
 * 解释：可以从魔法师 2 开始，吸收能量 -1。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= energy.length <= 10^5
 * -1000 <= energy[i] <= 1000
 * 1 <= k <= energy.length - 1
 *
 * @author simple
 */
public class TakingMaximumEnergyFromTheMysticDungeon {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] arr = new int[k];

        for (int i = 0; i < k; i++) {
            for (int j = i; j < n; j = j + k) {
                arr[i] += energy[j];
            }
        }

        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (i / k > 0) {
                arr[i % k] -= energy[i - k];
            }
            max = Math.max(arr[i % k], max);
        }
        return max;
    }

    //    作者：力扣官方题解
    //    链接：https://leetcode.cn/problems/taking-maximum-energy-from-the-mystic-dungeon/solutions/3796799/cong-mo-fa-shi-shen-shang-xi-qu-de-zui-d-xkjs/
    //    来源：力扣（LeetCode）
    //    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public int maximumEnergy_2(int[] energy, int k) {
        int n = energy.length;
        int ans = Integer.MIN_VALUE;
        for (int i = n - k; i < n; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j -= k) {
                sum += energy[j];
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new TakingMaximumEnergyFromTheMysticDungeon().maximumEnergy(new int[]{-2, -3, -1}, 2));
        System.out.println(new TakingMaximumEnergyFromTheMysticDungeon().maximumEnergy(new int[]{5, 2, -10, -5, 1}, 3));
    }
}
