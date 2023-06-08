package hard;

/**
 * 1240. 铺瓷砖
 * 你是一位施工队的工长，根据设计师的要求准备为一套设计风格独特的房子进行室内装修。
 * <p>
 * 房子的客厅大小为 n x m，为保持极简的风格，需要使用尽可能少的 正方形 瓷砖来铺盖地面。
 * <p>
 * 假设正方形瓷砖的规格不限，边长都是整数。
 * <p>
 * 请你帮设计师计算一下，最少需要用到多少块方形瓷砖？
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, m = 3
 * 输出：3
 * 解释：3 块地砖就可以铺满卧室。
 * 2 块 1x1 地砖
 * 1 块 2x2 地砖
 * 示例 2：
 * <p>
 * 输入：n = 5, m = 8
 * 输出：5
 * 示例 3：
 * <p>
 * 输入：n = 11, m = 13
 * 输出：6
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 13
 * 1 <= m <= 13
 *
 * @author simple
 */
public class TilingARectangleWithTheFewestSquares {

    public static void main(String[] args) {
        System.out.println(new TilingARectangleWithTheFewestSquares().tilingRectangle(11, 13));
    }

    // 官解
    int ans;

    public int tilingRectangle(int n, int m) {
        if (n % m == 0) return n / m;
        if (m % n == 0) return m / n;

        boolean[][] rect = new boolean[n][m];
        ans = Math.max(n, m);
        dfs(0, 0, rect, 0); // 从(0,0)的位置开始遍历，rect是存储是否遍历过某个点，cnt 当前大小的长方形的最小数量
        return ans;
    }

    // (x,y) 为矩阵的左上角
    private void dfs(int x, int y, boolean[][] rect, int cnt) {
        if (cnt >= ans) return;
        int n = rect.length, m = rect[0].length;
        if (x >= n) { // 全部计算完成
            ans = cnt;
            if (cnt == 6) {
                System.out.println("---");
            }
            return;
        }

        if (y >= m) {  // 越界，算下一行
            dfs(x + 1, 0, rect, cnt);
            return;
        }

        if (rect[x][y]) { // 当前的点已经算过了，计算下一个点
            dfs(x, y + 1, rect, cnt);
            return;
        }

        //
        for (int k = Math.min(n - x, m - y); k > 0; k--) {
            if (!isAvailable(rect, x, y, k)) continue;
            fillUp(rect, x, y, k, true);
            dfs(x, y + k, rect, cnt + 1); // 填充完一次，cnt就加1： (0,0+k)
            fillUp(rect, x, y, k, false);
        }
    }

    // 长宽为k的正方形是否可以填充到矩阵中
    private boolean isAvailable(boolean[][] rect, int x, int y, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (rect[x + i][y + j]) return false;
            }
        }
        return true;
    }

    // 填充|消除 长宽为k的正方形
    private void fillUp(boolean[][] rect, int x, int y, int k, boolean fill) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                rect[x + i][y + j] = fill;
            }
        }
    }
}
