#include <bits/stdc++.h>

using namespace std;
int n;
char s1[200];
char s2[200];


int main() {

    int t;
    cin >> t;
    while (t--) {
        cin >> n;
        cin >> s1;
        cin >> s2;

        bool flag = true;
        for (int i = 0; i < n; ++i) {
            if (s1[i] == s2[i] && s1[i] == '1') {
                flag = false;
                break;
            }
        }

        if (flag) cout << "YES" << endl;
        else cout << "NO" << endl;
    }
    return 0;
}