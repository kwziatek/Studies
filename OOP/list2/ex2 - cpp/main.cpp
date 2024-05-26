#include "trojkatpascala.h"
#include <vector>
#include <string>
#include <iostream>

int main(int liczbael, char* tablicael[]) {
    int n;
    try {
        n = stoi(tablicael[1]);
    } catch (invalid_argument &e) {
        cout << tablicael[1] << " - nieprawidlowy zakres" << endl;
        return 1;
    }

    vector<string> tablicaarg;
    for (int i = 2; i < liczbael; ++i) {
        tablicaarg.push_back(tablicael[i]);
        //cout<<tablicael[i]<<" ";
    }

    WierszTrojkataPascala pascal(n);
    pascal.SymbolNewtona(n);
    pascal.trojkat(n, tablicaarg);

    return 0;
}