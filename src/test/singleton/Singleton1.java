package test.singleton;

/**
 * Created by wuyue on 2020/11/18.
 *  饿汉模式
 */
public class Singleton1 {

    private static Singleton1 singleton =new Singleton1();

    private Singleton1(){}

    public static Singleton1 getInstance(){
        return singleton;
    }
}
