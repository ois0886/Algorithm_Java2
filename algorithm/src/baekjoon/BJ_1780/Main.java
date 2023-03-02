package baekjoon.BJ_1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준알고리즘 1780번 종이의 개수

public class Main {
    static int[][] arr;
    static int minus_one = 0, zero = 0, plus_one = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Solve(0, 0, N);

        System.out.println(minus_one);
        System.out.println(zero);
        System.out.println(plus_one);
    }

    public static void Solve(int startI, int startJ, int n) {
        if (Check(startI, startJ, n)) {
            if (arr[startI][startJ] == -1) {
                minus_one++;
            } else if (arr[startI][startJ] == 0) {
                zero++;
            } else {
                plus_one++;
            }
            return;
        }

        int new_Size = n / 3;

        Solve(startI, startJ, new_Size);
        Solve(startI, startJ + new_Size, new_Size);
        Solve(startI, startJ + 2 * new_Size, new_Size);

        Solve(startI + new_Size, startJ, new_Size);
        Solve(startI + new_Size, startJ + new_Size, new_Size);
        Solve(startI + new_Size, startJ + 2 * new_Size, new_Size);

        Solve(startI + 2 * new_Size, startJ, new_Size);
        Solve(startI + 2 * new_Size, startJ + new_Size, new_Size);
        Solve(startI + 2 * new_Size, startJ + 2 * new_Size, new_Size);
    }

    public static boolean Check(int startI, int startJ, int n) {
        int number = arr[startI][startJ];

        for (int i = startI; i < startI + n; i++) {
            for (int j = startJ; j < startJ + n; j++) {
                if (number != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}
