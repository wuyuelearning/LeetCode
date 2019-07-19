/**
 * Created by wuyue on 2019/7/18.
 * <p>
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num007 {
    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse(x));
    }

    private static int reverse(int x) {

        long result = 0L;
        boolean isTurn = false;

        if (x < 0) {
            x = -1 * x;
            isTurn = true;
        }

        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (isTurn) {
            result = -1 * result;
        }
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            result = 0;
        }

        return (int) result;
    }
}
