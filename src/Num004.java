/**
 * Created by wuyue on 2019/7/12.
 * <p>
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：取出两个数组中 ，中间位的数字
 * 两个指针，分别指向数组，比较之后，较小的一个数组，
 * 指针向后移动，直到找到中间位置的元素
 */
public class Num004 {
    public static void main(String[] args) {
        int[] n1 = {1, 2};
        int[] n2 = {3, 4};
        findMedianSortedArrays(n1, n2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double middle = 0L;
        if (nums1 == null || nums1.length == 0) {
            if (nums2.length % 2 == 0) {
                System.out.print("++ " + (double) (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2);
                return (double) (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2;
            } else {
                System.out.print("++  " + (nums2[nums2.length / 2]));
                return (double) (nums2[nums2.length / 2]);
            }
        }
        if (nums2 == null || nums2.length == 0) {
            if (nums1.length % 2 == 0) {  // nums1.length / 2 第m大的数，但下标要减一
                System.out.print("-- " + (double) (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2);
                return (double) (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2;
            } else {
                System.out.print("--  " + (nums1[nums1.length / 2]));
                return (double) (nums1[nums1.length / 2]);
            }
        }

        int max_i = nums1.length - 1;
        int max_j = nums2.length - 1;

        if ((nums1.length + nums2.length) % 2 == 0) {  //  如果是偶数个，则中间两个数，取均值
            int m = (nums1.length + nums2.length) / 2;   //  第m大的数
            int m2 = (nums1.length + nums2.length) / 2 + 1;
            int r1 = getNum(m, max_i, max_j, nums1, nums2);
            int r2 = getNum(m2, max_i, max_j, nums1, nums2);
            System.out.println("+++  " + r1);
            System.out.println("+++  " + r2);
            middle = (double) (r1 + r2) / 2;
            System.out.println("+++   " + middle);
        } else {     //  奇数个，取中间
            int m = (nums1.length + nums2.length) / 2 + 1;
            middle = getNum(m, max_i, max_j, nums1, nums2);
            System.out.println("" + middle);
        }
        return middle;

    }
    // 取出两个数组 第m大的数
    private static int getNum(int m, int max_i, int max_j, int[] nums1, int[] nums2) {
        int count = 0;
        int i = 0;
        int j = 0;
        int result = 0;

        //  count 计数
        while (count != m) {

            //  如果i到了max_i和没有选出第m大的数
            // 说明这个数在num2数组中，直接取出这个数即可
            // m-count ：距m剩余的数字，此时计数到第count大的数
            // m-count+j ：+j表示，num2中已经计过j个数
            // m-count+j-1：num2中距m剩余的数字的下标
            if (i > max_i) {
                return nums2[m - count + j - 1];
            }

            if (j > max_j) {
                return nums1[m - count + i - 1];
            }

            if (nums1[i] <= nums2[j]) {
                result = nums1[i];
                i++;
            } else {
                result = nums2[j];
                j++;
            }
            count++;
        }
        return result;
    }
}
