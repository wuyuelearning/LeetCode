/**
 * Created by wuyue on 2019/8/3.
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 执行用时 :2 ms, 在所有 Java 提交中击败了76.64%的用户
 * 内存消耗 :36.6 MB, 在所有 Java 提交中击败了86.98%的用户
 *
 *
 */
public class Num021 {

    public static void main(String[] args) {


        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);


        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);


        l1.next = l2;
        l2.next = l3;

        a1.next = a2;
        a2.next = a3;


        ListNode l = mergeTwoLists(l1, a1);
        while (l != null) {
            System.out.print("   " + l.val);
            l = l.next;
        }

    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode l3 = new ListNode(0);
        ListNode l4 = l3;
        if (l1.val <= l2.val) {
            l3.val = l1.val;
            l1 = l1.next;
            l3.next = new ListNode(0);
            l3 = l3.next;
        } else {
            l3.val = l2.val;
            l2 = l2.next;
            l3.next = new ListNode(0);
            l3 = l3.next;
        }
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                while (l2 != null) {
                    l3.val = l2.val;
                    l2 = l2.next;
                    if (l2 != null) {  //  这里需要注意判空
                        l3.next = new ListNode(0);
                        l3 = l3.next;
                    }
                }
                break;
            } else if (l2 == null) {
                while (l1 != null) {
                    l3.val = l1.val;
                    l1 = l1.next;
                    if (l1 != null) { //  这里需要注意判空
                        l3.next = new ListNode(0);
                        l3 = l3.next;
                    }
                }
                break;
            } else if (l1.val <= l2.val) {
                l3.val = l1.val;
                l1 = l1.next;
                l3.next = new ListNode(0);
                l3 = l3.next;
            } else {
                l3.val = l2.val;
                l2 = l2.next;
                l3.next = new ListNode(0);
                l3 = l3.next;
            }
        }
        return l4;
    }

}
