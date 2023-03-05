package baekjoon.BJ_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 백준알고리즘 2667번 단지번호붙이기

public class Main {
    static int N;
    static int[][] arr;
    static boolean[][] visit;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int count = 0;
        arr = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (arr[x][y] == 1 && !visit[x][y]) {
                    dfs(x, y);
                    count++;
                    list.add(result);
                    result = 0;
                }
            }
        }
        Collections.sort(list);
        sb.append(count).append('\n');
        for (Integer integer : list) {
            sb.append(integer).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        result++;
        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx >= 0 && cy >= 0 && cx < N && cy < N) {
                if (!visit[cx][cy] && arr[cx][cy] == 1) {
                    dfs(cx, cy);
                }
            }

        }

    }

}

