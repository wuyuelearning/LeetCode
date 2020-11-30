package test.singleton;

/**
 * Created by wuyue on 2020/11/18.
 */
public class Test {
    public static void main(String[] args) {

        for (int i=0;i<1000;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Singleton4.getInstance().hashCode());
                }
            }).start();
        }



    }
}
