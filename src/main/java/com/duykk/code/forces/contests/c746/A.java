package com.duykk.code.forces.contests.c746;


import java.util.*;

public class A {
  private static final Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    int t = sc.nextInt();
    while (t-- > 0) {

      int n = sc.nextInt();
      int h = sc.nextInt();

      int max1 = 0;
      int max2 = 0;

      for (int i = 0; i < n; i++) {
        int temp = sc.nextInt();
        if (temp > max1) {
          max2 = max1;
          max1 = temp;
        }
        else if (temp > max2) max2 = temp;
      }


      int result = h / (max1 + max2);

      if (h == result * (max1 + max2)) result = 2 * result;
      else if (h - max1 <= result * (max1 + max2)) result = 2 * result + 1;
      else if (h - max1 - max2 <= result * (max1 + max2)) result = 2 * result + 2;

      System.out.println(result);

    }
  }
}
