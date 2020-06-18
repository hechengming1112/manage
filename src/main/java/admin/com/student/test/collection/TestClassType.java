package admin.com.student.test.collection;

import com.sun.corba.se.spi.ior.ObjectKey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试类型
 */
public class TestClassType {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Object[] array = list.toArray();
        System.out.println("array className ：" + array.getClass().getSimpleName());


        System.out.println(Integer.MAX_VALUE - 8);
    }
}
