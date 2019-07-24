/**
 * Created by wuyue on 2019/7/24.
 * <p>
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num011 {


    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea1(a));
    }


    // 暴力解法，遍历
    private static int maxArea(int[] height) {
        int len = height.length;
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                int span = j - i;
                int heightSpan = height[j] > height[i] ? height[i] : height[j];
                if (max < heightSpan * span) {
                    max = heightSpan * span;
                }
            }
        }
        return max;
    }

    /**
     *  这种方法背后的思路在于，两线段之间形成的区域总是会受到其中较短那条长度的限制。此外，两线段距离越远，得到的面积就越大。
     *
     * 我们在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。 此外，我们会使用变量 maxareamaxarea 来持续存储到目前为止所获得的最大面积。
     * 在每一步中，我们会找出指针所指向的两条线段形成的区域，更新 maxareamaxarea，并将指向较短线段的指针向较长线段那端移动一步。
     *
     * 最初我们考虑由最外围两条线段构成的区域。现在，为了使面积最大化，我们需要考虑更长的两条线段之间的区域。
     * 如果我们试图将指向较长线段的指针向内侧移动，矩形区域的面积将受限于较短的线段而不会获得任何增加。
     * 但是，在同样的条件下，移动指向较短线段的指针尽管造成了矩形宽度的减小，但却可能会有助于面积的增大。
     * 因为移动较短线段的指针会得到一条相对较长的线段，这可以克服由宽度减小而引起的面积减小。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/two-sum/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/two-sum/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static int maxArea1(int[] height){

        int i=0;
        int j=height.length-1;
        int max =0;

        while (i<j){
            int heightSpan =  height[i]<height[j] ?height[i]:height[j];
            if (max <(heightSpan*(j-i))){
                max = heightSpan*(j-i);
            }

            if (height[i]<height[j]){
                i++;
            } else {
                j--;
            }
        }

        return max;
    }
}
