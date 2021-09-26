package com.duykk.code.forces.contests.c743;


import java.util.ArrayDeque;
import java.util.Scanner;

public class D {
  private static final Scanner scanner = new Scanner(System.in);
  private static int[] a = new int[2000500];
  private static int[] s = new int[2000500];
  private static ArrayDeque<Integer> q = new ArrayDeque<>();
  public static void main(String[] args) {
    int t = scanner.nextInt();

    while (t-- > 0) {
      int n = scanner.nextInt();


      for (int i = 1; i <= n; i++) {
        a[i] = scanner.nextInt();
        s[i] = a[i] ^ s[i - 1];
      }

      if (s[n] == 0) {
        if ((n & 1) == 1) out(1, n);
        else {
          for (int i = 1; i <= n; i += 2) {
            if (s[i] == 0) {
              out(1, i);
              out(i + 1, n);
              break;
            }
          }
        }
      }

      if (q.size() > 0) {
        System.out.println("YES");
        System.out.println(q.size());
        while (!q.isEmpty()) {
          System.out.print(q.poll() + " ");
        }
        System.out.print("\n");
      } else {
        System.out.println("NO");
      }

    }
  }

  private static void out(int l, int r) {
    for (int i = r - 2; i >= l ; i -= 2) {
      q.push(i);
    }
    for (int i = l; i < r; i += 2) {
      q.push(i);
    }
  }
}
