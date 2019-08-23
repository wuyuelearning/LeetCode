/**
 * Created by wuyue on 2019/7/11.
 *
 * *
 *  * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *  *
 *  * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *  *
 *  * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *  *
 *  * 示例：
 *  *
 *  * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  * 输出：7 -> 0 -> 8
 *  * 原因：342 + 465 = 807
 *  *
 *  * 来源：力扣（LeetCode）
 *  * 链接：https://leetcode-cn.com/problems/add-two-numbers
 *  * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  *
 *
 *  执行用时 :6 ms, 在所有 Java 提交中击败了85.43% 的用户
 *  内存消耗 : 43.5 MB, 在所有 Java 提交中击败了88.54%的用户
 */
public class Num002 {
    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
//        ListNode node12 = new ListNode(4);
//        ListNode node13 = new ListNode(3);
        ListNode node21 = new ListNode(9);
        ListNode node22 = new ListNode(6);
//        ListNode node23 = new ListNode(8);

//        node11.next = node12;
//        node12.next = node13;

        node21.next = node22;
//        node22.next = node23;

        ListNode node3 = addTwoNumbers(node11, node21);

        while (node3 != null) {
            System.out.print(node3.val + "-->");
            node3 = node3.next;
        }


    }


    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode node3 = new ListNode(0);
        ListNode node4 = node3;
        boolean shouldAdd1 = false;
        while (node1 != null || node2 != null) {
            int sum = 0;

            if (node1 == null || node2 == null) {
                if (node1 == null) {
                    sum = node2.val;
                } else {
                    sum = node1.val;
                }
            } else {
                sum = node1.val + node2.val;
            }

            if (shouldAdd1) {
                sum += 1;
            }


            if (sum >= 10) {
                node3.val = sum - 10;
                shouldAdd1 = true;
            } else {
                node3.val = sum;
                shouldAdd1 =false;
            }


            if (node1 != null) {
                node1 = node1.next;
            }

            if (node2 != null) {
                node2 = node2.next;
            }

            if (node1 ==null && node2==null){
                if (shouldAdd1){
                    node3.next =new ListNode(1);
                }
                break;
            }
            node3.next = new ListNode(0);
            node3 = node3.next;
        }
        return node4;
    }
}
