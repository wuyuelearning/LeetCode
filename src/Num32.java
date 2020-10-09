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
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 "()(())"
 *
 *  如果(()) 结果为2，是以下的解法 ，如果结果是4，则是按照有效的()为准，包含的也算
 *
 *  ()(()) :6
 *  (()()) :6
 */
public class Num32 {

    public static void main(String[] args) {
        Num32 n =new Num32();
       int  i = n.longestValidParentheses("()(())");
        System.out.println(i);
    }
    private int longestValidParentheses(String s) {
        int max =0;

        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;){
            int j =i;
            if (chars[i]=='('){
                for (;j<chars.length-1;j+=2){
                    if (chars[j]!='(' || chars[j+1]!=')'){
                        break;
                    }
                }
                if (max < j-i){
                    max =j-i;
                }
            }
            if (i==j){
                i+=1;
            } else {
                i =j+2;
            }
        }
        return max;
    }
}
