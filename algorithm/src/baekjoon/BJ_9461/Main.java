package baekjoon.BJ_9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준알고리즘 9461번 파도반 수열

public class Main {
    static int T;
    static long[] arr = new long[101];

    // n >= 3 arr[n] = arr[n-2] + arr[n-3]
    // arr[0] = 1, arr[1] = 1, arr[2] = 1
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        DP();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            sb.append(arr[N]).append("\n");
        }

        System.out.println(sb);
    }

    private static void DP() {
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        for (int i = 4; i < 101; i++) {
            arr[i] = arr[i - 2] + arr[i - 3];
        }
    }
}
