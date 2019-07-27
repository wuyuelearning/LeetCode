/**
 * Created by wuyue on 2019/7/25.
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 * 第一：因为是前缀，所以不存在 “aafd” ，“fd”可以匹配的情况只需要从头开始匹配
 * 第二：公共前缀长度小于等于数组中最短字符串长度，所以可以将strs[0]定位公共浅前缀的初始值，也是公共浅前缀的最大值
 */
public class Num014 {

    public static void main(String[] args) {

        String[] s = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(s));
    }

    private static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        char[] c = strs[0].toCharArray();
        int max = c.length;
        for (int i = 1; i < strs.length; i++) {
            char[] t = strs[i].toCharArray();
            int j = 0;
            while (j < max && j < t.length) {  //  公共前缀长度小于等于数组中最短字符串长度
                if (c[j] == t[j]) {
                    j++;
                } else {
                    if (j == 0) {  //  如果第一个就不同，说明没有公共前缀
                        return "";
                    } else {
                        break;
                    }
                }
            }
            if (j < max) {
                max = j;
            }
        }

        return strs[0].substring(0, max);

    }
}
