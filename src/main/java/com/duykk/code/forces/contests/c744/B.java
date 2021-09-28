package com.duykk.code.forces.contests.c744;

import java.util.Scanner;

public class B {
  private static final Scanner scanner = new Scanner(System.in);

  private static final int[] a = new int[1000000000];
  public static void main(String[] args) {
    int t = scanner.nextInt();

    while (t-- > 0) {
      int n = scanner.nextInt();
      for (int i = 1; i <= n; i++) {
        a[i] = scanner.nextInt();
      }


    }
  }

  private static void shift(int l, int r) {

  }
}
