package baekjoon.BJ_6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준알고리즘 6064번 카잉 달력

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            boolean check = false;

            for (int j = x; j < (N * M); j += M) {
                if (j % N == y) {
                    sb.append(j + 1).append("\n");
                    check = true;
                    break;
                }
            }

            if (!check) {
                sb.append(-1).append("\n");
            }

        }

        System.out.println(sb);
    }
}
