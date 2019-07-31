import java.util.HashSet;
import java.util.Set;

/**
 * Created by wuyue on 2019/7/31.
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num016 {
    public static void main(String[] args) {

        int[] n = {1,1,1,0};
        int a = -100;

        System.out.println(threeSumClosest(n, a));

    }

    private static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int sap =Integer.MAX_VALUE;
     /*   Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();*/
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
           /* if (!set.contains(nums[i])) {  //  用时反而更多
                set.add(nums[i]);
                set2.clear();
            } else {
                continue;
            }*/
            for (int j = i + 1; j < len - 1; j++) {
               /* if (!set2.contains(nums[j])) {
                    set2.add(nums[j]);
                } else {
                    continue;
                }*/
                for (int k = j + 1; k < len; k++) {
                    int s = nums[i] + nums[j] + nums[k];
                    if (s == target) {
                        return nums[i]  + nums[j] + nums[k];
                    }
                    int sapT = s - target;
                    if (sapT < 0) {
                        sapT = sapT * -1;
                    }
                    if (sapT < sap) {
                        sap =sapT;
                        result = nums[i]  + nums[j] + nums[k];
                    }
                }
            }
        }
        return result;
    }
}
