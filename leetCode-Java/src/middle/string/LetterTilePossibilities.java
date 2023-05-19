package middle.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1079. 活字印刷
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * <p>
 * 注意：本题中，每个活字字模只能使用一次。
 * <p>
 * 示例 1：
 * <p>
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 * 示例 2：
 * <p>
 * 输入："AAABBC"
 * 输出：188
 * 示例 3：
 * <p>
 * 输入："V"
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= tiles.length <= 7
 * tiles 由大写英文字母组成
 *
 * @author simple
 */
public class LetterTilePossibilities {
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> counts = new HashMap<>();
        for (var ch : tiles.toCharArray())
            counts.put(ch, counts.getOrDefault(ch, 0) + 1);
        Set<Character> tile = new HashSet<>(counts.keySet());
        return dfs(tiles.length(), counts, tile) - 1;
    }

    private int dfs(int i, Map<Character, Integer> counts, Set<Character> tile) {
        if (i == 0) return 1;
        int res = 1;

        for (var ch : tile) {
            if (counts.get(ch) > 0) {
                counts.put(ch, counts.get(ch) - 1);
                res += dfs(i - 1, counts, tile); // 少一个位置后能组成的字符数量
                counts.put(ch, counts.get(ch) + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LetterTilePossibilities().numTilePossibilities("AAB"));
    }
}
