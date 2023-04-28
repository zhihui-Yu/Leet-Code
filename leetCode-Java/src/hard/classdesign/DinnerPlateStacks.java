package hard.classdesign;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.TreeSet;

/**
 * 1172. 餐盘栈
 * 我们把无限数量 ∞ 的栈排成一行，按从左到右的次序从 0 开始编号。每个栈的的最大容量 capacity 都相同。
 * <p>
 * 实现一个叫「餐盘」的类 DinnerPlates：
 * <p>
 * DinnerPlates(int capacity) - 给出栈的最大容量 capacity。
 * void push(int val) - 将给出的正整数 val 推入 从左往右第一个 没有满的栈。
 * int pop() - 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1。
 * int popAtStack(int index) - 返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回 -1。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
 * [[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
 * 输出：
 * [null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 20000
 * 1 <= val <= 20000
 * 0 <= index <= 100000
 * 最多会对 push，pop，和 popAtStack 进行 200000 次调用。
 *
 * @author simple
 */
public class DinnerPlateStacks {
    public static void main(String[] args) {
//        DinnerPlates dinnerPlates = new DinnerPlates(1);
//        dinnerPlates.push(1);
//        dinnerPlates.push(2);
//        dinnerPlates.push(3);
//        dinnerPlates.popAtStack(1);
//        dinnerPlates.pop();
//        dinnerPlates.pop();
        DinnerPlates dinnerPlates = new DinnerPlates(2);
        dinnerPlates.push(1);
        dinnerPlates.push(2);
        dinnerPlates.push(3);
        dinnerPlates.push(4);
        dinnerPlates.push(5);
        System.out.println(dinnerPlates.popAtStack(0));
        dinnerPlates.push(20);
        dinnerPlates.push(21);
        System.out.println(dinnerPlates.popAtStack(0));
        System.out.println(dinnerPlates.popAtStack(2));
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
        System.out.println(dinnerPlates.pop());
    }

    static class DinnerPlates {
        int capacity;
        List<Deque<Integer>> queue = new ArrayList<>();
        TreeSet<Integer> notFull = new TreeSet<>(); // 维护一个未满stack的结构，方便遍历

        public DinnerPlates(int capacity) {
            this.capacity = capacity;
        }

        public void push(int val) {
            if (notFull.isEmpty()) { // 需要添加新stack
                queue.add(new ArrayDeque<>());
                queue.get(queue.size() - 1).push(val);
                if (capacity > 1) {
                    notFull.add(queue.size() - 1);
                }
            } else {
                Integer idx = notFull.first(); // 使用旧的stack
                queue.get(idx).push(val);
                if (queue.get(idx).size() == capacity) {
                    notFull.pollFirst();
                }
            }
        }

        public int pop() {
            return popAtStack(queue.size() - 1); // 最后一个必定是非空的stack
        }

        public int popAtStack(int index) {
            if (0 > index || index >= queue.size() || queue.get(index).isEmpty()) return -1;

            var val = queue.get(index).pop();
            if (index == queue.size() - 1 && queue.get(index).isEmpty()) { // 删除末尾的空栈，节约空间
                while (!queue.isEmpty() && queue.get(queue.size() - 1).isEmpty()) {
                    notFull.remove(queue.size() - 1); // 先删除notFull ！！  不然下面size会变动
                    queue.remove(queue.size() - 1);
                }
            } else {
                notFull.add(index);
            }
            return val;
        }
    }
}
