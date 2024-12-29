package programmers;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Lv2_42583 {
    public static void main(String[] args) {
        Lv2_42583 lv = new Lv2_42583();

        int[] truck_weights = new int[]{7,4,5,6};
        lv.solution(2, 10, truck_weights);
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> que = new LinkedList<>();
        for (int i=0; i<truck_weights.length; i++) {
            // que 에 add
            while(true) {
                if (que.isEmpty()) {
                    que.add(truck_weights[i]);
                    answer++;
                    sum += truck_weights[i];
                    break;
                } else if (que.size() == bridge_length) {
                    sum -= que.poll();
//                        que.remove();
//                        answer++;
//                        break;
                } else {
                    if (sum + truck_weights[i] <= weight) {
                        que.add(truck_weights[i]);
                        sum += truck_weights[i];
                        answer++;
                        break;
                    } else {
                        que.add(0);
//                        que.remove();
//                        que.add(truck_weights[i]);
//                        sum = truck_weights[i];
                        answer++;
                    }
                }
            }

        }
        return answer+bridge_length;
    }

}
