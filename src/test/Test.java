package test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/**
 * Created by wuyue on 2020/9/2.
 */


public class Test {

    public static void main(String[] args) {
        Test t = new Test();
//        t.fun2();
//        t.fun3();

//        TestObj testObj =new TestObj();
//        System.out.println(testObj.i);
//        System.out.println(testObj.b);
//        System.out.println(testObj.i1);
//        System.out.println(testObj.b1);


        t.fun6();



    }

    private void fun6(){
        Account A =new Account(100);
        Account B =new Account(100);
        Account C =new Account(100);


        new Thread(new Runnable() {
            @Override
            public void run() {
                A.transfer(B,100);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                B.transfer(C,100);
            }
        }).start();
    }


    class Account {
        private int balance;
        public Account (int balance){
            this.balance =balance;
        }

        public int getBalance() {
            return balance;
        }

        // 转账
        synchronized void transfer(Account target, int amt){
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }

    static class AtomicBooleanTest implements Runnable{
        AtomicBoolean flag =new AtomicBoolean(true);
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"  试图获得锁--"+"flag: "+flag);
            if (flag.compareAndSet(true,false)){
                System.out.println(Thread.currentThread().getName()+"  获得锁--"+"flag: "+flag);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"  释放锁");
                flag.set(true);
            } else {
                System.out.println(Thread.currentThread().getName()+ "  重试  flag: "+flag);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                run();
            }
        }
    }


    private void fun7() {
        String r = "00324";
        System.out.println(Long.parseLong(r));
    }


    private void fun6(String str) {
        Pattern pattern = Pattern.compile("^([1-9]\\d{0,9})");
        System.out.println(pattern.matcher(str).matches());

    }

    private void fun5() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "启动");
                lock();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                unlock();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "启动");
                lock();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                unlock();
            }
        }).start();
    }

    AtomicReference<Thread> threadAtomicReference = new AtomicReference<>();

    private void lock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "试图获得锁");
        while (!threadAtomicReference.compareAndSet(null, thread)) {

        }
        System.out.println(thread.getName() + "获得锁");
    }

    private void unlock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "解锁");
        threadAtomicReference.compareAndSet(thread, null);
    }

    private void fun4() {
        TY ty = new TY();
        fun5(ty);
        System.out.println(ty.a + "" + ty.b + "" + ty.c);
    }

    private void fun5(TY ty) {
        ty.a = 10;
        ty.b = true;
        ty.c = 1;
    }

    int b = 0;

    private void fun3() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("change");
                b = 1;
            }
        }).start();
        while (b == 0) {
            synchronized (this) {
            }
        }
        System.out.println("11111");
    }

    int a = 0;

    private void fun2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (a < 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a++;
                    System.out.println(Thread.currentThread().getName() + "  a:" + a);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (a < 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a++;
                    System.out.println(Thread.currentThread().getName() + "  a:" + a);
                }
            }
        }).start();


    }

    private static void fun1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.forEach(integer -> {
                    System.out.print(integer);
                }
        );
        System.out.println();
        List<Integer> k = list;
        k.set(3, 100);

        k.forEach(integer -> {
            System.out.print(integer);
        });
        System.out.println();
        list.forEach(integer -> {
                    System.out.print(integer);
                }
        );

    }

}

class TY {
    int a;
    boolean b;
    int c;

    public TY() {

    }
}
