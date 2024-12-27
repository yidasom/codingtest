package programmers;

public class Lv1_68935 {
    public static void main(String[] args) {
        Lv1_68935 lv = new Lv1_68935();
        lv.solution(45);
    }


    public int solution(int n) {
        String a = "";
        while (n> 0) {
            a = (n%3) + a;
            n /= 3;
        }
        a = new StringBuilder(a).reverse().toString();
        return Integer.parseInt(a, 10);
    }
}
