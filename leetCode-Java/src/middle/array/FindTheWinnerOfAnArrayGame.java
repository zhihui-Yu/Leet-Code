package middle.array;

/**
 * 1535. 找出数组游戏的赢家
 * 给你一个由 不同 整数组成的整数数组 arr 和一个整数 k 。
 * <p>
 * 每回合游戏都在数组的前两个元素（即 arr[0] 和 arr[1] ）之间进行。比较 arr[0] 与 arr[1] 的大小，
 * 较大的整数将会取得这一回合的胜利并保留在位置 0 ，较小的整数移至数组的末尾。当一个整数赢得 k 个连续回合时，游戏结束，该整数就是比赛的 赢家 。
 * <p>
 * 返回赢得比赛的整数。
 * <p>
 * 题目数据 保证 游戏存在赢家。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,1,3,5,4,6,7], k = 2
 * 输出：5
 * 解释：一起看一下本场游戏每回合的情况：
 * <p>
 * 因此将进行 4 回合比赛，其中 5 是赢家，因为它连胜 2 回合。
 * 示例 2：
 * <p>
 * 输入：arr = [3,2,1], k = 10
 * 输出：3
 * 解释：3 将会在前 10 个回合中连续获胜。
 * 示例 3：
 * <p>
 * 输入：arr = [1,9,8,2,3,7,6,4,5], k = 7
 * 输出：9
 * 示例 4：
 * <p>
 * 输入：arr = [1,11,22,33,44,55,66,77,88,99], k = 1000000000
 * 输出：99
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^6
 * arr 所含的整数 各不相同 。
 * 1 <= k <= 10^9
 *
 * @author simple
 */
public class FindTheWinnerOfAnArrayGame {
    public int getWinner(int[] arr, int k) {

        // 1，2，3，4
        // 1，2，3，4，1
        // 1，2，3，4，1，2
        // 1，2，3，4，1，2，3
        // 1，2，3，4，1，2，3

        int len = arr.length;
        int[] tmp = new int[2 * len]; // TODO: 可优化，使用原数组直接比较， see top1

        for (int i = 0; i < len; i++) {
            tmp[i] = arr[i];
        }

        // 最少两个数字在数组里, left 一直是最大的数字
        int left = 0, right = 1;
        int maxWin = Math.min(k, len);
        int index = len;

        for (int i = 0; i < maxWin; i++) {
            // 找到最大值了，但是没有赢到指定次数，返回最大值
            if (index == tmp.length) break;

            if (tmp[left] < tmp[right]) {
                tmp[index++] = tmp[left];
                // 同时右移， left还是需要比较的数字
                // case2: left...i...right, left = right, right+=1
                left = right;
                right += 1;
                i = 0;
            } else {
                //arr 所含的整数 各不相同
                tmp[index++] = tmp[right];
                right += 1;
            }
        }
        // 题目数据 保证 游戏存在赢家。
        return tmp[left];
    }


    // top1: TQL
    public int getWinner_top(int[] arr, int k) {
        int mx = arr[0];
        int win = 0;
        for (int i = 1; i < arr.length && win < k; i++) {
            if (arr[i] > mx) { // 新的最大值
                mx = arr[i];
                win = 0;
            }
            win++; // 获胜回合 +1
        }
        return mx;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheWinnerOfAnArrayGame().getWinner(new int[]{1, 25, 35, 42, 70, 68}, 6));
        System.out.println(new FindTheWinnerOfAnArrayGame().getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2));
        System.out.println(new FindTheWinnerOfAnArrayGame().getWinner(new int[]{1, 9, 8, 2, 3, 7, 6, 4, 5}, 7));
        System.out.println(new FindTheWinnerOfAnArrayGame().getWinner(new int[]{1, 11, 22, 33, 44, 55, 66, 77, 88, 99}, 1000000000));
    }
}
