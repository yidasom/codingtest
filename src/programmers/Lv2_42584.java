package programmers;

import java.util.*;

public class Lv2_42584 {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 2, 3};
        int[] prices2 = new int[]{5, 8, 6, 2, 4, 1};
        Lv2_42584 lv = new Lv2_42584();
        lv.solution(prices2);
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i=0; i<prices.length-1; i++) {
            for (int j=i+1; j<prices.length; j++) {
                ++answer[i];
                if (prices[i] > prices[j]) break;
            }
        }
        answer[prices.length-2] = 1;
        answer[prices.length-1] = 0;
        return answer;
    }
}
