package easy;

import java.util.Stack;

/**
 * @author simple
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char alpha = s.charAt(i);
            if (alpha == '(' || alpha == '[' || alpha == '{') {
                stack.push(alpha);
            }
            if (alpha == '}') {
                if (stack.empty() || stack.lastElement() != '{')
                    return false;
                else stack.pop();
            }
            if (alpha == ']') {
                if (stack.empty() || stack.lastElement() != '[')
                    return false;
                else stack.pop();
            }
            if (alpha == ')') {
                if (stack.empty() || stack.lastElement() != '(')
                    return false;
                else stack.pop();
            }
        }
        return stack.empty();
    }
}
