package proxy;

/**
 * Created by wuyue on 2020/9/16.
 */
public class DaiLi2 implements IProxy {
    private IProxy iProxy ;

    public DaiLi2(IProxy iProxy){
        this.iProxy = iProxy;
    }
    @Override
    public void fun1()  {
        this.iProxy.fun1();
    }

    @Override
    public void fun2() {
        this.iProxy.fun2();
    }

    @Override
    public void fun3() {
        this.iProxy.fun3();
    }

}
