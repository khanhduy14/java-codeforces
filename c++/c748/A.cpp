#include <bits/stdc++.h>

using namespace std;
int a, b, c;

int main() {

    int t;
    cin >> t;
    while (t--) {
        cin >> a >> b >> c;
        int m = max(a, max(b, c));
        cout << (m == a && m != b && m != c ? 0 : m - a + 1) << " " << (m == b && m != a && m != c ? 0 : m - b + 1) << " " << (m == c && m != b && m != a ? 0 : m - c + 1) << endl;
    }
    return 0;
}