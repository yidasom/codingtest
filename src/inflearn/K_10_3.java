package inflearn;

import java.io.*;
import java.util.StringTokenizer;

public class K_10_3 {

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dy = new int[arr.length];
        dy[0] = 1;
        for (int i=1; i<arr.length; i++) {
            int max=0;
            for (int j=i-1; j>=0; j--) {
                if (arr[j]<arr[i] && dy[j]>max) max=dy[j];
            }
            dy[i]=max+1;
            answer = Math.max(answer, dy[i]);
        }
        System.out.println(answer);
    }
}
