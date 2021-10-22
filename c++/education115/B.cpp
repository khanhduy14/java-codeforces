#include <bits/stdc++.h>

using namespace std;
long long n;
int a[1001][6];
int c[6];


bool checkXOR(int string[], int string1[]);

int main() {

    int t;
    cin >> t;
    while (t--) {
        cin >> n;
        int b[6][n+1];
        if (n % 2 == 1) {
            cout << "NO" << endl;
            continue;
        }

        for (int i = 1; i <= 5; ++i) {
            c[i] = 0;
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= 5; ++j) {
                cin >> a[i][j];
            }
        }

        for (int i = 1; i <= 5; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (a[j][i] == 1) {
                    c[i]++;
                    b[i][j] = 1;
                } else {
                    b[i][j] = 0;
                }
            }
        }

        int result = 0;
        for (int i = 1; i < 5; ++i) {
            if (c[i] >= n/2) {
                for (int j = i + 1; j <= 5; ++j) {
                    if (checkXOR(b[i], b[j]) && c[j] >= n/2) {
                        result = 1;
                        goto ENDLOOP;
                    }
                }
            }
        }


        ENDLOOP: {
        if (result == 1) cout << "YES" << endl;
        else cout << "NO" << endl;
    };

    }
    return 0;
}

bool checkXOR(int string[], int string1[]) {
    for (int i = 1; i <= n; ++i) {
        if ((string[i] | string1[i]) == 0) return false;
    }

    return true;
}