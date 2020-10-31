package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author simple
 * <p>
 * 设计一个支持在平均时间复杂度O(1)下，执行以下操作的数据结构。
 * <p>
 * 注意: 允许出现重复元素。
 * <p>
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 * 示例:
 * <p>
 * // 初始化一个空的集合。
 * RandomizedCollection collection = new RandomizedCollection();
 * <p>
 * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * collection.insert(1);
 * <p>
 * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * collection.insert(1);
 * <p>
 * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * collection.insert(2);
 * <p>
 * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * collection.getRandom();
 * <p>
 * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * collection.remove(1);
 * <p>
 * // getRandom 应有相同概率返回 1 和 2 。
 * collection.getRandom();
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-delete-getrandom-o1-duplicates-allowed
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RandomizedCollection {
    private final List<Integer> numbers;
    private final Map<Integer, TreeSet<Integer>> numberIndexes;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        numbers = new ArrayList<>();
        numberIndexes = new HashMap<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        // 将val 加入数组 并保存val的index到map中
        numbers.add(val);
        TreeSet<Integer> indexes = numberIndexes.getOrDefault(val, new TreeSet<>());
        indexes.add(numbers.size() - 1);
        numberIndexes.put(val, indexes);
        return indexes.size() == 1;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        // 查找val 出现的最后一个index 如果index数组等于0 则没有这个val 返回false
        TreeSet<Integer> indexes = numberIndexes.getOrDefault(val, new TreeSet<>());
        if (indexes.size() >= 1) {
            // 找到numbers中最后一个数字，将lastNumber 赋值给 lastVal 所在位置， 删除lastNumber -> O(1)
            int numberSize = numbers.size();
            Integer lastIndex = indexes.last();
            Integer lastNumber = numbers.get(numberSize - 1);
            numbers.set(lastIndex, lastNumber);
            numbers.remove(numberSize - 1);
            // 删除 LastVal 的 index
            indexes.remove(lastIndex);
            // 如果val != lastNumber, 说明LastNumber 中最后一个index 需要修改
            // 这里需要注意， 只能有序的集合才行，不然删除有问题( 1(index 2,3,0), 在删除1后，index(2,3), 但这时数组 len == 3 )
            if (val != lastNumber) {
                TreeSet<Integer> lastNumberIndexes = numberIndexes.get(lastNumber);
                lastNumberIndexes.remove(numberSize - 1);
                lastNumberIndexes.add(lastIndex);
            }
            return true;
        } else return false;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        Random random = new Random();
        return numbers.get(random.nextInt(numbers.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */