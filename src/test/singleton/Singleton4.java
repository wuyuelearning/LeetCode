package test.singleton;

/**
 * Created by wuyue on 2020/11/18.
 *  DCL 模式
 */
public class Singleton4 {

    private static Singleton4 singleton;

    private Singleton4(){}

    public static Singleton4 getInstance(){

        if (singleton==null){
            synchronized (Singleton4.class){
                if (singleton == null){
                    singleton= new Singleton4();
                }
            }
        }
        return singleton;
    }
}
