package inflearn;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class K_10_4 {
    public static class Bricks implements Comparable<Bricks> {
        public int s, h, w;  // s: 크기, h: 높이, w: 무게

        Bricks(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }

        // 크기(s) 기준으로 내림차순 정렬
        @Override
        public int compareTo(Bricks o) {
            return o.s - this.s;  // 내림차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 벽돌의 개수
        ArrayList<Bricks> arr = new ArrayList<>();
        StringTokenizer st;

        // 벽돌 정보 입력받기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr.add(new Bricks(a, b, c));
        }

        Collections.sort(arr);

        int[] dy = new int[n];
        dy[0] = arr.get(0).h;

        // 최댓값 초기화
        int answer = dy[0];

        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(i).w < arr.get(j).w) {
                    max = Math.max(max, dy[j]);
                }
            }
            dy[i] = max + arr.get(i).h;
            answer = Math.max(answer, dy[i]);
        }
        System.out.println(answer);
    }
}
