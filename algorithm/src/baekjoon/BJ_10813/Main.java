package baekjoon.BJ_10813;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준알고리즘 10813번

public class Main {

    static int N, M;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int temp;
            temp = arr[num1 - 1];
            arr[num1 - 1] = arr[num2 - 1];
            arr[num2 - 1] = temp;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
