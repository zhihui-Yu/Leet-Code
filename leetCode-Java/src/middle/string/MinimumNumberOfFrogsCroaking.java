package middle.string;

/**
 * 1419. 数青蛙
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，
 * 所以croakOfFrogs 中会混合多个 “croak” 。
 * <p>
 * 请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 * <p>
 * 要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。
 * 如果没有输出全部五个字母，那么它就不会发出声音。
 * 如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：croakOfFrogs = "croakcroak"
 * 输出：1
 * 解释：一只青蛙 “呱呱” 两次
 * 示例 2：
 * <p>
 * 输入：croakOfFrogs = "crcoakroak"
 * 输出：2
 * 解释：最少需要两只青蛙，“呱呱” 声用黑体标注
 * 第一只青蛙 "crcoakroak"
 * 第二只青蛙 "crcoakroak"
 * 示例 3：
 * <p>
 * 输入：croakOfFrogs = "croakcrook"
 * 输出：-1
 * 解释：给出的字符串不是 "croak" 的有效组合。
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= croakOfFrogs.length <= 105
 * 字符串中的字符只有 'c', 'r', 'o', 'a' 或者 'k'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-number-of-frogs-croaking
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author simple
 */
public class MinimumNumberOfFrogsCroaking {
    // 前提，每个青蛙叫声不会重叠，所以字符串是 5的倍数，所有字符串都是顺序的，如果有穿插则不是有效的
    public int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs.length() % 5 != 0) return -1;
        int c = 0, r = 0, o = 0, a = 0, k = 0, ans = 0;
        for (var x : croakOfFrogs.toCharArray()) {
            if (x == 'c') c++;
            else if (x == 'r') r++;
            else if (x == 'o') o++;
            else if (x == 'a') a++;
            else if (x == 'k') k++;

            if (!(c >= r && r >= o && o >= a && a >= k)) return -1; // 叫声字符有序，所以字母必定如此
            ans = Math.max(ans, c - k); // 同一只青蛙叫两次，c=2,k=1,则=>1
        }
        return c == r && r == o && o == a && a == k ? ans : -1;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfFrogsCroaking().minNumberOfFrogs("croakcroak"));
    }
}
