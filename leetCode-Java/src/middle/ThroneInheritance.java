package middle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author simple
 * <p>
 * 一个王国里住着国王、他的孩子们、他的孙子们等等。每一个时间点，这个家庭里有人出生也有人死亡。
 * <p>
 * 这个王国有一个明确规定的皇位继承顺序，第一继承人总是国王自己。我们定义递归函数Successor(x, curOrder)，给定一个人x和当前的继承顺序，该函数返回 x的下一继承人。
 * <p>
 * Successor(x, curOrder):
 * 如果 x 没有孩子或者所有 x 的孩子都在 curOrder 中：
 * 如果 x 是国王，那么返回 null
 * 否则，返回 Successor(x 的父亲, curOrder)
 * 否则，返回 x 不在 curOrder 中最年长的孩子
 * 比方说，假设王国由国王，他的孩子Alice 和 Bob （Alice 比 Bob年长）和 Alice 的孩子Jack 组成。
 * <p>
 * 一开始，curOrder为["king"].
 * 调用Successor(king, curOrder)，返回 Alice ，所以我们将 Alice 放入 curOrder中，得到["king", "Alice"]。
 * 调用Successor(Alice, curOrder)，返回 Jack ，所以我们将 Jack 放入curOrder中，得到["king", "Alice", "Jack"]。
 * 调用Successor(Jack, curOrder)，返回 Bob ，所以我们将 Bob 放入curOrder中，得到["king", "Alice", "Jack", "Bob"]。
 * 调用Successor(Bob, curOrder)，返回null。最终得到继承顺序为["king", "Alice", "Jack", "Bob"]。
 * 通过以上的函数，我们总是能得到一个唯一的继承顺序。
 * <p>
 * 请你实现ThroneInheritance类：
 * <p>
 * ThroneInheritance(string kingName) 初始化一个ThroneInheritance类的对象。国王的名字作为构造函数的参数传入。
 * void birth(string parentName, string childName)表示parentName新拥有了一个名为childName的孩子。
 * void death(string name)表示名为name的人死亡。一个人的死亡不会影响Successor函数，也不会影响当前的继承顺序。你可以只将这个人标记为死亡状态。
 * string[] getInheritanceOrder()返回 除去死亡人员的当前继承顺序列表。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["ThroneInheritance", "birth", "birth", "birth", "birth", "birth", "birth", "getInheritanceOrder", "death", "getInheritanceOrder"]
 * [["king"], ["king", "andy"], ["king", "bob"], ["king", "catherine"], ["andy", "matthew"], ["bob", "alex"], ["bob", "asha"], [null], ["bob"], [null]]
 * 输出：
 * [null, null, null, null, null, null, null, ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"], null, ["king", "andy", "matthew", "alex", "asha", "catherine"]]
 * <p>
 * 解释：
 * ThroneInheritance t= new ThroneInheritance("king"); // 继承顺序：king
 * t.birth("king", "andy"); // 继承顺序：king > andy
 * t.birth("king", "bob"); // 继承顺序：king > andy > bob
 * t.birth("king", "catherine"); // 继承顺序：king > andy > bob > catherine
 * t.birth("andy", "matthew"); // 继承顺序：king > andy > matthew > bob > catherine
 * t.birth("bob", "alex"); // 继承顺序：king > andy > matthew > bob > alex > catherine
 * t.birth("bob", "asha"); // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
 * t.getInheritanceOrder(); // 返回 ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
 * t.death("bob"); // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
 * t.getInheritanceOrder(); // 返回 ["king", "andy", "matthew", "alex", "asha", "catherine"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= kingName.length, parentName.length, childName.length, name.length <= 15
 * kingName，parentName，childName和name仅包含小写英文字母。
 * 所有的参数childName 和kingName互不相同。
 * 所有death函数中的死亡名字 name要么是国王，要么是已经出生了的人员名字。
 * 每次调用 birth(parentName, childName) 时，测试用例都保证 parentName 对应的人员是活着的。
 * 最多调用105次birth 和death。
 * 最多调用10次getInheritanceOrder。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/throne-inheritance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThroneInheritance {
    // 思路 树的先序遍历
    static class Node {
        public String name;
        public boolean alive;
        public List<Node> sons;

        public Node(String name) {
            this.name = name;
            this.alive = true;
            this.sons = new LinkedList<>();
        }
    }

    private final Node root;
    private final Map<String, Node> nodeMap = new HashMap<>();

    public ThroneInheritance(String kingName) {
        this.root = new Node(kingName);
        nodeMap.put(kingName, this.root);
    }

    public void birth(String parentName, String childName) {
        Node node = new Node(childName);
        nodeMap.put(childName,node);
        nodeMap.get(parentName).sons.add(node);
    }

    public void death(String name) {
        nodeMap.get(name).alive = false;
    }

    public List<String> getInheritanceOrder() {
        List<String> result = new LinkedList<>();
        addInto(root, result);
        return result;
    }

    private void addInto(Node root, List<String> result) {
        if (root.alive) {
            result.add(root.name);
        }
        for (Node node : root.sons) {
            addInto(node, result);
        }
    }


    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test2() {
        ThroneInheritance throneInheritance = new ThroneInheritance("king");
        // ["king"]
        System.out.println(throneInheritance.getInheritanceOrder());
        throneInheritance.birth("king", "clyde");
        throneInheritance.birth("clyde", "shannon");
        throneInheritance.birth("shannon", "scott");
        throneInheritance.birth("king", "keith");
        // ["king","clyde","shannon","scott","keith"]
        System.out.println(throneInheritance.getInheritanceOrder());
        throneInheritance.birth("clyde", "joseph");
        // ["king","clyde","shannon","scott","joseph","keith"]
        System.out.println(throneInheritance.getInheritanceOrder());
    }

    private static void test1() {
        ThroneInheritance throneInheritance = new ThroneInheritance("king");
        throneInheritance.birth("king", "andy");
        throneInheritance.birth("king", "bob");
        throneInheritance.birth("king", "catherine");
        throneInheritance.birth("andy", "matthew");
        throneInheritance.birth("bob", "alex");
        throneInheritance.birth("bob", "asha");
        //  ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"],
        System.out.println(throneInheritance.getInheritanceOrder());
        throneInheritance.death("bob");
        //  ["king", "andy", "matthew", "alex", "asha", "catherine"]
        System.out.println(throneInheritance.getInheritanceOrder());
    }
}
