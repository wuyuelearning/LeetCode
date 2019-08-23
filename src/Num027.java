/**
 * Created by wuyue on 2019/8/16.
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 注意这五个元素可为任意顺序。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路 ：
 * 整体左移
 *
 * 执行用时 :1 ms, 在所有 Java 提交中击败了96.70%的用户
 * 内存消耗 :36.1 MB, 在所有 Java 提交中击败了84.18% 的用户
 */
public class Num027 {
    public static void main(String[] args) {
        int[] a = {3,2,2,3};
        System.out.println(removeElement(a, 3));
    }

    private static int removeElement(int[] nums, int val) {
        int len = 0;   //  记录移动次数
        //  之后可能出现重复的数字，所以只判断到  nums.length-len，例如 3223，移动之后变成2233， nums.length-len =3 i可以到2 ，nums[2] =3,
        //  j<nums.length-len-1; j<2 ， nums[2]=nums[3];不做赋值了，会重复
        for (int i = 0; i < nums.length-len; ) {
            if (val == nums[i]) {
                for (int j =i;j<nums.length-len-1;j++){
                    nums[j]=nums[j+1];
                }
                len++;
            } else {
                i++;
            }
        }

        for (int i : nums)
            System.out.print(i + "  ");
        System.out.println();
        return nums.length - len;
    }
}
