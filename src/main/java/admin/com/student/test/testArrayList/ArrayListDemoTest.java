package admin.com.student.test.testArrayList;

import admin.com.student.test.collection.ArrayListDemo;

import javax.xml.transform.Source;
import java.util.Collection;
import java.util.List;

public class ArrayListDemoTest {
    public static void main(String[] args) {
        ArrayListDemo<Integer> list = new ArrayListDemo<Integer>();
        ArrayListDemo<Integer> Lis1 = new ArrayListDemo<Integer>();
        for (int i = 0; i <= 11; i++) {
            list.add(i);
        }
        list.remove(new ArrayListDemo<>());
        // System.out.println(list);

        boolean b = Lis1.addAll(list);
        if (b) {
            Lis1.addAll(5, list);
        }
        //System.out.println(Lis1);

        /*ArrayListDemo<String> l1 = new ArrayListDemo<>();
        l1.add("tom");
        l1.add("tom");
        System.out.println(l1.size());
        l1.remove("tom");
        System.out.println(l1.size());
        l1.remove("tom");
        System.out.println(l1.size());

        l1.add("tom");
        System.out.println(l1.size());

        l1.remove("tom");
        System.out.println(l1.size());*/

        ArrayListDemo<Person> l2 = new ArrayListDemo<>();
        l2.add(new Person("1"));
        l2.add(new Person("2"));
        l2.remove(new Person("2"));
        System.out.println(l2.size());


    }
}
