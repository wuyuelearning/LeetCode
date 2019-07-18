/**
 * Created by wuyue on 2019/7/18.
 * 第五题  动态规划方法
 * <p>
 * 推荐理由：暴力解法太 naive，中心扩散不普适，Manacher 就更不普适了，是专门解这个问题的方法。而用动态规划我认为是最有用的，可以帮助你举一反三的方法。
 * <p>
 * 补充说明：Manacher 算法有兴趣的朋友们可以了解一下，有人就借助它的第一步字符串预处理思想，解决了 LeetCode 第 4 题。因此以上推荐仅代表个人观点。
 * <p>
 * 解决这类 “最优子结构” 问题，可以考虑使用 “动态规划”：
 * <p>
 * 1、定义 “状态”；
 * 2、找到 “状态转移方程”。
 * <p>
 * 记号说明： 下文中，使用记号 s[l, r] 表示原始字符串的一个子串，l、r 分别是区间的左右边界的索引值，使用左闭、右闭区间表示左右边界可以取到。举个例子，当 s = 'babad' 时，s[0, 1] = 'ba' ，s[2, 4] = 'bad'。
 * <p>
 * 1、定义 “状态”，这里 “状态”数组是二维数组。
 * <p>
 * dp[l][r] 表示子串 s[l, r]（包括区间左右端点）是否构成回文串，是一个二维布尔型数组。即如果子串 s[l, r] 是回文串，那么 dp[l][r] = true。
 * <p>
 * 2、找到 “状态转移方程”。
 * <p>
 * 首先，我们很清楚一个事实：
 * <p>
 * 1、当子串只包含 11 个字符，它一定是回文子串；
 * <p>
 * 2、当子串包含 2 个以上字符的时候：如果 s[l, r] 是一个回文串，例如 “abccba”，那么这个回文串两边各往里面收缩一个字符（如果可以的话）的子串 s[l + 1, r - 1] 也一定是回文串，即：如果 dp[l][r] == true 成立，一定有 dp[l + 1][r - 1] = true 成立。
 * <p>
 * 根据这一点，我们可以知道，给出一个子串 s[l, r] ，如果 s[l] != s[r]，那么这个子串就一定不是回文串。如果 s[l] == s[r] 成立，就接着判断 s[l + 1] 与 s[r - 1]，这很像中心扩散法的逆方法。
 * <p>
 * 事实上，当 s[l] == s[r] 成立的时候，dp[l][r] 的值由 dp[l + 1][r - l] 决定，这一点也不难思考：当左右边界字符串相等的时候，整个字符串是否是回文就完全由“原字符串去掉左右边界”的子串是否回文决定。但是这里还需要再多考虑一点点：“原字符串去掉左右边界”的子串的边界情况。
 * <p>
 * 1、当原字符串的元素个数为 33 个的时候，如果左右边界相等，那么去掉它们以后，只剩下 11 个字符，它一定是回文串，故原字符串也一定是回文串；
 * <p>
 * 2、当原字符串的元素个数为 22 个的时候，如果左右边界相等，那么去掉它们以后，只剩下 00 个字符，显然原字符串也一定是回文串。
 * <p>
 * 把上面两点归纳一下，只要 s[l + 1, r - 1] 至少包含两个元素，就有必要继续做判断，否则直接根据左右边界是否相等就能得到原字符串的回文性。而“s[l + 1, r - 1] 至少包含两个元素”等价于 l + 1 < r - 1，整理得 l - r < -2，或者 r - l > 2。
 * <p>
 * 综上，如果一个字符串的左右边界相等，以下二者之一成立即可： 1、去掉左右边界以后的字符串不构成区间，即“ s[l + 1, r - 1] 至少包含两个元素”的反面，即 l - r >= -2，或者 r - l <= 2； 2、去掉左右边界以后的字符串是回文串，具体说，它的回文性决定了原字符串的回文性。
 * <p>
 * 于是整理成“状态转移方程”：
 * <p>
 * dp[l, r] = (s[l] == s[r] and (l - r >= -2 or dp[l + 1, r - 1]))
 * 或者
 * <p>
 * dp[l, r] = (s[l] == s[r] and (r - l <= 2 or dp[l + 1, r - 1]))
 * 编码实现细节：因为要构成子串 l 一定小于等于 r ，我们只关心 “状态”数组“上三角”的那部分取值。理解上面的“状态转移方程”中的 (r - l <= 2 or dp[l + 1, r - 1]) 这部分是关键，因为 or 是短路运算，因此，如果收缩以后不构成区间，那么就没有必要看继续 dp[l + 1, r - 1] 的取值。
 * <p>
 * 作者：liweiwei1419
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * <p>
 * 关键在  dp[l + 1][r - 1] 的作用理解， dp保存状态
 * <p>
 * a  b  c  a  f  a  c
 * a    f  f  f  f  f  f
 * b       f  f  f  f  f
 * c          f  f  f  t
 * a             f  t  f
 * f                f  f
 * a                   f
 * c
 * s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])
 * <p>
 * 当 s.charAt(l) == s.charAt(r) 不同 直接dp为f（初始化中dp都是f）
 * <p>
 * 当判断到 a  b  c  a  两个a，  s.charAt(l) == s.charAt(r)，但 r - l <= 2 为不成立 并且dp[l + 1][r - 1] =dp[1][2] 即bc的dp判断，此时
 * 已经判断出来，为f ，所以为f
 * <p>
 * 当判断到 a  b  c  a  f  a   两个a，  s.charAt(l) == s.charAt(r) , r - l <= 2 成立 不用判断 dp[l + 1][r - 1] ，所以为t
 * <p>
 * <p>
 * 当判断到 c  a  f  a  c   两个c  s.charAt(l) == s.charAt(r) ,r - l <= 2 为不成立  但是 dp[l + 1][r - 1] =dp[3][5] 即afa ，已经判断为true
 * 所以整体为t
 */
