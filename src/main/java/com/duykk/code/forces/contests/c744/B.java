package com.duykk.code.forces.contests.c744;

import java.util.Arrays;
import java.util.Scanner;

public class B {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int t = scanner.nextInt();

    while (t-- > 0) {
      int n = scanner.nextInt();
      int x = 0;
      int [][] result = new int[n][3];
      int[] a = new int[n];
      int[] origin = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scanner.nextInt();
        origin[i] = a[i];
      }


      Arrays.sort(a);

      for (int i = 0; i < n; i++) {
        if (a[i] != origin[i]) {
          int j = i;
          while (origin[j] > a[i]) j++;
          result[x][0] = i + 1;
          result[x][1] = j + 1;
          result[x][2] = j - i;

          while (j > i) {
            origin[j] = origin[j - 1];
            j --;
          }
          x ++;
          origin[i] = a[i];
        }
      }

      System.out.println(x);
      for (int i = 0; i < x; i++) {
        System.out.println(result[i][0] + " " + result[i][1] + " " + result[i][2]);
      }
    }
  }
}
