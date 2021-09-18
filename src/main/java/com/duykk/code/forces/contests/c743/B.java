package com.duykk.code.forces.contests.c743;

import java.util.Scanner;

public class B {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int t = scanner.nextInt();

    for (int i = 0; i < t; i++) {
      int n = scanner.nextInt();

      int[] a = new int[n];
      int[] b = new int[n];


      for (int j = 0; j < n; j++) {
        a[j] = scanner.nextInt();
      }

      for (int j = 0; j < n; j++) {
        b[j] = scanner.nextInt();
      }

      int minA = a[0];
      int maxB = b[0];

      int result = 0;

      for (int j = 0; j < n; j++) {

        int tempA = Math.min(minA, a[j]);
        int tempB = Math.max(maxB, b[j]);
        if (tempA != minA) {
          result ++;
          minA = tempA;
        }
        if (tempB != maxB) {
          result ++;
          maxB = tempB;
        }


        if (minA < maxB) {
          System.out.println(result);
          break;
        }
      }
    }
  }
}
