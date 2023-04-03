import java.util.*;

class SparseMatrix {
    private int n, m;
    private Node[] rows;

    public SparseMatrix(int[][] data) {
        n = data.length;
        m = data[0].length;
        rows = new Node[n];
        for (int i = 0; i < n; i++) {
            Node head = new Node(-1, -1, 0);
            Node tail = head;
            for (int j = 0; j < m; j++) {
                if (data[i][j] != 0) {
                    tail.next = new Node(i, j, data[i][j]);
                    tail = tail.next;
                }
            }
            rows[i] = head.next;
        }
    }

    public SparseMatrix add(SparseMatrix other) {
        if (n != other.n || m != other.m) {
            throw new IllegalArgumentException("Matrices must have the same dimensions");
        }
        int[][] data = new int[n][m];
        for (int i = 0; i < n; i++) {
            Node p = rows[i], q = other.rows[i];
            while (p != null || q != null) {
                int j, value;
                if (q == null || (p != null && p.j < q.j)) {
                    j = p.j;
                    value = p.value;
                    p = p.next;
                } else if (p == null || (q != null && q.j < p.j)) {
                    j = q.j;
                    value = q.value;
                    q = q.next;
                } else {
                    j = p.j;
                    value = p.value + q.value;
                    p = p.next;
                    q = q.next;
                }
                data[i][j] = value;
            }
        }
        return new SparseMatrix(data);
    }

    public SparseMatrix multiply(SparseMatrix other) {
        if (m != other.n) {
            throw new IllegalArgumentException("Matrices must have compatible dimensions");
        }
        SparseMatrix transposed = other.transpose();
        int[][] data = new int[n][other.m];
        for (int i = 0; i < n; i++) {
            Node p = rows[i];
            while (p != null) {
                int j = p.j;
                Node q = transposed.rows[j];
                while (q != null) {
                    int k = q.j;
                    data[i][k] += p.value * q.value;
                    q = q.next;
                }
                p = p.next;
            }
        }
        return new SparseMatrix(data);
    }

    public SparseMatrix transpose() {
        int[][] data = new int[m][n];
        for (int i = 0; i < n; i++) {
            Node p = rows[i];
            while (p != null) {
                int j = p.j;
                data[j][i] = p.value;
                p = p.next;
            }
        }
        return new SparseMatrix(data);
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            Node p = rows[i];
            for (int j = 0; j < m; j++) {
                if (p != null && p.j == j) {
                    System.out.printf("%d ", p.value);
                    p = p.next;
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    private static class Node {
        int i, j, value;
        Node next;

        Node(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[][] aData = {{0, 0, 1}, {0, 2, 0}, {3, 0, 0}};
        int[][] bData = {{0, 4, 0}, {0, 0, 5}, {6, 0, 0}};
        SparseMatrix a = new SparseMatrix(aData);
        SparseMatrix b = new SparseMatrix(bData);
        SparseMatrix s = a.add(b);
        SparseMatrix p = a.multiply(b);
        System.out.println("A:");
        a.print();
        System.out.println("B:");
        b.print();
        System.out.println("S = A + B:");
        s.print();
        System.out.println("P = A * B:");
        p.print();
    }
}