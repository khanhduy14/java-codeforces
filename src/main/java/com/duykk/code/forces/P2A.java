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
    String winner = "";
    LinkedList<String> linkedList = new LinkedList<>();
    long second = 0;
    long maxScore = 0;
    while (i < n) {
      String name = scanner.next();
      long score = scanner.nextLong();

      if (map.get(name) == null) {
        map.put(name, score);
        if (score > maxScore) {
          second = maxScore;
          maxScore = score;
          winner = name;
          linkedList.add(name);
        }
      } else {
        long currScore = map.get(name) + score;
        map.put(name, currScore);
        if (score < 0 && winner.equals(name)) {
          if (currScore < second)
        }
        if (currScore > maxScore) {
          second = maxScore;
          maxScore = currScore;
          winner = name;
          linkedList.add(name);
        }
      }
      ++i;
    }
    out.println(winner);
    out.close();
  }
}
