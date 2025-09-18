package middle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 3408. 设计任务管理器
 * 一个任务管理器系统可以让用户管理他们的任务，每个任务有一个优先级。这个系统需要高效地处理添加、修改、执行和删除任务的操作。
 * <p>
 * 请你设计一个 TaskManager 类：
 * <p>
 * TaskManager(vector<vector<int>>& tasks) 初始化任务管理器，初始化的数组格式为 [userId, taskId, priority] ，表示给 userId 添加一个优先级为 priority 的任务 taskId 。
 * <p>
 * void add(int userId, int taskId, int priority) 表示给用户 userId 添加一个优先级为 priority 的任务 taskId ，输入 保证 taskId 不在系统中。
 * <p>
 * void edit(int taskId, int newPriority) 更新已经存在的任务 taskId 的优先级为 newPriority 。输入 保证 taskId 存在于系统中。
 * <p>
 * void rmv(int taskId) 从系统中删除任务 taskId 。输入 保证 taskId 存在于系统中。
 * <p>
 * int execTop() 执行所有用户的任务中优先级 最高 的任务，如果有多个任务优先级相同且都为 最高 ，执行 taskId 最大的一个任务。执行完任务后，taskId 从系统中 删除 。同时请你返回这个任务所属的用户 userId 。如果不存在任何任务，返回 -1 。
 * <p>
 * 注意 ，一个用户可能被安排多个任务。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["TaskManager", "add", "edit", "execTop", "rmv", "add", "execTop"]
 * [[[[1, 101, 10], [2, 102, 20], [3, 103, 15]]], [4, 104, 5], [102, 8], [], [101], [5, 105, 15], []]
 * <p>
 * 输出：
 * [null, null, null, 3, null, null, 5]
 * <p>
 * 解释：
 * <p>
 * TaskManager taskManager = new TaskManager([[1, 101, 10], [2, 102, 20], [3, 103, 15]]); // 分别给用户 1 ，2 和 3 初始化一个任务。
 * taskManager.add(4, 104, 5); // 给用户 4 添加优先级为 5 的任务 104 。
 * taskManager.edit(102, 8); // 更新任务 102 的优先级为 8 。
 * taskManager.execTop(); // 返回 3 。执行用户 3 的任务 103 。
 * taskManager.rmv(101); // 将系统中的任务 101 删除。
 * taskManager.add(5, 105, 15); // 给用户 5 添加优先级为 15 的任务 105 。
 * taskManager.execTop(); // 返回 5 。执行用户 5 的任务 105 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= tasks.length <= 105
 * 0 <= userId <= 10^5
 * 0 <= taskId <= 10^5
 * 0 <= priority <= 10^9
 * 0 <= newPriority <= 10^9
 * add ，edit ，rmv 和 execTop 的总操作次数 加起来 不超过 2 * 10^5 次。
 * 输入保证 taskId 是合法的。
 */
public class DesignTaskManager {
    public static void main(String[] args) {
        TaskManager obj = new TaskManager(List.of(List.of(5, 2, 23), List.of(5, 10, 50), List.of(0, 27, 11), List.of(4, 1, 6)));
        obj.edit(27, 18);
        System.out.println(obj.execTop());
        obj.edit(27, 48);
        System.out.println(obj.execTop());
    }

    // 优先队列+哈希表
    static class TaskManager {
        // int[] = {userId, taskId, priority}
        Map<Integer, int[]> taskMap = new HashMap<>();
        PriorityQueue<int[]> taskPriority = new PriorityQueue<>((a, b) -> {
            // priority then taskId
            if (a[2] == b[2])
                return b[1] - a[1];
            return b[2] - a[2];
        });

        public TaskManager(List<List<Integer>> tasks) {
            for (List<Integer> task : tasks) {
                Integer userId = task.get(0);
                Integer taskId = task.get(1);
                Integer priority = task.get(2);
                add(userId, taskId, priority);
            }
        }

        public void add(int userId, int taskId, int priority) {
            // can't use same obj, because we would change the value of the arr, the value will be updated
            taskMap.put(taskId, new int[]{userId, taskId, priority});
            taskPriority.offer(new int[]{userId, taskId, priority});
        }

        public void edit(int taskId, int newPriority) {
            int[] task = taskMap.get(taskId);
            task[2] = newPriority;
            taskPriority.offer(new int[]{task[0], task[1], task[2]});
        }

        public void rmv(int taskId) {
            taskMap.remove(taskId);
        }

        public int execTop() {
            while (!taskPriority.isEmpty()) {
                int[] task = taskPriority.poll();
                int[] taskInfo = taskMap.get(task[1]);
                // 存在并且priority 一致则认为task有效
                if (taskInfo != null && taskInfo[2] == task[2] && taskInfo[0] == task[0]) {
                    taskMap.remove(task[1]);
                    return task[0];
                }
            }
            return -1;
        }
    }
}
