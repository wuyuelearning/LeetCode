/**
 * Created by wuyue on 2019/7/14.
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 这里的方法 是暴力方法：
 * 一个指针从左边开始，一个从右边，移动右边的指针，如果相等，
 * 再在这个两个指针的范围内左右两边同时向中间移动判断
 */

public class Num005 {

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }

    private static String longestPalindrome(String s) {

        if ("".equals(s) || s.length() == 0) {
            return s;
        }

        char[] c = s.toCharArray();
        int start = 0;
        String result;

        int max = 0;
        int maxT = 0;
        int i = 0;
        int end = 0;

        int index_i = 0;
        int index_j = 0;

        while (start < c.length - 1) {
            i = start;  //  使用i，为了保留start，保留最左边的下标start
            for (end = c.length - 1; end > i; end--) {
                int temp_j = end; //  使用temp_j，为了保留end，保留最左边的下标
                while (c[i] == c[temp_j] && i <= temp_j) { // 在i和temp_j之间判断回文
                    i++;
                    temp_j--;
                }
                if (i > temp_j) {   // 在 i > temp_j条件下跳出的while，而不是c[i] ！= c[temp_j]，表示这一段是回文
                    maxT = end - start;   // 计算回文长度
                    if (max < maxT) {
                        max = maxT;
                        index_i = start;  // 记录最长回文起始和结束下标
                        index_j = end;
                    }
                } else {
                    //  如果这一段不是回文，则i需要恢复到开始位置，在start和j之间还是有可能存在回文的
                    //  babb 在判断0 和4之间不是回文，不能在这里break后start++ ，要继续让i回到0（此时i为1，temp_j为2），
                    //   判断bab是否为回文
                    i = start;
                }
            }
            start++;
        }
        result = s.substring(index_i, index_j + 1);
        return result;
    }

}
