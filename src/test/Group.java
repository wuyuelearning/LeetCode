package test;

import java.util.*;

/**
 * Created by wuyue on 2020/8/7.
 */
public class Group {

    public static void main(String[] args) {
        Group group = new Group();
        group.fun();
    }

    private void fun() {

        List<Demo> f = new ArrayList<>();
        f.add(new Demo("1", Arrays.asList("A", "B", "C")));
        f.add(new Demo("2", Arrays.asList("B", "E", "C")));
        f.add(new Demo("3", Arrays.asList("F", "E", "C")));
        f.add(new Demo("4", Arrays.asList("A", "C", "D")));
        f.add(new Demo("5", Arrays.asList("D", "E", "A")));
        f.add(new Demo("6", Arrays.asList("A", "F", "B")));

        Map<String, List<String>> f1 = new HashMap<>();
        f.forEach(item -> item.taqs.forEach(item2 -> {
            List<String> i;
            if (f1.get(item2) != null) {
                i = f1.get(item2);
            } else {
                i = new ArrayList<>();
            }
            i.add(item.scenic);
            f1.put(item2, i);
        }));

        System.out.println(f1);


    }

}


class Demo {

    String scenic;
    List<String> taqs;

    Demo(String _scenic, List<String> _tags) {
        this.scenic = _scenic;
        this.taqs = _tags;
    }
}
