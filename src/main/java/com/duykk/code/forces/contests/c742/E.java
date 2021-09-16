package com.duykk.code.forces.contests.c742;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class E {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    int n = scanner.nextInt();
    int q = scanner.nextInt();

    List<Integer> array = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      array.add(scanner.nextInt());
    }

    List<Integer> compareList = new LinkedList<>();
    for (int i = 0; i < n - 1; i++) {
      if (array.get(i + 1) >= array.get(i)) compareList.add(1);
      else compareList.add(0);
    }

    for (int i = 0; i < q; i++) {
      int t = scanner.nextInt();
      if (t == 1) {
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        array.set(x - 1, y);

        if (x > 1) {
          if (y >= array.get(x - 2)) compareList.set(x - 2, 1);
          else compareList.set(x - 2, 0);
        }

        if (x < n) {
          if (y <= array.get(x)) compareList.set(x - 1, 1);
          else compareList.set(x - 1, 0);
        }

      } else {
        int l = scanner.nextInt();
        int r = scanner.nextInt();

        int result = r - l + 1;
        int temp = 0;
        for (int j = l - 1; j < r - 1; j++) {
          if (compareList.get(j) == 1) {
            result += 1;
            temp += 1;
          } else {
            result += temp * (temp - 1) / 2;
            temp = 0;
          }
        }

        if (temp != 0) {
          result += temp * (temp - 1) / 2;
        }

        System.out.println(result);
      }
    }
  }
}
