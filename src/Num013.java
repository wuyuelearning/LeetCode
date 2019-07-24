import java.util.HashMap;

/**
 * Created by wuyue on 2019/7/24.
 * <p>
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "III"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: "IV"
 * 输出: 4
 * 示例 3:
 * <p>
 * 输入: "IX"
 * 输出: 9
 * 示例 4:
 * <p>
 * 输入: "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 将字符串转换成数组，观察可得：
 *
 * 如果c[i]>=c[i+1] 是将单个字符转换成对应大小 ，直接相加
 *
 * 如果 c[i]<c[i+1] 将  c[i]c[i+1]看成一组取值后相加
 *
 * 例如：MMCD :
 * M+M+CD :1000+1000+(500-100)
 * 而不是：
 * M+ MC+D ：1000+(1000+100)+500
 */
public class Num013 {

    public static void main(String[] args) {
        String s = "IVII";
        System.out.println(romanToInt(s));
    }

    private static int romanToInt(String s) {
        int a = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("D", 500);
        map.put("C", 100);
        map.put("L", 50);
        map.put("X", 10);
        map.put("V", 5);
        map.put("I", 1);
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; ) {
            if (i <= len - 2) {
                int n = map.get(String.valueOf(chars[i]));
                int m = map.get(String.valueOf(chars[i + 1]));
                if (n < m) {
                    a = a + (m - n);
                    i = i + 2;
                } else {
                    a = a + n;
                    i++;
                }
            } else {  // 针对当  i == len-1时 ，如果可以到这一步，说明 i = i + 2，未能结束循环; 最后两个c[len-2],c[len-1],不能组合成一组，直接 取值后相加
                a = a + map.get(String.valueOf(chars[i]));
                i++;
            }
        }
        return a;
    }

}
