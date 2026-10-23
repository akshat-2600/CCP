#include <bits/stdc++.h>
using namespace std;

int main() {
    int n;
    cin >> n;
    
    string s;
    cin >> s;
    
    int i = 0;
    int count = 1;
    string ans;
    while (i < n) {
        ans.push_back(s[i]);
        count++;
        i += count; 
    }
    cout << ans << endl;
}