package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * n 个人站成一排，按从 1 到 n 编号。
 * <p>
 * 最初，排在队首的第一个人拿着一个枕头。每秒钟，拿着枕头的人会将枕头传递给队伍中的下一个人。一旦枕头到达队首或队尾，传递方向就会改变，队伍会继续沿相反方向传递枕头。
 * <p>
 * 例如，当枕头到达第 n 个人时，TA 会将枕头传递给第 n - 1 个人，然后传递给第 n - 2 个人，依此类推。
 * 给你两个正整数 n 和 time ，返回 time 秒后拿着枕头的人的编号。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, time = 5
 * 输出：2
 * 解释：队伍中枕头的传递情况为：1 -> 2 -> 3 -> 4 -> 3 -> 2 。
 * 5 秒后，枕头传递到第 2 个人手中。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 3, time = 2
 * 输出：3
 * 解释：队伍中枕头的传递情况为：1 -> 2 -> 3 。
 * 2 秒后，枕头传递到第 3 个人手中。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 1000
 * 1 <= time <= 1000
 * <p>
 * refer: <a href="https://leetcode.cn/problems/pass-the-pillow/">link</a>
 *
 * @author simple
 */
public class PassThePillow {
    public int passThePillow(int n, int time) {
        List<Integer> list = new ArrayList<>(n * 2);
        int x = n;
        for (int i = 2; i < n * 2; i++) {
            if (i > n && i != n * 2) {
                x -= 1;
                list.add(x);
            } else if (i == n * 2 - 1) {
                list.add(1);
            } else {
                list.add(i);
            }
        }
        int index = time % ((n - 1) * 2);
        return index == 0 ? 1 : list.get(index - 1);
    }

    public int passThePillow2(int n, int time) {
        // 关于n - 1，n个人，传递n-1次到达队尾
        // 传递多少轮
        int round = time / (n - 1);
        // 最后传递到第几位
        int index = time % (n - 1);
        // 先加后减，因此根据轮数的奇偶判断，是正向查找还是反向查找
        if (round % 2 == 1) {
            return n - index;
        } else {
            // 索引从1开始，因此+1
            return index + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new PassThePillow().passThePillow(4, 5)); // 2
        System.out.println(new PassThePillow().passThePillow(6, 8)); // 3
        System.out.println(new PassThePillow().passThePillow(18, 38)); // 5
        System.out.println(new PassThePillow().passThePillow(26, 1000)); // 1

    }
}
