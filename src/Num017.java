import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wuyue on 2019/7/31.
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 思路：
 * 两组两组进入循环
 *
 * 234
 * {"a", "b", "c"}, {"d", "e", "f"},
 * 先
 * {"a", "b", "c"}, {"d", "e", "f"},进入循环得到[ad, ae, af, bd, be, bf, cd, ce, cf]
 * 再与{"g", "h", "i"}进入循环
 */
public class Num017 {
    public static void main(String[] args) {

        String s = "23";
        System.out.println(letterCombinations(s));

    }

    private static List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();
        if (digits == null || digits.trim().length() == 0) {
            return list;

        }
        String[][] cc = {{"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};
        char[] c = digits.toCharArray();
        list.addAll(Arrays.asList(cc[c[0] - 48 - 2]));
        if (digits.length() == 1) {
            return list;
        }
        for (int k = 1; k < c.length; k++) {
            // 如果在for循环外面进行声明，并且有list = listT;，则会导致listT中添加元素，list中同步增加，
            //    在i <  list.size() 则会无限循环，除非int len =   list.size() ； i <  len ，但还是不能解决同步增加的问题
            // 并且存有之前的数据，例如 234 ：会有ad af等元素的存在
            List<String> listT = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < cc[c[k] - 48 - 2].length; j++) {
                    listT.add(list.get(i) + cc[c[k] - 48 - 2][j]);
                }
            }
            list = listT;
        }
        return list;
    }

}
