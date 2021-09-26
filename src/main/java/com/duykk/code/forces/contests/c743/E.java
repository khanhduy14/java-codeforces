package com.duykk.code.forces.contests.c743;

import java.util.Scanner;

public class E {
  private static final Scanner scanner = new Scanner(System.in);
  private static final int[] a = new int[3000000];
  public static void main(String[] args) {
    int t = scanner.nextInt();

    while (t-- > 0) {
      int n = scanner.nextInt();

      for (int i = 1; i <= n; i++) {
        a[i] = scanner.nextInt();
      }
    }
  }
}
