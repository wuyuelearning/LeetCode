package proxy.DynamicProxy;

import proxy.BeiDaiLi;
import proxy.IProxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wuyue on 2020/9/16.
 */
public class DynamicClient {
    public static void main(String[] args) throws Exception {
        // 构造被代理类
        IProxy beiDaiLi = new BeiDaiLi();
        // 构造动态代理
        DynamicProxy proxy =new DynamicProxy(beiDaiLi);
        // 获取被代理对象的类加载器
        ClassLoader loader =beiDaiLi.getClass().getClassLoader();
        // 由loader  IProxy.class  proxy构造出一个代理类
        // 被代理类和ITest接口作为参数传入 DynamicProxy 和 newProxyInstance中
        //  使生成的代理类与 被代理类和ITest接口解耦
        // 静态代理类 无法与接口解耦
        IProxy dynamicDaiLi  = (IProxy) Proxy.newProxyInstance(loader,new Class[]{IProxy.class},proxy);
        dynamicDaiLi.fun1();
        dynamicDaiLi.fun2();
        dynamicDaiLi.fun3();


        IProxy beiDaiLi2 = new BeiDaiLi();
        // 参数1：IProxy的类加载器
        // 参数2：代理和被代理类都需要实现的接口
        Class iProxyClass = Proxy.getProxyClass(IProxy.class.getClassLoader(),IProxy.class);
        // 得到有参构造器
        Constructor constructor =iProxyClass.getConstructor(InvocationHandler.class);
        // 反射创建代理实例对象
        IProxy daiLei  =(IProxy) constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(beiDaiLi2,args);
            }
        });
        daiLei.fun1();

    }
}
