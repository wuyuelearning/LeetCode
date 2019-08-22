import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by wuyue on 2019/8/20.
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoor" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num030 {

    public static void main(String[] args) {

        // 超时
        String s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
        String[] ss = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty"/*,"modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"*/};
        System.out.println(findSubstring(s, ss));

        System.out.println("".length());


    }

    private static ArrayList<String> li = new ArrayList<>();

    private static List<Integer> findSubstring(String s, String[] words) {

        ArrayList<Integer> result = new ArrayList<>();

        if (words.length == 0 || s == null || s.length() == 0)
            return result;

        StringBuilder stringBuilder = new StringBuilder();

        for (String ss : words)
            stringBuilder.append(ss);

        if (s.length() < stringBuilder.length())
            return result;


        if (stringBuilder.toString().equals(s)) {
            result.add(0);
            return result;
        }

        long startTime = System.currentTimeMillis();   //获取开始时间
        perm(words, 0, words.length - 1);
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "  ms");

        char[] sc = s.toCharArray();
        for (String ts : li) {
            for (int i = 0; i <= s.length() - ts.length(); i++) {
                if (check(sc, ts.toCharArray(), i)) {
                    result.add(i);
                }
            }
        }


        return result;
    }

    private static boolean check(char[] s, char[] c, int i) {
        for (int j = i, k = 0; k < c.length; j++, k++) {
            if (s[j] != c[k])
                return false;
        }
        return true;
    }


    private static void perm(String[] words, int p, int q) {
        if (p == q) {
            save(words);
            return;
        } else {
            for (int i = p; i <= q; i++) {
                swap(words, p, i);
                perm(words, p + 1, q);
                swap(words, p, i);

            }
        }
    }

    private static void save(String[] words) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String ss : words)
            stringBuilder.append(ss);
        if (!li.contains(stringBuilder.toString())) {
            li.add(stringBuilder.toString());
        }
        System.out.println(stringBuilder.toString());
    }

    private static void swap(String[] s, int i, int j) {
        String t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}
