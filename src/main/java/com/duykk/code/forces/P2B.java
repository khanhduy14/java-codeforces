package com.duykk.code.forces;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class P2B {
  static Scanner scanner = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  static class Temp {
    private final Integer num;
    private final String result;

    Temp(Integer num, String result) {
      this.num = num;
      this.result = result;
    }

    public int getNum() {
      return num;
    }

    public String getResult() {
      return result;
    }
  }

  public static void main(String[] args) throws IOException {
    int n = scanner.nextInt();
    int i = 0;
    ArrayList<Integer> list2 = new ArrayList<>();
    ArrayList<Integer> list5 = new ArrayList<>();
    while (i < n*n) {
      long a = scanner.nextLong();
      list2.add(calculate(a ,2));
      list5.add(calculate(a ,5));
      ++i;
    }
    Temp temp2 = minWay(list2, n);
    Temp temp5 = minWay(list5, n);
    if (temp2.getNum() > temp5.getNum()) {
      out.println(temp5.getNum());
      out.println(temp5.getResult());
    } else {
      out.println(temp2.getNum());
      out.println(temp2.getResult());
    }
    out.close();
  }

  private static int calculate(long a, int b) {
    int result = 0;
    while (a % b == 0) {
      a = a / b;
      result ++;
    }

    return result;
  }

  private static Temp minWay(ArrayList<Integer> list, Integer n) {
    StringBuilder result = new StringBuilder();
    ArrayList<Integer> listNum = new ArrayList<>();
    ArrayList<Integer> listWay = new ArrayList<>();
    for (int i = 0; i < n*n; i++) {
      if (i == 0) {
        listNum.add(list.get(i));
        listWay.add(0);
      } else {
        if (i % n == 0) {
          listNum.add(listNum.get(i-n) + list.get(i));
          listWay.add(1);
          continue;
        }
        if (i > n) {
          if (listNum.get(i-1) > listNum.get(i-n)) {
            listNum.add(listNum.get(i-n) + list.get(i));
            listWay.add(1);
          } else {
            listNum.add(listNum.get(i-1) + list.get(i));
            listWay.add(0);
          }
        } else {
          listNum.add(listNum.get(i-1) + list.get(i));
          listWay.add(0);
        }
      }
    }

    int j = n*n - 1;
    ArrayList<String> resultList = new ArrayList<>();
    while (j > 0) {
      if (listWay.get(j) == 1) {
        resultList.add("D");
        j = j - n;
      } else {
        resultList.add("R");
        j = j - 1;
      }
    }

    for (int i = resultList.size() - 1; i >= 0 ; i--) {
      result.append(resultList.get(i));
    }

    return new Temp(listNum.get(n*n - 1), result.toString());
  }
}
