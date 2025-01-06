package programmers;

public class Lv2_42883 {
    public static void main(String[] args) {
        Lv2_42883 lv = new Lv2_42883();
        lv.solution("1231234", 3);
    }
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i=0; i<number.length() - k; i++) {
            char max = 0;
            for (int j=idx; j<=i+k; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
