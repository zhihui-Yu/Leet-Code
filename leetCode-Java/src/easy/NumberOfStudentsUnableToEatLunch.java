package easy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author simple
 * <p>
 * 学校的自助午餐提供圆形和方形的三明治，分别用数字0和1表示。所有学生站在一个队列里，每个学生要么喜欢圆形的要么喜欢方形的。
 * 餐厅里三明治的数量与学生的数量相同。所有三明治都放在一个栈里，每一轮：
 * <p>
 * 如果队列最前面的学生喜欢栈顶的三明治，那么会拿走它并离开队列。
 * 否则，这名学生会放弃这个三明治并回到队列的尾部。
 * 这个过程会一直持续到队列里所有学生都不喜欢栈顶的三明治为止。
 * <p>
 * 给你两个整数数组students 和sandwiches，其中sandwiches[i]是栈里面第i​​​​​​个三明治的类型（i = 0是栈的顶部），students[j]是初始队列里第j​​​​​​名学生对三明治的喜好（j = 0是队列的最开始位置）。请你返回无法吃午餐的学生数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：students = [1,1,0,0], sandwiches = [0,1,0,1]
 * 输出：0
 * 解释：
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [1,0,0,1]。
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [0,0,1,1]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [0,1,1]，三明治栈为 sandwiches = [1,0,1]。
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [1,1,0]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [1,0]，三明治栈为 sandwiches = [0,1]。
 * - 最前面的学生放弃最顶上的三明治，并回到队列的末尾，学生队列变为 students = [0,1]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = [1]，三明治栈为 sandwiches = [1]。
 * - 最前面的学生拿走最顶上的三明治，剩余学生队列为 students = []，三明治栈为 sandwiches = []。
 * 所以所有学生都有三明治吃。
 * 示例 2：
 * <p>
 * 输入：students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= students.length, sandwiches.length <= 100
 * students.length == sandwiches.length
 * sandwiches[i]要么是0，要么是1。
 * students[i]要么是0，要么是1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-students-unable-to-eat-lunch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> studentStack = new ArrayDeque<>();
        int zeroCount = 0, oneCount = 0;
        for (int i : students) {
            if (i == 0) zeroCount++;
            else oneCount++;
            studentStack.addLast(i);
        }

        for (int i = 0; i < sandwiches.length;) {
            Integer first = studentStack.pollFirst();
            if (first != sandwiches[i]) {
                if (sandwiches[i] == 0 && zeroCount == 0) return oneCount;
                if (sandwiches[i] == 1 && oneCount == 0) return zeroCount;
                studentStack.addLast(first);
            } else {
                if (sandwiches[i] == 0) zeroCount--;
                if (sandwiches[i] == 1) oneCount--;
                i++;
            }
        }

        return studentStack.size();
    }

    public static void main(String[] args) {
        new NumberOfStudentsUnableToEatLunch().countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1});
    }
}
