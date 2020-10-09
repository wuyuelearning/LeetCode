/**
 * Created by wuyue on 2020/9/11.
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num35 {
    public static void main(String[] args) {
        Num35 n = new Num35();
        int[] nums = {1,3,5,6};
        int target = 0;
        int index = n.searchInsert(nums, target);
        System.out.println(index);
    }

    private int searchInsert(int[] nums, int target) {
        int[] res = fun(nums, target);
        int index ;
        // 如果res[0]不为-1  则表示找到了target值
        // 其实fun方法只需返回mid值即可 ， 判断 num[mid] 是否等于 target即可
        if (res[0] != -1) {
            return res[0];
        }
        int mid = res[1];//  返回mid值，这个下标是最接近target的值

        if (nums[mid] > target) {
            if (mid>0){
                index = mid ;
            } else {
                index =0;
            }
        } else {
            if (mid<nums.length-1){
                index = mid +1;
            } else {
                index =nums.length;
            }
        }
        return index;
    }

    private int[] fun(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = -1;
        int index = -1;
        int[] res = new int[2];

        while (start <= end) {
            mid = (start + end) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                index = mid;
                break;
            }
        }

        res[0] = index;
        res[1] = mid; // 返回mid值，这个下标是最接近target的值
        return res;
    }
}
