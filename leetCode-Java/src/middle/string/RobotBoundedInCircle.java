package middle.string;

/**
 * 1041. 困于环中的机器人
 * 在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。注意:
 * <p>
 * 北方向 是y轴的正方向。
 * 南方向 是y轴的负方向。
 * 东方向 是x轴的正方向。
 * 西方向 是x轴的负方向。
 * 机器人可以接受下列三条指令之一：
 * <p>
 * "G"：直走 1 个单位
 * "L"：左转 90 度
 * "R"：右转 90 度
 * 机器人按顺序执行指令 instructions，并一直重复它们。
 * <p>
 * 只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：instructions = "GGLLGG"
 * 输出：true
 * 解释：机器人最初在(0,0)处，面向北方。
 * “G”:移动一步。位置:(0,1)方向:北。
 * “G”:移动一步。位置:(0,2).方向:北。
 * “L”:逆时针旋转90度。位置:(0,2).方向:西。
 * “L”:逆时针旋转90度。位置:(0,2)方向:南。
 * “G”:移动一步。位置:(0,1)方向:南。
 * “G”:移动一步。位置:(0,0)方向:南。
 * 重复指令，机器人进入循环:(0,0)——>(0,1)——>(0,2)——>(0,1)——>(0,0)。
 * 在此基础上，我们返回true。
 * 示例 2：
 * <p>
 * 输入：instructions = "GG"
 * 输出：false
 * 解释：机器人最初在(0,0)处，面向北方。
 * “G”:移动一步。位置:(0,1)方向:北。
 * “G”:移动一步。位置:(0,2).方向:北。
 * 重复这些指示，继续朝北前进，不会进入循环。
 * 在此基础上，返回false。
 * 示例 3：
 * <p>
 * 输入：instructions = "GL"
 * 输出：true
 * 解释：机器人最初在(0,0)处，面向北方。
 * “G”:移动一步。位置:(0,1)方向:北。
 * “L”:逆时针旋转90度。位置:(0,1).方向:西。
 * “G”:移动一步。位置:(- 1,1)方向:西。
 * “L”:逆时针旋转90度。位置:(- 1,1)方向:南。
 * “G”:移动一步。位置:(- 1,0)方向:南。
 * “L”:逆时针旋转90度。位置:(- 1,0)方向:东方。
 * “G”:移动一步。位置:(0,0)方向:东方。
 * “L”:逆时针旋转90度。位置:(0,0)方向:北。
 * 重复指令，机器人进入循环:(0,0)——>(0,1)——>(- 1,1)——>(- 1,0)——>(0,0)。
 * 在此基础上，我们返回true。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= instructions.length <= 100
 * instructions[i] 仅包含 'G', 'L', 'R'
 *
 * @author simple
 */
public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int len = instructions.length();
        String cur;
        int face = 0; // Y<up> 0, X<right> 1, Y<down> 2, X<left> 3
        int x = 0;
        int y = 0;
        for (int i = 0; i < 4; i++) {
            cur = instructions;
            for (int j = 0; j < len; j++) {
                // 如果最后一步走完后跟第一步一样，则说明重复了
                char ch = cur.charAt(j);
                if (ch == 'G') {
                    if (face == 0) y += 1;
                    else if (face == 1) x += 1;
                    else if (face == 2) y -= 1;
                    else x -= 1;
                } else if (ch == 'L') {
                    face = (face - 1 + 4) % 4;
                } else { // only 'R'
                    face = (face + 1) % 4;
                }
                if (j == len - 1 && face == 0 && x == y && x == 0) return true;
            }
        }

        return false;
    }

    //
    public boolean isRobotBounded2(String instructions) {
        int k = 0; // 0-3, 北 0, 西 1, 南 2, 东 3
        int[] dis = new int[4]; // 四个方向的移动距离
        for (int i = 0; i < instructions.length(); i++) {
            char ch = instructions.charAt(i);
            if (ch == 'G') {
                dis[k]++;
            } else if (ch == 'R') {
                k = (k + 1) % 4;
            } else if (ch == 'L') {
                k = (k - 1 + 4) % 4;
            }
        }
        // X = Y 则 所有距离都是一样时会回到原点。  k=1时，四次执行后会回到远点， k =2时，两次， k =3是四次
        return (dis[0] == dis[2] && dis[1] == dis[3]) || k != 0;
    }

    public static void main(String[] args) {
        System.out.println(new RobotBoundedInCircle().isRobotBounded2("GGLLGG")); // true
        System.out.println(new RobotBoundedInCircle().isRobotBounded2("GG")); // false
        System.out.println(new RobotBoundedInCircle().isRobotBounded2("GL")); // true
    }
}
