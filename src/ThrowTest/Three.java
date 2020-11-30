package ThrowTest;

/**
 * Created by wuyue on 2020/9/16.
 */
public class Three {
    public void fun() throws Exception {
        try {
            int i =10/0;
        } catch (Exception e){
            System.out.println("1111");
            throw new Exception();
        }
    }
}
