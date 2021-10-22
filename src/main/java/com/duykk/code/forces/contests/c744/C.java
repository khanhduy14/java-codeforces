package com.duykk.code.forces.contests.c744;

import java.util.Scanner;

public class C {
  private static final Scanner scanner = new Scanner(System.in);
  private static final char[][] a = new char[20][30];
  private static int[][] s = new int[20][30];

  public static void main(String[] args) {
    int t = scanner.nextInt();

    while (t-- > 0) {
      s = new int[20][30];
      int n = scanner.nextInt();
      int m = scanner.nextInt();
      int k = scanner.nextInt();


      for (int i = 0; i < n; i++) {
        a[i] = scanner.next().toCharArray();
      }

      System.out.println(check(n, m, k));
    }
  }

  private static String check(int n, int m, int k) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == '*') {
          cal(i, j, m, k);
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i][j] == '*' && s[i][j] != 1) {
          return "NO";
        }
      }
    }

    return "YES";
  }

  private static void cal(int x, int y, int m, int k) {
    int i = 1;
    while (true) {
      if (x - i >= 0 && y - i >= 0 && y + i < m && a[x-i][y-i] == '*' && a[x-i][y+i] == '*') i++;
      else break;
    }
    i--;
    if (i < k) return;

    for (int j = 0; j <= i; j++) {
      s[x-j][y-j] = 1;
      s[x-j][y+j] = 1;
    }
  }
}
