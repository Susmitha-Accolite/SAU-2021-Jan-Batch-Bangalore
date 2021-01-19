import java.util.*;
import java.io.*;

class Problem1 {
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();

        list.add(18);
        list.add(1);
        list.add(8);
        list.add(3);
        list.add(6);
        list.add(16);
        list.add(15);

        Collections.sort(list);
        for(int i : list) {
            System.out.print(i + " ");
        }
    }
}