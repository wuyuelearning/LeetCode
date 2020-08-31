package test;

import java.util.Stack;

/**
 * Created by wuyue on 2020/7/8.
 * 指针翻转
 */
public class fanzhuan {
    public static void main(String[] args){
        ListNode n0 =new ListNode(0);
        ListNode n1 =new ListNode(1);
        ListNode n2 =new ListNode(2);
        ListNode n3 =new ListNode(3);
        ListNode n4 =new ListNode(4);
        ListNode n5 =new ListNode(5);
        ListNode n6 =new ListNode(6);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;


        ListNode n =n0;
        do{
            System.out.print(n.val+"-->");
            if (n.next == null)
                break;
            else {
                n =n.next;
            }
        } while(true);

//        fanzhuan(n0);
//        funzhuan(n0);

//        fun1();


    }


    private static void fun1(){
        System.out.println();
        try {

            int i =1/0;
            System.out.println(i);
        } catch (Exception e) {
            System.out.println("11");
//            e.printStackTrace();
        }
        System.out.println("2222");
    }


    private static void fanzhuan(ListNode head){

        Stack<Integer> stack =new Stack<>();

        ListNode n =head;
       do {
            stack.push(n.val);
            n =n.next;
        }while (n!=null);

        System.out.println();
        ListNode res =new ListNode(stack.pop());
        ListNode h =res;
        while (!stack.isEmpty()){
            res.next = new ListNode(stack.pop());
            res =res.next;
        }

        ListNode s =h;
        while (s!=null){
            System.out.print (s.val+"--->");
            s =s.next;
        }
    }

    private static void funzhuan(ListNode head){
        System.out.println();
        ListNode n1 =head;
        ListNode n =null;
        while (n1!=null){
            ListNode nn = new ListNode(n1.val);
            nn.next =n;
            n=nn;
            n1 =n1.next;
        }

        ListNode s =n;
        while (s!=null){
            System.out.print (s.val+"-->");
            s =s.next;
        }

    }





}
