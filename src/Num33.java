/**
 * Created by wuyue on 2020/9/8.
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 画出（x,y）坐标比较好理解
 */
public class Num33 {
    public static void main(String[] args) {
        Num33 n = new Num33();

        int[] nums = {3, 4, 5, 1, 2};
        int target = 4;
        int index = n.search(nums, target);
        System.out.println(index);

    }

    private int search(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;

        if (target == nums[start])
            return start;
        if (target == nums[end])
            return end;

        boolean isLeft;
        // 判断是落在了左边还是右边
        if (target > nums[start]) {
            isLeft = true;
        } else if (target < nums[end]) {
            isLeft = false;
        } else {
            return index;
        }

        if (isLeft) {
            while (start <= end) {
                int mid = (start + end) / 2;
                if (target < nums[mid]) {
                    end = mid - 1;
                } else if (target > nums[mid]) {
                    //  这里不能使用 nums[mid]>=nums[nums.length-1]
                    // 否则过不了 nums = {1,2,3,4,5,6} target  =4;
                    if (nums[mid] >= nums[0]) {
                        start = mid + 1; //  防止二分法进入无线循环
                    } else {
                        end = mid - 1;
                    }
                } else {
                    index = mid;
                    break;
                }
            }
        } else {
            while (start <= end) {
                int mid = (start + end) / 2;
                if (target < nums[mid]) {
                    //  同样不能使用  这里不能使用 nums[mid]<=nums[0]
                    if (nums[mid] <= nums[nums.length - 1]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else if (target > nums[mid]) {
                    start = mid + 1;
                } else {
                    index = mid;
                    break;
                }
            }
        }
        return index;
    }
}
