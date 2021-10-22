#include <bits/stdc++.h>

using namespace std;
long long a[200010];
long long m, x, y, sum, t;
int n;

long long f(long long x_) {
    if (x_ > 0) return x_;
    return 0;
}

int main() {

    cin >> n;
    for (int i = 0; i < n; ++i) {
        scanf("%lld",&a[i]);
        sum += a[i];
    }
    sort(a, a + n);

    for (cin >> m; m > 0; m --) {
        scanf("%lld%lld",&x,&y);
        t = lower_bound(a + 1, a + n, x) - a;
        cout << min(f(x - a[t]) + f(y + a[t] - sum), f(x - a[t - 1]) + f(y + a[t - 1] - sum)) << endl;
    }

    return 0;
}