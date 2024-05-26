
#include <vector>
#include <string>
#include <stdexcept>
using namespace std;

class WierszTrojkataPascala {
public:
    vector<int> TrojkatPascala;

    int SymbolNewtona(int n);

    int wiersz(int m);

    void trojkat(int n, vector<string>& args);

    WierszTrojkataPascala(int n);

    ~WierszTrojkataPascala();
};
