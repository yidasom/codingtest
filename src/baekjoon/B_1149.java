package baekjoon;

import java.io.*;
import java.util.*;

public class B_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 집의 수
        int n = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][3];

        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 1. 빨간집 일 때
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+r;
            // 2. 초록집 일 때
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+g;
            // 3. 파란집 일 때
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+b;
        }
        System.out.println(Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2])));
    }

}
