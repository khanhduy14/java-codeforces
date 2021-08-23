package com.duykk.code.forces;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class P2A {
  static Scanner scanner = new Scanner(System.in);
  static PrintWriter out = new PrintWriter(System.out);

  public static void main(String[] args) throws IOException {
    long n = scanner.nextLong();
    long i = 0;
    Map<String, Long> map = new HashMap<>();
    Map<String, Long> map1 = new HashMap<>();
    String winner = "";
    LinkedList<String> nameList = new LinkedList<>();
    LinkedList<Long> scoreList = new LinkedList<>();
    long maxScore = 0;
    while (i < n) {
      String name = scanner.next();
      long score = scanner.nextLong();

      if (map.get(name) == null) {
        map.put(name, score);
      } else {
        long currScore = map.get(name) + score;
        map.put(name, currScore);
      }
      nameList.add(name);
      scoreList.add(score);
      ++i;
    }
    for (String key : map.keySet()) {
      maxScore = Math.max(maxScore, map.get(key));
    }

    for (int j = 0; j < n; j++) {
      if (map1.get(nameList.get(j)) == null) {
        map1.put(nameList.get(j), scoreList.get(j));
      } else {
        long score = map1.get(nameList.get(j)) + scoreList.get(j);
        map1.put(nameList.get(j), score);
      }

      if (map1.get(nameList.get(j)) >= maxScore && map.get(nameList.get(j)) == maxScore) {
        out.println(nameList.get(j));
        break;
      }
    }
    out.close();
  }
}
