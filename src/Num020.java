import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by wuyue on 2019/8/2.
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 * 使用栈，如果出现了"{" 则下一次入栈的不是"}"则不满足条件
 */
public class Num020 {
    public static void main(String[] args) {

        String s = "[]}";

        System.out.println(isValid(s));


    }

    private static boolean isValid(String s) {


        if ("".equals(s)) {
            return true;
        }

        if (s == null || s.length() == 1) {
            return false;
        }

        char ch[] = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : ch) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty() && (c == ')' || c == '}' || c == ']')) {
                return false;
            } else if (!stack.isEmpty()) {
                if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
