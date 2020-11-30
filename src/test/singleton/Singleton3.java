package test.singleton;

/**
 * Created by wuyue on 2020/11/18.
 * 内部类的方式
 */
public  class  Singleton3 {

    private Singleton3(){}

    private static Singleton3 singleton;

    private static class SingletonHolder{
        private static Singleton3 singleton =new Singleton3();
    }

    public static Singleton3 getInstance(){
        return SingletonHolder.singleton;
    }

}
