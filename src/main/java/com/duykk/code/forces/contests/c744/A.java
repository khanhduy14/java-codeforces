package com.duykk.code.forces.contests.c744;

import java.util.Scanner;

public class A {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int t = scanner.nextInt();

    while (t-- > 0) {
      String s = scanner.next();
      char[] chars = s.toCharArray();

      int l = s.length();
      if (l % 2 == 1) {
        System.out.println("NO");
        continue;
      }

      int b = 0;
      for (char ch :
          chars) {
        if (ch == 'B') b++;
      }

      if (b != l/2) System.out.println("NO");
      else System.out.println("YES");
    }
  }
}
