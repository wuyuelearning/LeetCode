import java.util.ArrayList;

/**
 * Created by wuyue on 2019/8/30.
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num031 {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        nextPermutation(a);
        for (int i : a)
            System.out.print(i + " ");
    }

    private static void nextPermutation(int[] nums) {
        if (nums.length <= 1)
            return;
        int len = nums.length;

        /**
         *  针对：
         *  如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）
         */
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                count++;
            } else {
                break;
            }
        }
        if (count == len - 1) {
            for (int i = 0, j = len - 1; i < len / 2; i++, j--) {
                change(nums, i, j);
            }
            return;
        }

        /**
         * 第一步：找到下一顺序的最高位
         *
         * 从最低位（数组中下标最大）开始，和前面的数字比较，找到第一个（即最靠近自己的）比自己小的数字，记录下标index_l
         * 循环查找，找到整体index_l值最大的（位最低），因为不论数字多大，只要位数低，值就小
         *  （[4,2,0,2,3,2,0] ）
         *
         *  第一步后 ，如果不考虑index_l比较则是：4,2,2,2,3,0,0，替换的是下标1 和5
         *
         *  有比较则替换的是下标3和4 ：   3>1 取3
         *  4,2,0,3,2,2,0
         *
         */

        int index_l = -1;
        int index_r = len-1;
        for (int r = len - 1; r >= 1; r--) {
            for (int l = r - 1; l >= 0; l--) {
                if (nums[r] > nums[l]) {
                    if (index_l < l ) {
                        index_l = l;
                        index_r = r;
                    }
                }
            }
        }
        change(nums, index_l, index_r);
        /**
         *   第二步：用冒泡法将值较大的移到低位
         *
         *   以为在第一步以后，得到的数字n，已经是固定了高位（4,2,0,3 固定了），原数字a，并且一定有n>a（不论低位是多少）
         *
         *   所以，第二步就是找出，低位数字 2,2,0 的最小组合（即最接近a，并且比a大的数），用冒泡法即可
         */
        for (int i = len - 1; i >= 1; i--) {
            for (int j = i - 1; j > index_l; j--) {
                if (nums[i] < nums[j])
                    change(nums, i, j);
            }
        }
    }

    private static void change(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
