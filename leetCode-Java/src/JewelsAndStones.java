/**
 * @author simple
 * <p>
 * 给定字符串J代表石头中宝石的类型，和字符串S代表你拥有的石头。S中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * J中的字母不重复，J和S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * <p>
 * 注意:
 * <p>
 * S 和 J 最多含有50个字母。
 * J 中的字符不重复
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jewels-and-stones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        // 遍历S 中 包含 每种宝石的类型。
        int count = 0;
        char[] jewels = J.toCharArray();
        for (char j : jewels) {
            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == j) count++;
            }
        }
        return count;
    }
}
