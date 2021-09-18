package com.duykk.code.forces.contests.c742;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class E {

  private static int[] a;
  private static Node[] nodes;

  private static void run() throws IOException {
    int n, q;
    n = in.nextInt();
    q = in.nextInt();
    a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }

    nodes = new Node[4 * n + 10];
    init(0, n - 1, 1);

    for (int ca = 0; ca < q; ca++) {
      int t = in.nextInt();
      int l = in.nextInt();
      int r = in.nextInt();
      if (t == 1) {
        update(l - 1, r, 1);
      } else {
        out.println(query(l - 1, r - 1, 1));
      }
    }
  }

  private static long query(int left, int right, int p) {
    if (nodes[p].left == left && nodes[p].right == right) {
      return nodes[p].ans;
    }

    int mid = (nodes[p].left + nodes[p].right) >> 1;
    if (right <= mid) {
      return query(left, right, p * 2);
    } else if (left > mid) {
      return query(left, right, p * 2 + 1);
    } else {
      long ans = query(left, mid, p * 2) + query(mid + 1, right, p * 2 + 1);
      if (a[nodes[p * 2].right] <= a[nodes[p * 2 + 1].left]) {
        long left_options = Math.min(nodes[p * 2].right_size, mid - left + 1);
        long right_options = Math.min(nodes[p * 2 + 1].left_size, right - (mid + 1) + 1);
        ans += left_options * right_options;
      }
      return ans;
    }
  }

  private static void update(int x, int y, int p) {
    if (nodes[p].left == x && nodes[p].right == x) {
      a[x] = y;
      return;
    }

    int mid = (nodes[p].left + nodes[p].right) >> 1;
    if (x <= mid) {
      update(x, y, p * 2);
    } else {
      update(x, y, p * 2 + 1);
    }

    nodes[p].left_size = get_left_size(p);
    nodes[p].right_size = get_right_size(p);
    nodes[p].ans = nodes[p * 2].ans + nodes[p * 2 + 1].ans + get_ans_in_cross(p);
  }

  private static void init(int left, int right, int p) {
    nodes[p] = new Node();
    nodes[p].left = left;
    nodes[p].right = right;
    if (left == right) {
      nodes[p].left_size = 1;
      nodes[p].right_size = 1;
      nodes[p].ans = 1;
      return;
    }

    int mid = (left + right) >> 1;
    init(left, mid, p * 2);
    init(mid + 1, right, p * 2 + 1);

    nodes[p].left_size = get_left_size(p);
    nodes[p].right_size = get_right_size(p);
    nodes[p].ans = nodes[p * 2].ans + nodes[p * 2 + 1].ans + get_ans_in_cross(p);
  }

  private static long get_ans_in_cross(int p) {
    int left_child = p * 2;
    int right_child = left_child + 1;
    if (a[nodes[left_child].right] <= a[nodes[right_child].left]) {
      return nodes[left_child].right_size * nodes[right_child].left_size;
    } else {
      return 0;
    }
  }

  private static long get_left_size(int p) {
    int left_child = p * 2;
    int right_child = left_child + 1;
    if (nodes[left_child].left_size == nodes[left_child].get_total_size() && a[nodes[left_child].right] <= a[nodes[right_child].left]) {
      return nodes[left_child].left_size + nodes[right_child].left_size;
    } else {
      return nodes[left_child].left_size;
    }
  }

  private static long get_right_size(int p) {
    int left_child = p * 2;
    int right_child = left_child + 1;
    if (nodes[right_child].right_size == nodes[right_child].get_total_size() && a[nodes[left_child].right] <= a[nodes[right_child].left]) {
      return nodes[left_child].right_size + nodes[right_child].right_size;
    } else {
      return nodes[right_child].right_size;
    }
  }

  private static class Node {
    int left, right;
    long left_size, right_size, ans;

    private int get_total_size() {
      return this.right - this.left + 1;
    }
  }

  public static void main(String[] args) throws IOException {
    in = new Reader();
    out = new PrintWriter(new OutputStreamWriter(System.out));

//        int t = in.nextInt();
//        for (int i = 0; i < t; i++) {
//        }
    run();

    out.flush();
    in.close();
    out.close();
  }

  static final long mod = 1000000007;



  @SuppressWarnings("FieldCanBeLocal")
  private static Reader in;
  private static PrintWriter out;

  static class Reader {
    private static final int BUFFER_SIZE = 1 << 16;
    private final DataInputStream din;
    private final byte[] buffer;
    private int bufferPointer, bytesRead;

    Reader() {
      din = new DataInputStream(System.in);
      buffer = new byte[BUFFER_SIZE];
      bufferPointer = bytesRead = 0;
    }

    public int nextInt() throws IOException {
      int ret = 0;
      byte c = read();
      while (c <= ' ') {
        c = read();
      }
      final boolean neg = c == '-';
      if (neg) {
        c = read();
      }
      do {
        ret = ret * 10 + c - '0';
      } while ((c = read()) >= '0' && c <= '9');

      if (neg) {
        return -ret;
      }
      return ret;
    }




    private void fillBuffer() throws IOException {
      bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
      if (bytesRead == -1) {
        buffer[0] = -1;
      }
    }

    private byte read() throws IOException {
      if (bufferPointer == bytesRead) {
        fillBuffer();
      }
      return buffer[bufferPointer++];
    }

    public void close() throws IOException {
      din.close();
    }

  }
}