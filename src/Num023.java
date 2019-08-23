/**
 * Created by wuyue on 2019/8/7.
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 使用两个链表合并，每次添加一个listNode[]中的链表
 *
 *
 * 执行用时 :462 ms, 在所有 Java 提交中击败了8.31%的用户
 * 内存消耗 :299.8 MB, 在所有 Java 提交中击败了5.04%的用户
 *
 */
public class Num023 {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5, 6, 7};
        int[] a2 = {1, 12, 32, 41, 51, 66, 87};
        int[] a3 = {1, 2, 23, 34, 55, 76, 87};
        ListNode l1 = Num000.getNodeList(a1);
        ListNode l2 = Num000.getNodeList(a2);
        ListNode l3 = Num000.getNodeList(a3);
        ListNode[] s = {l1, l2, l3};
        Num000.printListNode(mergeKLists(s));
    }


    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        ListNode l1 = lists[0];
        for (int i = 1; i < lists.length; i++) {
            l1 = mergeTwoLists(lists[i], l1);
        }
        return l1;
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
