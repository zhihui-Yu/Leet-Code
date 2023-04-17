package easy.string;

/**
 * 2409. 统计共同度过的日子数
 * Alice 和 Bob 计划分别去罗马开会。
 * <p>
 * 给你四个字符串 arriveAlice ，leaveAlice ，arriveBob 和 leaveBob 。Alice 会在日期 arriveAlice 到 leaveAlice 之间在城市里（日期为闭区间），
 * 而 Bob 在日期 arriveBob 到 leaveBob 之间在城市里（日期为闭区间）。每个字符串都包含 5 个字符，格式为 "MM-DD" ，对应着一个日期的月和日。
 * <p>
 * 请你返回 Alice和 Bob 同时在罗马的天数。
 * <p>
 * 你可以假设所有日期都在 同一个 自然年，而且 不是 闰年。每个月份的天数分别为：[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31] 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19"
 * 输出：3
 * 解释：Alice 从 8 月 15 号到 8 月 18 号在罗马。Bob 从 8 月 16 号到 8 月 19 号在罗马，他们同时在罗马的日期为 8 月 16、17 和 18 号。所以答案为 3 。
 * 示例 2：
 * <p>
 * 输入：arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob = "12-31"
 * 输出：0
 * 解释：Alice 和 Bob 没有同时在罗马的日子，所以我们返回 0。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 所有日期的格式均为 "MM-DD" 。
 * Alice 和 Bob 的到达日期都 早于或等于 他们的离开日期。
 * 题目测试用例所给出的日期均为 非闰年 的有效日期。
 *
 * @author simple
 */
public class CountDaysSpentTogether {

    // 方法二： 将所有日期转为天数，然后做加减。 更方便
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] month = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int[] aliceArrive = convert(arriveAlice.split("-"));
        int[] aliceLeave = convert(leaveAlice.split("-"));
        int[] bobArrive = convert(arriveBob.split("-"));
        int[] bobLeave = convert(leaveBob.split("-"));

        if (aliceLeave[0] < bobArrive[0] || aliceLeave[0] == bobArrive[0] && aliceLeave[1] < bobArrive[1]) return 0;
        if (bobLeave[0] < aliceArrive[0] || bobLeave[0] == aliceArrive[0] && bobLeave[1] < aliceArrive[1]) return 0;

        int[] start = aliceArrive[0] < bobArrive[0] || aliceArrive[0] == bobArrive[0] && aliceArrive[1] < bobArrive[1] ? bobArrive : aliceArrive;
        int[] end = aliceLeave[0] < bobLeave[0] || aliceLeave[0] == bobLeave[0] && aliceLeave[1] < bobLeave[1] ? aliceLeave : bobLeave;

        int cnt = 0;
        if (start[0] != end[0]) {
            cnt += month[start[0] - 1] - start[1] + 1 + end[1];
            for (int i = start[0]; i < end[0] - 1; i++) {
                cnt += month[i];
            }
        } else {
            cnt += end[1] - start[1] + 1;
        }

        return cnt;
    }

    int[] convert(String[] date) {
        String month = date[0];
        String day = date[1];
        return new int[]{
            month.charAt(0) == '0' ? month.charAt(1) - '0' : Integer.parseInt(month),
            day.charAt(0) == '0' ? day.charAt(1) - '0' : Integer.parseInt(day),
        };
    }

    public static void main(String[] args) {
        System.out.println(new CountDaysSpentTogether().countDaysTogether("03-05", "07-14", "04-14", "09-21")); // 92
        System.out.println(new CountDaysSpentTogether().countDaysTogether("08-06", "12-08", "02-04", "09-01")); // 27
        System.out.println(new CountDaysSpentTogether().countDaysTogether("09-01", "10-19", "06-19", "10-20")); // 49
        System.out.println(new CountDaysSpentTogether().countDaysTogether("08-15", "08-18", "08-16", "08-19")); // 3
    }
}
