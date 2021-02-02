package collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author simple
 */
public class ListTest {
    public static void main(String[] args) {
        //to sum up, when size is lower than 100000, array list is fast. when the size is over 100k, the linked list will be good.
        int size = 10000000;
        testLinkList(size);
        testArrayList(size);
    }

    private static void testArrayList(int size) {
        List<Integer> arrayList = new ArrayList<Integer>();
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arrayList.add(0);
        }
        end = System.currentTimeMillis();
        System.out.println("ArrayList spend time -> " + (end - start));
    }

    private static void testLinkList(int size) {
        List linkedList = new LinkedList<Integer>();
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            linkedList.add(0);
        }
        end = System.currentTimeMillis();
        System.out.println("LinkedList spend time -> " + (end - start));
    }
}
