import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wuyue on 2019/8/7.
 *
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 核心思路：如果括号有效，任意位置的左括号是要大于等于右括号的，即如果左括号等于右括号数量，那么接下来的操作一定是 加入左括号；如果左括号大于右括号，有两种选择，出左括号或右括号。如果做括号数量已经为最大值，只需要将剩下的右括号补齐即可。
 *
 * 作者：qiu-xiao-dao
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/di-gui-fa-by-qiu-xiao-dao/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 * 执行用时 :3 ms, 在所有 Java 提交中击败了84.92%的用户
 * 内存消耗 :37.7 MB, 在所有 Java 提交中击败了77.75%的用户
 */
public class Num022 {
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {

        int n = 10;
        System.out.println(generateParenthesis(n));
        System.out.println(list.size());
    }

    private static List<String> generateParenthesis(int n) {
        if (n == 0)
            return list;
        fun(n, n, "");
        return list;
    }
    private static void fun(int l, int r, String s) {
        if (l == 0) {
            StringBuilder sBuilder = new StringBuilder(s);
            while (r > 0) {
                sBuilder.append(")");
                r--;
            }
            s = sBuilder.toString();
            list.add(s);
            return;
        }
        if (l == r) {
            fun(l - 1, r, s + "(");
        } else if (l < r) {
            fun(l - 1, r, s + "(");
            fun(l, r - 1, s + ")");
        }
    }
}

