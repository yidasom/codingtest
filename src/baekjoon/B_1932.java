package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 삼각형 크기
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        Integer[][] dp = new Integer[n][n];

        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<i+1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<n; i++) {
            dp[n-1][i] = arr[n-1][i];
        }

        maxi(0,0, dp, n, arr);
    }
    static int maxi(int dep, int idx, Integer[][] dp, int n, int[][] arr) {
        if (dep == n-1) return dp[dep][idx];

        if (dp[dep][idx] == null) {
            dp[dep][idx] = Math.max(maxi(dep+1, idx, dp, n, arr), maxi(dep+1, idx+1, dp, n, arr)) + arr[dep][idx];
        }

        return dp[dep][idx];
    }
}
