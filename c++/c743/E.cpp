#include <bits/stdc++.h>

using namespace std;
const int N = 3050;
int n, a[N], dp[N][N];
vector<int> pos[N];

int main() {
    int t;
    cin >> t;
    while (t--) {
        cin >> n;
        for (int i = 1; i <= n; i++)pos[i].clear();
        for (int i = 1; i <= n; i++) {
            cin >> a[i];
            pos[a[i]].push_back(i);
        }
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                dp[i][j] = (i == j ? 1 : dp[i + 1][j] + 1);
                for (int k: pos[a[i]]) {
                    if (k <= i || k > j)continue;
                    dp[i][j] = min(dp[i][j], (i + 2 <= k ? dp[i + 1][k - 1] : 0) + dp[k][j]);
                }
            }
        }
        cout << dp[1][n] - 1 << endl;
    }
    return 0;
}