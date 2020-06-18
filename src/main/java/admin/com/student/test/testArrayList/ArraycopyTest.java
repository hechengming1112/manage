package admin.com.student.test.testArrayList;

import admin.com.student.test.collection.ArrayListDemo;

import java.sql.SQLOutput;

public class ArraycopyTest {
    public static void main(String[] args) {
        int[] e = new int[10];
        e[0] = 0;
        e[1] = 1;
        e[2] = 2;
        e[3] = 3;
        e[4] = 4;
        e[5] = 5;
        e[6] = 6;
        for (int i = 0; i < e.length; i++) {
            System.out.print("old:" + e[i]);
        }

        System.arraycopy(e, 5, e, 6, 1);
        e[5] = 20;

        for (int i = 0; i < e.length; i++) {
            System.out.println("new:" + e[i]);
        }


    }
}
