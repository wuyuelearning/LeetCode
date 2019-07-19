import org.omg.CORBA.MARSHAL;

/**
 * Created by wuyue on 2019/7/18.
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231) 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 这部分代码基本思路就是，对‘ ’‘-’‘+’和数字判断，找出所有不成立的情况，
 * 当c[i] 是“+”的情况下，考虑空格，数字，减号的出现情况
 */
public class Num008 {
    public static void main(String[] args) {
        String s = "9223372036854775808";
        System.out.println(myAtoi(s));


//        System.out.print("asdasdasdasd");
//        System.out.print("    123123    ".trim());
//        System.out.print("asdasdasdas");
    }

    private static int myAtoi(String str) {
        if (str == null || str.length() == 0 || str.trim().length() == 0)
            return 0;
        boolean isTurn = false;
        boolean hasShowNum = false;
        boolean hasShowPlus = false;
        long result = 0L;
        if (str.charAt(0) == ' ' || ('0' <= str.charAt(0) && str.charAt(0) <= '9') || str.charAt(0) == '-' || str.charAt(0) == '+') {
            char[] c = str.toCharArray();
            int i = 0;
            int len = c.length;
            while (i < len) {
                if (c[i] == '-' || c[i] == ' ' || ('0' <= c[i] && c[i] <= '9' || c[i] == '+')) {
                    if (c[i] == '+') {
                        if (hasShowPlus) {
                            if (hasShowNum) {
                                break;
                            } else {
                                return 0;
                            }
                        } else {
                            if (isTurn) {
                                if (hasShowNum) {
                                    break;
                                } else {
                                    return 0;
                                }
                            } else if (hasShowNum) {
                                break;
                            } else {
                                hasShowPlus = true;
                            }
                        }
                        i++;
                    } else if (c[i] == '-') {
                        if (isTurn) {
                            if (hasShowNum) {
                                break;
                            } else {
                                return 0;
                            }
                        } else {
                            if (hasShowPlus) {
                                if (hasShowNum) {
                                    break;
                                } else {
                                    return 0;
                                }
                            } else if (hasShowNum) {
                                break;
                            }
                            isTurn = true;
                        }
                        i++;
                    } else if ('0' <= c[i] && c[i] <= '9') {
                        result = result * 10 + (c[i] - '0');
                        if (checkResult(result, isTurn) != 0) {
                            return checkResult(result, isTurn);
                        }
                        hasShowNum = true;
                        i++;
                    } else if (c[i] == ' ') {
                        if (hasShowNum) {
                            break;
                        }
                        if (isTurn || hasShowPlus) { //  在没有出现过数字的情况下已经出现了“-”或“+”，此时又出现空格
                            return 0;
                        }
                        i++;
                    }
                } else {
                    break;
                }
            }
        } else {
            return 0;
        }

        if (isTurn) {
            result = -1 * result;
        }

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        return (int) result;

    }

    /**
     * 每次及时判断是否超过界限
     * 否则  "9223372036854775808"
     * 输出
     * -2147483648
     * 预期结果
     * 2147483647
     * 如果在最后判断 result在while之后会变成   -9223372036854775808
     *
     * Long.MAX_VALUE =9223372036854775808
     */
    private static int checkResult(long result, boolean isTurn) {
        if (isTurn) {
            result = -1 * result;
        }

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return 0;
    }
}
