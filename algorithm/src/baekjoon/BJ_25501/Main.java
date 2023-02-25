package baekjoon.BJ_25501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준알고리즘 25512번 재귀의 귀재

public class Main {
    static int T;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            result = 0;
            sb.append(isPalindrome(str)).append(" ").append(result).append("\n");

        }
        System.out.println(sb);

    }

    public static int recursion(String s, int l, int r) {
        result++;
        if (l >= r) return 1;
        else if (s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l + 1, r - 1);
    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }
}