package com.duykk.code.forces.contests.c743;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class C {
  private static final Scanner scanner = new Scanner(System.in);
  public static void main(String[] args) throws IOException {
    int t = Integer.parseInt(scanner.nextLine());
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(scanner.nextLine());

      ArrayList<ArrayList<String>> input = new ArrayList<>();

      for (int j = 0; j < n; j++) {
        String s = scanner.nextLine();
        String[] array = s.split(" ");

        input.add(new ArrayList<>(Arrays.asList(array)));

      }
    }
  }
}
