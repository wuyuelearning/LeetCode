package test;

import java.util.Stack;


/**
 * Created by wuyue on 2020/8/6.
 *
 * https://blog.csdn.net/liujian20150808/article/details/50793101/
 *
 * 因此我们得出汉诺塔问题的以下几个限制条件：
 *
 * 1.在小圆盘上不能放大圆盘。
 *
 * 2.在三根柱子之间一回只能移动一个圆盘。
 *
 * 3.只能移动在最顶端的圆盘。
 *
 * 首先，我们从简单的例子开始分析，然后再总结出一般规律。
 *
 * 当n = 1的时候，即此时只有一个盘子，那么直接将其移动至C即可。移动过程就是 A -> C
 *
 * 当n = 2的时候，这时候有两个盘子，那么在一开始移动的时候，我们需要借助B柱作为过渡的柱子，即将A柱最上面的那个小圆盘移至B柱，然后将A柱底下的圆盘移至C柱，最后将B柱的圆盘移至C柱即可。那么完整移动过程就是A -> B , A -> C , B -> C
 *
 * 当n = 3的时候，那么此时从上到下依次摆放着从小到大的三个圆盘，根据题目的限制条件：在小圆盘上不能放大圆盘，而且把圆盘从A柱移至C柱后，C柱圆盘的摆放情况和刚开始A柱的是一模一样的。所以呢，我们每次移至C柱的圆盘（移至C柱后不再移到其他柱子上去），必须是从大到小的，即一开始的时候，我们应该想办法把最大的圆盘移至C柱，然后再想办法将第二大的圆盘移至C柱......然后重复这样的过程，直到所有的圆盘都按照原来A柱摆放的样子移动到了C柱。
 *
 * 那么根据这样的思路，问题就来了：
 *
 * 如何才能够将最大的盘子移至C柱呢？
 *
 * 那么我们从问题入手，要将最大的盘子移至C柱，那么必然要先搬掉A柱上面的n-1个盘子，而C柱一开始的时候是作为目标柱的，所以我们可以用B柱作为"暂存"这n-1个盘子的过渡柱，当把这n-1的盘子移至B柱后，我们就可以把A柱最底下的盘子移至C柱了。
 *
 * 而接下来的问题是什么呢？
 *
 * 我们来看看现在各个柱子上盘子的情况，A 柱上无盘子，而B 柱从上到下依次摆放着从小到大的n-1个盘子，C 柱上摆放着最大的那个盘子。
 *
 * 所以接下来的问题就显而易见了，那就是要把B柱这剩下的n-1个盘子移至C柱，而B柱作为过渡柱，那么我们需要借助A柱，将A柱作为新的"过渡"柱，将这n-1个盘子移至C柱。
 *
 * 该问题可以分解成以下子问题：
 *
 * 第一步：将n-1个盘子从A柱移动至B柱（借助C柱为过渡柱）
 *
 * 第二步：将A柱底下最大的盘子移动至C柱
 *
 * 第三步：将B 柱的n-1个盘子移至C 柱（借助A柱为过渡柱）
 */
public class HanNuo {
    public static void main(String[] args) {

        HanNuo hanNuo = new HanNuo();
        // 将4个盘子，从A通过B，移到C
        hanNuo.moveDiskDG(4, "A", "B", "C");
    }


    private void moveDiskDG(int n, String start, String mid, String end) {
        if (n == 1) {
            move(n, start, end);
        } else {
            // 这三步为移动n个盘子的一组动作
            // 1、将n-1个盘子从start（此时是A）通过mid（此时是C）移动到B
            moveDiskDG(n - 1, start, end, mid);
            // 2、将start（此时是A）上剩余的一个(第n个盘子)移到end（C）上
            move(n, start, end);
            // 3、此时mid（B）上有n-1个盘子，start（A）0个，end（C）上1个
            // 进行下一步，将这n-1个碟子移到end上去，
            // 以(int n, String start, String mid, String end)传参
            // 此时的mid为下一时刻的其实位置start ，此时的start已经空了，为下一步的mid，只有end是不变的
            // 前两步的start、mid、end是与传入的对应，第三步的时候要考虑此时的位置与下一步的start、mid、end对应关系
            moveDiskDG(n - 1, mid, start, end);

        }
    }

    // 这里以打印模拟移动一个盘子
    private void move(int n, String start, String end) {
        System.out.println("n: " + n + "  start " + start + "  end  " + end);
    }


    private Stack<Integer> left = new Stack<>();
    private Stack<Integer> mid = new Stack<>();
    private Stack<Integer> right = new Stack<>();

    private void init() {
        left.push(5);
        left.push(4);
        left.push(3);
        left.push(2);
        left.push(1);

    }
}
