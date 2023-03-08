package baekjoon.BJ_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준알고리즘 11053번 가장 긴 증가하는 부분 수열

public class Main {
    static int A;
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[A];
        dp = new Integer[A];
        for (int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < A; i++) {
            DP(i);
        }

        int max = dp[0];
        for (int i = 1; i < A; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }

    static int DP(int n) {
        if (dp[n] == null) {
            dp[n] = 1;

            for (int i = n - 1; i >= 0; i--) {
                if (arr[i] < arr[n]) {
                    dp[n] = Math.max(dp[n], dp[i] + 1);
                }
            }
        }
        return dp[n];
    }
}
