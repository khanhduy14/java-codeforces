package com.duykk.code.forces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

import static java.lang.Math.ceil;

public class P1BSpreadsheets {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static PrintWriter out = new PrintWriter(System.out);

  public static void main(String[] args) throws IOException {
    String[] p = in.readLine().split("\\s");
    long n = Long.parseLong(p[0]);
    int count = 0;
    while (count < n) {
      String[] temp = in.readLine().split("\\s");
      out.print(Arrays.toString(temp));
      count++;
    }
    char c = 'A';
    out.print((int) c);
    out.close();
  }
}
