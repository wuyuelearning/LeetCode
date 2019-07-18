/**
 * Created by wuyue on 2019/7/15.
 * <p>
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 思路：找出数组转换后的规律
 * 例如： n = 6
 * 0 (10)         10    (10)     20   间隔10  2n-2
 * 1 (8)      9 (2) 11   (8)   19     间隔 8 2 8 ：10 -2  ，10-（10-2）， 10-2
 * 2 (6)    8  (4)  12  (6)   18
 * 3 (4)   7  (6)  13  (4) 17
 * 4 (2) 6  (8)   14 (2) 16
 * 5       (10)  15
 */
public class Num006 {


    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        System.out.println(convert(s, 4));
    }

    private static String convert(String s, int numRows) {
        if (s.length() == 0 || numRows == 0 || numRows == 1 || s.length() <= numRows) {
            return s;
        }
        int index = 0;
        int n = 2 * numRows - 2;
        int gap = n;
        StringBuilder st = new StringBuilder();

        while (n >= 0) {
            int temp = n;
            int index_t = n;
            if (n == 0 || n == gap) {
                index_t = gap;
            }
            st.append(s.charAt(index));
            while (index + index_t < s.length()) {
                st.append(s.charAt(index + index_t));
                if (n == 0 || n == gap) {
                    temp = gap;
                } else {
                    temp = gap - temp;
                }
                index_t = temp + index_t;
            }
            index++;
            n = n - 2;
        }
        return st.toString();
    }
}
