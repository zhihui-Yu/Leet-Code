package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author simple
 * <p>
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * <p>
 * candidates中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 * [2,2,2,2],
 * [2,3,3],
 * [3,5]
 * ]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int length = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (length == 0)
            return res;

        Arrays.sort(candidates);
        // Deque<Integer> path = new ArrayDeque<>();
        LinkedList<Integer> path = new LinkedList<>();
        depthFirstSearch(candidates, target, res, path, 0, length);
        return res;
    }

    private void depthFirstSearch(int[] candidates, int target, List<List<Integer>> res, LinkedList<Integer> path, int begin, int length) {
        if (target == 0) {
            // 如果直接用path 则path最后回为空， 所以要存符合要求的path的复制
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < length; i++) {
            // 剪枝
            if (target - candidates[i] < 0) break;

            path.addLast(candidates[i]);
//            System.out.println("dfs 之前 => " + path + ", 还剩 => " + (target - candidates[i]));
            depthFirstSearch(candidates, target - candidates[i], res, path, i, length);
//            System.out.println("dfs 之后 => " + path + ", 还剩 => " + (target - candidates[i]));
            // 为了退回上一步，回溯(重点)
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        new CombinationSum().combinationSum(new int[]{2,3,6,7}, 7);
    }
}
