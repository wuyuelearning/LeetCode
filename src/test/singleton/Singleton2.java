package test.singleton;

/**
 * Created by wuyue on 2020/11/18.
 * 懒汉模式
 */
public class Singleton2 {
    private static Singleton2 singleton ;

    private Singleton2(){}

    public static Singleton2 getInstance(){
        if (singleton ==null){
            return new Singleton2();
        }
        return singleton;
    }
}
