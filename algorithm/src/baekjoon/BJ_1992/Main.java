package baekjoon.BJ_1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 알고리즘 1992번 쿼드트리
public class Main {
    static int N;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        Solve(0, 0, N);
        System.out.println(sb);
    }

    public static void Solve(int x, int y, int size) {
        // 압축이 가능할 경우 하나의 색상으로 압축해준다.
        if (isPossible(x, y, size)) {
            sb.append(arr[x][y]);
            return;
        }

        int newSize = size / 2;    // 압축이 불가능 할 경우 사이즈를 절반으로 나누어야 한다.

        sb.append('(');    // 각 레벨(depth)에서 여는괄호로 시작해야한다.

        Solve(x, y, newSize);                        // 왼쪽 위
        Solve(x, y + newSize, newSize);                // 오른쪽 위
        Solve(x + newSize, y, newSize);                // 왼쪽 아래
        Solve(x + newSize, y + newSize, newSize);    // 오른쪽 아래

        sb.append(')');    // 해당 레벨이 끝나면 닫는괄호도 닫아준다.
    }

    public static boolean isPossible(int x, int y, int size) {
        int value = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (value != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
