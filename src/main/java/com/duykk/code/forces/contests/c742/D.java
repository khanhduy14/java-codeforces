package com.duykk.code.forces.contests.c742;

import java.util.Scanner;

public class D {
  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int t = scanner.nextInt();
    for (int i = 0; i < t; i++) {
      int s = scanner.nextInt();
      int n = scanner.nextInt();

      if (n == 1) System.out.println(s);
      else {
        int log10 = (int) Math.log10(s);
        if (s % Math.pow(log10, 10) == 0) {
          for (int j = log10 - 1; j > 0 ; j--) {

          }
        }
      }
    }
  }
}
