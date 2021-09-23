package com.duykk.code.forces.contests.c742;

import javafx.util.Pair;

import java.util.*;

public class F {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    String[] nm = scanner.nextLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);

    String[][] input = new String[n][m];

    for (int i = 0; i < n; i++) {
      String[] row = scanner.nextLine().split("");
      for (int j = 0; j < m; j++) {
        input[i][j] = row[j];
      }
    }

    ArrayList<ArrayList<Integer>> aroundXs = new ArrayList<>(n*m);

    for (int i = 0; i < n * m; i++) {
      aroundXs.add(new ArrayList<>());
    }

    for (int i = 1; i < n - 1; i++) {
      for (int j = 1; j < m - 1; j++) {
        if (input[i][j].equals("X")) {
          List<Integer> aroundX = new ArrayList<>();
          for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (input[x][y].equals(".")) {
              aroundX.add(x*m + y);
            }
          }

          if (aroundX.size() % 2 != 0) {
            System.out.println("NO");
            return;
          } else if (aroundX.size() == 2) {
            aroundXs.get(aroundX.get(0)).add(aroundX.get(1));
            aroundXs.get(aroundX.get(1)).add(aroundX.get(0));
          } else if (aroundX.size() == 4) {
            aroundXs.get(aroundX.get(0)).add(aroundX.get(1));
            aroundXs.get(aroundX.get(1)).add(aroundX.get(0));
            aroundXs.get(aroundX.get(2)).add(aroundX.get(3));
            aroundXs.get(aroundX.get(3)).add(aroundX.get(2));
          }
        }
      }
    }

    ArrayList<ArrayList<Integer>> finalVector = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      ArrayList<Integer> temp = new ArrayList<>();
      for (int j = 0; j < m; j++) {
        temp.add(-1);
      }
      finalVector.add(temp);
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (finalVector.get(i).get(j) == -1 && input[i][j].equals(".")) {
          finalVector.get(i).set(j, 1);

          Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();
          queue.add(new Pair<>(i, j));

          while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int x = pair.getKey();
            int y = pair.getValue();

            int v = x*m + y;

            for (int w : aroundXs.get(v)) {
              int x2 = w/m;
              int y2 = w % m;

              if (finalVector.get(x2).get(y2) == -1) {
                finalVector.get(x2).set(y2, 5 - finalVector.get(x).get(y));
                queue.add(new Pair<>(x2, y2));
              }
            }
          }
        }
      }
    }

    for (int i = 1; i < n - 1; i++) {
      for (int j = 1; j < m - 1; j++) {

        if (input[i][j].equals("X")) {
          finalVector.get(i).set(j, 0);
          for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (input[x][y].equals(".")) {
              int temp = finalVector.get(i).get(j) + finalVector.get(x).get(y);
              finalVector.get(i).set(j, temp);
            }
          }
        }
      }
    }

    System.out.println("YES");

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        System.out.print(finalVector.get(i).get(j));
        if (j < m - 1) {
          System.out.print(" ");
        }
      }
      System.out.print("\n");
    }

  }

}
