package com.duykk.code.forces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Math.pow;

public class P1BSpreadsheets {
  static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  static PrintWriter out = new PrintWriter(System.out);

  public static void main(String[] args) throws IOException {
    String[] p = in.readLine().split("\\s");
    long n = Long.parseLong(p[0]);
    int count = 0;
    while (count < n) {
      char[] temp = in.readLine().toCharArray();
      boolean f = false;

      for (int i = 0; i < temp.length; i++) {
        if ((int)temp[1] < 65 && i > 1 && (int) temp[i] >= 65) {
          f = true;
          break;
        }
      }
      if (!f) {
        long y = 0;
        StringBuilder xString = new StringBuilder();
        long m = 0;
        for (char c : temp) {
          if ((int) c >= 65) {
            m++;
          } else {
            break;
          }
        }
        for (int i = 0; i < temp.length; i++) {
          if ((int) temp[i] >= 65) {
            y = (long) (y + (temp[i] - 64) * pow(26, m - i - 1));
          } else {
            xString.append(temp[i]);
          }
        }
        out.println("R" + xString + "C" + y);
      } else {
        StringBuilder xString = new StringBuilder();
        StringBuilder yString = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < temp.length; i++) {
          if (temp[i] == 'R') {
            continue;
          }

          if (temp[i] == 'C') {
            flag = false;
            continue;
          }

          if (flag) xString.append(temp[i]);
          if (!flag) {
            yString.append(temp[i]);
          }
        }
        long y = Long.parseLong(String.valueOf(yString));

        StringBuilder result = new StringBuilder();
        while (y > 0) {
          char c = (char) ((y-1)%26 + 64 + 1);
          y = (y - (y-1)%26 - 1) / 26;
          result.append(c);
        }
        out.println(result.reverse().toString() + xString);
      }


      count++;
    }
    out.close();
  }
}
