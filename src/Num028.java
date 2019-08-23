/**
 * Created by wuyue on 2019/8/16.
 *
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 执行用时 :3 ms, 在所有 Java 提交中击败了50.68%的用户
 * 内存消耗 :36.2 MB, 在所有 Java 提交中击败了83.39%的用户
 */
public class Num028 {
    public static void main(String[] args) {


        String s = "a";
        String s2 = "a";

        System.out.println(strStr(s, s2));

    }

    private static int strStr(String haystack, String needle) {


        if (needle == null || needle.length() == 0) {
            return 0;
        }
        char[] c1 = haystack.toCharArray();
        char[] c2 = needle.toCharArray();

        for (int i = 0; i < c1.length - c2.length + 1; i++) {
            if (c1[i] == c2[0]) {
                for (int j = 0, k = i; k < c1.length && j < c2.length; ) {
                    if (c1[k] != c2[j]) {
                        break;
                    } else {
                        if (j == c2.length - 1) {
                            return k - c2.length + 1;
                        }
                        j++;
                        k++;
                    }
                }
            }
        }


        return -1;

    }
}
