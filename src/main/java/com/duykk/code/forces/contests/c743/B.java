package com.duykk.code.forces.contests.c743;

import java.util.Arrays;
import java.util.Scanner;

public class B {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int t = scanner.nextInt();

    for (int i = 0; i < t; i++) {
      int n = scanner.nextInt();

      int[] posa = new int[n*2 + 1];
      Arrays.fill(posa, n - 1);
      int[] posb = new int[n*2 + 1];
      Arrays.fill(posb, n - 1);
      int[] a = new int[n];
      int[] b = new int[n];


      for (int j = 0; j < n; j++) {
        int temp = scanner.nextInt();
        a[j] = temp;
        posa[temp] = j;
      }

      for (int j = 0; j < n; j++) {
        int temp = scanner.nextInt();
        b[j] = temp;
        posb[temp] = j;
      }

      if (a[0] < b[0]) System.out.println(0);
      else {
        for (int j = 2*n - 1; j >= 0 ; --j) {
          posb[j] = Math.min(posb[j], posb[j+1]);
        }

        int result = n - 1;
        for (int j = 1; j < 2*n; j += 2) {
          result = Math.min(result, posa[j] + posb[j]);
        }

        System.out.println(result);
      }
    }
  }
}
