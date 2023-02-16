package baekjoon.BJ_5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 백준 알고리즘 5639번 이진탐색트리

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num;
        Node node = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            num = br.readLine();
            if (num == null || num.equals(""))
                break;
            node.insert(Integer.parseInt(num));
        }
        postOrder(node);
    }

    static void postOrder(Node node) {
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
}

class Node {
    int num;
    Node left, right;

    Node(int num) {
        this.num = num;
    }

    Node(int num, Node left, Node right) {
        this.num = num;
        this.left = left;
        this.right = right;
    }

    void insert(int n) {
        if (n < this.num) {
            if (this.left == null)
                this.left = new Node(n);
            else this.left.insert(n);
        } else {
            if (this.right == null)
                this.right = new Node(n);
            else this.right.insert(n);
        }
    }
}
