package baekjoon.BJ_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준알고리즘 1149번 RGB 거리

public class Main {
    static int N;
    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;

    static int[][] Cost;
    static int[][] DP;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Cost = new int[N][3];
        DP = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            Cost[i][Red] = Integer.parseInt(st.nextToken());
            Cost[i][Green] = Integer.parseInt(st.nextToken());
            Cost[i][Blue] = Integer.parseInt(st.nextToken());
        }


        // DP의 첫번째 값(집)은 각 색상비용의 첫번째 값으로 초기화
        DP[0][Red] = Cost[0][Red];
        DP[0][Green] = Cost[0][Green];
        DP[0][Blue] = Cost[0][Blue];


        System.out.println(Math.min(DP_Paint(N - 1, Red), Math.min(DP_Paint(N - 1, Green), DP_Paint(N - 1, Blue))));
    }

    private static int DP_Paint(int n, int color) {
        // 만약 탐색하지 않은 배열이라면
        if (DP[n][color] == 0) {

            // color의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해서 DP에 저장한다
            if (color == Red) {
                DP[n][Red] = Math.min(DP_Paint(n - 1, Green), DP_Paint(n - 1, Blue)) + Cost[n][Red];
            } else if (color == Green) {
                DP[n][Green] = Math.min(DP_Paint(n - 1, Red), DP_Paint(n - 1, Blue)) + Cost[n][Green];
            } else {
                DP[n][Blue] = Math.min(DP_Paint(n - 1, Red), DP_Paint(n - 1, Green)) + Cost[n][Blue];
            }

        }

        return DP[n][color];
    }

}
