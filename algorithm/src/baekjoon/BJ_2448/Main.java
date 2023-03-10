package baekjoon.BJ_2448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준알고리즘 2448번 별 찍기 - 11

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 24 , 48
        String[] map = new String[N];
        map[0] = "  *  ";
        map[1] = " * * ";
        map[2] = "*****";

        for (int k = 1; 3 * (int) Math.pow(2, k) <= N; ++k) {
            makeStar(k, map);
        }

        for (int i = 0; i < N; ++i) {
            System.out.println(map[i]);
        }

    }

    private static void makeStar(int k, String[] map) {
        int bottom = 3 * (int) Math.pow(2, k);
        int middle = bottom / 2;

        for (int i = middle; i < bottom; ++i) {
            map[i] = map[i - middle] + " " + map[i - middle];
        }

        String space = "";
        while (space.length() < middle) {
            space += " ";
        }
        for (int i = 0; i < middle; ++i) {
            map[i] = space + map[i] + space;
        }
    }
}
