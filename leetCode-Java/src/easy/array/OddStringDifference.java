package easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 2451. 差值数组不同的字符串
 * 给你一个字符串数组 words ，每一个字符串长度都相同，令所有字符串的长度都为 n 。
 * <p>
 * 每个字符串 words[i] 可以被转化为一个长度为 n - 1 的 差值整数数组 difference[i] ，
 * 其中对于 0 <= j <= n - 2 有 difference[i][j] = words[i][j+1] - words[i][j] 。
 * 注意两个字母的差值定义为它们在字母表中 位置 之差，也就是说 'a' 的位置是 0 ，'b' 的位置是 1 ，'z' 的位置是 25 。
 * <p>
 * 比方说，字符串 "acb" 的差值整数数组是 [2 - 0, 1 - 2] = [2, -1] 。
 * words 中所有字符串 除了一个字符串以外 ，其他字符串的差值整数数组都相同。你需要找到那个不同的字符串。
 * <p>
 * 请你返回 words中 差值整数数组 不同的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["adc","wzy","abc"]
 * 输出："abc"
 * 解释：
 * - "adc" 的差值整数数组是 [3 - 0, 2 - 3] = [3, -1] 。
 * - "wzy" 的差值整数数组是 [25 - 22, 24 - 25]= [3, -1] 。
 * - "abc" 的差值整数数组是 [1 - 0, 2 - 1] = [1, 1] 。
 * 不同的数组是 [1, 1]，所以返回对应的字符串，"abc"。
 * 示例 2：
 * <p>
 * 输入：words = ["aaa","bob","ccc","ddd"]
 * 输出："bob"
 * 解释：除了 "bob" 的差值整数数组是 [13, -13] 以外，其他字符串的差值整数数组都是 [0, 0] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= words.length <= 100
 * n == words[i].length
 * 2 <= n <= 20
 * words[i] 只含有小写英文字母。
 *
 * @author simple
 */
public class OddStringDifference {
    // 由于三个字符串出现两种不同数组就可以知道肯定有一个是答案，所以可以直接判断三个相邻数的数组是否一样就可以了。
    public String oddString(String[] words) {
        Map<String, List<String>> map = new HashMap<>();

        int k = 0;
        for (String word : words) {
            List<Integer> diff = new LinkedList<>();
            for (int i = 0; i < word.length() - 1; i++) {
                diff.add(word.charAt(i + 1) - word.charAt(i));
            }

            k++;
            var key = Arrays.toString(diff.toArray());
            map.compute(key, (ke, oldValue) -> {
                if (oldValue == null) {
                    oldValue = new ArrayList<>();
                }
                oldValue.add(word);
                return oldValue;
            });

            if (k > 2 && map.size() == 2) {
                for (var entry : map.entrySet()) {
                    if (entry.getValue().size() == 1) {
                        return entry.getValue().get(0);
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new OddStringDifference().oddString(new String[]{"adc","wzy","abc"}));
        System.out.println(new OddStringDifference().oddString(new String[]{"ddd", "poo", "baa", "onn"}));
    }
}
