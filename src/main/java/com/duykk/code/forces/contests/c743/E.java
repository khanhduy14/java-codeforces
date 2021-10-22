package com.duykk.code.forces.contests.c743;

import java.util.ArrayList;
import java.util.Scanner;

public class E {
  private static final Scanner scanner = new Scanner(System.in);
  private static final int[] a = new int[3050];
  private static final int[][] dp = new int[3050][3050];
  public static void main(String[] args) {
    int t = scanner.nextInt();


    while (t-- > 0) {
      int n = scanner.nextInt();
      ArrayList<ArrayList<Integer>> pos = new ArrayList<>();

      for (int i = 0; i <= n; i++) {
        pos.add(new ArrayList<>());
      }

      for (int i = 1; i <= n; i++) {
        a[i] = scanner.nextInt();
        pos.get(a[i]).add(i);
      }

      for (int i = n; i >= 1 ; i--) {
        for (int j = i; j <= n ; j++) {
          dp[i][j] = (i == j ? 1 : dp[i+1][j] + 1);

          for (Integer k : pos.get(a[i])) {
            if (k <= i || k > j) continue;
            dp[i][j] = Math.min(dp[i][j], (i + 2 <= k ? dp[i+1][k-1] : 0) + dp[k][j]);
          }
        }
      }

      System.out.println(dp[1][n] - 1);
    }
  }
}
