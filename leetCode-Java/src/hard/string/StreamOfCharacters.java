package hard.string;

/**
 * 1032. 字符流
 * 设计一个算法：接收一个字符流，并检查这些字符的后缀是否是字符串数组 words 中的一个字符串。
 * <p>
 * 例如，words = ["abc", "xyz"] 且字符流中逐个依次加入 4 个字符 'a'、'x'、'y' 和 'z' ，
 * 你所设计的算法应当可以检测到 "axyz" 的后缀 "xyz" 与 words 中的字符串 "xyz" 匹配。
 * <p>
 * 按下述要求实现 StreamChecker 类：
 * <p>
 * StreamChecker(String[] words) ：构造函数，用字符串数组 words 初始化数据结构。
 * boolean query(char letter)：从字符流中接收一个新字符，如果字符流中的任一非空后缀能匹配 words 中的某一字符串，返回 true ；否则，返回 false。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"]
 * [[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]]
 * 输出：
 * [null, false, false, false, true, false, true, false, false, false, false, false, true]
 * <p>
 * 解释：
 * StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
 * streamChecker.query("a"); // 返回 False
 * streamChecker.query("b"); // 返回 False
 * streamChecker.query("c"); // 返回n False
 * streamChecker.query("d"); // 返回 True ，因为 'cd' 在 words 中
 * streamChecker.query("e"); // 返回 False
 * streamChecker.query("f"); // 返回 True ，因为 'f' 在 words 中
 * streamChecker.query("g"); // 返回 False
 * streamChecker.query("h"); // 返回 False
 * streamChecker.query("i"); // 返回 False
 * streamChecker.query("j"); // 返回 False
 * streamChecker.query("k"); // 返回 False
 * streamChecker.query("l"); // 返回 True ，因为 'kl' 在 words 中
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 200
 * words[i] 由小写英文字母组成
 * letter 是一个小写英文字母
 * 最多调用查询 4 * 10^4 次
 *
 * @author simple
 */
public class StreamOfCharacters {
    public static void main(String[] args) {
        var checker2 = new StreamChecker(new String[]{"ab", "ba", "aaab", "abab", "baa"});

        var checker = new StreamChecker(new String[]{"cd", "f", "kl"});
        System.out.println(checker.query('a'));
        System.out.println(checker.query('b'));
        System.out.println(checker.query('c'));
        System.out.println(checker.query('d'));
        System.out.println(checker.query('e'));
        System.out.println(checker.query('f'));
        System.out.println(checker.query('g'));
        System.out.println(checker.query('h'));
        System.out.println(checker.query('i'));
        System.out.println(checker.query('j'));
        System.out.println(checker.query('k'));
        System.out.println(checker.query('l'));
    }

    public static class StreamChecker {
        Tree tree;
        StringBuilder input = new StringBuilder();

        public StreamChecker(String[] words) {
            this.tree = new Tree(false);
            for (String word : words) {
                Tree t = this.tree;
                for (int j = word.length() - 1; j >= 0; j--) {
                    var idx = word.charAt(j) - 'a';
                    if (t.children[idx] == null) { // 考虑被重复覆盖的情况
                        t.children[idx] = new Tree(j == 0);
                    } else if (j == 0) { // 到最后一个了并且不为空，则true
                        t.children[idx] = new Tree(true);
                    }
                    t = t.children[idx];
                }
            }
        }

        public boolean query(char letter) {
            input.append(letter);
            return tree.query(input.toString());
        }

        public static class Tree {
            public Tree[] children = new Tree[26]; // 26个字符
            public boolean isEnd;

            public Tree(boolean isEnd) {
                this.isEnd = isEnd;
            }

            public boolean query(String input) {
                var chs = this.children;
                for (int i = input.length() - 1; i >= 0; i--) {
                    var idx = input.charAt(i) - 'a';
                    Tree child = chs[idx];
                    if (child == null) return false;
                    if (child.isEnd) return true;
                    chs = child.children;
                }
                return false;
            }
        }
    }
}