import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyue on 2019/8/8.
 * 一些工具类
 */
public class Num000 {

    public static void main(String[] args) {

////        List<Integer> i = new ArrayList<>();
////        i.add(3);
////        i.add(1);
////        i.add(3);
////        i.add(6);
////        i.add(9);
//
        int[] i = {1, 9};

        ListNode l = getNodeList(i);

        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    static ListNode getNodeList(List<Integer> list) {
        if (list.size() == 0) {
            return null;
        }

        ListNode l = new ListNode(list.get(0));
        ListNode k = l;
        if (list.size() == 1) {
            return k;
        }
        l.next = new ListNode(0);
        l = l.next;
        for (int i = 1; i < list.size(); i++) {
            l.val = list.get(i);
            if (i < list.size() - 1) {
                l.next = new ListNode(0);
                l = l.next;
            }

        }
        return k;
    }

    static ListNode getNodeList(int[] arrays) {
        if (arrays.length == 0) {
            return null;
        }
        ListNode l = new ListNode(arrays[0]);
        ListNode k = l;
        if (arrays.length == 1) {
            return k;
        }
        l.next = new ListNode(0);
        l = l.next;
        for (int i = 1; i < arrays.length; i++) {
            l.val = arrays[i];

            if (i < arrays.length - 1) {
                l.next = new ListNode(0);
                l = l.next;
            }

        }
        return k;
    }

    static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + (listNode.next != null ? " -> " : ""));
            listNode = listNode.next;
        }
    }

}
