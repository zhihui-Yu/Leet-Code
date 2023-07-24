package easy.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. 宝石与石头
 * 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。 stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：jewels = "aA", stones = "aAAbbbb"
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：jewels = "z", stones = "ZZ"
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= jewels.length, stones.length <= 50
 * jewels 和 stones 仅由英文字母组成
 * jewels 中的所有字符都是 唯一的
 *
 * @author simple
 */
public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> j = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            j.add(jewels.charAt(i));
        }
        int cnt = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (j.contains(stones.charAt(i))) cnt++;
        }
        return cnt;
    }
}
