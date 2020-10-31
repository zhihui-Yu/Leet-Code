package easy;

/**
 * @author simple
 * <p>
 * <p>
 * 给你一个有效的 IPv4 地址address，返回这个 IP 地址的无效化版本。
 * <p>
 * 所谓无效化IP 地址，其实就是用"[.]"代替了每个 "."。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/defanging-an-ip-address
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DefangingAnIpAddress {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
