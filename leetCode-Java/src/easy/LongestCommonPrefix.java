package easy;

/**
 * @author simple
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串""。
 * <p>
 * 示例1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母a-z。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        // 必须是空字符
        if (strs == null || strs.length < 1) return "";
        String commonStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if ((commonStr = longestCommonPrefix(commonStr, strs[i])).equals("")) {
                return "";
            }
        }
        return commonStr;
    }

    private String longestCommonPrefix(String commonStr, String str) {
        int len = Math.min(commonStr.length(), str.length());
        int index = 0;
        // 只需要前缀
        while (index < len && commonStr.charAt(index) == str.charAt(index)) {
            index++;
        }
        return commonStr.substring(0, index);
    }
}
