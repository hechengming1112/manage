package admin.com.student.test.testArrayList;

import admin.com.student.test.collection.ArrayListDemo;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int i = (int) it.next();
            list.add(i);
        }

    }
}
