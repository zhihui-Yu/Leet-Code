package middle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 3433. 统计用户被提及情况
 * 给你一个整数 numberOfUsers 表示用户总数，另有一个大小为 n x 3 的数组 events 。
 * <p>
 * 每个 events[i] 都属于下述两种类型之一：
 * <p>
 * 消息事件（Message Event）：["MESSAGE", "timestampi", "mentions_stringi"]
 * 事件表示在 timestampi 时，一组用户被消息提及。
 * mentions_stringi 字符串包含下述标识符之一：
 * id<number>：其中 <number> 是一个区间 [0,numberOfUsers - 1] 内的整数。可以用单个空格分隔 多个 id ，并且 id 可能重复。此外，这种形式可以提及离线用户。
 * ALL：提及 所有 用户。
 * HERE：提及所有 在线 用户。
 * 离线事件（Offline Event）：["OFFLINE", "timestampi", "idi"]
 * 事件表示用户 idi 在 timestampi 时变为离线状态 60 个单位时间。用户会在 timestampi + 60 时自动再次上线。
 * 返回数组 mentions ，其中 mentions[i] 表示  id 为  i 的用户在所有 MESSAGE 事件中被提及的次数。
 * <p>
 * 最初所有用户都处于在线状态，并且如果某个用户离线或者重新上线，其对应的状态变更将会在所有相同时间发生的消息事件之前进行处理和同步。
 * <p>
 * 注意 在单条消息中，同一个用户可能会被提及多次。每次提及都需要被 分别 统计。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numberOfUsers = 2, events = [["MESSAGE","10","id1 id0"],["OFFLINE","11","0"],["MESSAGE","71","HERE"]]
 * <p>
 * 输出：[2,2]
 * <p>
 * 解释：
 * <p>
 * 最初，所有用户都在线。
 * <p>
 * 时间戳 10 ，id1 和 id0 被提及，mentions = [1,1]
 * <p>
 * 时间戳 11 ，id0 离线 。
 * <p>
 * 时间戳 71 ，id0 再次 上线 并且 "HERE" 被提及，mentions = [2,2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：numberOfUsers = 2, events = [["MESSAGE","10","id1 id0"],["OFFLINE","11","0"],["MESSAGE","12","ALL"]]
 * <p>
 * 输出：[2,2]
 * <p>
 * 解释：
 * <p>
 * 最初，所有用户都在线。
 * <p>
 * 时间戳 10 ，id1 和 id0 被提及，mentions = [1,1]
 * <p>
 * 时间戳 11 ，id0 离线 。
 * <p>
 * 时间戳 12 ，"ALL" 被提及。这种方式将会包括所有离线用户，所以 id0 和 id1 都被提及，mentions = [2,2]
 * <p>
 * 示例 3：
 * <p>
 * 输入：numberOfUsers = 2, events = [["OFFLINE","10","0"],["MESSAGE","12","HERE"]]
 * <p>
 * 输出：[0,1]
 * <p>
 * 解释：
 * <p>
 * 最初，所有用户都在线。
 * <p>
 * 时间戳 10 ，id0 离线 。
 * <p>
 * 时间戳 12 ，"HERE" 被提及。由于 id0 仍处于离线状态，其将不会被提及，mentions = [0,1]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= numberOfUsers <= 100
 * 1 <= events.length <= 100
 * events[i].length == 3
 * events[i][0] 的值为 MESSAGE 或 OFFLINE 。
 * 1 <= int(events[i][1]) <= 10^5
 * 在任意 "MESSAGE" 事件中，以 id<number> 形式提及的用户数目介于 1 和 100 之间。
 * 0 <= <number> <= numberOfUsers - 1
 * 题目保证 OFFLINE 引用的用户 id 在事件发生时处于 在线 状态。
 *
 * @author simple
 */
public class CountMentionsPerUser {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mem = new int[numberOfUsers];
        Set<Integer> onlineUsers = new HashSet<>();
        Map<Integer, Integer> offUsers = new HashMap<>();

        events.sort((a, b) -> {
            int timeA = Integer.parseInt(a.get(1));
            int timeB = Integer.parseInt(b.get(1));
            if (timeA != timeB) {
                return Integer.compare(timeA, timeB);
            }
            boolean aIsMessage = a.get(0).equals("MESSAGE");
            boolean bIsMessage = b.get(0).equals("MESSAGE");
            return Boolean.compare(aIsMessage, bIsMessage);
        });
        for (int i = 0; i < numberOfUsers; i++) {
            onlineUsers.add(i);
        }
        int all = 0;
        for (List<String> e : events) {
            String type = e.get(0);
            int time = Integer.parseInt(e.get(1));

            if (type.equals("OFFLINE")) {
                int id = Integer.parseInt(e.get(2).replace("id", ""));
                offUsers.put(id, time);
                onlineUsers.remove(id);
                continue;
            }
            if (type.equals("MESSAGE")) {
                String d3 = e.get(2);
                if (d3.equals("ALL")) {
                    all++;
                } else if (d3.equals("HERE")) {
                    List<Integer> online = offUsers.entrySet().stream().filter(x -> x.getValue() + 60 <= time).map(Map.Entry::getKey).toList();
                    online.forEach(offUsers::remove);
                    onlineUsers.addAll(online);
                    for (var id : onlineUsers) mem[id]++;
                } else {
                    String[] ids = d3.split("\\s");
                    for (var id : ids) mem[Integer.parseInt(id.replace("id", ""))]++;
                }
            }
        }
        for (int i = 0; i < mem.length; i++) {
            mem[i] += all;
        }
        return mem;
    }

    public static void main(String[] args) {
        CountMentionsPerUser solution = new CountMentionsPerUser();
        // 测试用例
        int numberOfUsers = 3;
        List<List<String>> events = Arrays.asList(
            Arrays.asList("MESSAGE", "2", "HERE"),
            Arrays.asList("OFFLINE", "2", "1"),
            Arrays.asList("OFFLINE", "1", "0"),
            Arrays.asList("MESSAGE", "61", "HERE")
        );

        int[] result = solution.countMentions(numberOfUsers, events);
        System.out.println("结果: " + Arrays.toString(result));
        System.out.println("期望: [1,0,2]");
    }
}
