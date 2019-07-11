import java.util.HashMap;

/**
 * Created by wuyue on 2019/7/11.
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 思路： 滑动窗口
 */
public class Num003 {
    public static void main(String[] args) {


        String a = "dvdf";

        System.out.print("" + lengthOfLongestSubstring(a));
    }

    private static int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int max = 1;
        int maxTemp = max;
        char[] cString = s.toCharArray();
        int index_i = 0;
        int index_j = 1;
//
//        HashMap<Character, Integer> map = new HashMap<>();
//        map.put(cString[index_i], 0);
//        while (index_j < cString.length) {
//            if (!map.containsKey(cString[index_j])) {
//                map.put(cString[index_j], index_j);
//                index_j++;
//                maxTemp++;
//            } else {
//                int i = map.get(cString[index_j]);
//                map.put(cString[index_j], index_j);
//                maxTemp = index_j - i;
//                index_j++;
//            }
//            if (max < maxTemp) {
//                max = maxTemp;
//            }
//        }


        while (index_j < cString.length) {
            int index = fun(cString, index_i, index_j);
            if (index == index_j) { //   index_i 到 index_j 没有相同的字母
                maxTemp++;
            } else {
                index_i = index + 1;  // 窗口左边移动
                maxTemp = index_j - index;
            }
            index_j++;  //  窗口右边移动
            if (max < maxTemp) {
                max = maxTemp;
            }
        }


        return max;

    }

    // 找到与cString[end]相同字母元素的下标，   start 和end 变化 --- 窗口的滑动
    private static int fun(char[] c, int start, int end) {
        int index_i = start;
        for (int i = start; i <= end; i++) {
            if (c[i] != c[end]) {
                index_i++;
            } else{
                break;
            }
        }
        return index_i;
    }
}
