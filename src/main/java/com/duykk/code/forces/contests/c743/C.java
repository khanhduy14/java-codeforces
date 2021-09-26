package com.duykk.code.forces.contests.c743;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class C {
  private static final Scanner scanner = new Scanner(System.in);
  private static int[] vis = new int[200005];
  private static int[] f = new int[200005];
  private static boolean ok = false;

  private static ArrayList<ArrayList<Integer>> input;


  public static void main(String[] args) throws IOException {
    int t = scanner.nextInt();
    for (int i = 0; i < t; i++) {
      ok = false;
      input = new ArrayList<>();
      int n = scanner.nextInt();

      for (int j = 0; j < n + 1; ++j) {
        vis[j + 1] = 0;
      }

      input.add(new ArrayList<>());

      for (int j = 0; j < n; ++j) {
        int s = scanner.nextInt();
        ArrayList<Integer> temp = new ArrayList<>();
        while (s-- > 0) {
          temp.add(scanner.nextInt());
        }

        input.add(temp);
      }

      ArrayList<Integer> temp = new ArrayList<>();

      for (int j = 0; j < n; j++) {
        temp.add(j + 1);
      }

      input.add(temp);

      dfs(n + 1);

      int result = ok ? -1 : f[n + 1];

      System.out.println(result);
    }
  }

  private static int dfs(int u) {
    if (vis[u] == 1 || ok) {
      ok = true;
      return 0;
    }
    if (vis[u] == 2) return f[u];
    int ans = 1;
    vis[u] = 1;

    for (int i = 0; i < input.get(u).size(); ++i) {
      ans = Math.max(ans, dfs(input.get(u).get(i)) + (u < input.get(u).get(i) ? 1 : 0));
    }

    vis[u] = 2;
    return f[u] = ans;
  }
}
