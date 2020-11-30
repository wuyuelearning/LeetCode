package test;

/**
 * Created by wuyue on 2020/9/9.
 */
public class ErFen {
    public static void main(String[] args) {
        ErFen erFen = new ErFen();

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 11, 22, 33, 44};
        int target = 3;
        int index;

        index =erFen.fun(nums,target);
//        index = erFen.fun2(nums, target);
//        index = erFen.fun3(nums,target,0,nums.length-1);


        System.out.println(index);

    }

    // 二分法 递归方式
    private int fun3(int[] nums, int target,int start ,int end){

        // return 条件之一
        if (target<nums[start] || target>nums[end] || start>end)
            return -1;

        int mid =(start+end)/2;
        if (target<nums[mid]){
            return fun3(nums,target,start,mid-1);
        } else if (target>nums[mid]){
            return fun3(nums,target,start+1,end);
        } else {
            // return 条件之二
            return mid;
        }
    }

    // 二分法 循环的方法
    private int fun2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target < nums[mid]) {
                end = mid -1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                index = mid;
                break;
            }
        }
        return index;
    }

    private int fun(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;
        if (start == end) {
            if (target == nums[start]) {
                return start;
            } else {
                return -1;
            }
        }

        while (start < end) {
            int mid = (start + end) / 2;
            if (target < nums[mid]) {
                end = mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                index = mid;
                break;
            }
            if (start == end && target == nums[(start + end) / 2]) {
                index = start;
                break;
            }
        }

        return index;
    }
}


