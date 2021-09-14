package com.duykk.code.forces.contests.c742;

import java.util.Scanner;

public class A {
  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int n = scanner.nextInt();
    for (int i = 0; i < n; i++) {
      int width = scanner.nextInt();
      String s = scanner.next();

      String result = "";
      if (s.contains("U")) {
        result = s.replace("U", "D");
      } else {
        result = s.replace("D", "U");
      }

      System.out.println(result);
    }
  }
}
