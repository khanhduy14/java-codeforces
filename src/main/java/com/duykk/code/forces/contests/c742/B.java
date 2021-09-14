package com.duykk.code.forces.contests.c742;

import java.util.Scanner;

public class B {
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int n = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();

      int xorToA = new B().computeXOR(a - 1);

      if ((xorToA^b) == 0) {
        System.out.println(a);
      } else if ((xorToA^b) == a) {
        System.out.println(a + 2);
      } else {
        System.out.println(a + 1);
      }
    }
  }

  private int computeXOR(int n)
  {
    if (n % 4 == 0)
      return n;

    if (n % 4 == 1)
      return 1;

    if (n % 4 == 2)
      return n + 1;

    return 0;
  }
}

