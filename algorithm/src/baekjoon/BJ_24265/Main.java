package baekjoon.BJ_24265;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준알고리즘 24265 알고리즘 수업 - 알고리즘의 수행 시간 4

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(1l*n*(n-1)/2);
        System.out.println(2);
    }
}
