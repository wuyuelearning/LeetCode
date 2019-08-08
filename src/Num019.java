import java.util.List;

/**
 * Created by wuyue on 2019/8/1.
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 * 两个指针，第一个比第二个提前n个位置
 */
public class Num019 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;

        ListNode l = removeNthFromEnd(listNode, 5);
        while (l != null) {
            System.out.print(l.val + "-->");
            l = l.next;
        }


    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode last = head;
        ListNode saved = last;
        int count = 0;
        while (count < n && head != null) {
            count++;
            head = head.next;
        }

        if (head == null) {
            saved = last.next;
        } else {
            while (head.next != null) {
                last = last.next;
                head = head.next;
            }
            last.next = last.next.next;
        }
        return saved;

    }
}


