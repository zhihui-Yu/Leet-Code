package easy;

/**
 * 717. 1 比特与 2 比特字符
 * 有两种特殊字符：
 * <p>
 * 第一种字符可以用一比特 0 表示
 * 第二种字符可以用两比特（10 或 11）表示
 * 给你一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一个一比特字符，则返回 true 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: bits = [1, 0, 0]
 * 输出: true
 * 解释: 唯一的解码方式是将其解析为一个两比特字符和一个一比特字符。
 * 所以最后一个字符是一比特字符。
 * 示例 2:
 * <p>
 * 输入：bits = [1,1,1,0]
 * 输出：false
 * 解释：唯一的解码方式是将其解析为两比特字符和两比特字符。
 * 所以最后一个字符不是一比特字符。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= bits.length <= 1000
 * bits[i] 为 0 或 1
 *
 * @author simple
 */
public class _1BitAnd2BitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int pre = 0;
        for (int i = 1; i < bits.length; i++) {
            if (bits[pre] == 1) pre = ++i;
            else pre = i;
        }
        return pre < bits.length;
    }

    public static void main(String[] args) {
        System.out.println(new _1BitAnd2BitCharacters().isOneBitCharacter(new int[]{0, 0, 0}));
        System.out.println(new _1BitAnd2BitCharacters().isOneBitCharacter(new int[]{0, 1, 0}));
        System.out.println(new _1BitAnd2BitCharacters().isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(new _1BitAnd2BitCharacters().isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }
}
