/**
 * Created by wuyue on 2020/9/9.
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 * [1,2,3,4,5,6,7,8,8,8,8,9,10,11,12]
 * 应该输出：[7,10]
 * 第一次二分找出 第一个分界点 假设下标为 mid=8 分隔成两部分
 *  [0,mid-1] [mid+1 len]
 *
 *  再对左边的循环二分，找出最左值，对右边的循环二分，找出最右值
 *
 */
public class Num34 {
    public static void main(String[] args) {
        Num34 n = new Num34();
        int[] nums = {1,1,1,1,1,1,2,3,4,4,5,5,5,6,7,8,8,8,8};
        int target = 8;
        int[] res = n.searchRange(nums, target);
        System.out.println(res[0] + "  " + res[1]);
    }

    private int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};

        int mid = fun(nums, target, 0, nums.length - 1);
        if (mid == -1) {
            return res;
        }
        int leftLast = mid;
        int left = fun(nums, target, 0, leftLast-1);
        while (left != leftLast && left!=-1) {
            leftLast = left;
            left = fun(nums, target, 0, leftLast-1);
        }
        if (left ==-1)
            left =leftLast;

        int rightLast = mid;
        int right = fun(nums, target, rightLast+1, nums.length - 1);
        while (right != rightLast && right!=-1) {
            rightLast = right;
            right = fun(nums, target, rightLast+1, nums.length - 1);
        }
        if (right==-1)
            right =rightLast;

        res[0] = left;
        res[1] = right;
        return res;

    }

    private int fun(int[] nums, int target, int left, int right) {
        int start = left;
        int end = right;
        int index = -1;
        while (start <= end) {
            int mid = start+((end - start)>>1);
            if (target < nums[mid]) {
                end = mid-1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                index = mid;
                break;
            }
        }
        return index;
    }


}
