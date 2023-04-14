package middle.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 1023. 驼峰式匹配
 * 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 * <p>
 * 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = ""FB""
 * 输出：[true,false,true,true,false]
 * 示例：
 * "FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
 * "FootBall" 可以这样生成："F" + "oot" + "B" + "all".
 * "FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
 * 示例 2：
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * 输出：[true,false,true,false,false]
 * 解释：
 * "FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
 * "FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
 * 示例 3：
 * <p>
 * 输出：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * 输入：[false,true,false,false,false]
 * 解释：
 * "FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= queries.length <= 100
 * 1 <= queries[i].length <= 100
 * 1 <= pattern.length <= 100
 * 所有字符串都仅由大写和小写英文字母组成。
 *
 * @author simple
 */
public class CamelcaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        int n = queries.length;
        int pLen = pattern.length();
        List<Boolean> ans = new ArrayList<>(n);
        for (String query : queries) {
            int l = query.length(), q = 0, p = 0; // q指向 query字符串下标，p指向pattern字符串下标
            Boolean exist = Boolean.TRUE;
            while (p < pLen || q < l) {
                if (p < pLen && q < l && query.charAt(q) == pattern.charAt(p)) {
                    p++;
                    q++;
                } else if (q < l && Character.isLowerCase(query.charAt(q))) {
                    q++;
                } else {
                    exist = Boolean.FALSE;
                    break;
                }
            }
            ans.add(exist);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CamelcaseMatching().camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBaT"));
        System.out.println(new CamelcaseMatching().camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBa"));
        System.out.println(new CamelcaseMatching().camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FB"));
    }
}
