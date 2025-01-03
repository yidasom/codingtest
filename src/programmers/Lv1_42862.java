package programmers;

import java.util.Arrays;

// greedy
public class Lv1_42862 {
    public static void main(String[] args) {
        Lv1_42862 lv = new Lv1_42862();
        int[] lost = new int[]{2,4};
        int[] reserve = new int[]{1,3,5};
        lv.solution(5, lost, reserve);
    }
    public int solution(int n, int[] lost, int[] reserve) {
        // list에 n사이즈 부여
        int[] a = new int[n];
        // 체육복이 다 있다는 가정 (1)
        for (int i=0; i<n; i++) a[i]++;
        // 체육복 잃어버린 학생 (1-1)
        for (int i=0; i<lost.length; i++) a[lost[i]-1]--;
        // 체육복 여벌이 있는 학생 (1+1)
        for (int i=0; i<reserve.length; i++) a[reserve[i]-1]++;

        // 로직
        for (int i=0; i<n; i++) {
            if (i-1 >= 0 && a[i-1] == 0 && a[i] >=2) { // i-1 학생이 체육복이 없을 때
                a[i-1]++;
                a[i]--;
            }
            if (i+1 < n && a[i+1] == 0 && a[i] >=2) { // i+1 학생이 체육복이 없을 때
                a[i+1]++;
                a[i]--;
            }
        }
        return (int) Arrays.stream(a).filter(el->el > 1).count();
    }
}
