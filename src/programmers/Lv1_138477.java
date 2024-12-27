package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lv1_138477 {
    public static void main(String[] args) {
        Lv1_138477 lv = new Lv1_138477();
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        lv.solution(3, score);
    }
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        List<Integer> arr = new ArrayList<>();
        for (int i=0; i<score.length; i++) {
            arr.add(score[i]);
            if (arr.size() > k) {
                arr.remove(Collections.min(arr));
            }
            answer[i] = Collections.min(arr);
        }
        return answer;
    }
}
