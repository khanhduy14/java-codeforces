package com.duykk.code.forces.contests.c743;

import java.util.Scanner;

public class A {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int t = scanner.nextInt();

    for (int i = 0; i < t; i++) {
      int n = scanner.nextInt();
      String s = scanner.next();

      char[] array = s.toCharArray();
      int result = 0;
      for (int j = 0; j < n - 1; j++) {
        if (array[j] != '0') {
          int c = array[j];
          result += c + 1 - 48;
        }
      }

      result += array[n-1] - 48;

      System.out.println(result);
    }
  }
}
