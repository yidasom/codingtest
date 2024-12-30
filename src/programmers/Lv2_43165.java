package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Lv2_43165 {
    public static void main(String[] args) {
        Lv2_43165 lv = new Lv2_43165();

        int[] numbers = new int[]{1, 1, 1, 1, 1};
//        lv.bfs(numbers, 3);

    }
    public int bfs(int[] numbers, int target) {
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        for (int i=0; i<numbers.length; i++) {
            int a = que.size();
            for (int j=0; j<a; j++) {
                int prev = que.poll();
                que.add(prev + numbers[i]);
                que.add(prev - numbers[i]);
            }
        }
        return que.stream().filter(e->e == target).collect(Collectors.toList()).size();
    }


}
