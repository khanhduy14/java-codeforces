package com.duykk.code.forces.contests.c742;

import java.util.Scanner;

public class D {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int t = scanner.nextInt();
    for (int i = 0; i < t; i++) {
      int s = scanner.nextInt();
      int n = scanner.nextInt();

      solve(s, n);
    }
  }

  private static int digit(int s) {

    return (int) Math.pow(10, (int) Math.log10(s));
  }

  private static void solve(int s, int n) {
    if (n == 1) System.out.println(s);

    else if ((s - digit(s)) >= n - 1) {
      System.out.print(digit(s) + " ");
      solve(s - digit(s), n-1);
    } else if ((s - digit(s)/10) >= n - 1) {
      System.out.print(digit(s)/10 + " ");
      solve(s - digit(s)/10, n-1);
    } else {
      System.out.print(digit(s)/100 + " ");
      solve(s - digit(s)/100, n-1);
    }
  }
}
