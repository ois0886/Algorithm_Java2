package baekjoon.BJ_9086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int l = str.length();
            String f_c = String.valueOf(str.charAt(0));
            String l_c = String.valueOf(str.charAt(l - 1));
            sb.append(f_c).append(l_c).append("\n");

        }
        System.out.println(sb);
    }
}
