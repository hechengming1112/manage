package admin.com.student.test.testArrayList;

import java.util.ArrayList;
import java.util.List;

public class ForTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <= 10; i++) {
            list.add(i);
        }
        for (Integer i : list) {
            list.add(i);
        }
    }
}
