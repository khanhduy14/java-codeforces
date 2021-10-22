package com.duykk.code.forces.contests.c746;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class B {
  private static final Scanner sc = new Scanner(System.in);
  private static final int[] a = new int[200000];
  public static void main(String[] args) {
    int t = sc.nextInt();

    while (t-- > 0) {
      int n = sc.nextInt();
      int x = sc.nextInt();

      List<Integer> sortList = new ArrayList<>();

      boolean flag = true;
      int max = 0;
      int min = 1000000000;
      for (int i = 1; i <= n; i++) {
        a[i] = sc.nextInt();
        sortList.add(a[i]);
        min = Math.min(a[i], min);
        max = Math.max(a[i], max);
        if (a[i] < a[i - 1]) {
          flag = false;
        }
      }

      if (flag) {
        System.out.println("YES");
        continue;
      }

      if (x <= n/2) {
        System.out.println("YES");
        continue;
      }

      sortList.sort(Comparator.naturalOrder());

      flag = true;
      for (int i = n - x + 1; i <= x; i++) {
        if (a[i] != sortList.get(i - 1)) {
          flag = false;
          break;
        }
      }

      System.out.println(flag ? "YES" : "NO");
    }
  }
}