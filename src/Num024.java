import java.util.List;

/**
 * Created by wuyue on 2019/8/8.
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * ListNode t = head.next;  // t ：2-3-4
 * head.next.next =head;    //  head : 1 ->2 and 2->1 存在循环，
 * head.next =t.next;        //  本想用t存的状态 2-3-4，可是在上一步之后，t也变成了  1 ->2 and 2->1 存在循环，和head同时变
 * head = head.next;
 *
 *
 *思路：
 * 使用一个虚拟节点 save，其next指针指向头节点：ListNode save = new ListNode(0); save.next = head;
 * 举例说明：1->2->3->4
 * 通过创建虚拟节点save，链表为 0->1->2->3->4
 *
 * 初始： pre = save(值为0)，head(值为1)， n = head.next(值为2）：pre(0)->head(1)->n(2)
 *
 * 交换过程：
 * pre.next = head.next; : 0 -> 2  save和pre的结构是同步变化，但是save一直指向的是 ：0
 * head.next = n.next; : 1 -> 3
 *  n.next =head; : 2 -> 1
 * 更新后的链表为 0->2->1->3->4
 * 更新指针：pre = head(值为1)，head = head.next(值为3)，n = head.next(值为4)
 *
 * 重复交换过程。。。
 *
 * 终止条件：
 *
 * head == NULL
 * 要判断的条件：
 * head 不为空时才进行 n = head->next
 * 交换过程中当n 不为空时才进行 head.next = n.next
 * 返回值： save->next
 *
 * 作者：fly_sky
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/c-jie-fa-die-dai-xiang-jie-by-fly_sky/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *
 *执行用时 :1 ms, 在所有 Java 提交中击败了82.66%的用户
 * 内存消耗 :34.5 MB, 在所有 Java 提交中击败了82.19%的用户
 *
 */
public class Num024 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        ListNode i = swapPairs(Num000.getNodeList(a));
        Num000.printListNode(i);
        System.out.println();
    }

    private static ListNode swapPairs(ListNode head) {
        ListNode ll = head;
        if (head == null || head.next == null) {
            return ll;
        }

        ListNode save = new ListNode(0);
        ListNode pre = save;
        save.next = head;

        while (head != null) {
            ListNode n = head.next;
            if (n == null)
                break;

            pre.next = head.next;
            head.next = n.next;
            n.next =head;

            pre =head;
            head  =head.next;

        }
        return save.next;
    }
}
