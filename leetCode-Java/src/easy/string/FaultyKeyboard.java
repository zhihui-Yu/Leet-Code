package easy.string;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 2810. 故障键盘
 * 你的笔记本键盘存在故障，每当你在上面输入字符 'i' 时，它会反转你所写的字符串。而输入其他字符则可以正常工作。
 * <p>
 * 给你一个下标从 0 开始的字符串 s ，请你用故障键盘依次输入每个字符。
 * <p>
 * 返回最终笔记本屏幕上输出的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "string"
 * 输出："rtsng"
 * 解释：
 * 输入第 1 个字符后，屏幕上的文本是："s" 。
 * 输入第 2 个字符后，屏幕上的文本是："st" 。
 * 输入第 3 个字符后，屏幕上的文本是："str" 。
 * 因为第 4 个字符是 'i' ，屏幕上的文本被反转，变成 "rts" 。
 * 输入第 5 个字符后，屏幕上的文本是："rtsn" 。
 * 输入第 6 个字符后，屏幕上的文本是： "rtsng" 。
 * 因此，返回 "rtsng" 。
 * 示例 2：
 * <p>
 * 输入：s = "poiinter"
 * 输出："ponter"
 * 解释：
 * 输入第 1 个字符后，屏幕上的文本是："p" 。
 * 输入第 2 个字符后，屏幕上的文本是："po" 。
 * 因为第 3 个字符是 'i' ，屏幕上的文本被反转，变成 "op" 。
 * 因为第 4 个字符是 'i' ，屏幕上的文本被反转，变成 "po" 。
 * 输入第 5 个字符后，屏幕上的文本是："pon" 。
 * 输入第 6 个字符后，屏幕上的文本是："pont" 。
 * 输入第 7 个字符后，屏幕上的文本是："ponte" 。
 * 输入第 8 个字符后，屏幕上的文本是："ponter" 。
 * 因此，返回 "ponter" 。
 * <p>
 * <p>
 * 提示：
 * 1 <= s.length <= 100
 * s 由小写英文字母组成
 * s[0] != 'i'
 *
 * @author simple
 */
public class FaultyKeyboard {
    public String finalString(String s) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                builder.reverse();
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

//    作者：灵茶山艾府
//    链接：https://leetcode.cn/problems/faulty-keyboard/solutions/2375152/shuang-duan-dui-lie-on-zuo-fa-by-endless-5pe1/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public String finalString_2(String s) {
        Deque<Character> q = new ArrayDeque<>();
        boolean tail = true;
        for (char c : s.toCharArray()) {
            if (c == 'i') {
                tail = !tail; // 修改添加方向
            } else if (tail) {
                q.addLast(c); // 加尾部
            } else {
                q.addFirst(c); // 加头部
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char c : q) {
            ans.append(c);
        }
        if (!tail) {
            ans.reverse();
        }
        return ans.toString();
    }
}
