package easy.array;

/**
 * 2660. 保龄球游戏的获胜者
 * 给你两个下标从 0 开始的整数数组 player1 和 player2 ，分别表示玩家 1 和玩家 2 击中的瓶数。
 * <p>
 * 保龄球比赛由 n 轮组成，每轮的瓶数恰好为 10 。
 * <p>
 * 假设玩家在第 i 轮中击中 xi 个瓶子。玩家第 i 轮的价值为：
 * <p>
 * 如果玩家在该轮的前两轮的任何一轮中击中了 10 个瓶子，则为 2xi 。
 * 否则，为 xi 。
 * 玩家的得分是其 n 轮价值的总和。
 * <p>
 * 返回
 * <p>
 * 如果玩家 1 的得分高于玩家 2 的得分，则为 1 ；
 * 如果玩家 2 的得分高于玩家 1 的得分，则为 2 ；
 * 如果平局，则为 0 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：player1 = [4,10,7,9], player2 = [6,5,2,3]
 * 输出：1
 * 解释：player1 的得分是 4 + 10 + 2*7 + 2*9 = 46 。
 * player2 的得分是 6 + 5 + 2 + 3 = 16 。
 * player1 的得分高于 player2 的得分，所以 play1 在比赛中获胜，答案为 1 。
 * 示例 2：
 * <p>
 * 输入：player1 = [3,5,7,6], player2 = [8,10,10,2]
 * 输出：2
 * 解释：player1 的得分是 3 + 5 + 7 + 6 = 21 。
 * player2 的得分是 8 + 10 + 2*10 + 2*2 = 42 。
 * player2 的得分高于 player1 的得分，所以 play2 在比赛中获胜，答案为 2 。
 * 示例 3：
 * <p>
 * 输入：player1 = [2,3], player2 = [4,1]
 * 输出：0
 * 解释：player1 的得分是 2 + 3 = 5 。
 * player2 的得分是 4 + 1 = 5 。
 * player1 的得分等于 player2 的得分，所以这一场比赛平局，答案为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == player1.length == player2.length
 * 1 <= n <= 1000
 * 0 <= player1[i], player2[i] <= 10
 *
 * @author simple
 */
public class DetermineTheWinnerOfABowlingGame {
    public int isWinner(int[] player1, int[] player2) {
        int p1 = 0, p2 = 0;
        for (int i = 0; i < player2.length; i++) {
            p1 += player1[i];
            p2 += player2[i];

            if (i > 0 && player1[i - 1] == 10 || i > 1 && player1[i - 2] == 10)
                p1 += player1[i];
            if (i > 0 && player2[i - 1] == 10 || i > 1 && player2[i - 2] == 10)
                p2 += player2[i];
        }

        if (p1 == p2) return 0;
        return p1 > p2 ? 1 : 2;
    }

    public static void main(String[] args) {
        System.out.println(new DetermineTheWinnerOfABowlingGame().isWinner(new int[]{5, 6, 1, 10}, new int[]{5, 1, 10, 5}));
        System.out.println(new DetermineTheWinnerOfABowlingGame().isWinner(new int[]{10, 2, 2, 3}, new int[]{3, 8, 4, 5}));
    }
}
