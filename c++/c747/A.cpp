#include <bits/stdc++.h>

using namespace std;
long long n;

int main() {

    int t;
    cin >> t;
    while (t--) {
        cin >> n;
        if (n % 2 == 1) {
            cout << n/2 << " " << n/2 + 1 << endl;
        } else {
            for (int i = 3; i <= 2*n; i+=2) {
                if (i % 2 == 0) {
                    if ((n - i/2) % i == 0) {
                        cout << (n - i/2) / i - i/2 + 1 << " " << (n + i/2) / i + i/2 - 1 << endl;
                        break;
                    }
                } else {
                    if (n % i == 0) {
                        cout << n/i - i/2 << " " << n/i + i/2 << endl;
                        break;
                    }
                }
            }
        }
    }
    return 0;
}