package ThrowTest;

/**
 * Created by wuyue on 2020/9/16.
 */
public class One {
    public static void main(String[] args) throws Exception {

        try {
            int i=1/0;
        } catch (Exception e){
            throw new Exception(e);
        }

//        Two t =new Two();
//        t.fun();
    }
}
