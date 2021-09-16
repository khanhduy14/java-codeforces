package com.duykk.code.forces.contests.c742;

import java.util.Scanner;

public class C {
  private static Scanner scanner = new Scanner(System.in);
  public static void main(String[] args) {
    int n = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      int sum = scanner.nextInt();
      int a = 0;
      int b = 0;
      int p = 1;
      while (sum > 0) {
        a += (sum % 10) * p;
        sum /= 10;
        b += (sum % 10) * p;
        sum /= 10;
        p *= 10;
      }

      int x = a + 1;
      int y = b + 1;
      System.out.println(x*y - 2);
    }
  }
}


