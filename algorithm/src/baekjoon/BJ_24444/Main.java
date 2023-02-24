package baekjoon.BJ_24444;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준알고리즘 24444번 알고리즘 수업 - 너비 우선 탐색1

public class Main {
    static int N, M, R;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        visited = new int[N+1];
        for (int i = 0; i <= N; i++)
            list.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list.get(A).add(B);
            list.get(B).add(A);

        }

        for (int i = 1; i <= N; i++)
            Collections.sort(list.get(i));
        bfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }

    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int cnt = 1;

        q.offer(start);
        visited[start] = cnt++;

        while (!q.isEmpty()) {
            int a = q.poll();

            for (int i = 0; i < list.get(a).size(); i++) {
                int nextV = list.get(a).get(i);

                if (visited[nextV] != 0)
                    continue;

                q.offer(nextV);
                visited[nextV] = cnt++;
            }
        }
    }
}
