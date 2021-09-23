package com.duykk.code.forces.contests.educational114;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
//    int t = scanner.nextInt();
//    while (t-- > 0) {
//      int a = scanner.nextInt();
//      int b = scanner.nextInt();
//      int c = scanner.nextInt();
//      int m = scanner.nextInt();
//
//      int other = a + b + c - Math.max(a, Math.max(b, c));
//      int L = a + b + c - 1 - 2 * other;
//      int R = a - 1 + b - 1 + c - 1;
//
//      String result = L <= m && m <= R ? "YES" : "NO";
//      System.out.println(result);
//    }

    ArrayList<ArrayList<Integer>> aroundXs = new ArrayList<>();

    aroundXs.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));



    aroundXs.get(0).add(5);
    System.out.println(aroundXs.get(0));
  }
}
