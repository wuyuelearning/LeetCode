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
 *
 * 官方解法:
 * 具体做法是我们始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」，这样的做法主要是考虑了边界条件的处理，栈里其他元素维护左括号的下标：
 *
 * 对于遇到的每个 '(' ，我们将它的下标放入栈中
 * 对于遇到的每个 ‘)’ ，我们先弹出栈顶元素表示匹配了当前右括号：
 * 如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
 * 如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
 * 我们从前往后遍历字符串并更新答案即可。
 *
 * 需要注意的是，如果一开始栈为空，第一个字符为左括号的时候我们会将其放入栈中，这样就不满足提及的「最后一个没有被匹配的右括号的下标」，为了保持统一，我们在一开始的时候往栈中放入一个值为 −1 的元素。
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Num32_2 {
    public static void main(String[] args) {
        Num32_2 n = new Num32_2();
        int i = n.longestValidParentheses("()(()");
        System.out.println(i);
    }

    private int longestValidParentheses(String s) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deque.push(i);
            } else {
                if (!deque.isEmpty())
                    deque.pop();
                if (deque.isEmpty()) {
                    deque.push(i);
                } else {
                    if (max < i - deque.peek()) {
                        max = i - deque.peek();
                    }
                }
            }
        }
        return max;
    }
}