public class Num005_1 {

    public static void main(String[] args) {
        String s = "abcafac";
       System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }
        int longestPalindrome = 1;
        String longestPalindromeStr = s.substring(0, 1);
        boolean[][] dp = new boolean[len][len];
        // abcdedcba
        //   l   r
        // 如果 dp[l, r] = true 那么 dp[l + 1, r - 1] 也一定为 true
        // 关键在这里：[l + 1, r - 1] 一定至少有 2 个元素才有判断的必要
        // 因为如果 [l + 1, r - 1] 只有一个元素，不用判断，一定是回文串
        // 如果 [l + 1, r - 1] 表示的区间为空，不用判断，也一定是回文串
        // [l + 1, r - 1] 一定至少有 2 个元素 等价于 l + 1 < r - 1，即 r - l >  2

        // 写代码的时候这样写：如果 [l + 1, r - 1]  的元素小于等于 1 个，即 r - l <=  2 ，就不用做判断了

        // 因为只有 1 个字符的情况在最开始做了判断
        // 左边界一定要比右边界小，因此右边界从 1 开始
        for (int r = 1; r < len; r++) {
            for (int l = 0; l < r; l++) {
                // 区间应该慢慢放大
                // 状态转移方程：如果头尾字符相等并且中间也是回文
                // 在头尾字符相等的前提下，如果收缩以后不构成区间（最多只有 1 个元素），直接返回 True 即可
                // 否则要继续看收缩以后的区间的回文性
                // 重点理解 or 的短路性质在这里的作用
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > longestPalindrome) {
                        longestPalindrome = r - l + 1;
                        longestPalindromeStr = s.substring(l, r + 1);
                    }
                }
            }
        }
        return longestPalindromeStr;
    }


//    private static String test(String s) {
//        int len = s.length();
//        if (len <= 1) {
//            return s;
//        }
//        int max = 1;
//        String result = s.substring(0, 1);
//        boolean[][] dp = new boolean[len][len];
//        for (int r = 1; r < len; r++) {
//            for (int l = 0; l < r; l++) {
//                if (s.charAt(r) == s.charAt(l) && (r - l <= 2 || dp[l + 1][r - 1])) {
//                    dp[r][l] = true;
//                    if (max < r - l + 1) {
//                        max = r - l + 1;
//                        result = s.substring(l, r + 1);
//                    }
//                }
//            }
//        }
//
//        return result;
//
//    }
}
