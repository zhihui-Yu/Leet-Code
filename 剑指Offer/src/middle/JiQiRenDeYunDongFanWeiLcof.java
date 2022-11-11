package middle;

/**
 * @author simple
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JiQiRenDeYunDongFanWeiLcof {
    int m, n, k;
    boolean[][] visited; // dfs 会找到重复的，所以要排除遍历过的

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return countDFS(0, 0);
    }

    private int countDFS(int i, int j) {
        if (i >= m || j >= n || numCount(i, j) > k || visited[i][j]) return 0;
        this.visited[i][j] = true;
        return 1 + countDFS(i + 1, j) + countDFS(i, j + 1);
    }

//    private int numCount(int i, int j) {
//        int numCount = 0;
//        for (int k = 0; k < String.valueOf(i).length(); k++) {
//            numCount += String.valueOf(i).charAt(k) - '0';
//        }
//        for (int k = 0; k < String.valueOf(j).length(); k++) {
//            numCount += String.valueOf(j).charAt(k) - '0';
//        }
//        return numCount;
//    }

    private int numCount(int i, int j) {
        return sum(i) + sum(j);
    }

    private int sum(int i) {
        int num = 0;
        while (i > 0) {
            num += i % 10;
            i = i / 10;
        }
        return num;
    }

    public static void main(String[] args) {
//        System.out.println(new JiQiRenDeYunDongFanWeiLcof().movingCount(2, 3, 1));
//        System.out.println(new JiQiRenDeYunDongFanWeiLcof().movingCount(3, 1, 0));
//        System.out.println(new JiQiRenDeYunDongFanWeiLcof().movingCount(7, 2, 3)); // 7
        System.out.println(new JiQiRenDeYunDongFanWeiLcof().movingCount(16, 8, 4)); // 15
    }
}
