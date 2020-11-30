package proxy;

/**
 * Created by wuyue on 2020/9/16.
 */
public class Client {
    public static void main(String[] args)  {
        BeiDaiLi beiDaiLi = new BeiDaiLi();
        DaiLi daiLi =new DaiLi(beiDaiLi);
        daiLi.fun1();
        daiLi.fun2();
        daiLi.fun3();

        System.out.println("--------");
        //构造被代理对象
        BeiDaiLi beiDaiLi2 = new BeiDaiLi();
        // 构造代理对象，将被代理对象传入
        DaiLi2 daiLi2 = new DaiLi2(beiDaiLi2);
        daiLi2.fun1();
        daiLi2.fun2();
        daiLi2.fun3();

        System.out.println("--------");
        BeiDaiLi2 beiDaiLi3 = new BeiDaiLi2();
        DaiLi2 daiLi3 =new DaiLi2(beiDaiLi3);
        daiLi3.fun1();
        daiLi3.fun2();
        daiLi3.fun3();


    }
}
