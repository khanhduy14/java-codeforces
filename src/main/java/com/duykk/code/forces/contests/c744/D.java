package com.duykk.code.forces.contests.c744;

import javafx.util.Pair;

import java.util.*;

public class D {
  private static final Scanner sc = new Scanner(System.in);
  private static final int[] a = new int[200000];

  public static void main(String[] args) {
    int t = sc.nextInt();


    while (t-- > 0) {
      int n = sc.nextInt();
      List<Pair<Integer, Integer>> result = new ArrayList<>();
      PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(n, Collections.reverseOrder(Comparator.comparingInt(Pair::getValue)));
      for (int i = 0; i < n; i++) {
        int x = sc.nextInt();
        if (x > 0) {
          pq.add(new Pair<>(i, x));
        }
      }


      while (pq.size() > 1) {
        Pair<Integer, Integer> first = pq.poll();
        Pair<Integer, Integer> second = pq.poll();

        result.add(new Pair<>(first.getKey() + 1, second.getKey() + 1));
        if (first.getValue() > 1) {
          pq.add(new Pair<>(first.getKey(), first.getValue() - 1));
        }

        if (second.getValue() > 1) {
          pq.add(new Pair<>(second.getKey(), second.getValue() - 1));
        }
      }

      System.out.println(result.size());
      for (Pair<Integer, Integer> p : result) {
        System.out.println(p.getKey() + " " + p.getValue());
      }
    }
  }
}
