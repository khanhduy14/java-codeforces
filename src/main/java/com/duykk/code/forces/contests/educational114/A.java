package com.duykk.code.forces.contests.educational114;

import java.util.Scanner;

public class A {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
      int t = scanner.nextInt();

      while (t-- > 0) {
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
          for (int j = 0; j < i; j++) {
            System.out.print("(");
          }

          for (int j = 0; j < (n - i); j++) {
            System.out.print("()");
          }

          for (int j = 0; j < i; j++) {
            System.out.print(")");
          }

          System.out.print("\n");
        }
      }
  }
}
