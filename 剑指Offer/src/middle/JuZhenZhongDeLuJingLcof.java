package middle;

/**
 * @author simple
 * <p>
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * A B C E
 * S F C S
 * A D E E
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * <p>
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * <p>
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JuZhenZhongDeLuJingLcof {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        if (word.length() == 0) return true;
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(words, board, i, j)) return true;
            }
        }
        return false;
    }

    // 从当前board字符出发是否存在一条路径与word相同
    private boolean dfs(char[] words, char[][] board, int i, int j) {
        // 边界判断
        if (words.length == 0) return true; // 已经没有剩余字母需要匹配
        if (i < 0 || j < 0 || board.length <= i || board[i].length <= j || board[i][j] != words[0])
            return false; // 越界了或者不匹配

        board[i][j] = '\0'; // 为了不被重复找到
        char[] leftWords = subCharArray(words, 1, words.length); // 可以用多加一个参数来判断word的位置，这样执行速度更快
        boolean res = dfs(leftWords, board, i + 1, j)
            || dfs(leftWords, board, i - 1, j)
            || dfs(leftWords, board, i, j + 1)
            || dfs(leftWords, board, i, j - 1);
        board[i][j] = words[0]; // 在匹配完后复原，以便后续匹配
        return res;
    }

    public char[] subCharArray(char[] chars, int start, int end) {
        if (chars.length == 1) return new char[0];
        char[] newChar = new char[end - start];
        int index = 0;
        for (int i = start; i < end; i++) {
            newChar[index++] = chars[i];
        }
        return newChar;
    }

    public static void main(String[] args) {
        JuZhenZhongDeLuJingLcof xx = new JuZhenZhongDeLuJingLcof();
        System.out.println(xx.exist(new char[][]{{'1', '2', '3'}, {'2', '2', '2'}}, "12321"));
    }
}
