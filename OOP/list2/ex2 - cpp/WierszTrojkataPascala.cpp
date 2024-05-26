#include "trojkatpascala.h"
#include <iostream>
using namespace std;

int WierszTrojkataPascala::SymbolNewtona(int n) {
    for(int i=0; i<=n; i++){
        if(i==0){
            TrojkatPascala.push_back(1);
        }
        else {
            TrojkatPascala.push_back(TrojkatPascala[i-1] * (n - i + 1) / (i));
        }
    }
}

int WierszTrojkataPascala::wiersz(int m) {
    return TrojkatPascala.at(m);
}

void WierszTrojkataPascala::trojkat(int n, vector<string>& args) {
    if (n < 0) {
        cout << n << " - nieprawidlowy numer wiersza" << endl;
    }
    else {

        for (string& argument : args) {
            try {
                int x = stoi(argument); //zamiana na liczbę
                cout << wiersz(x) << endl;
            } catch (invalid_argument& e) { //wyjątek, gdy danej nie da sie zamienic na liczbę
                cout << argument << " - nieprawidlowa dana" << endl;
            } catch (out_of_range& e) { //wyjątek, gdy indeks przekracza rozmiar listy
                cout << argument << " - liczba spoza zakresu" << endl;
            }
        }
    }

}

WierszTrojkataPascala::WierszTrojkataPascala(int n) {

}

WierszTrojkataPascala::~WierszTrojkataPascala() {
    TrojkatPascala.clear();
} 