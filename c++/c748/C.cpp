#include <bits/stdc++.h>

using namespace std;
int n, k;


int main() {

    int t;
    cin >> t;
    while (t--) {
        priority_queue<int> a;
        cin >> n >> k;
        int m = n;
        for (int i = 0; i < k; ++i) {
            int temp;
            cin >> temp;
            a.push(temp);
        }

        int cat = 0;
        int result = 0;
        while (!a.empty()) {
            int temp = a.top();

            if (cat < temp) {
                cat = cat + (m - temp);
                result ++;
                a.pop();
            } else {
                break;
            }
        }

        cout << result << endl;
    }
    return 0;
}