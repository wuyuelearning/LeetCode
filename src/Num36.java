import java.util.HashSet;
import java.util.Set;

/**
 * Created by wuyue on 2020/9/11.
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 *
 *
 * 上图是一个部分填充的有效的数独。
 *
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * 示例 1:
 *
 * 输入:
 * [
 * ['5','3','.','.','7','.','.','.','.'],
 * ['6','.','.','1','9','5','.','.','.'],
 * ['.','9','8','.','.','.','.','6','.'],
 * ['8','.','.','.','6','.','.','.','3'],
 * ['4','.','.','8','.','3','.','.','1'],
 * ['7','.','.','.','2','.','.','.','6'],
 * ['.','6','.','.','.','.','2','8','.'],
 * ['.','.','.','4','1','9','.','.','5'],
 * ['.','.','.','.','8','.','.','7','9']
 * ]
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * [
 *   ['8','3','.','.','7','.','.','.','.'],
 *   ['6','.','.','1','9','5','.','.','.'],
 *   ['.','9','8','.','.','.','.','6','.'],
 *   ['8','.','.','.','6','.','.','.','3'],
 *   ['4','.','.','8','.','3','.','.','1'],
 *   ['7','.','.','.','2','.','.','.','6'],
 *   ['.','6','.','.','.','.','2','8','.'],
 *   ['.','.','.','4','1','9','.','.','5'],
 *   ['.','.','.','.','8','.','.','7','9']
 * ]
 * 输出: false
 * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
 * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 * 说明:
 *
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  按照题目的思路解题
 */
public class Num36 {
    public static void main(String[] args) {
        Num36 n = new Num36();
        char[][] board = {
                {'.','.','.','.','5','.','.','1','.'}
                ,{'.','4','.','3','.','.','.','.','.'}
                ,{'.','.','.','.','.','3','.','.','1'}
                ,{'8','.','.','.','.','.','.','2','.'}
                ,{'.','.','2','.','7','.','.','.','.'}
                 ,{'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};
        boolean f = n.isValidSudoku(board);
        System.out.println(f);
    }

    private boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> setHang = new HashSet<>();
            Set<Character> setLie = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (setHang.contains(board[i][j])) {
                        return false;
                    } else {
                        setHang.add(board[i][j]);
                    }
                }
                if (board[j][i] != '.') {
                    if (setLie.contains(board[j][i])) {
                        return false;
                    } else {
                        setLie.add(board[j][i]);
                    }
                }
            }
        }

        int[][] s = {{0,0},{3,0},{0,3},{-3,0},{0,-3},{3,3},{-3,-3},{3,-3},{-3,3}};
        for (int i =0;i<s.length;i++) {
            boolean r = fun(board, 3 + s[i][0], 3 + s[i][1], 5 + s[i][0], 5 + s[i][1]);
            if (!r)
                return false;
        }
        return true;
    }

    private boolean fun(char[][] board, int start_i, int start_j, int end_i, int end_j) {
        Set<Character> set = new HashSet<>();
        for (int i = start_i; i <= end_i; i++) {
            for (int j = start_j; j <= end_j; j++) {
                if (board[i][j] != '.') {
                    if (set.contains(board[i][j])) {
                        return false;
                    } else {
                        set.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}
