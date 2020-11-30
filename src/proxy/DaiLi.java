package proxy;

/**
 * Created by wuyue on 2020/9/16.
 */
public class DaiLi implements IProxy {
    private BeiDaiLi beiDaiLi ;

    public DaiLi(BeiDaiLi beiDaiLi){
        this.beiDaiLi = beiDaiLi;
    }
    @Override
    public void fun1() {
        this.beiDaiLi.fun1();
    }

    @Override
    public void fun2() {
        this.beiDaiLi.fun2();
    }

    @Override
    public void fun3() {
        this.beiDaiLi.fun3();
    }
}
