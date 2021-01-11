package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author simple
 * <p>
 * 在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。给定一个数字序列，实现一个算法来返回匹配单词的列表。你会得到一张含有有效单词的列表。映射如下图所示：
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = "8733", words = ["tree", "used"]
 * 输出: ["tree", "used"]
 * 示例 2:
 * <p>
 * 输入: num = "2", words = ["a", "b", "c", "d"]
 * 输出: ["a", "b", "c"]
 * 提示：
 * <p>
 * num.length <= 1000
 * words.length <= 500
 * words[i].length == num.length
 * num中不会出现 0, 1 这两个数字
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/t9-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T9Lcci {
    public List<String> getValidT9Words(String num, String[] words) {
        if (words.length == 0) return List.of();
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 2);
        map.put('b', 2);
        map.put('c', 2);
        map.put('d', 3);
        map.put('e', 3);
        map.put('f', 3);
        map.put('g', 4);
        map.put('h', 4);
        map.put('i', 4);
        map.put('j', 5);
        map.put('k', 5);
        map.put('l', 5);
        map.put('m', 6);
        map.put('n', 6);
        map.put('o', 6);
        map.put('p', 7);
        map.put('q', 7);
        map.put('r', 7);
        map.put('s', 7);
        map.put('t', 8);
        map.put('u', 8);
        map.put('v', 8);
        map.put('w', 9);
        map.put('x', 9);
        map.put('y', 9);
        map.put('z', 9);
        List<String> res = new ArrayList<>();
        StringBuilder numbers = new StringBuilder();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                numbers.append(map.get(ch));
            }
            if (num.equals(numbers.toString())) {
                res.add(word);
            }
            numbers = new StringBuilder();
        }
        return res;
    }
}
