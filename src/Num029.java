/**
 * Created by wuyue on 2019/8/19.
 *
 *
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 说明:
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * 执行用时 :
 * 892 ms, 在所有 Java 提交中击败了 5.04% 的用户
 * 内存消耗 : 34.7 MB, 在所有 Java 提交中击败了75.76% 的用户
 */
public class Num029 {
    public static void main(String[] args) {
//        int a = 2147483647;
//        int b = 2147483647;
//
//        long startTime = System.currentTimeMillis();   //获取开始时间
//        System.out.println(divide(a, b));
//        long endTime = System.currentTimeMillis(); //获取结束时间
//        System.out.println("程序运行时间： " + (endTime - startTime) + "  ms");

    }

    private static int divide(int dividend, int divisor) {

        int result = 0;
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        if (dividend == divisor)
            return 1;

        if (divisor == 1)
            return dividend;

        if (divisor == -1 && dividend == Integer.MIN_VALUE)
            return Integer.MAX_VALUE;

        if (divisor == -1 && dividend == 0)
            return 0;


        long a = dividend;
        long a2 = divisor;

        boolean b = false;
        if ((a < 0 && a2 > 0) || (a > 0 && a2 < 0)) {
            if (a < 0) {
                a = 0 - a;
            } else {
                a2 = 0 - a2;
            }
            b = true;
        }

        if (a < 0 && a2 < 0) {
            a = 0 - a;
            a2 = 0 - a2;
        }

        if (a < a2)
            return result;


        if (a > 1) {
            a = (int) (a >> 1);  //  除以2 ，更快一些
            while (a >= a2) {
                a = a - a2;
                result++;
            }
            result += result;
            a += a;   //  为防止余数的两倍大于除数，还能再减一遍。需要做判断
            if (a >= a2)
                result += 1;
        } else {
            while (a >= a2) {
                a = a - a2;
                result++;
            }
        }


        if (b) {
            result = 0 - result;
        }

        return result;

    }
}
