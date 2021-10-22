#include <bits/stdc++.h>

using namespace std;
string n;

int main() {

    int t;
    cin >> t;
    while (t--) {
        cin >> n;
        int l = n.length();
        char char_array[l + 1];

        strcpy(char_array, n.c_str());

        int x0 = -1, x5 = -1;
        int result1 = 9999;
        int result2 = 9999;

        for (int i = l - 1; i >= 0; --i) {
            char a = char_array[i];

            if (a == '0' && x0 == -1) {
                x0 = i;
                continue;
            }
            if ((a == '0' || a == '5') && x0 > -1) {
                result1 = l - 2 - i;
                break;
            }
        }

        for (int i = l - 1; i >= 0; --i) {
            char a = char_array[i];

            if (a == '5' && x5 == -1) {
                x5 = i;
                continue;
            }
            if ((a == '2' || a == '7') && x5 > -1) {
                result2 = l - 2 - i;
                break;
            }
        }

        cout << min(result1, result2) << endl;
    }
    return 0;
}