package admin.com.student.test.testArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RemoveTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        System.out.println("list:" + list);
    }
}
