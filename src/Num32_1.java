import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by wuyue on 2020/9/7.
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * ()(()) :6
 * (()()) :6
 *      此方法未解出
 */
public class Num32_1 {
    public static void main(String[] args) {
        Num32_1 n = new Num32_1();
        int i = n.longestValidParentheses("()(())");
        System.out.println(i);
    }

    private int longestValidParentheses(String s) {
        int max = 0;
        int temp = 0;
        char[] chars = s.toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : chars) {
            if (c == '(') {
                if (!deque.isEmpty() && deque.peek() == '('){
                    temp = 0;
                }
                deque.push(c);
            } else {
                if (!deque.isEmpty() && deque.peek() == '(') {
                    deque.pop();
                    temp += 2;
                    if (max < temp)
                        max = temp;
                } else {
                    deque.push(c);
                    temp = 0;
                }
            }
        }

        if (max < temp)
            max = temp;

        return max;
    }
}
