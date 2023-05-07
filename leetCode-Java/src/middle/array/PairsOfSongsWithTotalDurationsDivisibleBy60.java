package middle.array;

/**
 * 1010. 总持续时间可被 60 整除的歌曲
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * <p>
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望下标数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：time = [30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整除：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * 示例 2：
 * <p>
 * 输入：time = [60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整除。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= time.length <= 6 * 104
 * 1 <= time[i] <= 500
 *
 * @author simple
 */
public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    // t % 60 == 0 =>  (x+y) % 60 == 0 =>  (60 - x) % 60 = y
    public int numPairsDivisibleBy60(int[] time) {
        int[] cnt = new int[60];
        int ans = 0;
        for (int t : time) {
            t %= 60;
            int y = (60 - t) % 60; // 求出互补值
            ans += cnt[y]; // 当前数可以与 互补值数量配对
            cnt[t]++;
        }
        return ans;
    }

    // 超时
    public int numPairsDivisibleBy60_timeout(int[] time) {
        int cnt = 0;
        for (int i = 0; i < time.length; i++) {
            for (int j = i + 1; j < time.length; j++) {
                if ((time[i] + time[j]) % 60 == 0) cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new PairsOfSongsWithTotalDurationsDivisibleBy60().numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
    }
}
