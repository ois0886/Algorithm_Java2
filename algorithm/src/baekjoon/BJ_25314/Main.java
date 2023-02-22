package baekjoon.BJ_25314;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N == 4) {
            System.out.println("long int");
        } else {
            N = N - 4;
            N = N / 4;
            for (int i = 0; i < N; i++) {
                System.out.print("long ");
            }
            System.out.println("long int");
        }
    }
}
